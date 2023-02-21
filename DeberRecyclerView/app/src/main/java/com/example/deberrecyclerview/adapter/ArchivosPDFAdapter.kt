package com.example.deberrecyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.deberrecyclerview.ArchivoPDF
import com.example.deberrecyclerview.R

class ArchivosPDFAdapter(
    private val archivosPDF: List<ArchivoPDF>,
    private val onClickListener: (ArchivoPDF) -> Unit
) :
    RecyclerView.Adapter<ArchivosPDFViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArchivosPDFViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ArchivosPDFViewHolder(
            layoutInflater.inflate(
                R.layout.item_archivopdf,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ArchivosPDFViewHolder, position: Int) {
        val item = archivosPDF[position]
        holder.render(item, onClickListener)

    }

    override fun getItemCount(): Int {
        return archivosPDF.size
    }
}