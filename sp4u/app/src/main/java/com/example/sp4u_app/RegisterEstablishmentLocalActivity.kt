package com.example.sp4u_app

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.sp4u_app.R
import com.example.sp4u_app.RegisterEstablishmentMusicActivity
import com.example.sp4u_app.utils.AbstractActivity

class RegisterEstablishmentLocalActivity : AbstractActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_establishment_local)
        setVariables()
    }
}
