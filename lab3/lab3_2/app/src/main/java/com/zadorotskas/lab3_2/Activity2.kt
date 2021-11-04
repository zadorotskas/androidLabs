package com.zadorotskas.lab3_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.zadorotskas.lab3_2.databinding.Activity2Binding

class Activity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = Activity2Binding.inflate(layoutInflater)
        binding.toFirst.setOnClickListener {
            finish()
        }

        binding.toThird.setOnClickListener {
            startActivityForResult(Intent(this, Activity3::class.java), REQUEST_CODE)
        }

        setContentView(binding.root)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE && resultCode == RESULT_TO_FIRST) {
            finish()
        }
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

    companion object {
        const val REQUEST_CODE = 0
        const val RESULT_TO_FIRST = 1
    }
}