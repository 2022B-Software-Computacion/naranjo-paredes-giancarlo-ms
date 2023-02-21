package com.example.deberrecyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.deberrecyclerview.adapter.ArchivosPDFAdapter
import com.example.deberrecyclerview.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()

        //Llamar al icono de documentos para mostrar el fragmento
        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        val menu = bottomNavigation.menu
        val itemDocumento = menu.findItem(R.id.menu_documentos)
        itemDocumento.setOnMenuItemClickListener {
            startActivity(Intent(this, RecyclerView2::class.java))
            true
        }
    }

    private fun initRecyclerView() {
        val manager = LinearLayoutManager(this)
        val decoration = DividerItemDecoration(this, manager.orientation)
        binding.recyclerArchivoPDF.layoutManager = manager
        binding.recyclerArchivoPDF.adapter = ArchivosPDFAdapter(
            ArchivosPDFProvider.listaDeArchivosPDF
        ) { archivoPDF -> onItemSelected(archivoPDF) }
        binding.recyclerArchivoPDF.addItemDecoration(decoration)
    }

    fun onItemSelected(archivoPDF: ArchivoPDF) {
        Toast.makeText(
            this,
            archivoPDF.nombreArchivo,
            Toast.LENGTH_SHORT
        ).show()
    }

}