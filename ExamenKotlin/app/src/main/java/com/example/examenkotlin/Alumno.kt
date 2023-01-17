package com.example.examenkotlin

import java.util.*


data class Alumno(
    var idAlumno: Int = getAutoID(),
    var nombre: String = "",
    var estatura: Double = 0.0,
    var matricula: Int = 0,
    var economia: Double = 0.0


) {
    companion object {
        fun getAutoID(): Int {
            val random = Random()
            return random.nextInt(100)
        }
    }

}