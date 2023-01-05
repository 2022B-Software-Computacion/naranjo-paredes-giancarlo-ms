package com.example.examenkotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AlumnoInterfaz : RecyclerView.Adapter<AlumnoInterfaz.AlumnoVista>() {
    private var alumnosBD: ArrayList<Alumno> = ArrayList()
    private var onClickItem: ((Alumno) -> Unit)? = null
    private var onClickDeleteItem: ((Alumno) -> Unit)? = null


    fun agregarRegistros(registros: ArrayList<Alumno>) {
        this.alumnosBD = registros
        notifyDataSetChanged()
    }

    fun setOnClickItem(callback: (Alumno) -> Unit) {
        this.onClickItem = callback
    }

    fun setOnClickDeleteItem(callback: (Alumno) -> Unit) {
        this.onClickDeleteItem = callback
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = AlumnoVista(
        LayoutInflater.from(parent.context).inflate(R.layout.borrar_alumnos, parent, false)
    )

    override fun onBindViewHolder(holder: AlumnoVista, position: Int) {
        val alumno = alumnosBD[position]
        holder.bindView(alumno)
        holder.itemView.setOnClickListener { onClickItem?.invoke(alumno) }
        holder.btnBorrar.setOnClickListener { onClickDeleteItem?.invoke(alumno) }
    }

    override fun getItemCount(): Int {
        return alumnosBD.size
    }

    class AlumnoVista(view: View) : RecyclerView.ViewHolder(view) {
        private var idAlumno = view.findViewById<TextView>(R.id.viewIdAlumno)
        private var nombre = view.findViewById<TextView>(R.id.viewNombre)
        var btnBorrar = view.findViewById<Button>(R.id.btnBorrar)


        fun bindView(alumno: Alumno) {
            idAlumno.text = alumno.toString()
            nombre.text = alumno.nombre


        }

    }
}