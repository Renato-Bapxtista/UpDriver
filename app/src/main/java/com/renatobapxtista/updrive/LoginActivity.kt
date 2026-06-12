package com.renatobapxtista.updrive

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.renatobapxtista.updrive.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupListeners()
    }

    private fun setupListeners() {
        binding.btnLogin.setOnClickListener {
            val intent = Intent(this, DashboardActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.btnGoogle.setOnClickListener {
            // Lógica de login com Google
        }

        binding.textRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}
