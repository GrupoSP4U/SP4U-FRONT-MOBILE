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
import com.example.sp4u_app.validator.validator
import kotlinx.android.synthetic.main.activity_register_establishment_adress.*
import kotlinx.android.synthetic.main.activity_register_establishment_music.*

class RegisterEstablishmentMusicActivity : AbstractActivity() {
    private var estiloMusica: MutableList<EstiloMusica> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_establishment_music)
        setVariables()
    }

    fun addTipoMusica(button: View) {
        when (button.id) {
            R.id.bt_sertanejo -> estiloMusica.add(EstiloMusica.SERTANEJO)
            R.id.bt_samba -> estiloMusica.add(EstiloMusica.SAMBA)
            R.id.bt_rap -> estiloMusica.add(EstiloMusica.RAP)
            R.id.bt_pagode -> estiloMusica.add(EstiloMusica.PAGODE)
            R.id.bt_eletronica -> estiloMusica.add(EstiloMusica.ELETRONICA)
            R.id.bt_forro -> estiloMusica.add(EstiloMusica.FORRO)
            R.id.bt_kpop -> estiloMusica.add(EstiloMusica.KPOP)
            R.id.bt_trance -> estiloMusica.add(EstiloMusica.TRANCE)
            R.id.bt_folk -> estiloMusica.add(EstiloMusica.FOLK)
            R.id.bt_hiphop -> estiloMusica.add(EstiloMusica.HIP_HOP)
            R.id.bt_pop -> estiloMusica.add(EstiloMusica.POP)
            R.id.bt_classico -> estiloMusica.add(EstiloMusica.CLASSICO)
            R.id.bt_axe -> estiloMusica.add(EstiloMusica.AXE)
            R.id.bt_gospel -> estiloMusica.add(EstiloMusica.GOSPEL)
            R.id.bt_metal -> estiloMusica.add(EstiloMusica.METAL)
            R.id.bt_rock -> estiloMusica.add(EstiloMusica.ROCK)
            R.id.bt_funk -> estiloMusica.add(EstiloMusica.FUNK)
            R.id.bt_trap -> estiloMusica.add(EstiloMusica.TRAP)
            R.id.bt_jazz -> estiloMusica.add(EstiloMusica.JAZZ)
            R.id.bt_mpb -> estiloMusica.add(EstiloMusica.MPB)
        }
        button.isEnabled = false
        Toast.makeText(
            baseContext,
            resources.getString(R.string.cadastro_estab_adicionado),
            Toast.LENGTH_SHORT
        ).show()
    }

    fun goToRegisterEstablishmentLocal(button: View) {
        var estabelecimentoDTO =
            intent.getSerializableExtra("ESTABELECIMENTO") as EstabelecimentoDTO?

        if (estiloMusica.isEmpty()) {
            Toast.makeText(
                baseContext,
                resources.getString(R.string.cadastro_estab_lista_vazia_musica),
                Toast.LENGTH_SHORT
            ).show()
            return
        }

        estabelecimentoDTO?.tagsEstabelecimento?.estiloMusica = estiloMusica

        val intent = Intent(this, RegisterEstablishmentLocalActivity::class.java)
        intent.putExtra("ESTABELECIMENTO", estabelecimentoDTO)
        intent.putExtra("USER_ID", userId)
        intent.putExtra("TOKEN", token)
        startActivity(intent)
    }
}
