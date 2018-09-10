package com.wizag.taxi.driver.databinding;
import com.wizag.taxi.driver.R;
import com.wizag.taxi.driver.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityTravelBinding extends android.databinding.ViewDataBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.layout_actions, 1);
        sViewsWithIds.put(R.id.in_location_button, 2);
        sViewsWithIds.put(R.id.call_button, 3);
        sViewsWithIds.put(R.id.distance_label, 4);
        sViewsWithIds.put(R.id.time_label, 5);
        sViewsWithIds.put(R.id.time_text, 6);
        sViewsWithIds.put(R.id.distance_text, 7);
        sViewsWithIds.put(R.id.cost_label, 8);
        sViewsWithIds.put(R.id.cost_text, 9);
        sViewsWithIds.put(R.id.layout_buttons, 10);
        sViewsWithIds.put(R.id.slide_start, 11);
        sViewsWithIds.put(R.id.slide_finish, 12);
        sViewsWithIds.put(R.id.slide_cancel, 13);
    }
    // views
    @NonNull
    public final android.support.v7.widget.AppCompatImageView callButton;
    @NonNull
    public final android.widget.TextView costLabel;
    @NonNull
    public final android.widget.TextView costText;
    @NonNull
    public final android.widget.TextView distanceLabel;
    @NonNull
    public final android.widget.TextView distanceText;
    @NonNull
    public final android.support.v7.widget.AppCompatImageView inLocationButton;
    @NonNull
    public final android.widget.LinearLayout layoutActions;
    @NonNull
    public final android.widget.LinearLayout layoutButtons;
    @NonNull
    private final android.support.constraint.ConstraintLayout mboundView0;
    @NonNull
    public final ng.max.slideview.SlideView slideCancel;
    @NonNull
    public final ng.max.slideview.SlideView slideFinish;
    @NonNull
    public final ng.max.slideview.SlideView slideStart;
    @NonNull
    public final android.widget.TextView timeLabel;
    @NonNull
    public final android.widget.TextView timeText;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityTravelBinding(@NonNull android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        super(bindingComponent, root, 0);
        final Object[] bindings = mapBindings(bindingComponent, root, 14, sIncludes, sViewsWithIds);
        this.callButton = (android.support.v7.widget.AppCompatImageView) bindings[3];
        this.costLabel = (android.widget.TextView) bindings[8];
        this.costText = (android.widget.TextView) bindings[9];
        this.distanceLabel = (android.widget.TextView) bindings[4];
        this.distanceText = (android.widget.TextView) bindings[7];
        this.inLocationButton = (android.support.v7.widget.AppCompatImageView) bindings[2];
        this.layoutActions = (android.widget.LinearLayout) bindings[1];
        this.layoutButtons = (android.widget.LinearLayout) bindings[10];
        this.mboundView0 = (android.support.constraint.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.slideCancel = (ng.max.slideview.SlideView) bindings[13];
        this.slideFinish = (ng.max.slideview.SlideView) bindings[12];
        this.slideStart = (ng.max.slideview.SlideView) bindings[11];
        this.timeLabel = (android.widget.TextView) bindings[5];
        this.timeText = (android.widget.TextView) bindings[6];
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x1L;
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
            return variableSet;
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
        // batch finished
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    @NonNull
    public static ActivityTravelBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityTravelBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<ActivityTravelBinding>inflate(inflater, com.wizag.taxi.driver.R.layout.activity_travel, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static ActivityTravelBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityTravelBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(com.wizag.taxi.driver.R.layout.activity_travel, null, false), bindingComponent);
    }
    @NonNull
    public static ActivityTravelBinding bind(@NonNull android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityTravelBinding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/activity_travel_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new ActivityTravelBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): null
    flag mapping end*/
    //end
}