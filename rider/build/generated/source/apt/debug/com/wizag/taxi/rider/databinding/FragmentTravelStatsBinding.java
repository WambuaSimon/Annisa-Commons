package com.wizag.taxi.rider.databinding;
import com.wizag.taxi.rider.R;
import com.wizag.taxi.rider.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentTravelStatsBinding extends android.databinding.ViewDataBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.distance_label, 1);
        sViewsWithIds.put(R.id.distance_text, 2);
        sViewsWithIds.put(R.id.time_label, 3);
        sViewsWithIds.put(R.id.time_text, 4);
        sViewsWithIds.put(R.id.cost_label, 5);
        sViewsWithIds.put(R.id.cost_text, 6);
        sViewsWithIds.put(R.id.balance_label, 7);
        sViewsWithIds.put(R.id.balance_text, 8);
        sViewsWithIds.put(R.id.charge_account_button, 9);
    }
    // views
    @NonNull
    public final android.widget.TextView balanceLabel;
    @NonNull
    public final android.widget.TextView balanceText;
    @NonNull
    public final android.widget.ImageView chargeAccountButton;
    @NonNull
    public final android.widget.TextView costLabel;
    @NonNull
    public final android.widget.TextView costText;
    @NonNull
    public final android.widget.TextView distanceLabel;
    @NonNull
    public final android.widget.TextView distanceText;
    @NonNull
    private final android.support.constraint.ConstraintLayout mboundView0;
    @NonNull
    public final android.widget.TextView timeLabel;
    @NonNull
    public final android.widget.TextView timeText;
    // variables
    @Nullable
    private com.wizag.taxi.common.models.Travel mTravel;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentTravelStatsBinding(@NonNull android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        super(bindingComponent, root, 1);
        final Object[] bindings = mapBindings(bindingComponent, root, 10, sIncludes, sViewsWithIds);
        this.balanceLabel = (android.widget.TextView) bindings[7];
        this.balanceText = (android.widget.TextView) bindings[8];
        this.chargeAccountButton = (android.widget.ImageView) bindings[9];
        this.costLabel = (android.widget.TextView) bindings[5];
        this.costText = (android.widget.TextView) bindings[6];
        this.distanceLabel = (android.widget.TextView) bindings[1];
        this.distanceText = (android.widget.TextView) bindings[2];
        this.mboundView0 = (android.support.constraint.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.timeLabel = (android.widget.TextView) bindings[3];
        this.timeText = (android.widget.TextView) bindings[4];
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
        if (BR.travel == variableId) {
            setTravel((com.wizag.taxi.common.models.Travel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setTravel(@Nullable com.wizag.taxi.common.models.Travel Travel) {
        this.mTravel = Travel;
    }
    @Nullable
    public com.wizag.taxi.common.models.Travel getTravel() {
        return mTravel;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeTravel((com.wizag.taxi.common.models.Travel) object, fieldId);
        }
        return false;
    }
    private boolean onChangeTravel(com.wizag.taxi.common.models.Travel Travel, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
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
        // batch finished
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    @NonNull
    public static FragmentTravelStatsBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static FragmentTravelStatsBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<FragmentTravelStatsBinding>inflate(inflater, com.wizag.taxi.rider.R.layout.fragment_travel_stats, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static FragmentTravelStatsBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static FragmentTravelStatsBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(com.wizag.taxi.rider.R.layout.fragment_travel_stats, null, false), bindingComponent);
    }
    @NonNull
    public static FragmentTravelStatsBinding bind(@NonNull android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static FragmentTravelStatsBinding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/fragment_travel_stats_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new FragmentTravelStatsBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): travel
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}