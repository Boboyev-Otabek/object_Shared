package com.example.sharedprfs.managers

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.google.gson.Gson

internal class PrefManager(applicationcontext: Context) {
    var sharedPreferences: SharedPreferences
    var gson: Gson
    fun getinstance(applicationcontext: Context): PrefManager? {
        if (prefManager == null) prefManager = PrefManager(applicationcontext)
        return prefManager
    }

    fun saveString(key: String?, value: String?): Boolean {
        return sharedPreferences.edit().putString(key, value).commit()
    }

    fun fetchString(key: String?): String? {
        return sharedPreferences.getString(key, "A/N")
    }

    fun saveObject(key: String?, value: Any): Boolean {
        Log.d("PrefManager", "@@@$value")
        return saveString(key, gson.toJson(value))
    }

    fun fetchObject(key: String?, targetclass: Class<*>?): Any? {
        var `object`: Any? = fetchString(key)
        if (`object` != null) `object` = gson.fromJson<Any>(`object` as String?, targetclass)
        return `object`
    }

    companion object {

        var prefManager: PrefManager? = null
    }

    init {
        gson = Gson()
        sharedPreferences = applicationcontext.applicationContext.getSharedPreferences(
           "MyPrefs",
            Context.MODE_PRIVATE
        )
    }
}
