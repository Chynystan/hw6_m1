package com.geektech.hw6_m1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.geektech.hw6_m1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).
        also { setContentView(it.root) }
        initListener()
        initTitle()
    }

    private fun initListener() {
        binding.btnSend.setOnClickListener {
            val title: String = binding.edtTxt.text.toString()
            if (title.isNotBlank()) {
                openActivity(title)
            } else {
                Toast.makeText(this,
                    "Edit text cannot be empty",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun initTitle() {
        val extra = intent.extras
        val title = extra?.getString("titleSecond")
        binding.edtTxt.setText(title)
    }

    private fun openActivity(title: String) {
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("titleFirst", title)
        startActivity(intent)
    }
}