package com.example.quizdapp.util

import android.content.Context

class PreferenceManager(context: Context) {

    private val sharedPreferences =
        context.getSharedPreferences("KEY_PREFERENCE_NAME", Context.MODE_PRIVATE)

    public fun putBoolean(key: String, value: Boolean) {
        val editor = sharedPreferences.edit()
        editor.putBoolean(key, value)
        editor.apply()
    }

    public fun getBoolean(key: String): Boolean {
        return sharedPreferences.getBoolean(key, false)
    }

    public fun putString(key: String, value: String) {
        val editor = sharedPreferences.edit()
        editor.putString(key, value)
        editor.apply()
    }

    public fun getString(key: String): String? {
        return sharedPreferences.getString(key, null)
    }

    public fun clear() {
        val editor = sharedPreferences.edit()
        editor.clear()
        editor.apply()
    }
}