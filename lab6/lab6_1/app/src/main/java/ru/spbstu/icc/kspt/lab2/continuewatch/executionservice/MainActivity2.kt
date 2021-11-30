package ru.spbstu.icc.kspt.lab2.continuewatch.executionservice

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import ru.spbstu.icc.kspt.lab2.continuewatch.R
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class MainActivity2 : AppCompatActivity() {
    private var secondsElapsed: Int = 0
    private lateinit var textSecondsElapsed: TextView

    private lateinit var executor: ExecutorService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textSecondsElapsed = findViewById(R.id.textSecondsElapsed)
    }

    override fun onStart() {
        super.onStart()
        initThread()
        Log.i("Thread", "Started counting")
    }

    override fun onStop() {
        executor.shutdownNow()
        Log.i("Thread", "Ended counting")
        super.onStop()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.run {
            putInt(SECONDS, secondsElapsed)
        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        with(savedInstanceState) {
            secondsElapsed = getInt(SECONDS)
        }

        textSecondsElapsed.text = getString(R.string.seconds_elapsed, (secondsElapsed / 20))
    }

    private fun initThread() {
        executor = Executors.newFixedThreadPool(1)
        executor.execute {
            try {
                while (!Thread.currentThread().isInterrupted) {
                    Thread.sleep(50)
                    textSecondsElapsed.post {
                        textSecondsElapsed.text =
                            getString(R.string.seconds_elapsed, (secondsElapsed++ / 20))
                    }
                }
            } catch (e: InterruptedException) {
                Log.i("Thread", "Interrupted ${Thread.currentThread().name}")
            }
        }
    }


    companion object {
        private const val SECONDS = "seconds"
    }
}
