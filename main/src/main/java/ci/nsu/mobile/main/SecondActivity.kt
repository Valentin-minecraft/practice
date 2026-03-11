package ci.nsu.mobile.main

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class SecondActivity : AppCompatActivity() {

    private lateinit var textViewReceivedData: TextView
    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        textViewReceivedData = findViewById(R.id.textViewReceivedData)
        toolbar = findViewById(R.id.toolbar)

        // Настраиваем Toolbar как ActionBar
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true) // Показываем кнопку "Назад"
        supportActionBar?.title = "Экран 2"

        // Получаем данные из Intent
        val receivedData = intent.getStringExtra("USER_DATA") ?: "Данные не получены"
        textViewReceivedData.text = "Полученные данные: $receivedData"
    }

    // Обработка нажатия на кнопку "Назад" в Toolbar
    override fun onSupportNavigateUp(): Boolean {
        finish() // Закрываем текущую Activity и возвращаемся назад
        return true
    }
}