package com.example.sp4u_app.activity.register

import android.os.Bundle
import android.view.View
import com.example.sp4u_app.R
import com.example.sp4u_app.activity.HomeActivity
import com.example.sp4u_app.utils.AbstractActivity
import com.example.sp4u_app.utils.buildSpinner
import kotlinx.android.synthetic.main.activity_register_estabilishment_config_description.*

class RegisterEstablishmentConfigDescriptionActivity : AbstractActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_estabilishment_config_description)
        setVariables()

        buildSpinner(baseContext, ps_musica,
                listOf("sertanejo", "metal", "trap", "gospel", "hip-hop", "rap", "clássico", "pop",
                        "trance", "jazz", "forró", "kpop", "samba", "mpb", "folk", "rock", "axé", "funk", "pagode"))

        buildSpinner(baseContext, ps_estab, listOf("restaurante", "bar", "balada", "pub"))
    }
}
