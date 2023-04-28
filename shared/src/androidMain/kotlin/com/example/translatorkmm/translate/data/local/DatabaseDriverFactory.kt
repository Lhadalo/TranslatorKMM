package com.example.translatorkmm.translate.data.local

import android.content.Context
import com.example.translatorkmm.database.TranslateDatabase
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

actual class DatabaseDriverFactory(
    private val context: Context
) {
    actual fun create(): SqlDriver {
        return AndroidSqliteDriver(
            TranslateDatabase.Schema,
            context,
            "translate.db"
        )
    }
}