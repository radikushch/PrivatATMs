package com.test.privatatms.utils

import java.io.IOException
import java.net.HttpURLConnection
import java.net.URL

fun isOnline(): Boolean {
    return try {
        val urlc = URL("http://www.google.com").openConnection() as HttpURLConnection
        urlc.setRequestProperty("User-Agent", "Test")
        urlc.setRequestProperty("Connection", "close")
        urlc.connectTimeout = 1500
        urlc.connect()
        urlc.responseCode == 200
    } catch (e: IOException) {
        false
    }
}

