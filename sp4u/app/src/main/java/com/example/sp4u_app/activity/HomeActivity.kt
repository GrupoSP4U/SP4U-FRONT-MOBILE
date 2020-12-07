package com.example.sp4u_app.activity

import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.LinearLayout.LayoutParams
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.example.sp4u_app.R
import com.example.sp4u_app.dto.EstabelecimentoDTO
import com.example.sp4u_app.dto.enums.Acompanhamento
import com.example.sp4u_app.utils.AbstractActivity
import com.example.sp4u_app.utils.RetrofitInitializer
import com.example.sp4u_app.utils.dpToPx
import kotlinx.android.synthetic.main.activity_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeActivity : AbstractActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setVariables()

        searchEstablishmentsByConcomitant(Acompanhamento.CASADE)
        searchEstablishmentsByConcomitant(Acompanhamento.SOZINHO)
    }

    private fun searchEstablishmentsByConcomitant(
        concomitant: Acompanhamento
    ) {
        val call = RetrofitInitializer(token).establishmentService().getFilteredPlaces(concomitant)

        call.enqueue(object : Callback<List<EstabelecimentoDTO>?> {
            override fun onResponse(
                call: Call<List<EstabelecimentoDTO>?>?,
                response: Response<List<EstabelecimentoDTO>?>?
            ) {
                if (response?.code() == 200) {
                    response?.body()?.let {
                        it.forEach { et ->
                            println(et.toString())
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

    private fun buildCards(
        concomitant: Acompanhamento,
        establishment: EstabelecimentoDTO
    ) {
        val cardView = CardView(baseContext)
        val layoutParams = LayoutParams(dpToPx(287), dpToPx(90))
        layoutParams.marginEnd = 10
        cardView.layoutParams = layoutParams
        cardView.setOnClickListener {
            navigateWithEstablishmentObject(establishment, AboutEstablishmentActivity().javaClass)
        }

        val newLinearLayout = LinearLayout(baseContext)
        newLinearLayout.layoutParams =
            LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.MATCH_PARENT
            )
        newLinearLayout.background =
            ContextCompat.getDrawable(baseContext, R.drawable.btn_rectangle_background)

        if (concomitant == Acompanhamento.SOZINHO) {
            newLinearLayout.backgroundTintList =
                ContextCompat.getColorStateList(baseContext, R.color.LightBlue)
        } else {
            newLinearLayout.backgroundTintList =
                ContextCompat.getColorStateList(baseContext, R.color.Pink)
        }

        newLinearLayout.orientation = LinearLayout.HORIZONTAL

        val imageLinearLayout = LinearLayout(baseContext)
        val imageLayoutParams =
            LayoutParams(
                dpToPx(95),
                LayoutParams.MATCH_PARENT
            )
        imageLayoutParams.marginEnd = 8
        imageLinearLayout.layoutParams = imageLayoutParams
        val imageView = ImageView(baseContext)
        imageView.layoutParams =
            LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.MATCH_PARENT
            )
        imageView.setImageResource(R.drawable.texas_image)
        imageLinearLayout.addView(imageView)
        newLinearLayout.addView(imageLinearLayout)

        val descriptionLinearLayout = LinearLayout(baseContext)
        descriptionLinearLayout.layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
        descriptionLinearLayout.orientation = LinearLayout.VERTICAL

        val colorText = ContextCompat.getColorStateList(
            baseContext,
            R.color.Fund
        )
        val textViewEstablishmentName = TextView(baseContext)
        textViewEstablishmentName.layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, dpToPx(22))
        textViewEstablishmentName.textSize = 16F
        textViewEstablishmentName.typeface =
            ResourcesCompat.getFont(baseContext, R.font.montserrat)
        textViewEstablishmentName.text = establishment.nomeFantasia
        textViewEstablishmentName.setTextColor(colorText)
        descriptionLinearLayout.addView(textViewEstablishmentName)

        val textViewEstablishmentDescription = TextView(baseContext)
        textViewEstablishmentDescription.layoutParams =
            LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
        textViewEstablishmentDescription.textSize = 12F
        textViewEstablishmentDescription.typeface =
            ResourcesCompat.getFont(baseContext, R.font.montserrat)
        textViewEstablishmentDescription.text = establishment.descricao
        textViewEstablishmentDescription.setTextColor(colorText)
        descriptionLinearLayout.addView(textViewEstablishmentDescription)

        newLinearLayout.addView(descriptionLinearLayout)
        cardView.addView(newLinearLayout)

        if (concomitant == Acompanhamento.SOZINHO) {
            ll_solteiros.addView(cardView)
        } else {
            ll_casais.addView(cardView)
        }
    }
}
