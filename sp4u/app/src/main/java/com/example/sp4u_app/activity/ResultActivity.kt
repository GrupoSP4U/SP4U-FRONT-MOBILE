package com.example.sp4u_app.activity

import android.os.Bundle
import android.os.Parcelable
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.example.sp4u_app.R
import com.example.sp4u_app.dto.EstabelecimentoDTO
import com.example.sp4u_app.dto.enums.Acompanhamento
import com.example.sp4u_app.dto.enums.Caracteristicas
import com.example.sp4u_app.utils.AbstractActivity
import com.example.sp4u_app.utils.RetrofitInitializer
import com.example.sp4u_app.utils.dpToPx
import kotlinx.android.synthetic.main.activity_result.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList

class ResultActivity : AbstractActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        setVariables()

        val caracteristicas: ArrayList<Caracteristicas> =
            intent.getParcelableArrayListExtra<Parcelable>("CARACTERISTICAS") as ArrayList<Caracteristicas>

        searchEstablishmentsByCharacteristics(caracteristicas, Acompanhamento.SOZINHO)
        searchEstablishmentsByCharacteristics(caracteristicas, Acompanhamento.CASADE)
        searchEstablishmentsByCharacteristics(caracteristicas, Acompanhamento.AMIGOS)
    }

    private fun searchEstablishmentsByCharacteristics(
        characteristics: List<Caracteristicas>,
        concomitant: Acompanhamento
    ) {
        val call = RetrofitInitializer(token).establishmentService()
            .getFilteredPlacesByCharacteristics(characteristics)

        call.enqueue(object : Callback<List<EstabelecimentoDTO>?> {
            override fun onResponse(
                call: Call<List<EstabelecimentoDTO>?>?,
                response: Response<List<EstabelecimentoDTO>?>?
            ) {
                if (response?.code() == 200) {
                    response?.body()?.let {
                        it.forEach { et ->
                            buildCards(concomitant, et)
                        }
                    }
                } else {
                    Toast.makeText(
                        applicationContext,
                        resources.getString(R.string.requisicao_erro_interno),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            override fun onFailure(
                call: Call<List<EstabelecimentoDTO>?>?,
                t: Throwable?
            ) {
                println(t.toString())
            }
        })
    }

    fun buildCards(concomitant: Acompanhamento, establishment: EstabelecimentoDTO) {
        val cardView = CardView(baseContext)
        val layoutParams = LinearLayout.LayoutParams(dpToPx(287), dpToPx(125))
        layoutParams.marginEnd = 10
        cardView.layoutParams = layoutParams
        cardView.setOnClickListener {
            navigateWithEstablishmentObject(establishment, AboutEstablishmentActivity().javaClass)
        }
        cardView.background = ContextCompat.getDrawable(baseContext, R.drawable.btn_rectangle_background)
        when (concomitant) {
            Acompanhamento.SOZINHO -> cardView.backgroundTintList =
                ContextCompat.getColorStateList(baseContext, R.color.Pink)
            Acompanhamento.CASADE -> cardView.backgroundTintList =
                ContextCompat.getColorStateList(baseContext, R.color.LightRed)
            Acompanhamento.AMIGOS -> cardView.backgroundTintList =
                ContextCompat.getColorStateList(baseContext, R.color.Green)
        }

        val newLinearLayout = LinearLayout(baseContext)
        val newLinearLayoutLayoutParams =
            LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
            )
        newLinearLayoutLayoutParams.marginStart = 8
        newLinearLayout.layoutParams = newLinearLayoutLayoutParams
        newLinearLayout.orientation = LinearLayout.VERTICAL

        val colorText = ContextCompat.getColorStateList(
            baseContext,
            R.color.White
        )
        val textViewEstablishmentName = TextView(baseContext)
        textViewEstablishmentName.layoutParams =
            LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, dpToPx(30))
        textViewEstablishmentName.textSize = 16F
        textViewEstablishmentName.typeface =
            ResourcesCompat.getFont(baseContext, R.font.montserrat)
        textViewEstablishmentName.text = establishment.nomeFantasia
        textViewEstablishmentName.setTextColor(colorText)
        newLinearLayout.addView(textViewEstablishmentName)

        val textViewEstablishmentDescription = TextView(baseContext)
        textViewEstablishmentDescription.layoutParams =
            LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
        textViewEstablishmentDescription.textSize = 12F
        textViewEstablishmentDescription.typeface =
            ResourcesCompat.getFont(baseContext, R.font.montserrat)
        textViewEstablishmentDescription.text = establishment.descricao
        textViewEstablishmentDescription.setTextColor(colorText)
        newLinearLayout.addView(textViewEstablishmentDescription)
        cardView.addView(newLinearLayout)

        when (concomitant) {
            Acompanhamento.SOZINHO -> ll_solteiros.addView(cardView)
            Acompanhamento.CASADE -> ll_casais.addView(cardView)
            Acompanhamento.AMIGOS -> ll_amigos.addView(cardView)
        }
    }
}
