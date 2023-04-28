package com.example.translatorkmm.translate.domain.translate

enum class TranslateError {
    SERVICE_UNAVAILABLE,
    CLIENT_ERROR,
    SERVER_ERROR,
    UNKNOWN_ERROR
}

class TranslateException(error: TranslateError): Exception(
    "An error occured when translating: $error"
)