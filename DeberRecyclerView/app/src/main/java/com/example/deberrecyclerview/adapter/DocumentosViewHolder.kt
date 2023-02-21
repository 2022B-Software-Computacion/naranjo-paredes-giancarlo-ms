package com.example.deberrecyclerview.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.deberrecyclerview.ArchivoPDF
import com.example.deberrecyclerview.Documentos
import com.example.deberrecyclerview.R
import com.example.deberrecyclerview.databinding.ItemDocumentoBinding
import com.squareup.picasso.Picasso

class DocumentosViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val binding = ItemDocumentoBinding.bind(view)

    fun render(documentoModelo: Documentos, onClickListener: (Documentos) -> Unit) {
        binding.nombreDocumento.text = documentoModelo.nombreDcumento
        binding.fechacreacion.text = documentoModelo.fechaDeCreacion
        binding.numeroPaginas.text = documentoModelo.numeroDePaginas.toString()
        Picasso.get().load(documentoModelo.srcImagen).error(R.mipmap.ic_launcher_round)
            .into(binding.imageView)

    }


}