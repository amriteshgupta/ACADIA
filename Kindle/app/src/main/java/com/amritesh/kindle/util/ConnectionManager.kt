package com.amritesh.kindle.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

class ConnectionManager {

    fun checkConnectivity(context: Context):Boolean{
        var connectivityManager=context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        var activeNetwork:NetworkInfo?=connectivityManager.activeNetworkInfo

        if(activeNetwork!=null){
            return activeNetwork.isConnected
        }
        else{
            return false
    }}
}