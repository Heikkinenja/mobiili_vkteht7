package com.example.bmi3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bmi3.ui.theme.BmiViewModel
import com.example.bmi3.ui.theme.Bmi3Theme

class MainActivity : ComponentActivity() {
    private val viewModel: BmiViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Bmi3Theme {
                Surface(
                    modifier = Modifier.padding(16.dp),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting(viewModel)
                }
            }
        }
    }
}

@Composable
fun Greeting(viewModel: BmiViewModel) {
    val state = viewModel.state

    Column(Modifier.padding(vertical = 16.dp)) {
        Text(text = "Body Mass Index", style = MaterialTheme.typography.headlineMedium)

        TextField(
            value = state.weight,
            onValueChange = { viewModel.changeWeight(it) },
            label = { Text("Weight (kg)") }
        )

        TextField(
            value = state.height,
            onValueChange = { viewModel.changeHeight(it) },
            label = { Text("Height (cm)") }
        )

        if (state.bmi > 0f) {
            Text(text = "BMI is: ${String.format("%.2f", state.bmi)}", style = MaterialTheme.typography.bodyLarge)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Bmi3Theme { 
        Greeting(viewModel = BmiViewModel())
    }
}
