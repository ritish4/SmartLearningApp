package com.example.smartlearningapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class SyllabusActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            SyllabusScreen()
        }
    }
}

@Composable
fun SyllabusScreen() {
    Column(modifier = Modifier.padding(16.dp)) {

        Text("📚 Syllabus", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(16.dp))

        Text("Unit 1: Basics of Programming")
        Text("Unit 2: Data Structures")
        Text("Unit 3: Algorithms")
        Text("Unit 4: Database Concepts")
        Text("Unit 5: Web Development")
    }
}