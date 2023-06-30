package com.pjff.androidejercicio1.componentesgraficos.recycleview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pjff.androidejercicio1.R

class TelefonoAdapter(private var list: List<Person>) : RecyclerView.Adapter<TelefonoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TelefonoViewHolder {
        return TelefonoViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_person, parent, false))
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: TelefonoViewHolder, position: Int) {
        holder.render(list[position])
    }



}

class TelefonoViewHolder(view: View) : RecyclerView.ViewHolder(view){

    val tvTEL = view.findViewById<TextView>(R.id.tvTel)

    fun render(telefono: Person) {
        tvTEL.text = telefono.name
    }
}