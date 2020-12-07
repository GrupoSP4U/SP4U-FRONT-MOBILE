package com.example.sp4u_app.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.example.sp4u_app.R
import com.example.sp4u_app.dto.EstabelecimentoDTO
import com.example.sp4u_app.dto.enums.Caracteristicas
import com.example.sp4u_app.utils.AbstractActivity
import kotlinx.android.synthetic.main.activity_additional_filters.*
import java.io.Serializable

class AdditionalFiltersActivity : AbstractActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_additional_filters)
        setVariables()
    }

    fun goToResult(button: View){
        val listCaracteristicas = ArrayList<Caracteristicas>()
        listCaracteristicas.add(intent.getSerializableExtra("HUMOR") as Caracteristicas)

        if(sw_cardapio_vegetariano.isChecked) {
            listCaracteristicas.add(Caracteristicas.VEGETARIANO)
        }

        if(sw_cardapio_vegano.isChecked) {
            listCaracteristicas.add(Caracteristicas.VEGANO)
        }

        if(sw_animais_permitidos.isChecked) {
            listCaracteristicas.add(Caracteristicas.PETS)
        }

        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra("USER_ID", userId)
        intent.putExtra("TOKEN", token)
        intent.putExtra("CARACTERISTICAS",  listCaracteristicas)
        startActivity(intent)
    }
}
