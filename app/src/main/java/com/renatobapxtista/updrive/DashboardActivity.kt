package com.renatobapxtista.updrive

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.renatobapxtista.updrive.databinding.ActivityDashboardBinding

class DashboardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupNavigation()
        setupListeners()
    }

    private fun setupListeners() {
        binding.btnStartShift.setOnClickListener {
            val intent = Intent(this, ActiveShiftActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setupNavigation() {
        binding.bottomNavigation.selectedItemId = R.id.nav_dashboard
        
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_dashboard -> true
                R.id.nav_shifts -> {
                    val intent = Intent(this, ActiveShiftActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.nav_expenses -> {
                    // Navegar para Despesas
                    true
                }
                R.id.nav_vehicle -> {
                    // Navegar para Veículo
                    true
                }
                R.id.nav_profile -> {
                    // Navegar para Perfil
                    true
                }
                else -> false
            }
        }
    }
}
