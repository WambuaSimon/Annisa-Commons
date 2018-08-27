package com.wizag.taxi.common.interfaces;

import com.wizag.taxi.common.utils.AlertDialogBuilder;

public interface AlertDialogEvent {
    void onAnswerDialog(AlertDialogBuilder.DialogResult result);
}