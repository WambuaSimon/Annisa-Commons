package com.wizag.taxi.driver.databinding;
import com.wizag.taxi.driver.R;
import com.wizag.taxi.driver.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityMainBinding extends android.databinding.ViewDataBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.appbarLayout, 1);
        sViewsWithIds.put(R.id.appbar, 2);
        sViewsWithIds.put(R.id.textView3, 3);
        sViewsWithIds.put(R.id.switch_connection, 4);
        sViewsWithIds.put(R.id.map_layout, 5);
        sViewsWithIds.put(R.id.bottom_sheet, 6);
        sViewsWithIds.put(R.id.requests_view_pager, 7);
        sViewsWithIds.put(R.id.floatingActionButton, 8);
        sViewsWithIds.put(R.id.request_show_fab, 9);
        sViewsWithIds.put(R.id.navigation_view, 10);
    }
    // views
    @NonNull
    public final android.support.v7.widget.Toolbar appbar;
    @NonNull
    public final android.support.design.widget.AppBarLayout appbarLayout;
    @NonNull
    public final android.support.v7.widget.CardView bottomSheet;
    @NonNull
    public final android.support.v4.widget.DrawerLayout drawerLayout;
    @NonNull
    public final android.support.design.widget.FloatingActionButton floatingActionButton;
    @NonNull
    public final android.widget.LinearLayout mapLayout;
    @NonNull
    public final android.support.design.widget.NavigationView navigationView;
    @NonNull
    public final android.support.design.widget.FloatingActionButton requestShowFab;
    @NonNull
    public final android.support.v4.view.ViewPager requestsViewPager;
    @NonNull
    public final android.widget.Switch switchConnection;
    @NonNull
    public final android.widget.TextView textView3;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityMainBinding(@NonNull android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        super(bindingComponent, root, 0);
        final Object[] bindings = mapBindings(bindingComponent, root, 11, sIncludes, sViewsWithIds);
        this.appbar = (android.support.v7.widget.Toolbar) bindings[2];
        this.appbarLayout = (android.support.design.widget.AppBarLayout) bindings[1];
        this.bottomSheet = (android.support.v7.widget.CardView) bindings[6];
        this.drawerLayout = (android.support.v4.widget.DrawerLayout) bindings[0];
        this.drawerLayout.setTag(null);
        this.floatingActionButton = (android.support.design.widget.FloatingActionButton) bindings[8];
        this.mapLayout = (android.widget.LinearLayout) bindings[5];
        this.navigationView = (android.support.design.widget.NavigationView) bindings[10];
        this.requestShowFab = (android.support.design.widget.FloatingActionButton) bindings[9];
        this.requestsViewPager = (android.support.v4.view.ViewPager) bindings[7];
        this.switchConnection = (android.widget.Switch) bindings[4];
        this.textView3 = (android.widget.TextView) bindings[3];
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
    public static ActivityMainBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityMainBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<ActivityMainBinding>inflate(inflater, com.wizag.taxi.driver.R.layout.activity_main, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static ActivityMainBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityMainBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(com.wizag.taxi.driver.R.layout.activity_main, null, false), bindingComponent);
    }
    @NonNull
    public static ActivityMainBinding bind(@NonNull android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityMainBinding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/activity_main_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new ActivityMainBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): null
    flag mapping end*/
    //end
}