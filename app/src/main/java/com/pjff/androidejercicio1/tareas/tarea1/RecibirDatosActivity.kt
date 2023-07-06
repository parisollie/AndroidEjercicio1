package com.pjff.androidejercicio1.tareas.tarea1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.pjff.androidejercicio1.R

class RecibirDatosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recibir_datos)

        //23-Junio-2023agregar la flechita de arriba <-
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //Recibimos,usando la forma corta
        val name = intent.getStringExtra("EXTRA_NAME")
        val lastName = intent.getStringExtra("EXTRA_LASTNAME")
        val email = intent.getIntExtra("EXTRA_EMAIL", 0)
        val sexo = intent.getStringExtra("EXTRA_SEX")
       // val tel = intent.getIntExtra("EXTRA_TEL", 0)
        //val sex = intent.getStringExtra("EXTRA_SEX")

        //Despliegamos la información
        val tvName = findViewById<TextView>(R.id.Nombrep)
        val tvLastname = findViewById<TextView>(R.id.Apellidop)
        val tvemail = findViewById<TextView>(R.id.Emailp)
        val tvsexo = findViewById<TextView>(R.id.Sexop)
       // val tvTel = findViewById<TextView>(R.id.tvTel)
       // val tvSex = findViewById<TextView>(R.id.tvSexo)

        //Asignamos los valores
        tvName.text = name
        tvLastname.text = lastName
        tvemail.text = email.toString()
        tvsexo.text = sexo
        //Concatenamos los valores para que los tóme
        //tvAge.text = "${age}"
       /* tvAge.text = age.toString()
        tvDir.text = dir
        tvTel.text = tel.toString()
        tvSex.text = sex*/
    }
}