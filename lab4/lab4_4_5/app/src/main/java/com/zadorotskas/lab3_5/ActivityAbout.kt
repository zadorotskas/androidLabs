package com.zadorotskas.lab3_5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.zadorotskas.lab3_5.databinding.ActivityAboutBinding

class ActivityAbout : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(ActivityAboutBinding.inflate(layoutInflater).root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}