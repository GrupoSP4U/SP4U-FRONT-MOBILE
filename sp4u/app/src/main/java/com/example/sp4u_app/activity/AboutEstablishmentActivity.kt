package com.example.sp4u_app.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sp4u_app.R
import com.example.sp4u_app.dto.EstabelecimentoDTO
import kotlinx.android.synthetic.main.activity_about_establishment.*

class AboutEstablishmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_establishment)

        val estabelecimentoDTO =
            intent.getSerializableExtra("ESTABELECIMENTO") as EstabelecimentoDTO?

        estabelecimentoDTO.let {
            var estilos = ""
            var acompanhamento = ""
            var caracteristicas = ""
            it?.tagsEstabelecimento?.estiloMusica?.forEach { em ->
                estilos += em.toString().replace("_", " ").toLowerCase() + ", "
            }
            estilos = estilos.substring(0, estilos.length - 2)

            it?.tagsEstabelecimento?.tipoAcompanhamento?.forEach { ac ->
                acompanhamento += ac.toString().toLowerCase() + ", "
            }
            acompanhamento = acompanhamento.substring(0, acompanhamento.length - 2)

            it?.tagsEstabelecimento?.caracteristicas?.forEach { crs ->
                caracteristicas += crs.toString().replace("_", " ").toLowerCase() + ", "
            }
            caracteristicas = caracteristicas.substring(0, caracteristicas.length - 2)

            tv_estilos.text = estilos
            tv_acompanhamento.text = acompanhamento
            tv_caracteristicas.text = caracteristicas
            tv_tipo.text =
                it?.tagsEstabelecimento?.tipoEstabelecimento?.first().toString().toLowerCase()

            tv_endereco.text = it?.endereco
        }
    }
}
