package com.example.sp4u_app

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.sp4u_app.utils.AbstractActivity

class HomeActivity : AbstractActivity() {

    private var userId: Int? = 0
    private var token: String? = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        userId = intent.getIntExtra("USER_ID", 0)
        token = intent.getStringExtra("TOKEN")

        if(userId == 0) {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }

    //    menu config

    fun goToHomeAuthenticated(button: View) {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }

    fun goToHumor(button: View) {
        navigate(userId, token, FeelsActivity().javaClass)
    }

    fun goToBasicSettings(button: View){
        val register = Intent(this, UserProfileActivity::class.java)
        startActivity(register)
    }

    fun goToEnterprise(button: View){
        val register = Intent(this, RegisterEstablishmentActivity::class.java)
        startActivity(register)
    }

//    fim menu config

}
