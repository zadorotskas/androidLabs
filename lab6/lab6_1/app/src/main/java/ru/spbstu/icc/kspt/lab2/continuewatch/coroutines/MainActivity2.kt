package ru.spbstu.icc.kspt.lab2.continuewatch.coroutines

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import ru.spbstu.icc.kspt.lab2.continuewatch.R
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class MainActivity2 : AppCompatActivity() {
    private var secondsElapsed: Int = 0
    private lateinit var textSecondsElapsed: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textSecondsElapsed = findViewById(R.id.textSecondsElapsed)

        lifecycleScope.launchWhenStarted {
            while (true) {
                Log.i("Coroutine", "coroutine is running")
                delay(50)
                textSecondsElapsed.text = getString(R.string.seconds_elapsed, (secondsElapsed++ / 20))
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.i("Coroutine", "app started")
    }

    override fun onStop() {
        Log.i("Coroutine", "app stopped")
        super.onStop()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.run {
            putInt(SECONDS, (secondsElapsed / 20))
        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        with(savedInstanceState) {
            secondsElapsed = getInt(SECONDS)
        }

        textSecondsElapsed.text = getString(R.string.seconds_elapsed, secondsElapsed)
    }

    companion object {
        private const val SECONDS = "seconds"
    }
}
