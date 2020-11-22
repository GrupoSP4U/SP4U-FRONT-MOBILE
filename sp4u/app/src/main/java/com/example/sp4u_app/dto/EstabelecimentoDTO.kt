package com.example.sp4u_app.dto

import com.example.sp4u_app.dto.enums.Dias
import java.io.Serializable

data class EstabelecimentoDTO(
    var userId: Int? = null,
    var nomeFantasia: String? = null,
    var razaoSocial: String? = null,
    var emailContato: String? = null,
    var cnpj: String? = null,
    var cep: String? = null,
    var mediaPreco: String? = null,
    var horarioAbre: Double? = null,
    var horarioFecha: Double? = null,
    var endereco: String? = null,
    var numeroEndereco: Int? = null,
    var complemento: String? = null,
    var nota: Double? = null,
    var foto: String? = null,
    var descricao: String? = null,
    var paraMaiores: Boolean? = null ,
    var dias: Collection<Dias>? = null,
    var tagsEstabelecimento: TagsEstabelecimento? = null
): Serializable
