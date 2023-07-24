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

        //Le mandamos nuestra list
        val list = findViewById<RecyclerView>(R.id.animalList)

        /*Hacemos nuestra lista de nuestro adaptador
        Haremos una instancia*/

        val animalList = listOf(
            Animal("Leon", "Amarillo","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRM1-2B5wjpFuyYrSCslCd0do7Do5-wcCwnOQ&usqp=CAU"),
            Animal("Jirafa", "Amarillo","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRM1-2B5wjpFuyYrSCslCd0do7Do5-wcCwnOQ&usqp=CAU"),
            Animal("Cocodrilo", "Verde","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRM1-2B5wjpFuyYrSCslCd0do7Do5-wcCwnOQ&usqp=CAU"),
            Animal("Colibri", "Azul","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRM1-2B5wjpFuyYrSCslCd0do7Do5-wcCwnOQ&usqp=CAU"),
            Animal("Orca", "Negro","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRM1-2B5wjpFuyYrSCslCd0do7Do5-wcCwnOQ&usqp=CAU"),
            Animal("Oso", "Blanco","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRM1-2B5wjpFuyYrSCslCd0do7Do5-wcCwnOQ&usqp=CAU")
        )

        /*Pasamos una instancia de nuestro animal adapter*/
        val adapter = AnimalAdapter(animalList)
        //Le pasamos nuestro animal seleccionado
        adapter.onItemSelected = { animal ->
            Toast.makeText(this, "${animal.name}", Toast.LENGTH_SHORT).show()
        }
        list.adapter = adapter
        list.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        //list.layoutManager = GridLayoutManager(this, 2)

    }


}
