package com.pjff.androidejercicio1.componentesgraficos.animallist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.pjff.androidejercicio1.R

/*Heredamos con (:)
* Le vamos a pasar nuestra coleccion de datos
* Con ( :) se hereda
* Los viewHolder,encargados de hacer la conexion de la informacion con la
* interfaz grafica.
*El constructor lleva ()
* */

//Le pasamos nuestra lista de animales < nuestro adaptador
class AnimalAdapter(private val list:List<Animal>): RecyclerView.Adapter<AnimalViewHolder>() {
    /*Nuestra clase animal view holder espera un view,convertimos nuestro xml en un view
    lo hacemos mediante inflate*/
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_animal, parent, false)
        return AnimalViewHolder(view)
    }
    //Le pasamos el tamaño de nuestra lista para que los pinte
    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        //Conectamos en el diseño 
        holder.render(list[position])
    }
}

//Este es el viewhOlder que espera nuestro adaptadDOR
class AnimalViewHolder(view: View) : RecyclerView.ViewHolder(view){
   //Por cada componente grafico debeo tener una variable
    //val root = view.findViewById<ConstraintLayout>(R.id.root)

    val ivAnimal = view.findViewById<ImageView>(R.id.ivAnimal)
    val tvAnimalName = view.findViewById<TextView>(R.id.tvAnimalName)

    fun render(animal: Animal) {
        tvAnimalName.text = animal.name
        /*root.setOnClickListener {
            onItemSelected?.invoke(animal)
        }

        Picasso.get().load(animal.url)
            .error(R.drawable.ic_people)
            .placeholder(R.drawable.img_android)
            .into(ivAnimal)*/

    }
}
