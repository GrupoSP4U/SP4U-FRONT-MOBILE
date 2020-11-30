package com.example.sp4u_app.activity.register

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.sp4u_app.R
import com.example.sp4u_app.dto.EstabelecimentoDTO
import com.example.sp4u_app.dto.enums.EstiloMusica
import com.example.sp4u_app.dto.enums.TipoEstabelecimento
import com.example.sp4u_app.utils.AbstractActivity

class RegisterEstablishmentLocalActivity : AbstractActivity() {
    private var estiloEstabelecimento: TipoEstabelecimento = TipoEstabelecimento.DEFAULT

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_establishment_local)
        setVariables()
    }

    fun addTipoEstabelecimento(button: View) {
        when (button.id) {
            R.id.bt_restaurantes -> estiloEstabelecimento = TipoEstabelecimento.RESTAURANTE
            R.id.bt_bares -> estiloEstabelecimento = TipoEstabelecimento.BAR
            R.id.bt_baladas -> estiloEstabelecimento = TipoEstabelecimento.BALADA
            R.id.bt_pub -> estiloEstabelecimento = TipoEstabelecimento.PUB
        }
        button.isEnabled = false
        Toast.makeText(
            baseContext,
            resources.getString(R.string.cadastro_estab_tipo_selecionaddo)+" "+ estiloEstabelecimento ,
            Toast.LENGTH_SHORT
        ).show()
    }

    fun goToRegisterEstablishmentFilters(button: View) {
        var estabelecimentoDTO =
            intent.getSerializableExtra("ESTABELECIMENTO") as EstabelecimentoDTO?

        if (estiloEstabelecimento == TipoEstabelecimento.DEFAULT) {
            Toast.makeText(
                baseContext,
                resources.getString(R.string.cadastro_estab_lista_vazia_tipo),
                Toast.LENGTH_SHORT
            ).show()
            return
        }

        estabelecimentoDTO?.tagsEstabelecimento?.tipoEstabelecimento = listOf(estiloEstabelecimento)

        val intent = Intent(this, RegisterEstablishmentFiltersActivity::class.java)
        intent.putExtra("ESTABELECIMENTO", estabelecimentoDTO)
        intent.putExtra("USER_ID", userId)
        intent.putExtra("TOKEN", token)
        startActivity(intent)
    }

}
