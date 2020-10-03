package com.example.sp4u_app

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class UserProfileActivity : AppCompatActivity() {

    lateinit var option: Spinner
    lateinit var result: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile)

        option = findViewById(R.id.sp_genero) as Spinner
        result = findViewById(R.id.tv_resultado) as TextView

        val options = arrayOf("Feminino", "Masculino", "Indefinido")

        option.adapter= ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,options)

        option.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(p0: AdapterView<*>?) {
                result.text= "Selecione uma opção"
            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                result.text = options.get(p2)
            }

        }
    }
}