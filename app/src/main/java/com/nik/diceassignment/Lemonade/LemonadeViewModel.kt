package com.nik.diceassignment.Lemonade

import android.content.Context
import com.nik.diceassignment.Dice
import com.nik.diceassignment.DiceUiState
import com.nik.diceassignment.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class LemonadeUiState(
    val imageResource: Int? = null,
    val text: String = "",
    val index: Int = 1,
    val count: Int = 0,
    val size: Int = 5
)

class LemonadeViewModel {
    private val _uiState = MutableStateFlow(LemonadeUiState())
    val uiState: StateFlow<LemonadeUiState> = _uiState.asStateFlow()

    fun action(context: Context) {
        _uiState.update { currentState ->
            currentState.copy(
                index = if (currentState.index == currentState.size) 1 else currentState.index + 1,
                text = updateText(context, currentState.index, currentState.count),
                imageResource = updateImage(currentState.index),
                count = if (currentState.index == currentState.size - 1) currentState.count + 1 else currentState.count,
            )
        }
    }

    fun updateText(context: Context, index: Int, count: Int): String {
        return when (index) {
            1 -> context.resources.getString(R.string.lemon_select)
            2 -> context.resources.getString(R.string.lemon_squeeze)
            3 -> context.resources.getString(R.string.lemon_drink)
            4 -> context.resources.getString(R.string.lemon_empty_glass)
            5 -> String.format(context.resources.getString(R.string.squeeze_count), count)
            else -> ""
        }
    }

    fun updateImage(index: Int): Int? {
        return when (index) {
            1 -> R.drawable.lemon_tree
            2 -> R.drawable.lemon_squeeze
            3 -> R.drawable.lemon_drink
            4 -> R.drawable.lemon_restart
            5 -> null
            else -> null
        }
    }
}