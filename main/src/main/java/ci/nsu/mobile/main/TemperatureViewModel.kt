package ci.nsu.mobile.main

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlin.text.format
import kotlin.text.isNotBlank
import kotlin.text.toDoubleOrNull

class TemperatureViewModel : ViewModel() {

    // ПРИВАТНЫЙ изменяемый поток состояния (только ViewModel может его менять)
    private val _uiState = MutableStateFlow(TemperatureUiState())

    // ПУБЛИЧНЫЙ поток только для чтения (UI может только читать)
    val uiState: StateFlow<TemperatureUiState> = _uiState.asStateFlow()

    // Функция вызывается, когда пользователь меняет поле "Цельсий"
    fun onCelsiusChanged(newValue: String) {
        _uiState.update { currentState ->
            val celsius = newValue
            val fahrenheit = if (celsius.isNotBlank()) {
                // Пытаемся преобразовать в число
                val c = celsius.toDoubleOrNull()
                if (c != null) {
                    // Формула: °F = °C × 9/5 + 32
                    val result = c * 9.0 / 5.0 + 32.0
                    // Округляем до 2 знаков после запятой
                    String.format("%.2f", result)
                } else {
                    ""  // Если введено не число - очищаем поле Фаренгейта
                }
            } else {
                ""  // Если поле Цельсия пустое - очищаем поле Фаренгейта
            }

            // Возвращаем новое состояние
            currentState.copy(
                celsius = celsius,
                fahrenheit = fahrenheit
            )
        }
    }
}