import java.util.*

fun main() {
    println("Hola")

    //Tipos de variables

    //INMUATBLES (No re asignar)=
    val inmutable: String = "Adrian";
    //inmutable = "Vicente"; //No se puede reasignar


    //Mutables (Re asignar)=
    var mutable: String = "Vicente"
    mutable = "Adrian"

    //val > var


    //Sintaxis Duck typing
    val ejemploVariable = "Ejemplo"
    val edadEjemplo: Int = 12
    ejemploVariable.trim()

    //Variables primitivas
    val nombreProfesor: String = "Adrian Eguez"
    val sueldo: Double = 1.2
    val estadoCivil: Char = 'S'
    val mayorEdad: Boolean = true

    //Clases JAVA
    val fechaNacimiento: Date = Date()

    if (true) {
    } else {
    }

    // switch no existe
    val estadoCivilWhen = "S"
    when (estadoCivilWhen) {
        ("S") -> {
            println("acercarse")
        }
        "C" -> {
            println("alejarse")
        }
        "UN" -> println("hablar")
        else -> println("No reconocido")
    }
    val coqueteo = if (estadoCivilWhen == "S") "SI" else "NO"


    // Unit == void
    fun imprimirNombre(nombre: String): Unit {
        println("Nombre : ${nombre}")
    }

    fun calcularSueldo(
        sueldo: Double, // Requerido
        tasa: Double = 12.00, // Opcional (Defecto)
        bonoEspecial: Double? = null, // Opcional (NULL) -> nullable
    ): Double {
        // String -> String?
        // Int -> Int?
        // Date -> Date?
        if (bonoEspecial == null) {
            return sueldo * (100 / tasa)
        } else {
            return sueldo * (100 / tasa) + bonoEspecial
        }
    }
}
