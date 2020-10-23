package com.example.sp4u_app.utils

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

abstract class AbstractActivity : AppCompatActivity(){
    fun navigate(userId: Int?, token: String?, activityClass: Class<Any>) {
        val intent = Intent(this, activityClass)
        intent.putExtra("USER_ID", userId)
        intent.putExtra("TOKEN", token)
        startActivity(intent)
    }
}