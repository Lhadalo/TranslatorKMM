package com.example.translatorkmm.translate.domain.translate

import com.example.translatorkmm.core.domain.language.Language
import com.example.translatorkmm.core.domain.util.Resource
import com.example.translatorkmm.translate.data.history.HistoryDataSource
import com.example.translatorkmm.translate.data.history.HistoryItem

class TranslateUseCase(
    private val client: TranslateClient,
    private val historyDataSource: HistoryDataSource
) {
    suspend fun execute(
        fromLanguage: Language,
        fromText: String,
        toLanguage: Language
    ): Resource<String> {
        try {
            val translatedText = client.translate(
                fromLanguage, fromText, toLanguage
            )
            historyDataSource.insertHistoryItem(
                HistoryItem(
                    id = null,
                    fromLanguageCode = fromLanguage.langCode,
                    fromText = fromText,
                    toLanguageCode = toLanguage.langCode,
                    toText = translatedText
                )
            )
            return Resource.Success(translatedText)
        } catch (e: TranslateException) {
            e.printStackTrace()
            return Resource.Error(e)
        }
    }
}