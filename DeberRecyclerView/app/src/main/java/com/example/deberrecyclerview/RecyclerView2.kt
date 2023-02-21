package com.example.deberrecyclerview

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.deberrecyclerview.adapter.DocumentosAdapter
import com.google.android.material.bottomnavigation.BottomNavigationView

@Suppress("DEPRECATION")
class RecyclerView2 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view2)
        initRecyclerView()

        //Llamar al icono de documentos para mostrar el fragmento
        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        /*
        bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_documentos -> {
                    startActivity(Intent(this, RecyclerView2::class.java))
                    true

                }
                else -> false
            }
        }*/
        val menu = bottomNavigation.menu
        val itemInicio = menu.findItem(R.id.menu_inicio)
        itemInicio.setOnMenuItemClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            true
        }
    }

    private fun initRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerDocumentos)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val decoration = DividerItemDecoration(this, LinearLayoutManager(this).orientation)

        recyclerView.adapter = DocumentosAdapter(DocumentosProvider.listaDocumentos) { documentos ->
            onItemSelected(documentos)
        }
        recyclerView.addItemDecoration(decoration)
    }

    fun onItemSelected(documentos: Documentos) {
        Toast.makeText(
            this,
            documentos.nombreDcumento,
            Toast.LENGTH_SHORT
        ).show()
    }

}

