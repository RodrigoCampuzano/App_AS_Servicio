package com.example.appservicio.core.translation

import com.google.mlkit.common.model.DownloadConditions
import com.google.mlkit.nl.translate.TranslateLanguage
import com.google.mlkit.nl.translate.Translation
import com.google.mlkit.nl.translate.TranslatorOptions
import kotlinx.coroutines.tasks.await

// La libreria de ML Kit. Es una librería de Inteligencia Artificial que traduce o lee códigos de barras.
// "Importante" Lo bueno es que puede funcionar "offline" (sin internet) una vez que baja el idioma.

class MLKitTranslator : Translator {

    override suspend fun translate(text: String, sourceLang: String, targetLang: String): String {
        // En esete paso se usa para ver o poner que idiomas vamos a traducir de cual a cual
        val options = TranslatorOptions.Builder()
            .setSourceLanguage(sourceLang)
            .setTargetLanguage(targetLang)
            .build()
        
        // Como sig paso obtenes las configracion de lo anterior
        val translator = Translation.getClient(options)
        
        // Aqui solo lo descarga si se tiene wifi, sino madres no deja
        val conditions = DownloadConditions.Builder()
            .requireWifi()
            .build()

        return try {
            // Si el cel no tiene el idioma lo baja, en caso de que no no hace nafa
            translator.downloadModelIfNeeded(conditions).await()
            
            // Aqui lo traduce, el texto
            translator.translate(text).await()
        } catch (e: Exception) {
            // Si falla se devuelve lo mismo
            "[Error de traducción] $text"
        } finally {
            translator.close()
        }
    }
}
