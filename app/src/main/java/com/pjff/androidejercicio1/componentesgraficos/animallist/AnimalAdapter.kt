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

/*
Paso 4,
Vamos a heredar el activity_animal_lsi.xml -> Heredamos con (:)
* Le vamos a pasar nuestra coleccion de datos.

* Los viewHolder,son los encargados de hacer la conexion de la informacion con la
* interfaz grafica.

*El constructor lleva ()
* */

//Paso 8,Le pasamos nuestra lista de animales a nuestro adaptador ->(private val list:List<Animal>)
class AnimalAdapter(private val list:List<Animal>): RecyclerView.Adapter<AnimalViewHolder>() {
    /*Para detectar un listener en nuestro adapter y lo hacemos con una lambda
     -> , en caso de que no lo adapte se presenta null (?) y le decimos
     que puede ser opcional,unit es algo generico que significa vacio */
    var onItemSelected : ((Animal) -> Unit)? = null


    //--------------------------Paso 7---Implementamos los metodos a sobreescribir
    /*Nuestra clase animal view holder espera un view,convertimos nuestro xml en un view
    lo hacemos mediante inflate*/
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        /*Aqui creamos el diseño,el metodo from necesita un contexto,el contexto se lo sacamos del parent
        * Y para usar el LayoutInflatter necesitamos el inflate */
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_animal, parent, false)
        //Paso 10, la funcion debe retornar AnimalViewHolder
        return AnimalViewHolder(view)
    }
    // Paso 9 ,Le pasamos el tamaño de nuestra lista para que los pinte, con list.size.
    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        //Conectamos en el diseño y le pasamos nuestro OnItemSelected
        holder.render(list[position],onItemSelected)
    }
}

/*Paso 5, Este es el viewholder que espera nuestro adaptador y hereda con los (:), también el ide
lo hace de forma autmatica*/

class AnimalViewHolder(view: View) : RecyclerView.ViewHolder(view){
   //Por cada componente gráfico debeo tener una variable

    val root = view.findViewById<ConstraintLayout>(R.id.root)
    val ivAnimal = view.findViewById<ImageView>(R.id.ivAnimal)
    val tvAnimalName = view.findViewById<TextView>(R.id.tvAnimalName)

    /*Le pasamos nuestro onItemSeleted
    Unit se ocupa cuando debe regresar algo, es vacío*/
    fun render(animal: Animal,onItemSelected : ((Animal) -> Unit)?) {
        tvAnimalName.text = animal.name
        root.setOnClickListener {
            //mandamos el animal seleccionado
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
