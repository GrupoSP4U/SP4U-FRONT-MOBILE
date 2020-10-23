package com.example.sp4u_app

import android.os.Bundle
import android.view.View
import com.example.sp4u_app.utils.AbstractActivity

class RegisterEstabilishmentConfigActivity : AbstractActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_estabilishment_config)
        setVariables()
    }

    fun goToDescriptionOfRole(textView:View){
        navigate(userId, token, RegisterEstabilishmentConfigDescriptionActivity().javaClass)
    }
}
