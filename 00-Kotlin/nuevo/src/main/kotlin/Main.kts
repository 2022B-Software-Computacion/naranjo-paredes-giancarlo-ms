import java.util.*
import kotlin.collections.ArrayList

fun main() {
    println("Hola")

    /*
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
    }*/
    //Arreglo estativo
    val arregloEstatico: ArrayList<Int> = arrayListOf<Int>(1, 2, 3)
    println(arregloEstatico)

    //Arreglo dinamico
    val arregloDinamico: ArrayList<Int> = arrayListOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    println(arregloDinamico)
    arregloDinamico.add(11)
    arregloDinamico.add(12)
    println(arregloDinamico)

    //Operadores -> Sirven para los arreglos estaticos y dinamicos
    //FOR EACH -> Unit
    //Iterar un arreglo
    val respuestaForEach: Unit = arregloDinamico
        .forEach { valorActual: Int ->
            println("Valor actual: ${valorActual}")
        }
    println(respuestaForEach)
    arregloEstatico
        .forEachIndexed { indice: Int, valorActual: Int ->
            println("Valor ${valorActual} Indice: ${indice}")
        }

    //MAP -> Muta el arreglo (Cambia el arreglo)
    // 1) Enviemos el nuevo valor de la iteracion
    // 2) Nos devuelve es un NUEVO ARREGLO con los valores modificados

    val respuestaMap: List<Double> = arregloDinamico
        .map { valorActual: Int ->
            return@map valorActual.toDouble() + 100.00 //@ pra cambiar el arreglo
        }
    println(respuestaMap)

    val respuestaMapDos = arregloDinamico.map { it + 15 }
    /*
        .map { valorActual: Int ->
            return@map valorActual + 15
         }
     */
    println(respuestaMapDos)

    /*Filter -> FILTRAR EL ARREGLO
    * 1) Devolver una expresion (TRUE o FALSE)
    * 2) Nuevo arreglo filtrado
    */
    val respuestaFilter: List<Int> = arregloDinamico.filter { valorActual: Int ->
        val mayoresACinco: Boolean = valorActual > 5
        return@filter mayoresACinco
    }
    val respuesFilterDos = arregloDinamico.filter { it <= 5 } //froma reducida
    println(respuestaFilter)
    println(respuesFilterDos)

    //OR AND
    //OR -> ANY (Alguno cumple?)
    //AND -> ALL (Todos cumplen?)
    val respuestaAny: Boolean = arregloDinamico
        .any { valorActual: Int ->
            return@any (valorActual > 5)
        }
    println(respuestaAny) //true

    val respuestaAll: Boolean = arregloDinamico
        .all { valorActual: Int ->
            return@all (valorActual > 5)
        }
    println(respuestaAll) //false

    // REDUCE -> Valor acumulado
    // valor acumulado = 0 (Siempre 0 en lenguaje Kotlin)
    //[1, 2, 3, 4, 5] -> Sumeme todos los valores del arreglo
    // valorIteracion1 = valorEmpieza + 1 = 0 + 1 = 1 -> Iteracion 1
    // valorIteracion2 = valorIteracion1 + 2 = 1 + 2 = 3 -> Iteracion 2
    // valorIteracion3 = valorIteracion2 + 3 = 3 + 3 = 6 -> Iteracion 3
    // valorIteracion4 = valorIteracion3 + 4 = 6 + 4 = 10 -> Iteracion 4
    // valorIteracion5 = valorIteracion4 + 5 = 18 + 5 = 15 -> Iteracion 5
    val respuestaReduce: Int = arregloDinamico
        .reduce { // acumulado = 0 -> SIEMPRE EMPIEZA EN O
                acumulado: Int, valorActual: Int ->
            return@reduce (acumulado + valorActual) // -> Logica negocio
        }
    println(respuestaReduce) //78
}
main()
/*
13
abstract class NumerosJava {
    protected val numeroUno: Int
    protected val numeroDos: Int

    constructor(
        uno: Int,
        dos: Int
    ) {// Bloque codigo constructor
        this.numeroUno = uno
        this.numeroDos = dos
        println("Inicializado")
    }


}

abstract class Numeros(protected val numeroUno: Int, protected val numeroDos: Int) {
    init {
        this.numeroUno = numeroUno
        numeroUno
        this.numeroDos = numeroDos
        numeroDos
        println("Inicializado")
    }
}

class Suma(uno: Int, dos: Int) : Numeros(uno, dos) {
    init {
        this.numeroUno
        this.numeroDos
    }

    // Primer constructor
    constructor(uno: Int?, dos: Int) : this(
        if (uno == null) 0 else uno, dos
    ) {
    }

    // Segundo constructor
    constructor(uno: Int, dos: Int?) : this(
        uno, if (dos == null) 0 else dos
    ) {
    }

    // Tercer constructor
    constructor(uno: Int?, dos: Int?) : this(
        if (uno == null) 0 else uno, if (dos == null) 0 else dos
    ) {
    }

    public fun sumar(): Int {
        return numeroUno + numeroDos
    }

    companion object { // Atributos y Metodos compartidos entre la instancias
        val pi = 3.14
        fun elevarAlCuadrado(num: Int): Int {
            return num * num
        }

        val historialSumas = arrayListOf<Int>()
        fun agregarHistorial(valorNuevaSuma: Int) {
            historialSumas.add(valorNuevaSuma) s
        }

    }
}*/
