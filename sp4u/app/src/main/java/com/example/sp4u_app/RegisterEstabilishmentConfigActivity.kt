package com.example.sp4u_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.sp4u_app.utils.AbstractActivity

class RegisterEstabilishmentConfigActivity : AbstractActivity() {

    private var userId: Int? = 0
    private var token: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_estabilishment_config)
        userId = intent.getIntExtra("USER_ID", 0)
        token = intent.getStringExtra("TOKEN")
    }

    fun goToDescriptionOfRole(textView:View){
        navigate(userId, token, RegisterEstabilishmentConfigDescriptionActivity().javaClass)
    }
}