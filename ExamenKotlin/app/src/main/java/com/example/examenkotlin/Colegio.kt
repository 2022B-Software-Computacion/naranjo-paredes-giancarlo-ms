package com.example.examenkotlin

import java.util.*

class Colegio {
    val fechaCreacion: String? = ""

    // String --> Char
    val bloque: String = ""
    val inversion = 0.0
    val nombre = ""
    val idColegio = getAutoID()

    companion object {
        fun getAutoID(): Int {
            val random = Random()
            return random.nextInt(100)
        }
    }
}
