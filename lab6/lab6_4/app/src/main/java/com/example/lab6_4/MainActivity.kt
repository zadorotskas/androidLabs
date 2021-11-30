package com.example.lab6_4

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lab6_4.databinding.ActivityMainBinding
import com.facebook.drawee.backends.pipeline.Fresco

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Fresco.initialize(this)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        downloadImage(binding)
    }

    private fun downloadImage(binding: ActivityMainBinding) {
        binding.draweeView.setImageURI(Uri.parse(PHOTO_URL))
    }

    companion object {
        const val PHOTO_URL = "https://sun9-84.userapi.com/impg/iOwEmtp3GF_sQfJhdk0TCEBlu5MSL8_JB7iAwQ/wTV4w3Yh7fs.jpg?size=425x604&quality=96&sign=97f8ea6bac0bef0bede1bb7d19d8dcd4&type=album"
    }
}