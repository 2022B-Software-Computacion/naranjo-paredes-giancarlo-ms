fun main(args: Array<String>) {
    /*Se debera enviar un archivo ya sea en blanco o con datos para la realización de métodos CRUD*/

    /*Comprobar si existen o no datos, en caso de existir mostrar los datos existentes , en caso de no existir
    * ingresar los datos que se quiere, tanto de alumno como de colegio */

    /*Como existe la relación 1-n existirá una FK en COLEGIO la cual será Cédula como PK de alumno por lo que si se elimina
    * algún alumno se debera eliminar de igual forma en colegio, y en caso de que se quiera eliminar de colegio, se eliminara
    * de igual forma en alumno */

    val alumno1 = Alumno(1706912258, "Carlos", "Sanchez")
    val alumno2 = Alumno(1803848157, "Andres", "Ortega")
    val alumnos: ArrayList<Alumno> = arrayListOf()
    alumnos.add(alumno1)
    alumnos.add(alumno2)

    val colegio = Colegio(1, "CNC", alumnos)


}

class Colegio(idColegio: Int, nombreColegio: String, alumnos: ArrayList<Alumno>) {
    private val idColegio: Int
    private val nombreColegio: String
    private val alumnos: ArrayList<Alumno>

    init {
        this.idColegio = idColegio
        this.nombreColegio = nombreColegio
        this.alumnos = alumnos
    }

    fun getIdColegio(): Int {
        return this.idColegio
    }

    fun getNombreColegio(): String {
        return this.nombreColegio;
    }

    fun getAlumnos(): ArrayList<Alumno> {
        return this.alumnos
    }

}

class Alumno(idAlumno: Int, nombre: String, apellido: String) {
    private val idAlumno: Int
    private val nombre: String
    private val apellido: String

    init {
        this.nombre = nombre
        this.apellido = apellido
        this.idAlumno = idAlumno
    }

    fun getCId(): Int {
        return this.idAlumno
    }

    fun getNombre(): String {
        return this.nombre
    }

    fun getApellido(): String {
        return this.apellido
    }

}