package ru.spbstu.icc.kspt.lab2.continuewatch.coroutines

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import ru.spbstu.icc.kspt.lab2.continuewatch.R
import java.util.concurrent.Executor
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class MainActivity3 : AppCompatActivity() {
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
        secondsElapsed = getPreferences(Context.MODE_PRIVATE).getInt(SECONDS, 0)
        textSecondsElapsed.text = getString(R.string.seconds_elapsed, (secondsElapsed / 20))
    }

    override fun onStop() {
        Log.i("Coroutine", "app stopped")
        with(getPreferences(Context.MODE_PRIVATE).edit()) {
            putInt(SECONDS, secondsElapsed)
            apply()
        }
        super.onStop()
    }

    companion object {
        private const val SECONDS = "seconds"
    }
}
