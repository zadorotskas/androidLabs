package com.zadorotskas.lab3_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.zadorotskas.lab3_2.databinding.Activity1Binding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = Activity1Binding.inflate(layoutInflater)
        binding.bnToSecond.setOnClickListener {
            startActivity(Intent(this, Activity2::class.java))
        }
        setContentView(binding.root)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.options_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (item.itemId == R.id.to_about) {
            startActivity(Intent(this, AboutActivity::class.java))
            true
        }
        else super.onOptionsItemSelected(item)
    }
}