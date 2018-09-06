package com.wizag.taxi.driver.services;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import android.os.Vibrator;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.gson.Gson;
import com.wizag.taxi.common.events.AcceptOrderEvent;
import com.wizag.taxi.common.events.BackgroundServiceStartedEvent;
import com.wizag.taxi.common.events.ChangeProfileImageEvent;
import com.wizag.taxi.common.events.ChangeProfileImageResultEvent;
import com.wizag.taxi.common.events.ChargeAccountEvent;
import com.wizag.taxi.common.events.ChargeAccountResultEvent;
import com.wizag.taxi.common.events.ConnectEvent;
import com.wizag.taxi.common.events.ConnectResultEvent;
import com.wizag.taxi.common.events.EditProfileInfoEvent;
import com.wizag.taxi.common.events.EditProfileInfoResultEvent;
import com.wizag.taxi.common.events.GetStatusEvent;
import com.wizag.taxi.common.events.GetStatusResultEvent;
import com.wizag.taxi.common.events.GetTravelsEvent;
import com.wizag.taxi.common.events.GetTravelsResultEvent;
import com.wizag.taxi.common.events.HideTravelEvent;
import com.wizag.taxi.common.events.HideTravelResultEvent;
import com.wizag.taxi.common.events.LoginEvent;
import com.wizag.taxi.common.events.ProfileInfoChangedEvent;
import com.wizag.taxi.common.events.ServiceCallRequestEvent;
import com.wizag.taxi.common.events.ServiceCallRequestResultEvent;
import com.wizag.taxi.common.events.ServiceCancelEvent;
import com.wizag.taxi.common.events.ServiceCancelResultEvent;
import com.wizag.taxi.common.events.SocketConnectionEvent;
import com.wizag.taxi.common.events.WriteComplaintEvent;
import com.wizag.taxi.common.events.WriteComplaintResultEvent;
import com.wizag.taxi.common.models.Driver;
import com.wizag.taxi.common.utils.CommonUtils;
import com.wizag.taxi.common.utils.MyPreferenceManager;
import com.wizag.taxi.common.utils.ServerResponse;
import com.wizag.taxi.driver.R;
import com.wizag.taxi.driver.activities.main.MainActivity;
import com.wizag.taxi.driver.events.ChangeHeaderImageEvent;
import com.wizag.taxi.driver.events.ChangeHeaderImageResultEvent;
import com.wizag.taxi.driver.events.ChangeStatusEvent;
import com.wizag.taxi.driver.events.ChangeStatusResultEvent;
import com.wizag.taxi.driver.events.GetStatisticsEvent;
import com.wizag.taxi.driver.events.GetStatisticsResultEvent;
import com.wizag.taxi.driver.events.LocationChangedEvent;
import com.wizag.taxi.driver.events.LoginResultEvent;
import com.wizag.taxi.driver.events.PaymentRequestEvent;
import com.wizag.taxi.driver.events.PaymentRequestResultEvent;
import com.wizag.taxi.driver.events.RequestReceivedEvent;
import com.wizag.taxi.driver.events.RiderAcceptedEvent;
import com.wizag.taxi.driver.events.SendTravelInfoEvent;
import com.wizag.taxi.driver.events.ServiceFinishEvent;
import com.wizag.taxi.driver.events.ServiceFinishResultEvent;
import com.wizag.taxi.driver.events.ServiceInLocationEvent;
import com.wizag.taxi.driver.events.ServiceStartEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import io.socket.client.Ack;
import io.socket.client.IO;
import io.socket.client.Socket;


public class DriverService extends Service {
    final static String DRIVER_ACCEPTED = "driverAccepted";
    final static String EDIT_PROFILE = "editProfile";
    final static String ACTIVATE_DRIVER = "changeStatus";
    final static String BUZZ = "buzz";
    final static String START_TRAVEL = "startTravel";
    final static String CANCEL_TRAVEL = "cancelTravel";
    final static String GET_DRIVER_TRAVELS = "getTravels";
    final static String CALL_REQUEST = "callRequest";
    Socket socket;
    Vibrator vibe;
    EventBus eventBus = EventBus.getDefault();

    @Subscribe
    public void connectSocket(ConnectEvent event) {
        try {
            IO.Options options = new IO.Options();
            options.query = "token=" + event.token;
            socket = IO.socket(getString(R.string.server_address), options);
            socket.on(Socket.EVENT_CONNECT, args -> {
                eventBus.post(new ConnectResultEvent(ServerResponse.OK.getValue()));
                eventBus.post(new SocketConnectionEvent(Socket.EVENT_CONNECT));
            })
                    .on(Socket.EVENT_DISCONNECT, args -> eventBus.post(new SocketConnectionEvent(Socket.EVENT_DISCONNECT)))
                    .on(Socket.EVENT_CONNECTING, args -> eventBus.post(new SocketConnectionEvent(Socket.EVENT_CONNECTING)))
                    .on(Socket.EVENT_CONNECT_ERROR, args -> eventBus.post(new SocketConnectionEvent(Socket.EVENT_CONNECT_ERROR)))
                    .on(Socket.EVENT_CONNECT_TIMEOUT, args -> eventBus.post(new SocketConnectionEvent(Socket.EVENT_CONNECT_TIMEOUT)))
                    .on(Socket.EVENT_RECONNECT, args -> eventBus.post(new SocketConnectionEvent(Socket.EVENT_RECONNECT)))
                    .on(Socket.EVENT_RECONNECTING, args -> eventBus.post(new SocketConnectionEvent(Socket.EVENT_RECONNECTING)))
                    .on(Socket.EVENT_RECONNECT_ATTEMPT, args -> eventBus.post(new SocketConnectionEvent(Socket.EVENT_RECONNECT_ATTEMPT)))
                    .on(Socket.EVENT_RECONNECT_ERROR, args -> eventBus.post(new SocketConnectionEvent(Socket.EVENT_RECONNECT_ERROR)))
                    .on(Socket.EVENT_RECONNECT_FAILED, args -> eventBus.post(new SocketConnectionEvent(Socket.EVENT_RECONNECT_FAILED)))
                    .on("error", args -> {
                        try {
                            JSONObject obj = new JSONObject(args[0].toString());
                            eventBus.post(new ConnectResultEvent(ServerResponse.UNKNOWN_ERROR.getValue(), obj.getString("message")));
                        } catch (JSONException c) {
                            eventBus.post(new ConnectResultEvent(ServerResponse.UNKNOWN_ERROR.getValue(), args[0].toString()));
                        }
                    })
                    .on("requestReceived", args -> {
                        try {
                            eventBus.post(new RequestReceivedEvent(args[0].toString(), (Integer) args[1], (Integer) args[2], Double.valueOf(args[3].toString())));
                            Intent notificationIntent = new Intent(getBaseContext(), MainActivity.class);
                            PendingIntent contentIntent = PendingIntent.getActivity(getBaseContext(), 0, notificationIntent, 0);
                            NotificationCompat.Builder mBuilder =
                                    new NotificationCompat.Builder(DriverService.this)
                                            .setSmallIcon(R.drawable.fab_requests)
                                            .setContentTitle(getString(R.string.app_name))
                                            .setDefaults(NotificationCompat.DEFAULT_LIGHTS | NotificationCompat.DEFAULT_SOUND | NotificationCompat.DEFAULT_VIBRATE)
                                            .setContentIntent(contentIntent)
                                            .setAutoCancel(true)
                                            .setOngoing(true)
                                            .setContentText(getString(R.string.notification_requests_waiting));
                            NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                            Notification notification = mBuilder.build();
                            notification.flags |= Notification.FLAG_ONGOING_EVENT;
                            notificationManager.notify(0, notification);
                        } catch (Exception c) {
                            c.printStackTrace();
                        }
                    })
                    .on("riderAccepted", args -> {
                        try {
                            eventBus.post(new RiderAcceptedEvent(args));
                        } catch (Exception c) {
                            c.printStackTrace();
                        }
                    })
                    .on("driverInfoChanged", args -> {
                        MyPreferenceManager SP = new MyPreferenceManager(getApplicationContext());
                        SP.putString("driver_user", args[0].toString());
                        CommonUtils.driver = new Gson().fromJson(args[0].toString(), Driver.class);
                        eventBus.postSticky(new ProfileInfoChangedEvent());
                    })
                    .on("cancelTravel", args -> eventBus.post(new ServiceCancelResultEvent(200)));
            socket.connect();
        } catch (Exception c) {
            Log.e("Connect Socket", c.getMessage());
        }

    }

    @Subscribe
    public void getStatus(GetStatusEvent event){
        socket.emit("getStatus", (Ack) args -> eventBus.post(new GetStatusResultEvent(args)));
    }

    @Subscribe
    public void login(LoginEvent event) {
        new LoginRequest().execute(String.valueOf(event.userName), String.valueOf(event.versionNumber));
    }

    @Subscribe
    public void FinishTravel(final ServiceFinishEvent event) {
        socket.emit("finishedTaxi", event.cost, event.duration, event.distance, event.log, (Ack) args -> eventBus.post(new ServiceFinishResultEvent((int) args[0], (boolean) args[1], Float.parseFloat(args[2].toString()))));
    }

    @Subscribe
    public void PaymentRequested(final PaymentRequestEvent event) {
        socket.emit("requestPayment", (Ack) args -> eventBus.post(new PaymentRequestResultEvent((int) args[0])));
    }

    @Subscribe
    public void editProfile(final EditProfileInfoEvent event) {
        socket.emit(EDIT_PROFILE, event.userInfo, (Ack) args -> eventBus.post(new EditProfileInfoResultEvent((Integer) args[0])));
    }

    @Subscribe
    public void acceptOrder(AcceptOrderEvent event) {
        socket.emit(DRIVER_ACCEPTED, event.travelId);
    }

    @Subscribe
    public void changeStatus(final ChangeStatusEvent event) {
        socket.emit(ACTIVATE_DRIVER, event.status.getValue(), (Ack) args -> eventBus.post(new ChangeStatusResultEvent((int) args[0])));
    }

    @Subscribe
    public void serviceInLocation(ServiceInLocationEvent event) {
        socket.emit(BUZZ);
    }

    @Subscribe
    public void startTaxi(ServiceStartEvent event) {
        socket.emit(START_TRAVEL);
    }

    @Subscribe
    public void callRequest(ServiceCallRequestEvent event) {
        socket.emit(CALL_REQUEST, (Ack) args -> eventBus.post(new ServiceCallRequestResultEvent((int) args[0])));
    }

    @Subscribe
    public void cancelTaxi(ServiceCancelEvent event) {
        socket.emit(CANCEL_TRAVEL, (Ack) args -> eventBus.post(new ServiceCancelResultEvent((int) args[0])));
    }

    @Subscribe
    public void getTravels(final GetTravelsEvent event) {
        socket.emit(GET_DRIVER_TRAVELS, (Ack) args -> eventBus.post(new GetTravelsResultEvent((int) args[0], args[1].toString())));
    }

    @Subscribe
    public void locationChanged(LocationChangedEvent event) {
        socket.emit("locationChanged", event.location.latitude, event.location.longitude);
    }

    @Subscribe
    public void chargeAccount(ChargeAccountEvent event) {
        socket.emit("chargeAccount", event.type,event.stripeToken, event.amount, (Ack) args -> eventBus.post(new ChargeAccountResultEvent(args)));
    }

    @Subscribe
    public void ChangeProfileImage(ChangeProfileImageEvent event) {
        File file = new File(event.path);
        byte[] data = new byte[(int) file.length()];
        try {
            int len = new FileInputStream(file).read(data);
            if (len > 0)
                socket.emit("changeProfileImage", data, (Ack) args -> eventBus.post(new ChangeProfileImageResultEvent((int) args[0], args[1].toString())));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Subscribe
    public void HideTravel(final HideTravelEvent event) {
        socket.emit("hideTravel", event.travelId, (Ack) args -> eventBus.post(new HideTravelResultEvent(ServerResponse.OK.getValue())));
    }

    @Subscribe
    public void changeHeaderImage(ChangeHeaderImageEvent event) {
        File file = new File(event.path);
        byte[] data = new byte[(int) file.length()];
        try {
            int len = new FileInputStream(file).read(data);
            if (len > 0)
                socket.emit("changeHeaderImage", data, (Ack) args -> eventBus.post(new ChangeHeaderImageResultEvent((int) args[0], args[1].toString())));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Subscribe
    public void getDriverStatistics(GetStatisticsEvent event) {
        socket.emit("getStats", event.queryTime.getValue(), (Ack) args -> eventBus.post(new GetStatisticsResultEvent((Integer) args[0], args[1] != null ? args[1].toString() : null, args[2] != null ? args[2].toString() : null)));
    }

    @Subscribe
    public void WriteComplaint(final WriteComplaintEvent event) {
        socket.emit("writeComplaint", event.travelId, event.subject, event.content, (Ack) args -> eventBus.post(new WriteComplaintResultEvent((int) args[0])));
    }

    @Subscribe
    public void sendTravelInfo(SendTravelInfoEvent event) {
        socket.emit("travelInfo", event.travel.getDistanceReal(), event.travel.getDurationReal(), event.travel.getCost());
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        vibe = (Vibrator) this.getSystemService(Context.VIBRATOR_SERVICE);
        eventBus.post(new BackgroundServiceStartedEvent());
        return Service.START_STICKY;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private class LoginRequest extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... uri) {
            try {
                URL url = new URL(getString(R.string.server_address) + "driver_login");
                HttpURLConnection client = (HttpURLConnection) url.openConnection();
                client.setRequestMethod("POST");
                client.setDoOutput(true);
                client.setDoInput(true);
                DataOutputStream wr = new DataOutputStream(client.getOutputStream());

                HashMap<String, String> postDataParams = new HashMap<>();
                postDataParams.put("user_name", uri[0]);
                postDataParams.put("version", uri[1]);
                StringBuilder result = new StringBuilder();
                boolean first = true;
                for (Map.Entry<String, String> entry : postDataParams.entrySet()) {
                    if (first)
                        first = false;
                    else
                        result.append("&");
                    result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
                    result.append("=");
                    result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
                }
                wr.write(result.toString().getBytes());
                BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null)
                    sb.append(line);
                return sb.toString();
            } catch (Exception c) {
                c.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            try {
                JSONObject obj = new JSONObject(result);
                int status = obj.getInt("status");
                if (status == 200)
                    eventBus.post(new LoginResultEvent(obj.getInt("status"), obj.getString("user"), obj.getString("token")));
                else
                    eventBus.post(new LoginResultEvent(status));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}