package com.example.sp4u_app.activity.user

import android.os.Bundle
import com.example.sp4u_app.R
import com.example.sp4u_app.utils.AbstractActivity

class UserProfileConfigActivity : AbstractActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile_config)
        setVariables()
    }
}
