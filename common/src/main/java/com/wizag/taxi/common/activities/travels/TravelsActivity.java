package com.wizag.taxi.common.activities.travels;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.widget.ListView;

import com.wizag.taxi.common.R;
import com.wizag.taxi.common.activities.travels.adapters.TravelListViewAdapter;
import com.wizag.taxi.common.activities.travels.fragments.WriteComplaintDialog;
import com.wizag.taxi.common.components.BaseActivity;
import com.wizag.taxi.common.components.LoadingDialog;
import com.wizag.taxi.common.events.GetTravelsEvent;
import com.wizag.taxi.common.events.GetTravelsResultEvent;
import com.wizag.taxi.common.events.HideTravelEvent;
import com.wizag.taxi.common.events.HideTravelResultEvent;
import com.wizag.taxi.common.events.WriteComplaintEvent;
import com.wizag.taxi.common.events.WriteComplaintResultEvent;
import com.wizag.taxi.common.models.Travel;
import com.wizag.taxi.common.utils.AlertDialogBuilder;
import com.wizag.taxi.common.utils.AlerterHelper;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

public class TravelsActivity extends BaseActivity implements WriteComplaintDialog.onWriteComplaintInteractionListener {

    private String subjectText;
    private String contentText;
    private long lastSelectedTravelId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travels);
        initializeToolbar(getString(R.string.title_travel));
    }

    @Override
    protected void onResume() {
        super.onResume();
        getTravels();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onWriteComplaintResult(WriteComplaintResultEvent event){
        LoadingDialog.dismiss();
        if(event.hasError()){
            event.showError(TravelsActivity.this, result -> {
                if(result == AlertDialogBuilder.DialogResult.RETRY){
                    eventBus.post(new WriteComplaintEvent(lastSelectedTravelId, subjectText, contentText));
                    LoadingDialog.show(TravelsActivity.this,getString(R.string.sending_complaint));
                }
            });
        } else {
            AlerterHelper.showInfo(TravelsActivity.this,getString(R.string.message_complaint_sent));
        }
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onHideTravelResult(HideTravelResultEvent event){
        if(event.hasError())
            return;
        AlerterHelper.showInfo(TravelsActivity.this,getString(R.string.info_travel_hidden));
        getTravels();

    }
    private void getTravels() {
        eventBus.post(new GetTravelsEvent());
        LoadingDialog.show(this, getString(R.string.message_loading_travels));
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onTravelsReceived(GetTravelsResultEvent event) {
        LoadingDialog.dismiss();
        if (event.hasError()) {
            event.showError(TravelsActivity.this, result -> {
                if (result == AlertDialogBuilder.DialogResult.RETRY)
                    getTravels();
                else
                    finish();
            });
            return;
        }
        loadList(event.travels);
    }

    private void loadList(final ArrayList<Travel> travels) {
        if (travels == null)
            return;

        final TravelListViewAdapter adapter = new TravelListViewAdapter(TravelsActivity.this,travels);
        adapter.setHideTravelClickListener(view -> {
            AlertDialogBuilder.show(TravelsActivity.this, getString(R.string.question_hide_travel), AlertDialogBuilder.DialogButton.OK_CANCEL, result -> {
                if(result == AlertDialogBuilder.DialogResult.OK)
                    eventBus.post(new HideTravelEvent((int)view.getTag()));
            });
        });
        adapter.setWriteComplaintClickListener(view -> {
            lastSelectedTravelId = (int)view.getTag();
            FragmentManager fm = getSupportFragmentManager();
            (new WriteComplaintDialog()).show(fm, "fragment_complaint");
        });
        final ListView listView = findViewById(R.id.list_travels);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener((adapterView, view, pos, l) -> {
            // toggle clicked cell state
            //((FoldingCell) view).toggle(false);
            // register in adapter that state for selected cell is toggled
            //adapter.registerToggle(pos);
        });
    }

    @Override
    public void onSaveComplaintClicked(WriteComplaintEvent event) {
        event.travelId = lastSelectedTravelId;
        eventBus.post(event);
        LoadingDialog.show(TravelsActivity.this,getString(R.string.sending_complaint));
    }
}