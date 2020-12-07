package com.example.sp4u_app.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.example.sp4u_app.R
import com.example.sp4u_app.dto.enums.Caracteristicas
import com.example.sp4u_app.utils.AbstractActivity
import kotlinx.android.synthetic.main.activity_feels.*

class FeelsActivity : AbstractActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feels)
        setVariables()
    }

    fun goToAdditionalFilters(button: View) {
        val intent = Intent(this, AdditionalFiltersActivity::class.java)
        intent.putExtra("USER_ID", userId)
        intent.putExtra("TOKEN", token)

        when (button) {
            cv_animado -> intent.putExtra("HUMOR", Caracteristicas.ANIMADO)
            cv_com_fome -> intent.putExtra("HUMOR", Caracteristicas.COM_FOME)
            cv_feliz -> intent.putExtra("HUMOR", Caracteristicas.FELIZ)
            cv_desanimado -> intent.putExtra("HUMOR", Caracteristicas.DESANIMADO)
            cv_entediado -> intent.putExtra("HUMOR", Caracteristicas.ENTEDIADO)
            cv_fogoso -> intent.putExtra("HUMOR", Caracteristicas.FOGOSO)
        }

        startActivity(intent)
    }
}
