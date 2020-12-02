package com.example.sp4u_app.activity.register

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.example.sp4u_app.R
import com.example.sp4u_app.dto.EstabelecimentoDTO
import com.example.sp4u_app.utils.AbstractActivity
import com.example.sp4u_app.validator.validator
import kotlinx.android.synthetic.main.activity_register_establishment_principal.*

class RegisterEstablishmentPrincipalActivity : AbstractActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_establishment_principal)
        setVariables()
    }

    fun goToRegisterEstablishmentAddress(button: View){
        validator(listOf(et_razao_social, et_nome_fantasia, et_telefone, et_cnpj))
        var estabelecimento = EstabelecimentoDTO()
        estabelecimento.razaoSocial = et_razao_social.text.toString()
        estabelecimento.nomeFantasia = et_nome_fantasia.text.toString()
        estabelecimento.cnpj = et_cnpj.text.toString()
        estabelecimento.userId = userId
        estabelecimento.telefone = et_telefone.text.toString()

        navigateWithEstablishmentObject(
            estabelecimento,
            RegisterEstablishmentAdressActivity().javaClass
        )
    }
}
