package com.renatobapxtista.updrive

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.renatobapxtista.updrive.databinding.ActivityActiveShiftBinding

class ActiveShiftActivity : AppCompatActivity() {

    private lateinit var binding: ActivityActiveShiftBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityActiveShiftBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupNavigation()
    }

    private fun setupNavigation() {
        binding.btnBack.setOnClickListener {
            finish()
        }

        binding.bottomNavigation.selectedItemId = R.id.nav_shifts
        
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_dashboard -> {
                    finish()
                    true
                }
                R.id.nav_shifts -> true
                else -> false
            }
        }
    }
}
