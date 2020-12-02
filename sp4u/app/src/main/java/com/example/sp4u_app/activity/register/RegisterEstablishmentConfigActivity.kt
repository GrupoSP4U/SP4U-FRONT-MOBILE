package com.example.sp4u_app.activity.register

import android.os.Bundle
import android.view.View
import com.example.sp4u_app.R
import com.example.sp4u_app.dto.EstabelecimentoDTO
import com.example.sp4u_app.utils.AbstractActivity
import kotlinx.android.synthetic.main.activity_register_establishment_config.*

class RegisterEstablishmentConfigActivity : AbstractActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_establishment_config)
        setVariables()

        var establishment =
            intent.getSerializableExtra("ESTABELECIMENTO") as EstabelecimentoDTO?

        establishment?.let {
            tv_titulo_cadastro_estabelecimento_config.text = it.nomeFantasia
            et_razao_social.setText(it.razaoSocial)
            et_nome_fantasia.setText(it.nomeFantasia)
            et_telefone.setText(it.telefone)
            et_endereco.setText(it.endereco)
            et_cep.setText(it.cep)
            et_bairro.setText(it.bairro)
            et_cidade.setText(it.cidade)
            et_estado.setText(it.estado)
            it.numeroEndereco?.let { nmr -> et_numero.setText(nmr.toString()) }
            et_complemento.setText(it.complemento)
            et_email.setText(it.emailContato)
        }
    }

    fun goToDescriptionOfRole(textView: View) {
        navigateWithEstablishmentObject(
            intent.getSerializableExtra("ESTABELECIMENTO") as EstabelecimentoDTO?,
            RegisterEstablishmentConfigDescriptionActivity().javaClass
        )
    }
}
