package ci.nsu.mobile.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.collectAsState

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TemperatureConverterApp()
        }
    }
}

@Composable
fun TemperatureConverterApp() {
    // Создаем ViewModel
    val viewModel: TemperatureViewModel = viewModel()

    // Подписываемся на изменения состояния
    val uiState by viewModel.uiState.collectAsState()

    // Отображаем экран
    TemperatureScreen(
        uiState = uiState,
        onCelsiusChanged = { viewModel.onCelsiusChanged(it) }
    )
}

@Composable
fun TemperatureScreen(
    uiState: TemperatureUiState,
    onCelsiusChanged: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Заголовок
        Text(
            text = "Конвертер температуры",
            fontSize = 24.sp,
            modifier = Modifier.padding(bottom = 32.dp)
        )

        // Поле для ввода Цельсия
        OutlinedTextField(
            value = uiState.celsius,
            onValueChange = onCelsiusChanged,
            label = { Text("Градусы Цельсия (°C)") },
            isError = !uiState.isCelsiusValid && uiState.celsius.isNotBlank(),
            supportingText = {
                if (!uiState.isCelsiusValid && uiState.celsius.isNotBlank()) {
                    Text("Введите число")
                }
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Поле для ввода Фаренгейта (пока только для отображения)
        OutlinedTextField(
            value = uiState.fahrenheit,
            onValueChange = { /* Пока ничего не делаем */ },
            label = { Text("Градусы Фаренгейта (°F)") },
            readOnly = true,  // Пока только для чтения
            modifier = Modifier.fillMaxWidth()
        )
    }
}