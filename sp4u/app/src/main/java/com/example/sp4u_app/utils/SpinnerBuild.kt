package com.example.sp4u_app.utils


import android.content.Context
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.example.sp4u_app.R

fun buildSpinner(context: Context, spinner: Spinner, list: List<String>?) {
    val combo = list?.let { ArrayAdapter(context, R.layout.spinner_item, it) }

    combo?.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
    spinner.adapter = combo

    spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
        override fun onNothingSelected(parent: AdapterView<*>?) {}

        override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
            // either one will work as well
            // val item = parent.getItemAtPosition(position) as String
            val item = combo?.getItem(position)
        }
    }
}
