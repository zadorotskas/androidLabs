package com.zadorotskas.lab3_3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.zadorotskas.lab3_3.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(ActivityAboutBinding.inflate(layoutInflater).root)
    }
}
