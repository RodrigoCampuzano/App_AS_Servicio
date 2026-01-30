package com.example.appservicio.core.translation

interface Translator {
    suspend fun translate(text: String, sourceLang: String, targetLang: String): String
}
