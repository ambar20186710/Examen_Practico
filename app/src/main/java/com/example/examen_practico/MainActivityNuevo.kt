package com.example.examen_practico

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.examen_practico.databinding.ActivityMainBinding
import com.example.examen_practico.databinding.ActivityMainNuevoBinding

class MainActivityNuevo : AppCompatActivity() {

    private lateinit var binding: ActivityMainNuevoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainNuevoBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val nombre = binding.mostrarNombre

        nombre.setText("${intent.getStringExtra("Nombre").toString()}")
        supportActionBar?.apply {
            title = "Contacto de agenda"
            setDisplayHomeAsUpEnabled(true)
        }
    }
}