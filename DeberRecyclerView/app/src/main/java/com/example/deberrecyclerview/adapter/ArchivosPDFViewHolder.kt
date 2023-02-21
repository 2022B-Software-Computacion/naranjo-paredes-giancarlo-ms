package com.example.deberrecyclerview.adapter

import  android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.deberrecyclerview.ArchivoPDF
import com.example.deberrecyclerview.R
import com.example.deberrecyclerview.databinding.ItemArchivopdfBinding
import com.squareup.picasso.Picasso

class ArchivosPDFViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val binding = ItemArchivopdfBinding.bind(view)

    fun render(archivoPDFModel: ArchivoPDF, onClickListener: (ArchivoPDF) -> Unit) {
        binding.tvArchivoPDFNombre.text = archivoPDFModel.nombreArchivo
        binding.tvArchivoPDFFechaCreacion.text = archivoPDFModel.fechaCreacion
        binding.tvArchivoPDFNumeroPaginas.text = archivoPDFModel.numeroDePaginasPDF.toString()
        Picasso.get().load(archivoPDFModel.srcImagen).error(R.mipmap.ic_launcher_round)
            .into(binding.ivArchivoPDF)

        itemView.setOnClickListener {
            onClickListener(archivoPDFModel)
        }

    }
}