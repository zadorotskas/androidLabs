package com.zadorotskas.lab3_3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.zadorotskas.lab3_3.databinding.Activity1Binding

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
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.options_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (item.itemId == R.id.to_about) {
            val intent = Intent(this, AboutActivity::class.java)
            startActivity(intent)
            true
        }
        else super.onOptionsItemSelected(item)
    }
}