package com.example.examen_practico

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.examen_practico.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        data class Agenda(val nombre:String, val noControl:Int)
        val nombre = binding.nombre
        val noControl = binding.noControl
        val btnAgregar = binding.btnAgregar
        val cuenta = binding.cuenta
        val btnBuscar = binding.btnBuscar
        val buscar = binding.buscar

        val agenda = mutableListOf<Agenda>()

        btnAgregar.setOnClickListener{
            if(nombre.text.isNotEmpty() && noControl.text.isNotEmpty()) {
                agenda.add(Agenda(nombre.text.toString(), noControl.text.toString().toInt()))
                cuenta.setText("Llevas agregados: ${agenda.count()}")
                Toast.makeText(this, "Agregado con éxito", Toast.LENGTH_SHORT).show()
                nombre.text.clear()
                noControl.text.clear()
            }
            else{
                Toast.makeText(this, "Los campos deben estar llenos", Toast.LENGTH_SHORT).show()
            }
        }

        btnBuscar.setOnClickListener{
            if(buscar.text.isNotEmpty()){
                val intento = Intent(this,MainActivityNuevo::class.java)
                var valor = agenda.find{it.noControl == buscar.text.toString().toInt()}
                if(valor != null) {
                    val nombre = valor.nombre
                    intento.putExtra("Nombre", nombre)
                    startActivity(intento)
                    buscar.text.clear()
                }
                else{
                    Toast.makeText(this, "No se encontro ningun elemento en la agenda", Toast.LENGTH_SHORT).show()
                }
            }
            else{
                Toast.makeText(this, "Necesitas ingresar un número de control", Toast.LENGTH_SHORT).show()
            }
        }




    }
}