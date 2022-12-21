package com.nik.diceassignment

import android.arch.lifecycle.ViewModel
import android.content.Context
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class DiceUiState(
    val value: Int? = null,
    val result: String = "",
    val count: Int = 0
)

class DiceViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(DiceUiState())
    val uiState: StateFlow<DiceUiState> = _uiState.asStateFlow()

    private val dice = Dice()

    fun roll(context: Context) {
        _uiState.update { currentState ->
            currentState.copy(
                value = dice.roll(),
                result = dice.result(context),
                count = currentState.count + 1
            )
        }
    }
}