package com.example.examenkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var edNombre: EditText
    private lateinit var edEstatura: EditText
    private lateinit var edMatricula: EditText
    private lateinit var edEconomia: EditText
    private lateinit var btnIngresar: Button
    private lateinit var btnVisualizar: Button

    private lateinit var conexion: Conexion


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inicializarVista()
        conexion = Conexion(this)
        btnIngresar.setOnClickListener { crearAlumno() }
        btnVisualizar.setOnClickListener { leerAlumnos() }
    }

    private fun leerAlumnos() {
        val alumnos = conexion.leerAlumno()
        println(alumnos)
        Log.e("pppp", "${alumnos.size}")
    }

    private fun crearAlumno() {
        val nombre = edNombre.text.toString()
        val estatura = edEstatura.text.toString().toDouble()
        val matricula = edMatricula.text.toString().toInt()
        val economia = edEconomia.text.toString().toDouble()

        if (nombre.isEmpty()) {
            Toast.makeText(this, "Porfavor ingresar todos los campos", Toast.LENGTH_SHORT).show()
        } else {
            val alumno = Alumno(
                nombre = nombre,
                estatura = estatura,
                matricula = matricula,
                economia = economia
            )
            val estado = conexion.crearAlumno(alumno)
            if (estado > -1) {
                Toast.makeText(this, "Estudiante agregado", Toast.LENGTH_SHORT).show()
                clearEditText()
            } else {
                Toast.makeText(this, "Registro no guardado", Toast.LENGTH_SHORT).show()

            }
        }


    }

    private fun clearEditText() {
        edNombre.setText("")
        edEstatura.setText("")
        edMatricula.setText("")
        edEconomia.setText("")
        edNombre.requestFocus()

    }

    private fun inicializarVista() {
        edNombre = findViewById(R.id.edNombre)
        edEstatura = findViewById(R.id.edEstatura)
        edMatricula = findViewById(R.id.edMatricula)
        edEconomia = findViewById(R.id.edEconomia)
        btnIngresar = findViewById(R.id.btnIngresar)
        btnVisualizar = findViewById(R.id.btnVisualizar)
    }
}