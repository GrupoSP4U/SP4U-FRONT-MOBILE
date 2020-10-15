package com.example.sp4u_app.validator

import android.widget.EditText

fun validator(editTexts: List<EditText>): Boolean {
    var isValid = true
    editTexts.forEach { et ->
        run {
            if (et.text.isNullOrEmpty()) {
                et.error = "Deve ser preenchido"
                isValid = false
            }
        }
    }

    return isValid
}
