package com.example.assembletheconstructoryourself

import android.content.Context
import java.io.File
import java.io.FileOutputStream

object DatabaseCopier {

    fun copyDatabase(context: Context) {
        val databasePath = context.getDatabasePath("db").path
        if (!File(databasePath).exists()) {
            try {
                val inputStream = context.assets.open("sqlite.db")
                val outputStream = FileOutputStream(databasePath)
                val buffer = ByteArray(1024)
                var length: Int
                while (inputStream.read(buffer).also { length = it } > 0) {
                    outputStream.write(buffer, 0, length)
                }
                outputStream.flush()
                outputStream.close()
                inputStream.close()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}