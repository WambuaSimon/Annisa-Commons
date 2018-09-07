package com.wizag.taxi.driver.databinding;
import com.wizag.taxi.driver.R;
import com.wizag.taxi.driver.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityStatisticsBinding extends android.databinding.ViewDataBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.app_bar_layout, 3);
        sViewsWithIds.put(R.id.toolbar, 4);
        sViewsWithIds.put(R.id.tab_date, 5);
        sViewsWithIds.put(R.id.income_card, 6);
        sViewsWithIds.put(R.id.income_text, 7);
        sViewsWithIds.put(R.id.income_label, 8);
        sViewsWithIds.put(R.id.service_card, 9);
        sViewsWithIds.put(R.id.service_text, 10);
        sViewsWithIds.put(R.id.service_label, 11);
        sViewsWithIds.put(R.id.rating_card, 12);
        sViewsWithIds.put(R.id.rating_text, 13);
        sViewsWithIds.put(R.id.rating_label, 14);
        sViewsWithIds.put(R.id.chart_card, 15);
        sViewsWithIds.put(R.id.chart, 16);
        sViewsWithIds.put(R.id.payment_request_card, 17);
        sViewsWithIds.put(R.id.label_payment_request, 18);
        sViewsWithIds.put(R.id.text_payment_bound, 19);
    }
    // views
    @NonNull
    public final android.support.design.widget.AppBarLayout appBarLayout;
    @NonNull
    public final android.widget.Button buttonPaymentRequest;
    @NonNull
    public final com.db.chart.view.LineChartView chart;
    @NonNull
    public final android.support.v7.widget.CardView chartCard;
    @NonNull
    public final android.support.v7.widget.CardView incomeCard;
    @NonNull
    public final android.widget.TextView incomeLabel;
    @NonNull
    public final android.widget.TextView incomeText;
    @NonNull
    public final android.widget.TextView labelPaymentRequest;
    @NonNull
    private final android.support.constraint.ConstraintLayout mboundView0;
    @NonNull
    public final android.support.v7.widget.CardView paymentRequestCard;
    @NonNull
    public final android.widget.ProgressBar progressPayment;
    @NonNull
    public final android.support.v7.widget.CardView ratingCard;
    @NonNull
    public final android.widget.TextView ratingLabel;
    @NonNull
    public final android.widget.TextView ratingText;
    @NonNull
    public final android.support.v7.widget.CardView serviceCard;
    @NonNull
    public final android.widget.TextView serviceLabel;
    @NonNull
    public final android.widget.TextView serviceText;
    @NonNull
    public final android.support.design.widget.TabLayout tabDate;
    @NonNull
    public final android.widget.TextView textPaymentBound;
    @NonNull
    public final android.support.v7.widget.Toolbar toolbar;
    // variables
    @Nullable
    private com.wizag.taxi.common.models.Driver mDriver;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityStatisticsBinding(@NonNull android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        super(bindingComponent, root, 1);
        final Object[] bindings = mapBindings(bindingComponent, root, 20, sIncludes, sViewsWithIds);
        this.appBarLayout = (android.support.design.widget.AppBarLayout) bindings[3];
        this.buttonPaymentRequest = (android.widget.Button) bindings[2];
        this.buttonPaymentRequest.setTag(null);
        this.chart = (com.db.chart.view.LineChartView) bindings[16];
        this.chartCard = (android.support.v7.widget.CardView) bindings[15];
        this.incomeCard = (android.support.v7.widget.CardView) bindings[6];
        this.incomeLabel = (android.widget.TextView) bindings[8];
        this.incomeText = (android.widget.TextView) bindings[7];
        this.labelPaymentRequest = (android.widget.TextView) bindings[18];
        this.mboundView0 = (android.support.constraint.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.paymentRequestCard = (android.support.v7.widget.CardView) bindings[17];
        this.progressPayment = (android.widget.ProgressBar) bindings[1];
        this.progressPayment.setTag(null);
        this.ratingCard = (android.support.v7.widget.CardView) bindings[12];
        this.ratingLabel = (android.widget.TextView) bindings[14];
        this.ratingText = (android.widget.TextView) bindings[13];
        this.serviceCard = (android.support.v7.widget.CardView) bindings[9];
        this.serviceLabel = (android.widget.TextView) bindings[11];
        this.serviceText = (android.widget.TextView) bindings[10];
        this.tabDate = (android.support.design.widget.TabLayout) bindings[5];
        this.textPaymentBound = (android.widget.TextView) bindings[19];
        this.toolbar = (android.support.v7.widget.Toolbar) bindings[4];
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
        updateRegistration(0, Driver);
        this.mDriver = Driver;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.driver);
        super.requestRebind();
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
        java.lang.Double driverBalance = null;
        boolean androidDatabindingViewDataBindingSafeUnboxDriverBalanceInt50BooleanTrueBooleanFalse = false;
        com.wizag.taxi.common.models.Driver driver = mDriver;
        boolean androidDatabindingViewDataBindingSafeUnboxDriverBalanceInt50 = false;
        int intAndroidDatabindingViewDataBindingSafeUnboxDriverBalance = 0;
        double androidDatabindingViewDataBindingSafeUnboxDriverBalance = 0.0;

        if ((dirtyFlags & 0x3L) != 0) {



                if (driver != null) {
                    // read driver.balance
                    driverBalance = driver.getBalance();
                }


                // read android.databinding.ViewDataBinding.safeUnbox(driver.balance)
                androidDatabindingViewDataBindingSafeUnboxDriverBalance = android.databinding.ViewDataBinding.safeUnbox(driverBalance);


                // read android.databinding.ViewDataBinding.safeUnbox(driver.balance) >= 50
                androidDatabindingViewDataBindingSafeUnboxDriverBalanceInt50 = (androidDatabindingViewDataBindingSafeUnboxDriverBalance) >= (50);
                // read (int) android.databinding.ViewDataBinding.safeUnbox(driver.balance)
                intAndroidDatabindingViewDataBindingSafeUnboxDriverBalance = ((int) (androidDatabindingViewDataBindingSafeUnboxDriverBalance));
            if((dirtyFlags & 0x3L) != 0) {
                if(androidDatabindingViewDataBindingSafeUnboxDriverBalanceInt50) {
                        dirtyFlags |= 0x8L;
                }
                else {
                        dirtyFlags |= 0x4L;
                }
            }


                // read android.databinding.ViewDataBinding.safeUnbox(driver.balance) >= 50 ? true : false
                androidDatabindingViewDataBindingSafeUnboxDriverBalanceInt50BooleanTrueBooleanFalse = ((androidDatabindingViewDataBindingSafeUnboxDriverBalanceInt50) ? (true) : (false));
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            this.buttonPaymentRequest.setEnabled(androidDatabindingViewDataBindingSafeUnboxDriverBalanceInt50BooleanTrueBooleanFalse);
            this.progressPayment.setProgress(intAndroidDatabindingViewDataBindingSafeUnboxDriverBalance);
        }
        if ((dirtyFlags & 0x2L) != 0) {
            // api target 1

            this.progressPayment.setMax(progressPayment.getResources().getInteger(R.integer.minimum_payment_request));
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    @NonNull
    public static ActivityStatisticsBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityStatisticsBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<ActivityStatisticsBinding>inflate(inflater, com.wizag.taxi.driver.R.layout.activity_statistics, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static ActivityStatisticsBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityStatisticsBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(com.wizag.taxi.driver.R.layout.activity_statistics, null, false), bindingComponent);
    }
    @NonNull
    public static ActivityStatisticsBinding bind(@NonNull android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityStatisticsBinding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/activity_statistics_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new ActivityStatisticsBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): driver
        flag 1 (0x2L): null
        flag 2 (0x3L): android.databinding.ViewDataBinding.safeUnbox(driver.balance) >= 50 ? true : false
        flag 3 (0x4L): android.databinding.ViewDataBinding.safeUnbox(driver.balance) >= 50 ? true : false
    flag mapping end*/
    //end
}