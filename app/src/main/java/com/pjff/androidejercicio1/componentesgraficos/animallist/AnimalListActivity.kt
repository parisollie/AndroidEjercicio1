package com.pjff.androidejercicio1.componentesgraficos.animallist
//02-6/junio/2023

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
            Animal("Leon", "Amarillo"),
            Animal("Jirafa", "Amarillo"),
            Animal("Cocodrilo", "Verde"),
            Animal("Colibri", "Azul"),
            Animal("Orca", "Negro"),
            Animal("Oso", "Blanco")
        )

        /*Pasamos una instancia de nuestro animal adapter*/
        val adapter = AnimalAdapter(animalList)

       /* adapter.onItemSelected = { animal ->
            Toast.makeText(this, "${animal.name}", Toast.LENGTH_SHORT).show()
        }*/
        list.adapter = adapter
        list.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        //list.layoutManager = GridLayoutManager(this, 2)

    }


}
