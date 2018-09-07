package com.wizag.taxi.driver.databinding;
import com.wizag.taxi.driver.R;
import com.wizag.taxi.driver.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityEditProfileBinding extends android.databinding.ViewDataBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.app_bar_layout, 11);
        sViewsWithIds.put(R.id.collapse_toolbar, 12);
        sViewsWithIds.put(R.id.camera_header_image, 13);
        sViewsWithIds.put(R.id.upload_ride_label, 14);
        sViewsWithIds.put(R.id.toolbar, 15);
        sViewsWithIds.put(R.id.fields_layout, 16);
        sViewsWithIds.put(R.id.mobile_text_layout, 17);
        sViewsWithIds.put(R.id.email_text_layout, 18);
        sViewsWithIds.put(R.id.first_name_text_layout, 19);
        sViewsWithIds.put(R.id.last_name_text_layout, 20);
        sViewsWithIds.put(R.id.car_color_text_layout, 21);
        sViewsWithIds.put(R.id.plate_num_text_layout, 22);
        sViewsWithIds.put(R.id.address_text_layout, 23);
    }
    // views
    @NonNull
    public final android.support.design.widget.TextInputLayout addressTextLayout;
    @NonNull
    public final android.support.design.widget.AppBarLayout appBarLayout;
    @NonNull
    public final android.widget.ImageView cameraHeaderImage;
    @NonNull
    public final android.support.design.widget.TextInputLayout carColorTextLayout;
    @NonNull
    public final android.support.design.widget.CollapsingToolbarLayout collapseToolbar;
    @NonNull
    public final android.support.design.widget.TextInputLayout emailTextLayout;
    @NonNull
    public final android.widget.LinearLayout fieldsLayout;
    @NonNull
    public final android.support.design.widget.TextInputLayout firstNameTextLayout;
    @NonNull
    public final android.support.design.widget.TextInputLayout lastNameTextLayout;
    @NonNull
    private final android.support.design.widget.CoordinatorLayout mboundView0;
    @NonNull
    private final android.widget.EditText mboundView10;
    @NonNull
    private final android.support.v7.widget.AppCompatEditText mboundView3;
    @NonNull
    private final android.support.v7.widget.AppCompatEditText mboundView4;
    @NonNull
    private final android.widget.EditText mboundView5;
    @NonNull
    private final android.widget.EditText mboundView6;
    @NonNull
    private final android.widget.EditText mboundView8;
    @NonNull
    private final android.widget.EditText mboundView9;
    @NonNull
    public final android.widget.ImageView media;
    @NonNull
    public final android.support.design.widget.TextInputLayout mobileTextLayout;
    @NonNull
    public final android.support.design.widget.TextInputLayout plateNumTextLayout;
    @NonNull
    public final de.hdodenhof.circleimageview.CircleImageView profileImage;
    @NonNull
    public final com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner spinnerGender;
    @NonNull
    public final android.support.v7.widget.Toolbar toolbar;
    @NonNull
    public final android.widget.TextView uploadRideLabel;
    // variables
    @Nullable
    private com.wizag.taxi.common.utils.Converters mConverter;
    @Nullable
    private com.wizag.taxi.common.models.Driver mUser;
    // values
    // listeners
    // Inverse Binding Event Handlers
    private android.databinding.InverseBindingListener mboundView10androidTextAttrChanged = new android.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of user.address
            //         is user.setAddress((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = android.databinding.adapters.TextViewBindingAdapter.getTextString(mboundView10);
            // localize variables for thread safety
            // user.address
            java.lang.String userAddress = null;
            // user != null
            boolean userJavaLangObjectNull = false;
            // user
            com.wizag.taxi.common.models.Driver user = mUser;



            userJavaLangObjectNull = (user) != (null);
            if (userJavaLangObjectNull) {




                user.setAddress(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private android.databinding.InverseBindingListener mboundView4androidTextAttrChanged = new android.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of user.email
            //         is user.setEmail((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = android.databinding.adapters.TextViewBindingAdapter.getTextString(mboundView4);
            // localize variables for thread safety
            // user.email
            java.lang.String userEmail = null;
            // user != null
            boolean userJavaLangObjectNull = false;
            // user
            com.wizag.taxi.common.models.Driver user = mUser;



            userJavaLangObjectNull = (user) != (null);
            if (userJavaLangObjectNull) {




                user.setEmail(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private android.databinding.InverseBindingListener mboundView5androidTextAttrChanged = new android.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of user.firstName
            //         is user.setFirstName((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = android.databinding.adapters.TextViewBindingAdapter.getTextString(mboundView5);
            // localize variables for thread safety
            // user != null
            boolean userJavaLangObjectNull = false;
            // user.firstName
            java.lang.String userFirstName = null;
            // user
            com.wizag.taxi.common.models.Driver user = mUser;



            userJavaLangObjectNull = (user) != (null);
            if (userJavaLangObjectNull) {




                user.setFirstName(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private android.databinding.InverseBindingListener mboundView6androidTextAttrChanged = new android.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of user.lastName
            //         is user.setLastName((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = android.databinding.adapters.TextViewBindingAdapter.getTextString(mboundView6);
            // localize variables for thread safety
            // user != null
            boolean userJavaLangObjectNull = false;
            // user
            com.wizag.taxi.common.models.Driver user = mUser;
            // user.lastName
            java.lang.String userLastName = null;



            userJavaLangObjectNull = (user) != (null);
            if (userJavaLangObjectNull) {




                user.setLastName(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private android.databinding.InverseBindingListener mboundView8androidTextAttrChanged = new android.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of user.carColor
            //         is user.setCarColor((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = android.databinding.adapters.TextViewBindingAdapter.getTextString(mboundView8);
            // localize variables for thread safety
            // user != null
            boolean userJavaLangObjectNull = false;
            // user
            com.wizag.taxi.common.models.Driver user = mUser;
            // user.carColor
            java.lang.String userCarColor = null;



            userJavaLangObjectNull = (user) != (null);
            if (userJavaLangObjectNull) {




                user.setCarColor(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private android.databinding.InverseBindingListener mboundView9androidTextAttrChanged = new android.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of user.carPlate
            //         is user.setCarPlate((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = android.databinding.adapters.TextViewBindingAdapter.getTextString(mboundView9);
            // localize variables for thread safety
            // user != null
            boolean userJavaLangObjectNull = false;
            // user
            com.wizag.taxi.common.models.Driver user = mUser;
            // user.carPlate
            java.lang.String userCarPlate = null;



            userJavaLangObjectNull = (user) != (null);
            if (userJavaLangObjectNull) {




                user.setCarPlate(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private android.databinding.InverseBindingListener spinnerGendergenderAttrChanged = new android.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of user.gender
            //         is user.setGender((com.wizag.taxi.common.models.Gender) callbackArg_0)
            com.wizag.taxi.common.models.Gender callbackArg_0 = com.wizag.taxi.common.utils.DataBinder.getGender(spinnerGender);
            // localize variables for thread safety
            // user != null
            boolean userJavaLangObjectNull = false;
            // user
            com.wizag.taxi.common.models.Driver user = mUser;
            // user.gender
            com.wizag.taxi.common.models.Gender userGender = null;



            userJavaLangObjectNull = (user) != (null);
            if (userJavaLangObjectNull) {




                user.setGender(((com.wizag.taxi.common.models.Gender) (callbackArg_0)));
            }
        }
    };

    public ActivityEditProfileBinding(@NonNull android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        super(bindingComponent, root, 1);
        final Object[] bindings = mapBindings(bindingComponent, root, 24, sIncludes, sViewsWithIds);
        this.addressTextLayout = (android.support.design.widget.TextInputLayout) bindings[23];
        this.appBarLayout = (android.support.design.widget.AppBarLayout) bindings[11];
        this.cameraHeaderImage = (android.widget.ImageView) bindings[13];
        this.carColorTextLayout = (android.support.design.widget.TextInputLayout) bindings[21];
        this.collapseToolbar = (android.support.design.widget.CollapsingToolbarLayout) bindings[12];
        this.emailTextLayout = (android.support.design.widget.TextInputLayout) bindings[18];
        this.fieldsLayout = (android.widget.LinearLayout) bindings[16];
        this.firstNameTextLayout = (android.support.design.widget.TextInputLayout) bindings[19];
        this.lastNameTextLayout = (android.support.design.widget.TextInputLayout) bindings[20];
        this.mboundView0 = (android.support.design.widget.CoordinatorLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView10 = (android.widget.EditText) bindings[10];
        this.mboundView10.setTag(null);
        this.mboundView3 = (android.support.v7.widget.AppCompatEditText) bindings[3];
        this.mboundView3.setTag(null);
        this.mboundView4 = (android.support.v7.widget.AppCompatEditText) bindings[4];
        this.mboundView4.setTag(null);
        this.mboundView5 = (android.widget.EditText) bindings[5];
        this.mboundView5.setTag(null);
        this.mboundView6 = (android.widget.EditText) bindings[6];
        this.mboundView6.setTag(null);
        this.mboundView8 = (android.widget.EditText) bindings[8];
        this.mboundView8.setTag(null);
        this.mboundView9 = (android.widget.EditText) bindings[9];
        this.mboundView9.setTag(null);
        this.media = (android.widget.ImageView) bindings[1];
        this.media.setTag(null);
        this.mobileTextLayout = (android.support.design.widget.TextInputLayout) bindings[17];
        this.plateNumTextLayout = (android.support.design.widget.TextInputLayout) bindings[22];
        this.profileImage = (de.hdodenhof.circleimageview.CircleImageView) bindings[2];
        this.profileImage.setTag(null);
        this.spinnerGender = (com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner) bindings[7];
        this.spinnerGender.setTag(null);
        this.toolbar = (android.support.v7.widget.Toolbar) bindings[15];
        this.uploadRideLabel = (android.widget.TextView) bindings[14];
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x20L;
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
        if (BR.converter == variableId) {
            setConverter((com.wizag.taxi.common.utils.Converters) variable);
        }
        else if (BR.user == variableId) {
            setUser((com.wizag.taxi.common.models.Driver) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setConverter(@Nullable com.wizag.taxi.common.utils.Converters Converter) {
        this.mConverter = Converter;
    }
    @Nullable
    public com.wizag.taxi.common.utils.Converters getConverter() {
        return mConverter;
    }
    public void setUser(@Nullable com.wizag.taxi.common.models.Driver User) {
        updateRegistration(0, User);
        this.mUser = User;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.user);
        super.requestRebind();
    }
    @Nullable
    public com.wizag.taxi.common.models.Driver getUser() {
        return mUser;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeUser((com.wizag.taxi.common.models.Driver) object, fieldId);
        }
        return false;
    }
    private boolean onChangeUser(com.wizag.taxi.common.models.Driver User, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        else if (fieldId == BR.carMedia) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
            }
            return true;
        }
        else if (fieldId == BR.media) {
            synchronized(this) {
                    mDirtyFlags |= 0x8L;
            }
            return true;
        }
        else if (fieldId == BR.gender) {
            synchronized(this) {
                    mDirtyFlags |= 0x10L;
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
        java.lang.String stringValueOfUserMobileNumber = null;
        com.wizag.taxi.common.models.Media userCarMedia = null;
        com.wizag.taxi.common.models.Gender userGender = null;
        java.lang.String userEmail = null;
        com.wizag.taxi.common.models.Media userMedia = null;
        java.lang.String userFirstName = null;
        java.lang.String userCarColor = null;
        java.lang.String userCarPlate = null;
        long userMobileNumber = 0L;
        com.wizag.taxi.common.models.Driver user = mUser;
        java.lang.String userAddress = null;
        java.lang.String userLastName = null;

        if ((dirtyFlags & 0x3dL) != 0) {


            if ((dirtyFlags & 0x25L) != 0) {

                    if (user != null) {
                        // read user.carMedia
                        userCarMedia = user.getCarMedia();
                    }
            }
            if ((dirtyFlags & 0x31L) != 0) {

                    if (user != null) {
                        // read user.gender
                        userGender = user.getGender();
                    }
            }
            if ((dirtyFlags & 0x21L) != 0) {

                    if (user != null) {
                        // read user.email
                        userEmail = user.getEmail();
                        // read user.firstName
                        userFirstName = user.getFirstName();
                        // read user.carColor
                        userCarColor = user.getCarColor();
                        // read user.carPlate
                        userCarPlate = user.getCarPlate();
                        // read user.mobileNumber
                        userMobileNumber = user.getMobileNumber();
                        // read user.address
                        userAddress = user.getAddress();
                        // read user.lastName
                        userLastName = user.getLastName();
                    }


                    // read String.valueOf(user.mobileNumber)
                    stringValueOfUserMobileNumber = java.lang.String.valueOf(userMobileNumber);
            }
            if ((dirtyFlags & 0x29L) != 0) {

                    if (user != null) {
                        // read user.media
                        userMedia = user.getMedia();
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0x21L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView10, userAddress);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView3, stringValueOfUserMobileNumber);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView4, userEmail);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView5, userFirstName);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView6, userLastName);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView8, userCarColor);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView9, userCarPlate);
        }
        if ((dirtyFlags & 0x20L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.mboundView10, (android.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, mboundView10androidTextAttrChanged);
            android.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.mboundView4, (android.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, mboundView4androidTextAttrChanged);
            android.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.mboundView5, (android.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, mboundView5androidTextAttrChanged);
            android.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.mboundView6, (android.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, mboundView6androidTextAttrChanged);
            android.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.mboundView8, (android.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, mboundView8androidTextAttrChanged);
            android.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.mboundView9, (android.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, mboundView9androidTextAttrChanged);
            com.wizag.taxi.common.utils.DataBinder.bindGenderChanged(this.spinnerGender, spinnerGendergenderAttrChanged);
        }
        if ((dirtyFlags & 0x25L) != 0) {
            // api target 1

            com.wizag.taxi.common.utils.DataBinder.setMedia(this.media, userCarMedia);
        }
        if ((dirtyFlags & 0x29L) != 0) {
            // api target 1

            com.wizag.taxi.common.utils.DataBinder.setMedia(this.profileImage, userMedia);
        }
        if ((dirtyFlags & 0x31L) != 0) {
            // api target 1

            com.wizag.taxi.common.utils.DataBinder.setGender(this.spinnerGender, userGender);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    @NonNull
    public static ActivityEditProfileBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityEditProfileBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<ActivityEditProfileBinding>inflate(inflater, com.wizag.taxi.driver.R.layout.activity_edit_profile, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static ActivityEditProfileBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityEditProfileBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(com.wizag.taxi.driver.R.layout.activity_edit_profile, null, false), bindingComponent);
    }
    @NonNull
    public static ActivityEditProfileBinding bind(@NonNull android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityEditProfileBinding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/activity_edit_profile_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new ActivityEditProfileBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): user
        flag 1 (0x2L): converter
        flag 2 (0x3L): user.carMedia
        flag 3 (0x4L): user.media
        flag 4 (0x5L): user.gender
        flag 5 (0x6L): null
    flag mapping end*/
    //end
}