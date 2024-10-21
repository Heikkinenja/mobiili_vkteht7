package com.example.bmi3

//import com.example.bmi3.ui.theme.ViewModel.BmiViewModel
//import androidx.lifecycle.ViewModel.compose.viewModel
//import androidx.lifecycle.viewmodel
import com.example.bmi3.ui.theme.BmiViewModel
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Column
import androidx.compose.ui.unit.dp
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview



@Composable
fun Greeting(viewModel: BmiViewModel) {
    val state = viewModel.state
    val weight = state.weight
    val height = state.height
    val bmi = state.bmi

    Column(
        Modifier.padding(vertical = 16.dp)) {
        Text(text = "Body Mass Index", style = MaterialTheme.typography.headlineMedium)
        TextField(
            value = weight,
            onValueChange = { viewModel.changeWeight(it) },
            label = { Text("Weight (kg)") }
        )
        TextField(
            value = height,
            onValueChange = { viewModel.changeHeight(it) },
            label = { Text("Height (cm)") }
        )
        if (bmi > 0) {
            Text(text = "BMI is: $bmi")
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    //BMI3Theme {
    Greeting(viewModel = BmiViewModel())
    // (viewModel: BmiViewModel)
    //}
}
