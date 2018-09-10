package com.wizag.taxi.driver.databinding;
import com.wizag.taxi.driver.R;
import com.wizag.taxi.driver.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class CardRequestBinding extends android.databinding.ViewDataBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.progress_timeout, 6);
        sViewsWithIds.put(R.id.image_location, 7);
        sViewsWithIds.put(R.id.label_from, 8);
        sViewsWithIds.put(R.id.label_to, 9);
        sViewsWithIds.put(R.id.image_distance, 10);
        sViewsWithIds.put(R.id.label_distance, 11);
        sViewsWithIds.put(R.id.image_from_you, 12);
        sViewsWithIds.put(R.id.label_from_you, 13);
        sViewsWithIds.put(R.id.image_cost, 14);
        sViewsWithIds.put(R.id.label_cost, 15);
        sViewsWithIds.put(R.id.button_decline, 16);
        sViewsWithIds.put(R.id.button_accept, 17);
    }
    // views
    @NonNull
    public final android.widget.Button buttonAccept;
    @NonNull
    public final android.widget.Button buttonDecline;
    @NonNull
    public final android.support.v7.widget.CardView cardView;
    @NonNull
    public final android.widget.ImageView imageCost;
    @NonNull
    public final android.widget.ImageView imageDistance;
    @NonNull
    public final android.widget.ImageView imageFromYou;
    @NonNull
    public final android.widget.ImageView imageLocation;
    @NonNull
    public final android.widget.TextView labelCost;
    @NonNull
    public final android.widget.TextView labelDistance;
    @NonNull
    public final android.widget.TextView labelFrom;
    @NonNull
    public final android.widget.TextView labelFromYou;
    @NonNull
    public final android.widget.TextView labelTo;
    @NonNull
    public final android.widget.ProgressBar progressTimeout;
    @NonNull
    public final android.widget.TextView textCost;
    @NonNull
    public final android.widget.TextView textDistance;
    @NonNull
    public final android.widget.TextView textFrom;
    @NonNull
    public final android.widget.TextView textFromYou;
    @NonNull
    public final android.widget.TextView textTo;
    // variables
    @Nullable
    private com.wizag.taxi.common.models.Request mRequest;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public CardRequestBinding(@NonNull android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        super(bindingComponent, root, 0);
        final Object[] bindings = mapBindings(bindingComponent, root, 18, sIncludes, sViewsWithIds);
        this.buttonAccept = (android.widget.Button) bindings[17];
        this.buttonDecline = (android.widget.Button) bindings[16];
        this.cardView = (android.support.v7.widget.CardView) bindings[0];
        this.cardView.setTag(null);
        this.imageCost = (android.widget.ImageView) bindings[14];
        this.imageDistance = (android.widget.ImageView) bindings[10];
        this.imageFromYou = (android.widget.ImageView) bindings[12];
        this.imageLocation = (android.widget.ImageView) bindings[7];
        this.labelCost = (android.widget.TextView) bindings[15];
        this.labelDistance = (android.widget.TextView) bindings[11];
        this.labelFrom = (android.widget.TextView) bindings[8];
        this.labelFromYou = (android.widget.TextView) bindings[13];
        this.labelTo = (android.widget.TextView) bindings[9];
        this.progressTimeout = (android.widget.ProgressBar) bindings[6];
        this.textCost = (android.widget.TextView) bindings[5];
        this.textCost.setTag(null);
        this.textDistance = (android.widget.TextView) bindings[3];
        this.textDistance.setTag(null);
        this.textFrom = (android.widget.TextView) bindings[1];
        this.textFrom.setTag(null);
        this.textFromYou = (android.widget.TextView) bindings[4];
        this.textFromYou.setTag(null);
        this.textTo = (android.widget.TextView) bindings[2];
        this.textTo.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.request == variableId) {
            setRequest((com.wizag.taxi.common.models.Request) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setRequest(@Nullable com.wizag.taxi.common.models.Request Request) {
        this.mRequest = Request;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.request);
        super.requestRebind();
    }
    @Nullable
    public com.wizag.taxi.common.models.Request getRequest() {
        return mRequest;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        com.wizag.taxi.common.models.Request request = mRequest;
        java.lang.String textDistanceAndroidStringUnitDistanceRequestDistance = null;
        java.lang.Double requestCost = null;
        java.lang.String textFromYouAndroidStringUnitDistanceRequestFromDriver = null;
        java.lang.String requestTravelPickupAddress = null;
        java.lang.String requestTravelDestinationAddress = null;
        java.lang.String textCostAndroidStringUnitMoneyRequestCost = null;
        com.wizag.taxi.common.models.TravelSerializable requestTravel = null;
        java.lang.Double requestFromDriver = null;
        java.lang.Double requestDistance = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (request != null) {
                    // read request.cost
                    requestCost = request.cost;
                    // read request.travel
                    requestTravel = request.travel;
                    // read request.fromDriver
                    requestFromDriver = request.fromDriver;
                    // read request.distance
                    requestDistance = request.distance;
                }


                // read @android:string/unit_money
                textCostAndroidStringUnitMoneyRequestCost = textCost.getResources().getString(R.string.unit_money, requestCost);
                // read @android:string/unit_distance
                textFromYouAndroidStringUnitDistanceRequestFromDriver = textFromYou.getResources().getString(R.string.unit_distance, requestFromDriver);
                // read @android:string/unit_distance
                textDistanceAndroidStringUnitDistanceRequestDistance = textDistance.getResources().getString(R.string.unit_distance, requestDistance);
                if (requestTravel != null) {
                    // read request.travel.pickupAddress
                    requestTravelPickupAddress = requestTravel.getPickupAddress();
                    // read request.travel.destinationAddress
                    requestTravelDestinationAddress = requestTravel.getDestinationAddress();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.textCost, textCostAndroidStringUnitMoneyRequestCost);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.textDistance, textDistanceAndroidStringUnitDistanceRequestDistance);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.textFrom, requestTravelPickupAddress);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.textFromYou, textFromYouAndroidStringUnitDistanceRequestFromDriver);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.textTo, requestTravelDestinationAddress);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    @NonNull
    public static CardRequestBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static CardRequestBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<CardRequestBinding>inflate(inflater, com.wizag.taxi.driver.R.layout.card_request, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static CardRequestBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static CardRequestBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(com.wizag.taxi.driver.R.layout.card_request, null, false), bindingComponent);
    }
    @NonNull
    public static CardRequestBinding bind(@NonNull android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static CardRequestBinding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/card_request_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new CardRequestBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): request
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}