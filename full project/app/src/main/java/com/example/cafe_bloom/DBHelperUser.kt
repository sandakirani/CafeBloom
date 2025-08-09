package com.example.cafe_bloom

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelperUser(context: Context) : SQLiteOpenHelper(context, "CafeBloom", null, 1) {
    companion object {
        const val TABLE_NAME = "User"
        private const val SQL_CREATE_ENTRIES = "CREATE TABLE $TABLE_NAME (id INTEGER PRIMARY KEY AUTOINCREMENT, UserName TEXT, Name TEXT, Email TEXT, PhoneNumber TEXT, Password TEXT)"
        private const val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS $TABLE_NAME"
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(SQL_CREATE_ENTRIES)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL(SQL_DELETE_ENTRIES)
        onCreate(db)
    }

    fun insertUser(username: String, email: String, phone: String, password: String) {
        val values = ContentValues().apply {
            put("UserName", username)
            put("Email", email)
            put("PhoneNumber", phone)
            put("Password", password)
        }
        writableDatabase.insert(TABLE_NAME, null, values)
    }

    fun updatePassword(id: Int, password: String): Int {
        val db = writableDatabase
        val contentValues = ContentValues().apply {
            put("Password", password) // Update password column
        }
        return db.update(TABLE_NAME, contentValues, "id=?", arrayOf(id.toString()))
    }

    fun getUserIdByPassword(password: String): Int {
        val db = readableDatabase
        val query = "SELECT id FROM $TABLE_NAME WHERE Password = ?"
        val cursor = db.rawQuery(query, arrayOf(password))

        return if (cursor.moveToFirst()) {
            val userId = cursor.getInt(0)
            cursor.close()
            userId
        } else {
            cursor.close()
            -1 // Return -1 if no user matches
        }
    }

    fun updateUser(name: String, email: String, phone: String): Int {
        val db = this.writableDatabase
        val contentValues = ContentValues()

        // Set the updated values
        contentValues.put("Name", name)
        contentValues.put("PhoneNumber", phone)

        // Update the row where the email matches
        val whereClause = "Email = ?"
        val whereArgs = arrayOf(email)

        // Execute the update and return the number of rows affected
        val rowsAffected = db.update(TABLE_NAME, contentValues, whereClause, whereArgs)

        db.close()
        return rowsAffected
    }
}