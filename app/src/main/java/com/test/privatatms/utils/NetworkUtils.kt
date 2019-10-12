package com.test.privatatms.utils

import java.net.InetAddress
import java.net.UnknownHostException
import java.util.concurrent.*

fun isOnline(): Boolean {
    var netAddress: InetAddress? = null
    try {
        val future = Executors.newSingleThreadExecutor().submit(Callable<InetAddress> {
            try {
                InetAddress.getByName("google.com")
            } catch (e: UnknownHostException) {
                null
            }
        })
        netAddress = future.get(10000, TimeUnit.MILLISECONDS)
        future.cancel(true)
    } catch (e: InterruptedException) {
    } catch (e: ExecutionException) {
    } catch (e: TimeoutException) {
    }

    return netAddress != null && !netAddress.equals("")
}


