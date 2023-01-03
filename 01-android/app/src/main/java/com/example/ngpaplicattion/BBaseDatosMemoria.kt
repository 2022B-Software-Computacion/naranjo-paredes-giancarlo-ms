package com.example.ngpaplicattion

class BBaseDatosMemoria {
    //Ayuda a crear un singleton
    companion object {
        val arregloBEntrenador = arrayListOf<BEntrenador>()

        init {
            arregloBEntrenador.add(
                BEntrenador("Giancarlo", "a@a.com")
            )
            arregloBEntrenador.add(
                BEntrenador("Andres", "b@b.com")
            )

            arregloBEntrenador.add(
                BEntrenador("Carolina", "c@c.com")
            )
        }
    }
}

