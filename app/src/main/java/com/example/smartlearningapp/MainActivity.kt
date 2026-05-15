package com.example.smartlearningapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen() {
    val context = LocalContext.current

    Column(modifier = Modifier.padding(20.dp)) {

        Text("Smart Learning App", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(30.dp))

        Button(onClick = {
            context.startActivity(Intent(context, SyllabusActivity::class.java))
        }) {
            Text("View Syllabus")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            context.startActivity(Intent(context, QuizActivity::class.java))
        }) {
            Text("Start Quiz")
        }
    }
}