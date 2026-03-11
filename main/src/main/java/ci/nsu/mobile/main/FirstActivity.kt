package ci.nsu.mobile.main

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class FirstActivity : AppCompatActivity() {

    private lateinit var editTextData: EditText
    private lateinit var buttonGoToSecond: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        editTextData = findViewById(R.id.editTextData)
        buttonGoToSecond = findViewById(R.id.buttonGoToSecond)

        buttonGoToSecond.setOnClickListener {
            // Получаем текст из EditText
            val userData = editTextData.text.toString()

            // Создаём Intent для перехода на SecondActivity
            val intent = Intent(this, SecondActivity::class.java)

            // Передаём данные через putExtra
            intent.putExtra("USER_DATA", userData)

            // Запускаем SecondActivity
            startActivity(intent)
        }
    }
}