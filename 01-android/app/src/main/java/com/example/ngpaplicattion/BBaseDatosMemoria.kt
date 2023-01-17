package com.example.ngpaplicattion

class BBaseDatosMemoria {
    //Ayuda a crear un singleton
    companion object {
        val arregloBEntrenador = arrayListOf<BEntrenador>()

        init {
            arregloBEntrenador.add(
                BEntrenador(1, "Giancarlo", "a@a.com")
            )
            arregloBEntrenador.add(
                BEntrenador(2, "Andres", "b@b.com")
            )

            arregloBEntrenador.add(
                BEntrenador(3, "Carolina", "c@c.com")
            )
        }
    }
}

