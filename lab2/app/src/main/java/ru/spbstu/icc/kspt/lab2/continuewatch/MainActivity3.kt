package ru.spbstu.icc.kspt.lab2.continuewatch

import android.content.Context
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity3 : AppCompatActivity() {
    private var secondsElapsed: Int = 0
    private lateinit var textSecondsElapsed: TextView

    private var backgroundThread = Thread {
        while (true) {
            Thread.sleep(1000)
            textSecondsElapsed.post {
                textSecondsElapsed.text = getString(R.string.seconds_elapsed, secondsElapsed++)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textSecondsElapsed = findViewById(R.id.textSecondsElapsed)
        backgroundThread.start()
    }

    override fun onStart() {
        super.onStart()
        val sharedPref = getPreferences(Context.MODE_PRIVATE)
        val seconds = sharedPref.getInt(SECONDS, 0)
        secondsElapsed = seconds
        textSecondsElapsed.post {
            textSecondsElapsed.text = getString(R.string.seconds_elapsed, secondsElapsed)
        }
    }

    override fun onStop() {
        super.onStop()
        val sharedPref = getPreferences(Context.MODE_PRIVATE)
        with (sharedPref.edit()) {
            putInt(SECONDS, secondsElapsed)
            apply()
        }
    }

    companion object {
        private const val SECONDS = "seconds"
    }
}
