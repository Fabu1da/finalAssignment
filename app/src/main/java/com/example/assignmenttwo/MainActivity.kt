package com.example.assignmenttwo

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.assignmenttwo.ui.theme.AssignmentTwoTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val scaffoldState = rememberScaffoldState()
            var textFieldStateUsername by remember {
                mutableStateOf("")
            }
            var textFieldStatePassword by remember {
                mutableStateOf("")
            }
            val scope = rememberCoroutineScope()
            val context = LocalContext.current
            Scaffold(modifier = Modifier.fillMaxSize(),
                scaffoldState = scaffoldState
            ) {
                Column(modifier = Modifier
                    .fillMaxSize()
                    .padding(15.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(text = "Login Here", fontSize = 25.sp, fontWeight = FontWeight.Bold, fontStyle = FontStyle(30), modifier = Modifier.padding(50.dp, 10.dp))
                    TextField(value = textFieldStateUsername ,
                        label = {
                            Text("Username")
                        },
                        onValueChange = {
                            textFieldStateUsername=it
                        }, singleLine = true,
                        modifier = Modifier.fillMaxWidth())
                    Spacer(modifier = Modifier.height(16.dp))
                    TextField(value = textFieldStatePassword ,
                        label = {
                            Text("Password")
                        },
                        onValueChange = {
                            textFieldStatePassword=it
                        }, singleLine = true,
                        modifier = Modifier.fillMaxWidth())
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(onClick = {
                        if(textFieldStateUsername=="" && textFieldStatePassword == ""){
                            scope.launch {
                                scaffoldState.snackbarHostState.showSnackbar("Fields are empty")
                            }
                        }else if(textFieldStateUsername=="user" && textFieldStatePassword == "123"){
                            scope.launch {
                                scaffoldState.snackbarHostState.showSnackbar("Hello $textFieldStateUsername $textFieldStatePassword !")
                            }
                            val intent = Intent(context, HomePage1::class.java)
                            intent.putExtra("username", textFieldStateUsername)
                            intent.putExtra("password", textFieldStatePassword)
                            context.startActivity(intent)
                        }else{
                            scope.launch {
                                scaffoldState.snackbarHostState.showSnackbar("Wrong username or password")
                            }
                        }

                    }) {
                        Text(text = "Login")
                    }
                }
            }


        }
    }
}
