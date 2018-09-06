package com.wizag.taxi.rider.databinding;
import com.wizag.taxi.rider.R;
import com.wizag.taxi.rider.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentTravelDriverBinding extends android.databinding.ViewDataBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.image_driver, 1);
        sViewsWithIds.put(R.id.text_driver_name, 2);
        sViewsWithIds.put(R.id.text_car_name, 3);
        sViewsWithIds.put(R.id.image_location, 4);
        sViewsWithIds.put(R.id.text_pickup, 5);
        sViewsWithIds.put(R.id.text_destination, 6);
    }
    // views
    @NonNull
    public final de.hdodenhof.circleimageview.CircleImageView imageDriver;
    @NonNull
    public final android.widget.ImageView imageLocation;
    @NonNull
    private final android.support.constraint.ConstraintLayout mboundView0;
    @NonNull
    public final android.widget.TextView textCarName;
    @NonNull
    public final android.widget.TextView textDestination;
    @NonNull
    public final android.widget.TextView textDriverName;
    @NonNull
    public final android.widget.TextView textPickup;
    // variables
    @Nullable
    private com.wizag.taxi.common.models.Driver mDriver;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentTravelDriverBinding(@NonNull android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        super(bindingComponent, root, 1);
        final Object[] bindings = mapBindings(bindingComponent, root, 7, sIncludes, sViewsWithIds);
        this.imageDriver = (de.hdodenhof.circleimageview.CircleImageView) bindings[1];
        this.imageLocation = (android.widget.ImageView) bindings[4];
        this.mboundView0 = (android.support.constraint.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.textCarName = (android.widget.TextView) bindings[3];
        this.textDestination = (android.widget.TextView) bindings[6];
        this.textDriverName = (android.widget.TextView) bindings[2];
        this.textPickup = (android.widget.TextView) bindings[5];
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
        if (BR.driver == variableId) {
            setDriver((com.wizag.taxi.common.models.Driver) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setDriver(@Nullable com.wizag.taxi.common.models.Driver Driver) {
        this.mDriver = Driver;
    }
    @Nullable
    public com.wizag.taxi.common.models.Driver getDriver() {
        return mDriver;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeDriver((com.wizag.taxi.common.models.Driver) object, fieldId);
        }
        return false;
    }
    private boolean onChangeDriver(com.wizag.taxi.common.models.Driver Driver, int fieldId) {
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
    public static FragmentTravelDriverBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static FragmentTravelDriverBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<FragmentTravelDriverBinding>inflate(inflater, com.wizag.taxi.rider.R.layout.fragment_travel_driver, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static FragmentTravelDriverBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static FragmentTravelDriverBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(com.wizag.taxi.rider.R.layout.fragment_travel_driver, null, false), bindingComponent);
    }
    @NonNull
    public static FragmentTravelDriverBinding bind(@NonNull android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static FragmentTravelDriverBinding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/fragment_travel_driver_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new FragmentTravelDriverBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): driver
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}