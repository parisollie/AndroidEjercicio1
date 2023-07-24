package com.pjff.androidejercicio1.activities

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import com.pjff.androidejercicio1.R
import com.pjff.androidejercicio1.componentesgraficos.animallist.Animal

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        //23-Junio-2023agregar la flechita de arriba <-
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //Recibimos,usando la forma corta
        val name = intent.getStringExtra("EXTRA_NAME")
        val lastName = intent.getStringExtra("EXTRA_LASTNAME")
        val age = intent.getIntExtra("EXTRA_AGE", 0)
        val dir = intent.getStringExtra("EXTRA_DIR")
        val tel = intent.getIntExtra("EXTRA_TEL", 0)
        val sex = intent.getStringExtra("EXTRA_SEX")

        //6/junio/2023
        val animal = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getSerializableExtra("EXTRA_ANIMAL", Animal::class.java)
        } else {
            //Si es menor, ocupa el metodo anterior
            intent.getSerializableExtra("EXTRA_ANIMAL") as Animal
        }

        //Despliegamos la información
        val tvName = findViewById<TextView>(R.id.tvName)
        val tvLastname = findViewById<TextView>(R.id.tvLastname)
        val tvAge = findViewById<TextView>(R.id.tvAge)
        val tvDir = findViewById<TextView>(R.id.tvDir)
        val tvTel = findViewById<TextView>(R.id.tvTel)
        val tvSex = findViewById<TextView>(R.id.tvSexo)

        //6//junio/2023
        tvName.text = animal?.name

        //Asignamos los valores
        tvName.text = name
        tvLastname.text = lastName
        //Concatenamos los valores para que los tóme
        //tvAge.text = "${age}"
        tvAge.text = age.toString()
        tvDir.text = dir
        tvTel.text = tel.toString()
        tvSex.text = sex

        val btBack = findViewById<Button>(R.id.btBack)

        btBack.setOnClickListener {
            val returnIntent = Intent().apply {
                putExtra("EXTRA_IS_OK", true)
            }
            //Set result regresar información
            setResult(RESULT_OK, returnIntent)
            finish()
        }

    }

    //Metodo para manejar los clciks de <-
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                val returnIntent = Intent().apply {
                    putExtra("EXTRA_IS_OK", true)
                    //23-Junio-Lo usamos para cerrar ,la actividad
                    putExtra("EXTRA_IS_ACTIVITY_BACK", true)
                }
                //Set result regresar información
                setResult(RESULT_OK, returnIntent)
                onBackPressedDispatcher.onBackPressed()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}