package com.example.fakeaccountdetector

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class ReportDatabaseHelper(context: Context) :
    SQLiteOpenHelper(context, "ReportDB", null, 1) {

    override fun onCreate(db: SQLiteDatabase) {
        val createTable = """
            CREATE TABLE reports (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                username TEXT,
                trustScore INTEGER,
                result TEXT
            )
        """.trimIndent()
        db.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS reports")
        onCreate(db)
    }

    fun insertReport(username: String, trustScore: Int, result: String): Boolean {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put("username", username)
        values.put("trustScore", trustScore)
        values.put("result", result)
        val inserted = db.insert("reports", null, values)
        return inserted != -1L
    }
}
