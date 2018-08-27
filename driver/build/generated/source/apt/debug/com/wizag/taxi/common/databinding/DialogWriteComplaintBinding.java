package com.wizag.taxi.common.databinding;
import com.wizag.taxi.common.R;
import com.wizag.taxi.common.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class DialogWriteComplaintBinding extends android.databinding.ViewDataBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.text_layout_subject, 1);
        sViewsWithIds.put(R.id.text_subject, 2);
        sViewsWithIds.put(R.id.text_layout_content, 3);
        sViewsWithIds.put(R.id.text_content, 4);
    }
    // views
    @NonNull
    public final android.widget.LinearLayout customDialogLayoutDesignUserInput;
    @NonNull
    public final android.support.design.widget.TextInputEditText textContent;
    @NonNull
    public final android.support.design.widget.TextInputLayout textLayoutContent;
    @NonNull
    public final android.support.design.widget.TextInputLayout textLayoutSubject;
    @NonNull
    public final android.support.design.widget.TextInputEditText textSubject;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public DialogWriteComplaintBinding(@NonNull android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        super(bindingComponent, root, 0);
        final Object[] bindings = mapBindings(bindingComponent, root, 5, sIncludes, sViewsWithIds);
        this.customDialogLayoutDesignUserInput = (android.widget.LinearLayout) bindings[0];
        this.customDialogLayoutDesignUserInput.setTag(null);
        this.textContent = (android.support.design.widget.TextInputEditText) bindings[4];
        this.textLayoutContent = (android.support.design.widget.TextInputLayout) bindings[3];
        this.textLayoutSubject = (android.support.design.widget.TextInputLayout) bindings[1];
        this.textSubject = (android.support.design.widget.TextInputEditText) bindings[2];
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
    public static DialogWriteComplaintBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static DialogWriteComplaintBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<DialogWriteComplaintBinding>inflate(inflater, com.wizag.taxi.common.R.layout.dialog_write_complaint, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static DialogWriteComplaintBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static DialogWriteComplaintBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(com.wizag.taxi.common.R.layout.dialog_write_complaint, null, false), bindingComponent);
    }
    @NonNull
    public static DialogWriteComplaintBinding bind(@NonNull android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static DialogWriteComplaintBinding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/dialog_write_complaint_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new DialogWriteComplaintBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): null
    flag mapping end*/
    //end
}