package com.zadorotskas.lab3_4

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.zadorotskas.lab3_4.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(ActivityAboutBinding.inflate(layoutInflater).root)
    }
}
