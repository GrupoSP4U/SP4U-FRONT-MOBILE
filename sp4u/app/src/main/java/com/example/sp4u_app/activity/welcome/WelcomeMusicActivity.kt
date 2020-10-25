package com.example.sp4u_app.activity.welcome

import android.os.Bundle
import android.view.View
import com.example.sp4u_app.R
import com.example.sp4u_app.utils.AbstractActivity

class WelcomeMusicActivity : AbstractActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome_music)
        setVariables()
    }

    fun goToWelcomeLocal(component: View) {
        navigate(userId, token, WelcomeLocalActivity().javaClass)
    }
}
