package com.example.sp4u_app.activity

import android.os.Bundle
import android.view.View
import com.example.sp4u_app.R
import com.example.sp4u_app.utils.AbstractActivity

class AdditionalFiltersActivity : AbstractActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_additional_filters)
        userId = intent.getIntExtra("USER_ID", 0)
        token = intent.getStringExtra("TOKEN")
    }

    fun goToResult(button: View){
        navigate(ResultActivity().javaClass)
    }
}
