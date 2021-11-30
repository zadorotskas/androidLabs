package com.example.lab6_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lab6_2.databinding.ActivityMainBinding
import kotlinx.coroutines.newFixedThreadPoolContext
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import android.graphics.BitmapFactory
import android.provider.ContactsContract.CommonDataKinds.Website.URL
import android.view.View
import java.io.FileNotFoundException
import java.net.URL


class MainActivity : AppCompatActivity() {
    private lateinit var executor: ExecutorService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        executor = Executors.newFixedThreadPool(1)
        executor.execute {
            downloadImage(binding)
        }
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

    override fun onDestroy() {
        executor.shutdownNow()
        super.onDestroy()
    }

    companion object {
        const val PHOTO_URL = "https://sun9-84.userapi.com/impg/iOwEmtp3GF_sQfJhdk0TCEBlu5MSL8_JB7iAwQ/wTV4w3Yh7fs.jpg?size=425x604&quality=96&sign=97f8ea6bac0bef0bede1bb7d19d8dcd4&type=album"
    }
}