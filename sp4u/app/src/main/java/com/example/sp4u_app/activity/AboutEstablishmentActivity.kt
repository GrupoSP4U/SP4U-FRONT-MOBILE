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
            var styles = ""
            var concomitant = ""
            var characteristics = ""
            it?.tagsEstabelecimento?.estiloMusica?.forEach { em ->
                styles += em.toString().replace("_", " ").toLowerCase() + ", "
            }
            styles = styles.substring(0, styles.length - 2)

            it?.tagsEstabelecimento?.tipoAcompanhamento?.forEach { ac ->
                concomitant += ac.toString().toLowerCase() + ", "
            }
            concomitant = concomitant.substring(0, concomitant.length - 2)

            it?.tagsEstabelecimento?.caracteristicas?.forEach { crs ->
                characteristics += crs.toString().replace("_", " ").toLowerCase() + ", "
            }
            characteristics = characteristics.substring(0, characteristics.length - 2)

            tv_estilos.text = styles
            tv_acompanhamento.text = concomitant
            tv_caracteristicas.text = characteristics
            tv_tipo.text =
                it?.tagsEstabelecimento?.tipoEstabelecimento?.first().toString().toLowerCase()

            tv_endereco.text = it?.endereco
            tv_nome.text = it?.nomeFantasia
            tv_descricao.text = it?.descricao
        }
    }
}
