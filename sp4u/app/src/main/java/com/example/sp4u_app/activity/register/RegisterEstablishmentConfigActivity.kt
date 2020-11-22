package com.example.sp4u_app.activity.register

import android.os.Bundle
import android.view.View
import com.example.sp4u_app.R
import com.example.sp4u_app.utils.AbstractActivity

class RegisterEstablishmentConfigActivity : AbstractActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_establishment_config)
        setVariables()
    }

    fun goToDescriptionOfRole(textView:View){
        navigate(userId, token, RegisterEstablishmentConfigDescriptionActivity().javaClass)
    }
}
