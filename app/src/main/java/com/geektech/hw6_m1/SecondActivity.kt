package com.geektech.hw6_m1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.geektech.hw6_m1.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
        private lateinit var binding: ActivitySecondBinding
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivitySecondBinding.inflate(layoutInflater).
            also { setContentView(it.root) }
            initTitle()
            initListener()
        }
        private fun initListener() {
            binding.btnSendSec.setOnClickListener {
                val secondTitle = binding.edtTxtSec.text.toString()
                if (secondTitle.isNotBlank()) {
                    back(secondTitle)
                } else {
                   Toast.makeText(this, "Edit text cannot be empty", Toast.LENGTH_SHORT
                   ).show()
                }
            }
        }
        private fun back(secondTitle: String) {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("titleSecond", secondTitle)
            startActivity(intent)
        }
        private fun initTitle() {
            val extras = intent.extras
            val title = extras?.getString("titleFirst")
            binding.edtTxtSec.setText(title)
        }
    }
