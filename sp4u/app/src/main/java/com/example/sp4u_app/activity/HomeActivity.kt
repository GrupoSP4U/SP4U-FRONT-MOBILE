package com.example.sp4u_app.activity

import android.os.Bundle
import com.example.sp4u_app.R
import com.example.sp4u_app.utils.AbstractActivity

class HomeActivity : AbstractActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setVariables()
    }
}