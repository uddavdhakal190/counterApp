package com.example.counterapp
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val counterTextView = findViewById<TextView>(R.id.counterTextView)
        val incrementButton = findViewById<Button>(R.id.incrementButton)
        val decrementButton = findViewById<Button>(R.id.decrementButton)
        val rootLayout = findViewById<RelativeLayout>(R.id.rootLayout)

        fun updateCounterDisplay() {
            counterTextView.text = counter.toString()

            when {
                counter == 0 -> rootLayout.setBackgroundColor(Color.RED)
                counter > 10 -> rootLayout.setBackgroundColor(Color.YELLOW)
                else -> rootLayout.setBackgroundColor(Color.WHITE)
            }
        }

        incrementButton.setOnClickListener {
            counter++
            updateCounterDisplay()
        }

        decrementButton.setOnClickListener {
            if (counter > 0) {
                counter--
                updateCounterDisplay()
            }
        }

        // Initial color setup
        updateCounterDisplay()
    }
}
