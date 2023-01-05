package com.example.examenkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var edIdAlumno: TextView
    private lateinit var edNombre: EditText
    private lateinit var edEstatura: EditText
    private lateinit var edMatricula: Spinner
    private lateinit var fechaNacimiento: EditText
    private lateinit var btnIngresar: Button
    private lateinit var btnVisualizar: Button
    private lateinit var btnActualizar: Button


    private lateinit var conexion: Conexion
    private lateinit var recyclerView: RecyclerView
    private var interfaz: AlumnoInterfaz? = null
    private var alumno: Alumno? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inicializarVista()
        inicializarRecyclerView()
        edMatricula = findViewById(R.id.edMatricula)
        /*ArrayAdapter<String> adapter = ArrayAdapter . createFromResource (
                this,
        R.array.matriculado,
        android.R.layout.simple_spinner_item
        )
        */

        conexion = Conexion(this)
        btnIngresar.setOnClickListener { crearAlumno() }
        btnVisualizar.setOnClickListener { leerAlumnos() }
        btnActualizar.setOnClickListener { actualizarAlumno() }

        interfaz?.setOnClickItem {
            var idAlumnoVista: String = "Codigo de alumno: " + it.idAlumno.toString()
            edIdAlumno.setText(idAlumnoVista)
            Toast.makeText(this, it.nombre, Toast.LENGTH_SHORT).show()
            // Colocamos los registros
            edNombre.setText(it.nombre)
            edEstatura.setText(it.estatura.toString())
            edMatricula.setText(it.matricula.toString())
            fechaNacimiento.setText(it.fechaNacimiento.toString())
            alumno = it
        }

        interfaz?.setOnClickDeleteItem {
            eliminarEstudiante(it.idAlumno)
        }


    }

    private fun actualizarAlumno() {
        val nombre = edNombre.text.toString()
        val estatura = edEstatura.text.toString().toDouble()
        val matricula = edMatricula.text.toString().toInt()
        val fechaNacimiento = fechaNacimiento.text.toString()

        //Revisar que efectivamente haya cambios
        if (nombre == alumno?.nombre && estatura == alumno?.estatura) {
            Toast.makeText(this, "Registro no cambiado", Toast.LENGTH_SHORT).show()
            return
        }
        if (alumno == null) return
        val alumno = Alumno(
            idAlumno = alumno!!.idAlumno,
            nombre = nombre,
            estatura = estatura,
            matricula = matricula,
            fechaNacimiento = fechaNacimiento
        )
        val estado = conexion.actualizarAlumno(alumno)
        if (estado > -1) {
            clearEditText()
            leerAlumnos()
        } else {
            Toast.makeText(this, "Actualizacion fallida", Toast.LENGTH_SHORT).show()
        }
    }

    private fun leerAlumnos() {
        val alumnos = conexion.leerAlumno()
        //Necesitaremos una vista para la muestra de datos
        interfaz?.agregarRegistros(alumnos)
    }

    private fun crearAlumno() {
        val nombre = edNombre.text.toString()
        val estatura = edEstatura.text.toString().toDouble()
        val matricula = edMatricula.text.toString().toInt()
        val fechaNacimiento = fechaNacimiento.text.toString()

        if (nombre.isEmpty()) {
            Toast.makeText(this, "Porfavor ingresar todos los campos", Toast.LENGTH_SHORT).show()
        } else {
            val alumno = Alumno(
                nombre = nombre,
                estatura = estatura,
                matricula = matricula,
                fechaNacimiento = fechaNacimiento
            )
            val estado = conexion.crearAlumno(alumno)
            if (estado > -1) {
                Toast.makeText(this, "Estudiante agregado", Toast.LENGTH_SHORT).show()
                clearEditText()
                leerAlumnos()
            } else {
                Toast.makeText(this, "Registro no guardado", Toast.LENGTH_SHORT).show()

            }
        }
    }

    private fun eliminarEstudiante(id: Int) {
        if (id == null) return
        val builder = AlertDialog.Builder(this)
        builder.setMessage("Estas seguro que quieres eliminar este estudiante?")
        builder.setCancelable(true)
        builder.setPositiveButton("Si") { dialog, _ ->
            conexion.eliminarAlumno(id)
            leerAlumnos()
            dialog.dismiss()
        }
        builder.setNegativeButton("No") { dialog, _ ->
            dialog.dismiss()
        }

        val alert = builder.create()
        alert.show()
    }

    private fun clearEditText() {
        edNombre.setText("")
        edEstatura.setText("")
        edMatricula.setText("")
        fechaNacimiento.setText("")
        edNombre.requestFocus()

    }

    private fun inicializarRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        interfaz = AlumnoInterfaz()
        recyclerView.adapter = interfaz

    }

    private fun inicializarVista() {
        edIdAlumno = findViewById(R.id.edIdAlumno);
        edNombre = findViewById(R.id.edNombre)
        edEstatura = findViewById(R.id.edEstatura)
        edMatricula = findViewById(R.id.edMatricula)
        var adaptador = ArrayAdapter.createFromResource(
            this,
            R.array.matriculado,
            android.R.layout.simple_spinner_item
        )
        fechaNacimiento = findViewById(R.id.edFechaNacimiento)
        btnIngresar = findViewById(R.id.btnIngresar)
        btnVisualizar = findViewById(R.id.btnVisualizar)
        btnActualizar = findViewById(R.id.btnActualizar)
        recyclerView = findViewById(R.id.recycleView)
    }

}