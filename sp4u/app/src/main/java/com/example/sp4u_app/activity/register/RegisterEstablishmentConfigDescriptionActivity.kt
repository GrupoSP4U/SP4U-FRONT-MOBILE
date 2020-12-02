package com.example.sp4u_app.activity.register

import android.os.Bundle
import android.view.View
import com.example.sp4u_app.R
import com.example.sp4u_app.dto.EstabelecimentoDTO
import com.example.sp4u_app.dto.enums.Caracteristicas
import com.example.sp4u_app.dto.enums.TipoEstabelecimento
import com.example.sp4u_app.utils.AbstractActivity
import com.example.sp4u_app.utils.buildSpinner
import kotlinx.android.synthetic.main.activity_register_establishment_config_description.*

class RegisterEstablishmentConfigDescriptionActivity : AbstractActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_establishment_config_description)
        setVariables()

        buildSpinner(baseContext, ps_estab, listOf("restaurante", "bar", "balada", "pub"))

        var establishment =
            intent.getSerializableExtra("ESTABELECIMENTO") as EstabelecimentoDTO?

        establishment?.let { it ->
            et_descricao_atual.setText(it.descricao)
            it.tagsEstabelecimento?.let { tags ->
                sw_cardapio_vegetariano.isChecked =
                    tags.caracteristicas?.contains(Caracteristicas.VEGETARIANO)!!
                sw_cardapio_vegano.isChecked =
                    tags.caracteristicas?.contains(Caracteristicas.VEGANO)!!
                sw_permitido_animais.isChecked =
                    tags.caracteristicas?.contains(Caracteristicas.PETS)!!
                sw_idade_minima.isChecked = it.paraMaiores!!

                buildSpinner(
                    baseContext, ps_musica,
                    tags.estiloMusica?.map { msc -> msc.toString().replace("_", " ").toLowerCase() }
                )

                if (tags.tipoEstabelecimento?.contains(TipoEstabelecimento.RESTAURANTE)!!) {
                    ps_estab.setSelection(0)
                } else if (tags.tipoEstabelecimento?.contains(TipoEstabelecimento.BAR)!!) {
                    ps_estab.setSelection(1)
                } else if (tags.tipoEstabelecimento?.contains(TipoEstabelecimento.BALADA)!!) {
                    ps_estab.setSelection(2)
                } else {
                    ps_estab.setSelection(3)
                }
            }
        }
    }

    fun goToEstablishmentConfig(button: View) {
        navigateWithEstablishmentObject(
            intent.getSerializableExtra("ESTABELECIMENTO") as EstabelecimentoDTO?,
            RegisterEstablishmentConfigActivity().javaClass
        )
    }
}
