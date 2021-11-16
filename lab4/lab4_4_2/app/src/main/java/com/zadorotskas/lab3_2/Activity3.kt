package com.zadorotskas.lab3_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.zadorotskas.lab3_2.databinding.Activity2Binding
import com.zadorotskas.lab3_2.databinding.Activity3Binding

class Activity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = Activity3Binding.inflate(layoutInflater)
        binding.bnToFirst.setOnClickListener {
            setResult(Activity2.RESULT_TO_FIRST)
            finish()
        }

        binding.bnToSecond.setOnClickListener {
            finish()
        }

        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
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

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}