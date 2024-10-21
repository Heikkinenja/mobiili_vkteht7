package com.example.bmi3.ui.theme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel


data class BmiState(
    val weight: String = "",
    val height: String = "",
    val bmi: Float = 0f
)

class BmiViewModel : ViewModel() {
    var state by mutableStateOf(BmiState())

    fun changeWeight(weight: String) {
        state = state.copy(weight = weight)
        calculateBmi()
    }

    fun changeHeight(height: String) {
        state = state.copy(height = height)
        calculateBmi()
    }

    private fun calculateBmi() {
        if (state.height.isNotEmpty() && state.weight.isNotEmpty()) {
            val height = state.height.toFloat() / 100  // cm -> m
            val weight = state.weight.toFloat()
            val bmi = weight / (height * height)
            state = state.copy(bmi = bmi)
        } else {
            state = state.copy(bmi = 0f)
        }
    }
}