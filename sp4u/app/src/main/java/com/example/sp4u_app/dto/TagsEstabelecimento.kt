package com.example.sp4u_app.dto

import com.example.sp4u_app.dto.enums.Acompanhamento
import com.example.sp4u_app.dto.enums.Caracteristicas
import com.example.sp4u_app.dto.enums.EstiloMusica
import com.example.sp4u_app.dto.enums.TipoEstabelecimento
import java.io.Serializable


data class TagsEstabelecimento (
    var estiloMusica: List<EstiloMusica>? = null,
    var tipoEstabelecimento: List<TipoEstabelecimento>? = null,
    var caracteristicas: List<Caracteristicas>? = null,
    var acompanhamento: List<Acompanhamento>? = null
): Serializable
