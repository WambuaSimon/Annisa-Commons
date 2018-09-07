package com.wizag.taxi.common.databinding;
import android.databinding.Bindable;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
public abstract class DialogWriteComplaintBinding extends ViewDataBinding {
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
    protected DialogWriteComplaintBinding(@Nullable android.databinding.DataBindingComponent bindingComponent, @Nullable android.view.View root_, int localFieldCount
        , android.widget.LinearLayout customDialogLayoutDesignUserInput1
        , android.support.design.widget.TextInputEditText textContent1
        , android.support.design.widget.TextInputLayout textLayoutContent1
        , android.support.design.widget.TextInputLayout textLayoutSubject1
        , android.support.design.widget.TextInputEditText textSubject1
    ) {
        super(bindingComponent, root_, localFieldCount);
        this.customDialogLayoutDesignUserInput = customDialogLayoutDesignUserInput1;
        this.textContent = textContent1;
        this.textLayoutContent = textLayoutContent1;
        this.textLayoutSubject = textLayoutSubject1;
        this.textSubject = textSubject1;
    }
    //getters and abstract setters
    @NonNull
    public static DialogWriteComplaintBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static DialogWriteComplaintBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static DialogWriteComplaintBinding bind(@NonNull android.view.View view) {
        return null;
    }
    @NonNull
    public static DialogWriteComplaintBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return null;
    }
    @NonNull
    public static DialogWriteComplaintBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return null;
    }
    @NonNull
    public static DialogWriteComplaintBinding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return null;
    }
}