package com.wizag.taxi.driver;

import org.greenrobot.eventbus.meta.SimpleSubscriberInfo;
import org.greenrobot.eventbus.meta.SubscriberMethodInfo;
import org.greenrobot.eventbus.meta.SubscriberInfo;
import org.greenrobot.eventbus.meta.SubscriberInfoIndex;

import org.greenrobot.eventbus.ThreadMode;

import java.util.HashMap;
import java.util.Map;

/** This class is generated by EventBus, do not edit. */
public class DriverEventBusIndex implements SubscriberInfoIndex {
    private static final Map<Class<?>, SubscriberInfo> SUBSCRIBER_INDEX;

    static {
        SUBSCRIBER_INDEX = new HashMap<Class<?>, SubscriberInfo>();

        putIndex(new SimpleSubscriberInfo(com.wizag.taxi.driver.activities.statistics.StatisticsActivity.class, true,
                new SubscriberMethodInfo[] {
            new SubscriberMethodInfo("onChartUpdated", com.wizag.taxi.driver.events.GetStatisticsResultEvent.class,
                    ThreadMode.MAIN),
            new SubscriberMethodInfo("onPaymentRequestResult",
                    com.wizag.taxi.driver.events.PaymentRequestResultEvent.class, ThreadMode.MAIN),
        }));

        putIndex(new SimpleSubscriberInfo(com.wizag.taxi.driver.activities.travel.TravelActivity.class, true,
                new SubscriberMethodInfo[] {
            new SubscriberMethodInfo("onCallRequested",
                    com.wizag.taxi.common.events.ServiceCallRequestResultEvent.class, ThreadMode.MAIN),
            new SubscriberMethodInfo("onServiceCanceled", com.wizag.taxi.common.events.ServiceCancelResultEvent.class,
                    ThreadMode.MAIN),
            new SubscriberMethodInfo("onServicedFinished", com.wizag.taxi.driver.events.ServiceFinishResultEvent.class,
                    ThreadMode.MAIN),
        }));

        putIndex(new SimpleSubscriberInfo(com.wizag.taxi.driver.activities.splash.SplashActivity.class, true,
                new SubscriberMethodInfo[] {
            new SubscriberMethodInfo("onConnectedResult", com.wizag.taxi.common.events.ConnectResultEvent.class,
                    ThreadMode.MAIN),
            new SubscriberMethodInfo("onServiceStarted",
                    com.wizag.taxi.common.events.BackgroundServiceStartedEvent.class),
            new SubscriberMethodInfo("onLoginResultEvent", com.wizag.taxi.driver.events.LoginResultEvent.class,
                    ThreadMode.MAIN),
        }));

        putIndex(new SimpleSubscriberInfo(com.wizag.taxi.driver.activities.main.MainActivity.class, true,
                new SubscriberMethodInfo[] {
            new SubscriberMethodInfo("onRequestReceived", com.wizag.taxi.driver.events.RequestReceivedEvent.class,
                    ThreadMode.MAIN),
            new SubscriberMethodInfo("onProfileChanged", com.wizag.taxi.common.events.ProfileInfoChangedEvent.class,
                    ThreadMode.MAIN, 0, true),
            new SubscriberMethodInfo("onDisconnected", com.wizag.taxi.common.events.SocketConnectionEvent.class,
                    ThreadMode.MAIN),
            new SubscriberMethodInfo("onStatusChanged", com.wizag.taxi.driver.events.ChangeStatusResultEvent.class,
                    ThreadMode.MAIN),
            new SubscriberMethodInfo("onRiderAccepted", com.wizag.taxi.driver.events.RiderAcceptedEvent.class,
                    ThreadMode.MAIN),
            new SubscriberMethodInfo("OnGetStatusResultReceived",
                    com.wizag.taxi.common.events.GetStatusResultEvent.class, ThreadMode.MAIN),
        }));

        putIndex(new SimpleSubscriberInfo(com.wizag.taxi.driver.activities.profile.ProfileActivity.class, true,
                new SubscriberMethodInfo[] {
            new SubscriberMethodInfo("onProfileInfoChanged",
                    com.wizag.taxi.common.events.EditProfileInfoResultEvent.class, ThreadMode.MAIN),
            new SubscriberMethodInfo("onProfileImageChanged",
                    com.wizag.taxi.common.events.ChangeProfileImageResultEvent.class, ThreadMode.MAIN),
            new SubscriberMethodInfo("onHeaderImageChanged",
                    com.wizag.taxi.driver.events.ChangeHeaderImageResultEvent.class, ThreadMode.MAIN),
        }));

        putIndex(new SimpleSubscriberInfo(com.wizag.taxi.driver.services.DriverService.class, true,
                new SubscriberMethodInfo[] {
            new SubscriberMethodInfo("connectSocket", com.wizag.taxi.common.events.ConnectEvent.class),
            new SubscriberMethodInfo("getStatus", com.wizag.taxi.common.events.GetStatusEvent.class),
            new SubscriberMethodInfo("login", com.wizag.taxi.common.events.LoginEvent.class),
            new SubscriberMethodInfo("FinishTravel", com.wizag.taxi.driver.events.ServiceFinishEvent.class),
            new SubscriberMethodInfo("PaymentRequested", com.wizag.taxi.driver.events.PaymentRequestEvent.class),
            new SubscriberMethodInfo("editProfile", com.wizag.taxi.common.events.EditProfileInfoEvent.class),
            new SubscriberMethodInfo("acceptOrder", com.wizag.taxi.common.events.AcceptOrderEvent.class),
            new SubscriberMethodInfo("changeStatus", com.wizag.taxi.driver.events.ChangeStatusEvent.class),
            new SubscriberMethodInfo("serviceInLocation", com.wizag.taxi.driver.events.ServiceInLocationEvent.class),
            new SubscriberMethodInfo("startTaxi", com.wizag.taxi.driver.events.ServiceStartEvent.class),
            new SubscriberMethodInfo("callRequest", com.wizag.taxi.common.events.ServiceCallRequestEvent.class),
            new SubscriberMethodInfo("cancelTaxi", com.wizag.taxi.common.events.ServiceCancelEvent.class),
            new SubscriberMethodInfo("getTravels", com.wizag.taxi.common.events.GetTravelsEvent.class),
            new SubscriberMethodInfo("locationChanged", com.wizag.taxi.driver.events.LocationChangedEvent.class),
            new SubscriberMethodInfo("chargeAccount", com.wizag.taxi.common.events.ChargeAccountEvent.class),
            new SubscriberMethodInfo("ChangeProfileImage", com.wizag.taxi.common.events.ChangeProfileImageEvent.class),
            new SubscriberMethodInfo("HideTravel", com.wizag.taxi.common.events.HideTravelEvent.class),
            new SubscriberMethodInfo("changeHeaderImage", com.wizag.taxi.driver.events.ChangeHeaderImageEvent.class),
            new SubscriberMethodInfo("getDriverStatistics", com.wizag.taxi.driver.events.GetStatisticsEvent.class),
            new SubscriberMethodInfo("WriteComplaint", com.wizag.taxi.common.events.WriteComplaintEvent.class),
            new SubscriberMethodInfo("sendTravelInfo", com.wizag.taxi.driver.events.SendTravelInfoEvent.class),
        }));

        putIndex(new SimpleSubscriberInfo(com.wizag.taxi.driver.ui.DriverBaseActivity.class, true,
                new SubscriberMethodInfo[] {
            new SubscriberMethodInfo("onServiceStarted",
                    com.wizag.taxi.common.events.BackgroundServiceStartedEvent.class),
            new SubscriberMethodInfo("onConnectedResult", com.wizag.taxi.common.events.ConnectResultEvent.class,
                    ThreadMode.MAIN),
        }));

    }

    private static void putIndex(SubscriberInfo info) {
        SUBSCRIBER_INDEX.put(info.getSubscriberClass(), info);
    }

    @Override
    public SubscriberInfo getSubscriberInfo(Class<?> subscriberClass) {
        SubscriberInfo info = SUBSCRIBER_INDEX.get(subscriberClass);
        if (info != null) {
            return info;
        } else {
            return null;
        }
    }
}
