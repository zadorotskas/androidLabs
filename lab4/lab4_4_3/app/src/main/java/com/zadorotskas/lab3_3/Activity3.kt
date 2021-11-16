package com.zadorotskas.lab3_3

import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.zadorotskas.lab3_3.databinding.Activity3Binding

class Activity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = Activity3Binding.inflate(layoutInflater)
        binding.bnToFirst.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java).addFlags(FLAG_ACTIVITY_CLEAR_TOP))
        }

        binding.bnToSecond.setOnClickListener {
            finish()
        }

        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
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

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}