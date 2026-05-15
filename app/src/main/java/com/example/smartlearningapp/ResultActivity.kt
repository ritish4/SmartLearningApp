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

class ResultActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val score = intent.getIntExtra("score", 0)
        val total = intent.getIntExtra("total", 0)

        setContent {
            ResultScreen(score, total)
        }
    }
}

@Composable
fun ResultScreen(score: Int, total: Int) {

    val context = LocalContext.current

    Column(modifier = Modifier.padding(20.dp)) {

        Text("🎉 Quiz Completed!", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(20.dp))

        Text("Score: $score / $total")

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            context.startActivity(Intent(context, QuizActivity::class.java))
        }) {
            Text("Restart Quiz")
        }
    }
}