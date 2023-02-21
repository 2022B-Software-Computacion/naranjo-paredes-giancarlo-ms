package com.example.deberrecyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.deberrecyclerview.Documentos
import com.example.deberrecyclerview.R

class DocumentosAdapter(
    private val documentos: List<Documentos>,
    private val onClickListener: (Documentos) -> Unit
) :
    RecyclerView.Adapter<DocumentosViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DocumentosViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return DocumentosViewHolder(
            layoutInflater.inflate(
                R.layout.item_documento,
                parent,
                false
            )
        )
    }


    override fun onBindViewHolder(holder: DocumentosViewHolder, position: Int) {
        val item = documentos[position]
        holder.render(item, onClickListener)

    }

    override fun getItemCount(): Int {
        return documentos.size
    }
}