package com.example.smartlearningapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

class QuizActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            QuizScreen()
        }
    }
}

data class Question(
    val question: String,
    val options: List<String>,
    val correctAnswer: Int
)

@Composable
fun QuizScreen() {

    val context = LocalContext.current

    val questions = listOf(
        Question("What is 2 + 2?", listOf("3", "4", "5", "6"), 1),
        Question("Capital of India?", listOf("Delhi", "Mumbai", "Chennai", "Kolkata"), 0),
        Question("Android is developed by?", listOf("Apple", "Google", "Microsoft", "IBM"), 1)
    )

    var current by remember { mutableStateOf(0) }
    var score by remember { mutableStateOf(0) }
    var selected by remember { mutableStateOf(-1) }

    if (current < questions.size) {

        val q = questions[current]

        Column(modifier = Modifier.padding(16.dp)) {

            Text(q.question, style = MaterialTheme.typography.headlineSmall)

            Spacer(modifier = Modifier.height(20.dp))

            q.options.forEachIndexed { index, option ->
                Row {
                    RadioButton(
                        selected = selected == index,
                        onClick = { selected = index }
                    )
                    Text(option)
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(onClick = {
                if (selected == q.correctAnswer) score++
                selected = -1
                current++
            }) {
                Text("Next")
            }
        }

    } else {
        // Go to Result Screen
        val intent = Intent(context, ResultActivity::class.java)
        intent.putExtra("score", score)
        intent.putExtra("total", questions.size)
        context.startActivity(intent)
    }
}