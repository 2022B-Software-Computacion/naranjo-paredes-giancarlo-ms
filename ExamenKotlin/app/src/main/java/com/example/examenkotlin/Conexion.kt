package com.example.examenkotlin

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class Conexion(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    companion object {
        private const val DATABASE_VERSION = 2
        private const val DATABASE_NAME = "alumno.db"
        private const val TBL_ALUMNO = "tbl_student"
        private const val IDALUMNO = "id"
        private const val NOMBRE = "nombre"
        private const val ESTATURA = "estatura"
        private const val MATRICULA = "matricula"
        private const val ECONOMIA = "economia"

        //Crear las variables para la base de datos colegio
        private const val TBL_COLEGIO = "tbl_colegio"
        private const val IDCOLEGIO = "id" //Int
        private const val NOMBRECOLEGIO = "nombre_colegio" //String
        private const val INVERSION = "inversion_colegio" //Double
        private const val BLOQUE = "bloque" //Char
        private const val FECHACREACION = "fecha_creacion" //Date

        //Foreing key en la tabla alumno de colegio
        private const val FKCOLEGIO =
            "FOREIGN KEY($IDCOLEGIO) REFERENCES $TBL_ALUMNO($IDALUMNO)"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        //Creacion de la tabla colegio
        val createTableColegio = (
                "CREATE TABLE " + TBL_COLEGIO +
                        "(" +
                        IDCOLEGIO + " INTEGER PRIMARY KEY," +
                        NOMBRECOLEGIO + " TEXT," +
                        INVERSION + " real," +
                        BLOQUE + " TEXT," +
                        FECHACREACION + " TEXT" +
                        ")"
                )
        db?.execSQL(createTableColegio)

        val createTableAlumno = (
                "CREATE TABLE " + TBL_ALUMNO +
                        "(" +
                        IDALUMNO + " INTEGER PRIMARY KEY," +
                        NOMBRE + " TEXT," +
                        ESTATURA + " real," +
                        MATRICULA + " INTEGER," +
                        ECONOMIA + " real," +
                        FKCOLEGIO +
                        ")"
                )
        db?.execSQL(createTableAlumno)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $TBL_ALUMNO;")
        onCreate(db)
    }

    //Metodos CRUD para alumnos
    fun crearAlumno(alumno: Alumno): Long {
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put(IDALUMNO, alumno.idAlumno)
        cv.put(NOMBRE, alumno.nombre)
        cv.put(ESTATURA, alumno.estatura)
        cv.put(MATRICULA, alumno.matricula)
        cv.put(ECONOMIA, alumno.economia)

        val success = db.insert(TBL_ALUMNO, null, cv)
        db.close()
        return success
    }

    fun leerAlumno(): ArrayList<Alumno> {
        val alumnos: ArrayList<Alumno> = ArrayList()
        val consulta = "SELECT * FROM $TBL_ALUMNO"
        val db = this.readableDatabase
        val cursor: Cursor?

        try {
            cursor = db.rawQuery(consulta, null)
        } catch (e: Exception) {
            e.printStackTrace()
            db.execSQL(consulta)
            return ArrayList()
        }

        var idAlumno: Int
        var nombre: String
        var estatura: Double
        var matricula: Int
        var economia: Double

        if (cursor.moveToFirst()) {
            do {
                idAlumno = cursor.getInt(cursor.getColumnIndexOrThrow("id"))
                nombre = cursor.getString(cursor.getColumnIndexOrThrow("nombre"))
                estatura = cursor.getDouble(cursor.getColumnIndexOrThrow("estatura"))
                matricula = cursor.getInt(cursor.getColumnIndexOrThrow("matricula"))
                economia = cursor.getDouble(cursor.getColumnIndexOrThrow("economia"))

                val alumno = Alumno(
                    idAlumno = idAlumno, nombre = nombre, estatura = estatura,
                    matricula = matricula, economia = economia
                )
                alumnos.add(alumno)
            } while (cursor.moveToNext())
        }
        return alumnos
    }

    fun actualizarAlumno(alumno: Alumno): Int {
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put(IDALUMNO, alumno.idAlumno)
        cv.put(NOMBRE, alumno.nombre)
        cv.put(ESTATURA, alumno.estatura)
        cv.put(MATRICULA, alumno.matricula)
        cv.put(ECONOMIA, alumno.economia)
        val success = db.update(TBL_ALUMNO, cv, "id=" + alumno.idAlumno, null)
        db.close()
        return success
    }

    fun eliminarAlumno(idAlumno: Int): Int {
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put(IDALUMNO, idAlumno)
        val success = db.delete(TBL_ALUMNO, "id=$idAlumno", null)
        db.close()
        return success
    }

    //Metodos CRUD para colegio
    fun crearColegio(colegio: Colegio): Long {
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put(IDCOLEGIO, colegio.idColegio)
        cv.put(NOMBRECOLEGIO, colegio.nombre)
        cv.put(INVERSION, colegio.inversion)
        cv.put(BLOQUE, colegio.bloque)
        cv.put(FECHACREACION, colegio.fechaCreacion)

        val success = db.insert(TBL_COLEGIO, null, cv)
        db.close()
        return success
    }

    fun eliminarColegio(idColegio: Int): Int {
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put(IDCOLEGIO, idColegio)
        val success = db.delete(TBL_COLEGIO, "id=$idColegio", null)
        db.close()
        return success
    }

    fun actualizarColegio(colegio: Colegio): Int {
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put(IDCOLEGIO, colegio.idColegio)
        cv.put(NOMBRECOLEGIO, colegio.nombre)
        cv.put(INVERSION, colegio.inversion)
        cv.put(BLOQUE, colegio.bloque)
        cv.put(FECHACREACION, colegio.fechaCreacion)
        val success = db.update(TBL_COLEGIO, cv, "id=" + colegio.idColegio, null)
        db.close()
        return success
    }
}