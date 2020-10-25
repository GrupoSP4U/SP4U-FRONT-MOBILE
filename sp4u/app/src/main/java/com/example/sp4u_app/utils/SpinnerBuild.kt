package com.example.sp4u_app.utils

import android.R
import android.content.Context
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner

fun buildSpinner(context: Context, spinner: Spinner, list: List<String>) {
    val combo = ArrayAdapter(context, R.layout.simple_spinner_item, list)

    combo.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
    spinner.adapter = combo

    spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
        override fun onNothingSelected(parent: AdapterView<*>?) {}

        override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
            // either one will work as well
            // val item = parent.getItemAtPosition(position) as String
            val item = combo.getItem(position)
        }
    }
}
