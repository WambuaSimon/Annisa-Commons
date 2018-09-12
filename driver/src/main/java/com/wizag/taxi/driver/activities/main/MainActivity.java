package com.wizag.taxi.driver.activities.main;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.graphics.Interpolator;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBar;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.wizag.taxi.common.activities.chargeAccount.ChargeAccountActivity;
import com.wizag.taxi.common.activities.travels.TravelsActivity;
import com.wizag.taxi.common.components.LoadingDialog;
import com.wizag.taxi.common.events.AcceptOrderEvent;
import com.wizag.taxi.common.events.GetStatusEvent;
import com.wizag.taxi.common.events.GetStatusResultEvent;
import com.wizag.taxi.common.events.ProfileInfoChangedEvent;
import com.wizag.taxi.common.events.SocketConnectionEvent;
import com.wizag.taxi.common.models.Request;
import com.wizag.taxi.common.utils.AlertDialogBuilder;
import com.wizag.taxi.common.utils.AlerterHelper;
import com.wizag.taxi.common.utils.CommonUtils;
import com.wizag.taxi.common.utils.DataBinder;
import com.wizag.taxi.common.utils.MyPreferenceManager;
import com.wizag.taxi.driver.R;
import com.wizag.taxi.driver.activities.about.AboutActivity;
import com.wizag.taxi.driver.activities.main.adapters.RequestsFragmentPagerAdapter;
import com.wizag.taxi.driver.activities.main.fragments.RequestCardFragment;
import com.wizag.taxi.driver.activities.profile.ProfileActivity;
import com.wizag.taxi.driver.activities.statistics.StatisticsActivity;
import com.wizag.taxi.driver.activities.travel.TravelActivity;
import com.wizag.taxi.driver.databinding.ActivityMainBinding;
import com.wizag.taxi.driver.events.ChangeStatusEvent;
import com.wizag.taxi.driver.events.ChangeStatusResultEvent;
import com.wizag.taxi.driver.events.LocationChangedEvent;
import com.wizag.taxi.driver.events.RequestReceivedEvent;
import com.wizag.taxi.driver.events.RiderAcceptedEvent;
import com.wizag.taxi.driver.ui.DriverBaseActivity;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static com.wizag.taxi.driver.BR.user;
import static org.greenrobot.eventbus.ThreadMode.MAIN;

public class MainActivity extends DriverBaseActivity implements OnMapReadyCallback, LocationListener, RequestCardFragment.OnFragmentInteractionListener {
    String SENT, DELIVERED;
    MyPreferenceManager SP;
    private GoogleMap mMap;
    Marker driverPoint;
    ActivityMainBinding binding;
    private RequestsFragmentPagerAdapter requestCardsAdapter;
    static final int ACTIVITY_PROFILE = 11;
    static final int ACTIVITY_WALLET = 12;
    private long firstTime = 0, secondTime = 0;
    static final int ACTIVITY_TRAVEL = 14;
    String phone_number;
    SupportMapFragment mapFragment;
    private static final int PERMISSION_REQUEST_CODE = 1;
    TextView numberPlaceholder;
//    LatLng oldLocation;
//    LatLng newLocaation;

    private boolean isMarkerRotating;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(MainActivity.this, R.layout.activity_main);
       // TextView numberPlaceholder=(TextView) findViewById(R.id.numberPlaceholder);
        isMarkerRotating = false;
        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        requestCardsAdapter = new RequestsFragmentPagerAdapter(getSupportFragmentManager(), new ArrayList<>());
        binding.requestsViewPager.setAdapter(requestCardsAdapter);
        binding.requestsViewPager.setOffscreenPageLimit(3);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        SP = MyPreferenceManager.getInstance(this.getApplicationContext());
        setSupportActionBar(binding.appbar);
        ActionBar actionBar = getSupportActionBar();
        //rotating icon






        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.drawable.menu);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        binding.navigationView.setNavigationItemSelectedListener(menuItem -> {
            binding.drawerLayout.closeDrawers();
            switch (menuItem.getItemId()) {
                case (R.id.nav_item_travels):
                    startActivity(new Intent(MainActivity.this, TravelsActivity.class));
                    break;
                case (R.id.nav_item_profile):
                    startActivityForResult(new Intent(MainActivity.this, ProfileActivity.class), ACTIVITY_PROFILE);
                    break;
                case (R.id.nav_item_statistics):
                    startActivity(new Intent(MainActivity.this, StatisticsActivity.class));
                    break;
                case (R.id.nav_item_charge_account):
                    startActivityForResult(new Intent(MainActivity.this, ChargeAccountActivity.class), ACTIVITY_WALLET);
                    break;
                case (R.id.nav_item_about):
                    startActivity(new Intent(MainActivity.this, AboutActivity.class));
                    break;
                case (R.id.nav_item_exit):
                    logout();
                    break;
                default:
                    Toast.makeText(MainActivity.this, menuItem.getTitle(), Toast.LENGTH_SHORT).show();
                    break;
            }
            return true;
        });
        fillInfo();
        eventBus.post(new GetStatusEvent());
        binding.switchConnection.setOnCheckedChangeListener(onConnectionSwitchChanged);
        BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.from(binding.bottomSheet);
        binding.requestShowFab.setOnClickListener(view -> {
            if (bottomSheetBehavior.getState() == BottomSheetBehavior.STATE_COLLAPSED)
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            else
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        });


        //sos button code for sending sms
        FloatingActionButton myButton = findViewById(R.id.floatingActionButton);
        myButton.setBackgroundColor(Color.RED);
        myButton.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getActionMasked();

                if (action == MotionEvent.ACTION_DOWN) {
                    firstTime = System.currentTimeMillis();

                } else if (action == MotionEvent.ACTION_UP
                        || action == MotionEvent.ACTION_CANCEL) {
                    secondTime = System.currentTimeMillis();
                    if (System.currentTimeMillis() - firstTime >= 2000) {
                        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {

                            if (checkSelfPermission(Manifest.permission.SEND_SMS)
                                    == PackageManager.PERMISSION_DENIED) {

                                Log.d("permission", "permission denied to SEND_SMS - requesting it");
                                String[] permissions = {Manifest.permission.SEND_SMS};

                                requestPermissions(permissions, PERMISSION_REQUEST_CODE);

                            }
                        }


                        // at least 5000 ms touch down time
                        // launch your target activity from here
//                        Toast.makeText(MainActivity.this,"Wabeeee",Toast.LENGTH_LONG).show();
                        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this)
                                //set icon
                                .setIcon(android.R.drawable.ic_dialog_alert)
                                //set title
                                .setTitle("SOS MESSAGE")
                                //set message
                                .setMessage("Do you want to Notify Annisa of an Emergency?")
                                //set positive button
                                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        //set what would happen when positive button is clicked
                                        //finish();
                                      //  phone_number=numberPlaceholder.getText().toString();
                                        String message = "There is an emergency on an An nisa ride for:\t Driver";
                                        String phoneNo = "+254798058191";

                                        //for getting multiple numbers that are separated by a comma eg 144,234
                                        StringTokenizer st = new StringTokenizer(phoneNo, ",");
                                        while (st.hasMoreElements()) {
                                            String tempMobileNumber = (String) st.nextElement();
                                            if (tempMobileNumber.length() > 0 && message.trim().length() > 0) {

                                                sendSMS(tempMobileNumber, message);
                                            }
                                            //for making sure none of the two fields is null
                                            else {
                                                Toast.makeText(getBaseContext(),
                                                        "Please enter both phone number and message.",
                                                        Toast.LENGTH_SHORT).show();
                                            }
                                        }


                                    }

                                })
                                //set negative button
                                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        //set what should happen when negative button is clicked
                                        Toast.makeText(getApplicationContext(), "SOS message cancelled.", Toast.LENGTH_LONG).show();
                                    }
                                })
                                .show();
                    } else { //ignore it}
                        firstTime = 0; //reseting the value for the next time
                        secondTime = 0;//reseting the value for the next time

                    }
                    // TODO Auto-generated method stub

                }
                return false;
            }
        });



    }

    @SuppressLint("MissingPermission")
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
//        mMap.setTrafficEnabled(true);
        LocationManager locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        assert locationManager != null;
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 5, this);
        getLastKnownLocation();
        if (getResources().getBoolean(R.bool.isNotNightMode)) {
            boolean success = mMap.setMapStyle(
                    MapStyleOptions.loadRawResourceStyle(
                            this, R.raw.map_night));
            if (!success)
                Log.e("MapsActivityRaw", "Style parsing failed.");
        }
    }

    public void moveDriverPin(double lat, double lng) {
        LatLng driver = new LatLng(lat, lng);
        driverPoint.setPosition(driver);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                binding.drawerLayout.openDrawer(GravityCompat.START);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onRequestReceived(RequestReceivedEvent event) {
        if (!binding.switchConnection.isChecked())
            return;
        requestCardsAdapter.add(event.request);
        requestCardsAdapter.notifyDataSetChanged();
        BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.from(binding.bottomSheet);
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onProfileChanged(ProfileInfoChangedEvent event) {
        fillInfo();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onDisconnected(SocketConnectionEvent event) {
        binding.switchConnection.setOnCheckedChangeListener(null);
        binding.switchConnection.setChecked(false);
        binding.switchConnection.setOnCheckedChangeListener(onConnectionSwitchChanged);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onStatusChanged(ChangeStatusResultEvent event) {
        if (event.hasError()) {
            event.showError(MainActivity.this, result -> {
                if (result == AlertDialogBuilder.DialogResult.RETRY)
                    onConnectionSwitchChanged.onCheckedChanged(null, binding.switchConnection.isChecked());
                else {
                    binding.switchConnection.setEnabled(true);
                    binding.switchConnection.setOnCheckedChangeListener(null);
                    binding.switchConnection.setChecked(false);
                    binding.switchConnection.setOnCheckedChangeListener(onConnectionSwitchChanged);
                }
            });
        } else
            binding.switchConnection.setEnabled(true);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onRiderAccepted(RiderAcceptedEvent event) {
        LoadingDialog.dismiss();
        Intent intentTravel = new Intent(MainActivity.this, TravelActivity.class);
        intentTravel.putExtra("travel",event.travel.toJson());
        intentTravel.putExtra("driverLat", driverPoint.getPosition().latitude);
        intentTravel.putExtra("driverLng", driverPoint.getPosition().longitude);
        startActivityForResult(intentTravel, ACTIVITY_TRAVEL);
    }

    private CompoundButton.OnCheckedChangeListener onConnectionSwitchChanged = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            if (binding.switchConnection.isChecked()) {
                LocationManager manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
                if ((manager != null && !manager.isProviderEnabled(LocationManager.GPS_PROVIDER)) || driverPoint.getPosition() == null) {
                    binding.switchConnection.setChecked(false);
                    CommonUtils.displayPromptForEnablingGPS(MainActivity.this);
                    return;
                }
                eventBus.post(new ChangeStatusEvent(ChangeStatusEvent.Status.ONLINE));
                eventBus.post(new LocationChangedEvent(driverPoint.getPosition()));
            } else
                eventBus.post(new ChangeStatusEvent(ChangeStatusEvent.Status.OFFLINE));
            binding.switchConnection.setEnabled(false);

        }
    };

    private void getLastKnownLocation() {
        if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        LocationManager manager = (LocationManager) getApplicationContext().getSystemService(LOCATION_SERVICE);
        List<String> providers;
        if (manager != null) {
            providers = manager.getProviders(true);
        } else
            return;
        Location bestLocation = null;
        for (String provider : providers) {
            Location l = manager.getLastKnownLocation(provider);
            if (l == null) {
                continue;
            }
            if (bestLocation == null || l.getAccuracy() < bestLocation.getAccuracy()) {
                bestLocation = l;
            }
        }
        LatLng latLng;
        if (bestLocation == null)
            latLng = new LatLng(Float.parseFloat(getString(R.string.defaultLocation).split(",")[0]), Float.parseFloat(getString(R.string.defaultLocation).split(",")[1]));
        else
            latLng = new LatLng(bestLocation.getLatitude(), bestLocation.getLongitude());
        if (driverPoint == null)
            driverPoint = mMap.addMarker(new MarkerOptions()
                    .position(latLng)
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_taxi))
                    .flat(true)
                    .anchor(0.5f, 0.5f).rotation(90.0f)

                    //.rotation(new LocationChangedEvent(latLng))

                    );
        else
//        driverPoint.setPosition(latLng);
//        float bearing = (float) bearingBetweenLocations(oldLocation, newLocaation);
//        rotateMarker(driverPoint, bearing);
        if (binding.switchConnection.isChecked())
            eventBus.post(new LocationChangedEvent(latLng));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 16));
    }

    private void fillInfo() {
        try {
            String name;
            if (CommonUtils.driver.getStatus() != null && CommonUtils.driver.getStatus().equals("blocked")) {
                logout();
                return;
            }
            if ((CommonUtils.driver.getFirstName() == null || CommonUtils.driver.getFirstName().isEmpty()) && (CommonUtils.driver.getLastName() == null || CommonUtils.driver.getLastName().isEmpty()))
                name = String.valueOf(CommonUtils.driver.getMobileNumber());
            else
                name = CommonUtils.driver.getFirstName() + " " + CommonUtils.driver.getLastName();
            View header = binding.navigationView.getHeaderView(0);
            ((TextView) header.findViewById(R.id.navigation_header_name)).setText(name);
         //   ((TextView) header.findViewById(R.id.navigation_header_charge)).setText(getString(R.string.drawer_header_balance, CommonUtils.driver.getBalance()));
            ImageView imageView = header.findViewById(R.id.navigation_header_image);
            ImageView headerView = header.findViewById(R.id.navigation_background);
            DataBinder.setMedia(imageView, CommonUtils.driver.getMedia());
            DataBinder.setMedia(headerView, CommonUtils.driver.getCarMedia());
        } catch (Exception ignored) {
        }
    }

    private void logout() {
        SP.putString("driver_token", "");
        finish();
    }

    @Override
    public void onBackPressed() {
//        logout();
        finish();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case (ACTIVITY_PROFILE):
                if (resultCode == RESULT_OK)
                    AlerterHelper.showInfo(MainActivity.this, getString(R.string.info_edit_profile_success));
                fillInfo();
                break;

            case (ACTIVITY_WALLET):
                if (resultCode == RESULT_OK)
                    AlerterHelper.showInfo(MainActivity.this, getString(R.string.account_charge_success));
                fillInfo();
                break;

            case (ACTIVITY_TRAVEL):
                binding.switchConnection.setOnCheckedChangeListener(null);
                binding.switchConnection.setChecked(true);
                binding.switchConnection.setOnCheckedChangeListener(onConnectionSwitchChanged);
                onConnectionSwitchChanged.onCheckedChanged(binding.switchConnection, binding.switchConnection.isChecked());
                break;
        }
    }

    private void updateCameraBearing(GoogleMap googleMap, float bearing) {
        if ( googleMap == null) return;
        CameraPosition camPos = CameraPosition
                .builder(
                        googleMap.getCameraPosition() // current Camera
                )
                .bearing(bearing)
                .build();
        googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(camPos));
    }

    @Override
    public void onLocationChanged(Location location) {
        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
        if (binding.switchConnection.isChecked())
            eventBus.post(new LocationChangedEvent(latLng));
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(latLng, mMap.getCameraPosition().zoom > 5 ? mMap.getCameraPosition().zoom : 16);
        mMap.animateCamera(cameraUpdate);
        moveDriverPin(location.getLatitude(), location.getLongitude());

        updateCameraBearing(mMap, location.getBearing());
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }

    @Override
    public void onAccept(Request request) {
        eventBus.post(new AcceptOrderEvent(request.travel.getId(), request.cost));
        LoadingDialog.showWithTimer(this, getString(R.string.waiting_passenger), 20);
        while (requestCardsAdapter.getCount() > 0)
            requestCardsAdapter.remove(0);
        BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.from(binding.bottomSheet);
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
    }

    @Subscribe(threadMode = MAIN)
    public void OnGetStatusResultReceived(GetStatusResultEvent event) {
        if (event.hasError())
            return;
        AlertDialogBuilder.show(MainActivity.this, getString(R.string.recovery_travel_driver), getString(R.string.message_default_title), AlertDialogBuilder.DialogButton.OK, result -> {
            Intent intent = new Intent(MainActivity.this, TravelActivity.class);
            intent.putExtra("travel",event.travel.toJson());
            intent.putExtra("driverLat", driverPoint.getPosition().latitude);
            intent.putExtra("driverLng", driverPoint.getPosition().longitude);
            startActivityForResult(intent, ACTIVITY_TRAVEL);
        });
    }

    @Override
    public void onDecline(Request request) {
        int position = requestCardsAdapter.getPosition(request);
        if (position >= 0)
            requestCardsAdapter.remove(position);
    }

    //method for sending sms
    private void sendSMS(String phoneNumber, String message) {
        SENT = "SOS_SENT";
        DELIVERED = "SOS_DELIVERED";


        PendingIntent sentPI = PendingIntent.getBroadcast(this, 0,
                new Intent(SENT), 0);

        PendingIntent deliveredPI = PendingIntent.getBroadcast(this, 0,
                new Intent(DELIVERED), 0);

        //---when the SMS has been sent---
        registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context arg0, Intent arg1) {
                switch (getResultCode()) {
                    case Activity.RESULT_OK:
                        Toast.makeText(getBaseContext(), "SOS sent",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case SmsManager.RESULT_ERROR_GENERIC_FAILURE:
                        Toast.makeText(getBaseContext(), "Generic failure",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case SmsManager.RESULT_ERROR_NO_SERVICE:
                        Toast.makeText(getBaseContext(), "No service",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case SmsManager.RESULT_ERROR_NULL_PDU:
                        Toast.makeText(getBaseContext(), "Null PDU",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case SmsManager.RESULT_ERROR_RADIO_OFF:
                        Toast.makeText(getBaseContext(), "Radio off",
                                Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        }, new IntentFilter(SENT));

        //---when the SMS has been delivered---
        registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context arg0, Intent arg1) {
                switch (getResultCode()) {
                    case Activity.RESULT_OK:
                        Toast.makeText(getBaseContext(), "SOS delivered",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case Activity.RESULT_CANCELED:
                        Toast.makeText(getBaseContext(), "SOS not delivered",
                                Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        }, new IntentFilter(DELIVERED));

        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(phoneNumber, null, message, sentPI, deliveredPI);
    }
    public void displayToast(View v)
    {
        Toast.makeText(MainActivity.this,"Emergency button",Toast.LENGTH_SHORT).show();
        Toast.makeText(MainActivity.this,"Long press to send SOS",Toast.LENGTH_SHORT).show();
    }

}
