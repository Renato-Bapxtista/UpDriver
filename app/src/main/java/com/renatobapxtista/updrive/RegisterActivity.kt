package com.renatobapxtista.updrive

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.renatobapxtista.updrive.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupStateSpinner()
        setupListeners()
    }

    private fun setupStateSpinner() {
        val states = arrayOf(
            "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG",
            "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"
        )
        val adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, states)
        binding.editState.setAdapter(adapter)
    }

    private fun setupListeners() {
        // Botão Voltar
        binding.btnBack.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        binding.textLogin.setOnClickListener {
            finish()
        }

        binding.btnRegister.setOnClickListener {
            val name = binding.editName.text.toString()
            val email = binding.editEmail.text.toString()
            val phone = binding.editPhone.text.toString()
            val city = binding.editCity.text.toString()
            val state = binding.editState.text.toString()
            val password = binding.editPassword.text.toString()
            val confirmPassword = binding.editConfirmPassword.text.toString()
            val acceptedTerms = binding.checkTerms.isChecked

            if (validateFields(name, email, phone, city, state, password, confirmPassword, acceptedTerms)) {
                // Lógica de cadastro (exemplo)
                Toast.makeText(this, "Cadastro realizado com sucesso!", Toast.LENGTH_SHORT).show()
                finish()
            }
        }
    }

    private fun validateFields(
        name: String,
        email: String,
        phone: String,
        city: String,
        state: String,
        password: String,
        confirmPassword: String,
        acceptedTerms: Boolean
    ): Boolean {
        if (name.isEmpty() || email.isEmpty() || phone.isEmpty() || city.isEmpty() || state.isEmpty()) {
            Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
            return false
        }
        if (password.length < 6) {
            Toast.makeText(this, "A senha deve ter pelo menos 6 caracteres", Toast.LENGTH_SHORT).show()
            return false
        }
        if (password != confirmPassword) {
            Toast.makeText(this, "As senhas não coincidem", Toast.LENGTH_SHORT).show()
            return false
        }
        if (!acceptedTerms) {
            Toast.makeText(this, "Você precisa aceitar os termos", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }
}
