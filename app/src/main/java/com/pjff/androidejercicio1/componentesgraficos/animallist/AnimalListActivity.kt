package com.pjff.androidejercicio1.componentesgraficos.animallist
//02-6/junio/2023

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pjff.androidejercicio1.R

class AnimalListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animal_list)

        //Paso 17 , Le mandamos nuestra list, la referencia de nuestro componente Recycker view con su id
        val list = findViewById<RecyclerView>(R.id.animalList)

        /*Paso 3, Hacemos nuestra lista de nuestro adaptador
        Haremos una instancia de esta clase tipo animal */

        val animalList = listOf(
            Animal("Leon", "Amarillo","https://encrypted-tbn0.gstatic.com/" +
                    "images?q=tbn:ANd9GcTl-hrk27A1NgigMIGXSO1hgUq-l" +
                    "_wrKSMP_pudWt6NsNyeW4kykmuewLw7BLMKPmCcfvs&usqp=CAU"),
            Animal("Jirafa", "Amarillo","https://encrypted-tbn0.gstatic.com/" +
                    "images?q=tbn:ANd9GcStUgJf7okD0O_2XGxP8cR6NB0Ba7vOzt4w5g&s"),
            Animal("Cocodrilo", "Verde","https://encrypted-tbn0.gstatic.com/" +
                    "images?q=tbn:ANd9GcRM1-2B5wjpFuyYrSCslCd0do7Do5-wcCwnOQ&usqp=CAU"),
            Animal("Colibri", "Azul","https://encrypted-tbn0.gstatic.com/" +
                    "images?q=tbn:ANd9GcRM1-2B5wjpFuyYrSCslCd0do7Do5-wcCwnOQ&usqp=CAU"),
            Animal("Orca", "Negro","https://encrypted-tbn0.gstatic.com/" +
                    "images?q=tbn:ANd9GcRM1-2B5wjpFuyYrSCslCd0do7Do5-wcCwnOQ&usqp=CAU"),
            Animal("Oso", "Blanco","https://encrypted-tbn0.gstatic.com/" +
                    "images?q=tbn:ANd9GcRM1-2B5wjpFuyYrSCslCd0do7Do5-wcCwnOQ&usqp=CAU")
        )

        /*Paso 16 ,Pasamos una instancia de nuestro animal al adapter*/
        val adapter = AnimalAdapter(animalList)

        //Paso 18,Le pasamos nuestro animal seleccionado
        adapter.onItemSelected = { animal ->
            Toast.makeText(this, "${animal.name}", Toast.LENGTH_SHORT).show()
        }
        list.adapter = adapter

        /*Paso 19,Para que pinte nuestros datos, obtenemos el contexto con (this) ,por default
         esta de forma vertical*/
        list.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        //list.layoutManager = GridLayoutManager(this, 2)
    }
}
