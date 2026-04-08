package ci.nsu.mobile.main

import androidx.compose.runtime.Stable
import kotlin.text.toDoubleOrNull

@Stable
data class TemperatureUiState(
    val celsius: String = "",      // значение в градусах Цельсия (строка, т.к. пользователь вводит текст)
    val fahrenheit: String = ""    // значение в градусах Фаренгейта (строка)
) {
    // Проверяем, можно ли преобразовать строку в число
    val isCelsiusValid: Boolean
        get() = celsius.toDoubleOrNull() != null

    val isFahrenheitValid: Boolean
        get() = fahrenheit.toDoubleOrNull() != null
}