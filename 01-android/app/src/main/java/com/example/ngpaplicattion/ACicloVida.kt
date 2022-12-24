package com.example.ngpaplicattion

import android.os.Bundle
import android.os.PersistableBundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.ngpaplicattion.databinding.ActivityAcicloVidaBinding

class ACicloVida : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityAcicloVidaBinding
    var textoGlobal = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAcicloVidaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_aciclo_vida)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        mostrarSnackbar("onStart")
    }// onCreate fin de cloque de codigo

    override fun onStart() {
        super.onStart()
        mostrarSnackbar("onStart")
    }

    override fun onResume() {
        super.onResume()
        mostrarSnackbar("onResume")
    }

    override fun onRestart() {
        super.onRestart()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_aciclo_vida)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }

    fun mostrarSnackbar(texto: String) {
        textoGlobal += texto
        Snackbar.make(findViewById(R.id.cl_ciclo_vida), textoGlobal, Snackbar.LENGTH_LONG)
            .setAction("Action", null).show()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.run {
            // GUARDAR LAS VARIABLES
            // PRIMITIVOS
            putString("textoGuardado", textoGlobal)
            //putInt("numeroGuardado", numero)
        }
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val textoRecuperado: String? = savedInstanceState.getString("textoGuardado")

        if (textoRecuperado != null) {
            mostrarSnackbar(textoRecuperado)
            textoGlobal = textoRecuperado
        }
    }
}
