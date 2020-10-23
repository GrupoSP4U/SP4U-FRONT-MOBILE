package com.example.sp4u_app

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.sp4u_app.utils.AbstractActivity
import kotlinx.android.synthetic.main.activity_register_estabilishment_config_description.*

class RegisterEstabilishmentConfigDescriptionActivity : AbstractActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_estabilishment_config_description)
        setVariables()

        val comboMusica = ArrayAdapter(baseContext, android.R.layout.simple_spinner_item,
                listOf("sertanejo", "metal", "trap", "gospel","hip-hop","rap","clássico","pop",
                "trance","jazz","forró","kpop","samba","mpb","folk","rock","axé","funk","pagode"))

        comboMusica.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        ps_musica.adapter = comboMusica

        ps_musica.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                // either one will work as well
                // val item = parent.getItemAtPosition(position) as String
                val item = comboMusica.getItem(position)
            }
        }

        val comboEstab = ArrayAdapter(baseContext, android.R.layout.simple_spinner_item,
                listOf("restaurante", "bar", "balada", "pub"))

        comboEstab.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        ps_estab.adapter = comboEstab

        ps_estab.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                // either one will work as well
                // val item = parent.getItemAtPosition(position) as String
                val item = comboEstab.getItem(position)
            }
        }
    }



    fun goToBasicConfig(textView: View) {
        navigate(userId, token, HomeActivity().javaClass)
    }
}
