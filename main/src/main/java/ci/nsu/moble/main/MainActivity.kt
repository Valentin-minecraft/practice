package ci.nsu.moble.main

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {


    data class MyColor(val name: String, val colorCode: Int)


    private val colorPalette = listOf(
        MyColor("Red", Color.RED),
        MyColor("Orange", Color.rgb(255, 165, 0)),
        MyColor("Yellow", Color.YELLOW),
        MyColor("Green", Color.GREEN),
        MyColor("Blue", Color.BLUE),
        MyColor("Indigo", Color.rgb(75, 0, 130)),
        MyColor("Violet", Color.rgb(238, 130, 238))
    )


    private lateinit var editTextColor: EditText
    private lateinit var buttonApply: Button
    private lateinit var paletteContainer: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        editTextColor = findViewById(R.id.editTextColor)
        buttonApply = findViewById(R.id.buttonApply)
        paletteContainer = findViewById(R.id.paletteContainer)


        buttonApply.setOnClickListener {
            findAndApplyColor()
        }


        showPalette()
    }


    private fun findAndApplyColor() {

        val inputText = editTextColor.text.toString().trim()


        val foundColor = colorPalette.find {
            it.name.equals(inputText, ignoreCase = true)
        }

        if (foundColor != null) {

            buttonApply.setBackgroundColor(foundColor.colorCode)

        }
    }


    private fun showPalette() {

        paletteContainer.removeAllViews()


        for (colorItem in colorPalette) {

            val rowLayout = LinearLayout(this).apply {
                orientation = LinearLayout.HORIZONTAL
                layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    80
                ).apply {
                    setMargins(0, 5, 0, 5)
                }
            }


            val colorBox = View(this).apply {
                layoutParams = LinearLayout.LayoutParams(80, 80)  // ширина и высота 80px
                setBackgroundColor(colorItem.colorCode)
            }


            val colorName = TextView(this).apply {
                text = colorItem.name
                textSize = 18f
                layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                ).apply {
                    setMargins(20, 0, 0, 0)  // отступ слева 20px
                }
            }


            rowLayout.addView(colorBox)
            rowLayout.addView(colorName)


            paletteContainer.addView(rowLayout)
        }
    }
}