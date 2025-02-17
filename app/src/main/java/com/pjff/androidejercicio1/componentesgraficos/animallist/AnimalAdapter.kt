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

    /*Paso 1.0, Para detectar un listener en nuestro Adapter , lo hacemos con una lambda
    (->) , en caso de que no lo adapte se presenta null (?) y le decimos
     que puede ser opcional,unit es algo generico que significa vacio */

    var onItemSelected : ((Animal) -> Unit)? = null


    //--------------------------Paso 7-Implementamos los metodos a sobreescribir-Override---------------------------------

    /*Nuestra clase animal view holder espera un view,convertimos nuestro xml en un view
    lo hacemos mediante inflate*/
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {

        /*Paso 13,Aquí creamos el diseño,el metodo from necesita un contexto,el contexto se lo sacamos del parent
        * Y para usar el LayoutInflatter necesitamos el inflate,por lo regular siempre es false */
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_animal, parent, false)
        //Paso 10, la funcion debe retornar AnimalViewHolder
        return AnimalViewHolder(view)
    }
    // Paso 9 ,Le pasamos el tamaño de nuestra lista para que los pinte, con list.size.
    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        //Paso 14,Conectamos con en el diseño y Paso 2.0 le pasamos nuestro OnItemSelected
        holder.render(list[position],onItemSelected)
    }
}

/*Paso 5, Este es el viewholder que espera nuestro adaptador y hereda con los (:), también el IDE
lo hace de forma autmatica*/

class AnimalViewHolder(view: View) : RecyclerView.ViewHolder(view){
    //Paso 5.0,Hacemos referencia item_animal , es el primer comentario.
    val root = view.findViewById<ConstraintLayout>(R.id.root)
    //Paso 15,Por cada componente gráfico que quiero ligar debeo tener una variable.
    val ivAnimal = view.findViewById<ImageView>(R.id.ivAnimal)
    val tvAnimalName = view.findViewById<TextView>(R.id.tvAnimalName)

    /*
    Le pasamos nuestro onItemSeleted
    Unit -> se ocupa cuando debe regresar algo (es vacío), todas las funciones debe regresar algo
    */
    fun render(animal: Animal,onItemSelected : ((Animal) -> Unit)?) {
        tvAnimalName.text = animal.name
        //Paso 6.0,Cuando el usuario de click
        root.setOnClickListener {
            //mandamos el animal seleccionado, si es nulo no invocara el metodo
            onItemSelected?.invoke(animal)
        }

        Picasso.get().load(animal.url)
             //Cuando encuentre un error al cargarl la url de la foto cargame esto:
            .error(R.drawable.ic_people)
            .placeholder(R.drawable.img_android)
            //En donde lo vas a cargar en el ivAnimal
            .into(ivAnimal)
    }
}
