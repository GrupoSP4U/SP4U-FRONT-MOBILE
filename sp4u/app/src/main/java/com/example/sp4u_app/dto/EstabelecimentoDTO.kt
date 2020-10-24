package com.example.sp4u_app.dto

import com.example.sp4u_app.dto.enums.Dias

data class EstabelecimentoDTO(
    val nomeFantasia: String,
    val razaoSocial: String,
    val emailContato: String,
    val cnpj: String,
    val cep: String,
    val mediaPreco: String,
    val horarioAbre: Double,
    val horarioFecha: Double,
    val endereco: String,
    val numeroEndereco: Int,
    val complemento: String,
    val nota: Double,
    val foto: String,
    val descricao: String,
    val dias: Collection<Dias>? = null
    //private val tagsEstabelecimento: TagsEstabelecimento? = null
)
