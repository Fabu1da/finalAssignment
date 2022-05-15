package com.example.assignmenttwo

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
       Toast.makeText(context, "YOU RECEIVED ME FROM MANIFEST ", Toast.LENGTH_SHORT).show()
    }
}