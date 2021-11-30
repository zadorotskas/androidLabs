package com.example.lab6_3

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.example.lab6_3.databinding.ActivityMainBinding
import kotlinx.coroutines.*
import java.net.URL

class MainActivity : AppCompatActivity() {
    private lateinit var job: Job

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        job = CoroutineScope(Dispatchers.IO).launch {
            downloadImage(binding)
        }
    }

    override fun onDestroy() {
        job.cancel()
        super.onDestroy()
    }

    private fun downloadImage(binding: ActivityMainBinding) {
        try {
            val mIconVal = BitmapFactory.decodeStream(URL(PHOTO_URL).openConnection().getInputStream())
            binding.imageView.post {
                binding.imageView.setImageBitmap(mIconVal)
            }
        } catch (e: Exception) {
            binding.textView.post {
                binding.textView.text = getString(R.string.error_message)
                binding.textView.visibility = View.VISIBLE
            }
        }
    }

    companion object {
        const val PHOTO_URL = "https://sun9-37.userapi.com/impg/fpkPDN2psyU3gaAWb9F1jz_RbpTQ31BsrsPYxA/7aj9SQ6JxWk.jpg?size=1579x1579&quality=96&sign=4dee11153ac49a51e7085bc1853406d5&type=album"
    }
}