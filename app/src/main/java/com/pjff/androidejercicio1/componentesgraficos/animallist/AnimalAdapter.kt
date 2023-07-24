package com.pjff.androidejercicio1.componentesgraficos.animallist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.pjff.androidejercicio1.R
import com.squareup.picasso.Picasso

/*Heredamos con (:)
* Le vamos a pasar nuestra coleccion de datos
* Con ( :) se hereda
* Los viewHolder,encargados de hacer la conexion de la informacion con la
* interfaz grafica.
*El constructor lleva ()
* */

//Le pasamos nuestra lista de animales < nuestro adaptador
class AnimalAdapter(private val list:List<Animal>): RecyclerView.Adapter<AnimalViewHolder>() {
    /*Para detectar un listener en nuestro adapter y lo hacemos una lambda
     -> , en caso de que no lo adapte se presenta null (?) y le decimos
     que puede ser opcional */
    var onItemSelected : ((Animal) -> Unit)? = null





    /*Nuestra clase animal view holder espera un view,convertimos nuestro xml en un view
    lo hacemos mediante inflate*/
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        /*El metodo from necesita un contexto,el contexto se lo sacamos del parent
        * Y para usar el LayoutInflatter necesitamos el inflate */
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_animal, parent, false)
        return AnimalViewHolder(view)
    }
    //Le pasamos el tamaño de nuestra lista para que los pinte
    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        //Conectamos en el diseño y le pasamos nuestro OnItemSelected
        holder.render(list[position],onItemSelected)
    }
}

//Este es el viewhOlder que espera nuestro adaptadDOR
class AnimalViewHolder(view: View) : RecyclerView.ViewHolder(view){
   //Por cada componente grafico debeo tener una variable

    val root = view.findViewById<ConstraintLayout>(R.id.root)
    val ivAnimal = view.findViewById<ImageView>(R.id.ivAnimal)
    val tvAnimalName = view.findViewById<TextView>(R.id.tvAnimalName)
    //Le pasamos nuestro onItemSeleted
    //Unit se ocupa cuando debe regresar algo, es vacío
    fun render(animal: Animal,onItemSelected : ((Animal) -> Unit)?) {
        tvAnimalName.text = animal.name
        root.setOnClickListener {
            onItemSelected?.invoke(animal)
        }

        Picasso.get().load(animal.url)
        //Cuando haya un error cargame esto
            .error(R.drawable.ic_people)
            .placeholder(R.drawable.img_android)
            //En donde lo vas a cargar
            .into(ivAnimal)

    }
}
