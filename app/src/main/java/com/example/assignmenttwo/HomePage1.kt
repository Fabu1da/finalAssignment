package com.example.assignmenttwo

import android.annotation.SuppressLint
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.media.session.MediaController
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.assignmenttwo.ui.theme.AssignmentTwoTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking

class HomePage1 : ComponentActivity() {
    @SuppressLint("FlowOperatorInvokedInComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        setContent {
            val username = intent.getStringExtra("username")
            lateinit var receiver: BroadcastReceiver
            lateinit var context: Context

            //Context registered receiver
            context = this
            val filter = IntentFilter()
            filter.addAction(Intent.ACTION_POWER_CONNECTED)
            filter.addAction(Intent.ACTION_POWER_DISCONNECTED)
            receiver = object:BroadcastReceiver(){
                override fun onReceive(context: Context?, intent: Intent?) {
                    Toast.makeText(context, intent?.action, Toast.LENGTH_SHORT)
                }

            }
            registerReceiver(receiver, filter)

            Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(15.dp)) {
                Text("Welcome $username", fontSize = 25.sp, fontWeight = FontWeight.Bold )

                //not Done  after break
                val namesFlow = flow {
                    val names = listOf("Jody", "Steve", "Lance", "Joe")
                    for (name in names) {
                        delay(100)
                        emit(name)
                    }
                }
5



                
                Spacer(modifier = Modifier.height(30.dp))
                Button(onClick = {
                    sendBroadcast(Intent(context, MyReceiver::class.java ))
                }) {
                    Text(text ="Send BroadCast")
                }

                Button(onClick = {
                    val intent = Intent(context, MyService::class.java)
                    startService(intent)
                }) {
                    Text("Start Service")

                }
            }

        }
    }




   
}

