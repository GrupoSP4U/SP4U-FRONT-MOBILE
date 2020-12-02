package com.example.sp4u_app.activity.register

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.sp4u_app.R
import com.example.sp4u_app.dto.EstabelecimentoDTO
import com.example.sp4u_app.dto.enums.Caracteristicas
import com.example.sp4u_app.utils.AbstractActivity
import com.example.sp4u_app.utils.RetrofitInitializer
import com.example.sp4u_app.validator.validator
import kotlinx.android.synthetic.main.activity_register_establishment_filters.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterEstablishmentFiltersActivity : AbstractActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_establishment_filters)
        setVariables()
    }

    fun registerAndGoToEstablishmentConfig(button: View) {
        validator(listOf(et_tell_about))

        var caracteristicasEstabelecimento: MutableList<Caracteristicas> = mutableListOf()
        var estabelecimentoDTO =
                intent.getSerializableExtra("ESTABELECIMENTO") as EstabelecimentoDTO?

        if (sw_cardapio_vegetariano.isChecked) caracteristicasEstabelecimento.add(Caracteristicas.VEGETARIANO)
        if (sw_cardapio_vegano.isChecked) caracteristicasEstabelecimento.add(Caracteristicas.VEGANO)
        if (sw_animais_permitidos.isChecked) caracteristicasEstabelecimento.add(Caracteristicas.PETS)

        estabelecimentoDTO?.tagsEstabelecimento?.caracteristicas = caracteristicasEstabelecimento
        estabelecimentoDTO?.paraMaiores = sw_idade_permitida.isChecked
        estabelecimentoDTO?.descricao = et_tell_about.text.toString()

        registerEstablishment(estabelecimentoDTO)
    }

    private fun registerEstablishment(request: EstabelecimentoDTO?) {
        val call = RetrofitInitializer(token)
                .establishmentService()
                .register(request)

        call.enqueue(object : Callback<Void?> {
            override fun onResponse(
                    call: Call<Void?>?,
                    response: Response<Void?>?
            ) {
                if (response?.code() == 201) {
                    navigateWithEstablishmentObject(
                        request,
                        RegisterEstablishmentConfigActivity().javaClass
                    )
                } else {
                    Toast.makeText(
                            baseContext,
                            resources.getString(R.string.requisicao_erro_interno),
                            Toast.LENGTH_SHORT
                    ).show()
                }
            }

            override fun onFailure(
                    call: Call<Void?>?,
                    t: Throwable?
            ) {
                println(t.toString())
            }
        })
    }
}
