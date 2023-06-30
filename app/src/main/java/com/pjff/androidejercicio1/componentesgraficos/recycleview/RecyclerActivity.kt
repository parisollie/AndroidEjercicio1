package com.pjff.androidejercicio1.componentesgraficos.recycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pjff.androidejercicio1.R

class RecyclerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)

        val rvPerson = findViewById<RecyclerView>(R.id.personList)
        val personAdapter = PersonAdapter(arrayListOf(
            Person("1", "Juan Pablo"),
            Person("2", "Julia"),
            Person("3", "Valentina"),
            Person("4", "Sylvain"),
            Person("5", "Oliver"),
            Person("1", "Ollie"),
            Person("2", "Andrew"),
            Person("3", "Nick"),
            Person("4", "Diana"),
            Person("5", "Genesis")
        ))

        val rvTel = findViewById<RecyclerView>(R.id.personListTelefono)
        val personTel = PersonAdapter(arrayListOf(
            Person("1", "178282"),
            Person("2", "182763"),
            Person("3", "293884"),
            Person("4", "398423"),
            Person("5", "387482"),
            Person("1", "384892"),
            Person("2", "387472"),
            Person("3", "938842"),
            Person("4", "837912"),
            Person("5", "2333338")
        ))

        rvTel.adapter = personTel
        rvTel.layoutManager = LinearLayoutManager(this)

        rvPerson.adapter = personAdapter
        rvPerson.layoutManager = LinearLayoutManager(this)

    }
}