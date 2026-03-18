package ci.nsu.mobile.main

import android.os.Bundle
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


        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Экран 2"


        val receivedData = intent.getStringExtra("USER_DATA")
        textViewReceivedData.text = "Полученные данные: $receivedData"
    }


    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}