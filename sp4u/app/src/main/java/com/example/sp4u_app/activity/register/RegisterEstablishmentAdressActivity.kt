package com.example.sp4u_app.activity.register

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.example.sp4u_app.R
import com.example.sp4u_app.dto.EstabelecimentoDTO
import com.example.sp4u_app.utils.AbstractActivity
import com.example.sp4u_app.validator.validator
import kotlinx.android.synthetic.main.activity_register_establishment_adress.*
import kotlinx.android.synthetic.main.activity_register_establishment_principal.*

class RegisterEstablishmentAdressActivity : AbstractActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_establishment_adress)
        setVariables()
    }

    fun goToRegisterEstablishmentMusic(button: View) {
        var estabelecimentoDTO =
            intent.getSerializableExtra("ESTABELECIMENTO") as EstabelecimentoDTO?

        validator(
            listOf(
                et_endereco,
                et_cep,
                et_bairro,
                et_cidade,
                et_estado,
                et_numero,
                et_email_contato
            )
        )

        estabelecimentoDTO?.endereco = et_endereco.text.toString()
        estabelecimentoDTO?.cep = et_cep.text.toString()
        estabelecimentoDTO?.numeroEndereco = et_numero.text.toString().toInt()
        estabelecimentoDTO?.complemento = et_complemento.text.toString()
        estabelecimentoDTO?.emailContato = et_email_contato.text.toString()
        estabelecimentoDTO?.bairro = et_bairro.text.toString()
        estabelecimentoDTO?.estado = et_estado.text.toString()
        estabelecimentoDTO?.cidade = et_cidade.text.toString()

        navigateWithEstablishmentObject(
            intent.getSerializableExtra("ESTABELECIMENTO") as EstabelecimentoDTO?,
            RegisterEstablishmentMusicActivity().javaClass
        )
    }
}
