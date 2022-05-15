package com.example.assignmenttwo

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.os.Message
import android.util.Log

class MyService : Service() {
    var  TAG = "MyService"
    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun onCreate() {
        ShowLog("onCreate")
        super.onCreate()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        ShowLog("on start command")

        val runnable = Runnable {
            for (i in 1..10) {
                ShowLog("onStartCommend $i")
                Thread.sleep(1000)
            }
            stopSelf()
        }
        val runThread = Thread(runnable)
        runThread.start()
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        ShowLog("On Destroy is called our service is destroyed ")
        super.onDestroy()
    }
    fun ShowLog(message: String){
        Log.d(TAG, message)
    }
}