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

            val userData = editTextData.text.toString()


            val intent = Intent(this, SecondActivity::class.java)


            intent.putExtra("USER_DATA", userData)


            startActivity(intent)
        }
    }
}