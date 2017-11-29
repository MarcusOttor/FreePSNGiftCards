package com.freepsn.freegift.freecards

import android.content.Context
import android.net.ConnectivityManager
import android.provider.Settings
import java.util.regex.Matcher
import java.util.regex.Pattern

object AppTools {

    fun isNetworkAvaliable(context: Context): Boolean {
        var connectivity = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        var info = connectivity.activeNetworkInfo

        return info != null && info.isConnectedOrConnecting
    }

    fun isEmailAdressCorrect(email: String) : Boolean {
        var pattern = Pattern.compile("^[a-zA-Z0-9]+@[a-zA-Z0-9]+(.[a-zA-Z]{2,})$")
        var matcher = pattern.matcher(email)
        return (matcher.matches() and (email.length > 5))
    }

    fun uniqueId(context: Context): String {
        return Settings.Secure.getString(context.contentResolver, Settings.Secure.ANDROID_ID)
    }
}