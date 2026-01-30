package com.example.appservicio.features.randomadvice.data.datasources.remote.model

import com.google.gson.annotations.SerializedName

// Estos son los "objetos de datos" que coinciden con el JSON de la API.
// Se obtinee el texto crudo desde internet. Se manda o mueve La info hacia el Mapper.
data class AdviceResponseDto(
    @SerializedName("slip") val slip: SlipDto
)

data class SlipDto(
    @SerializedName("id") val id: Int,
    @SerializedName("advice") val advice: String
)
