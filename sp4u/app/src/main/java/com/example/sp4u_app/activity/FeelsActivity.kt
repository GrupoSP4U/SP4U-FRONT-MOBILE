package com.example.sp4u_app.activity

import android.os.Bundle
import android.view.View
import com.example.sp4u_app.R
import com.example.sp4u_app.utils.AbstractActivity

class FeelsActivity : AbstractActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feels)
        userId = intent.getIntExtra("USER_ID", 0)
        token = intent.getStringExtra("TOKEN")
    }

    fun goToAdditionalFilters(button: View) {
        navigate(AdditionalFiltersActivity().javaClass)
    }
}
