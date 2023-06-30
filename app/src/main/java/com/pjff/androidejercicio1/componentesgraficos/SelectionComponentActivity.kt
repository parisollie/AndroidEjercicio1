package com.pjff.androidejercicio1.componentesgraficos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.CheckBox
import android.widget.Button
import android.widget.Spinner
import android.widget.RadioGroup
import android.widget.Toast
import com.pjff.androidejercicio1.R

class SelectionComponentActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selection_component)
        /* Hacemos la referencia de nuestros componentes*/

        val cbFutas = findViewById<CheckBox>(R.id.cbFrutas)
        val cbDulces = findViewById<CheckBox>(R.id.cbDulces)

        val rgSabor= findViewById<RadioGroup>(R.id.rgSabor)
        val rgDulces = findViewById<RadioGroup>(R.id.rgCandys)

        val btSend = findViewById<Button>(R.id.btSend)


        /*CHECKBOX,cuando el usuario lo marque o lo desmarqué,
        lo hacemos con el set.
        this, hace referencia al mismo activity.
        */
        cbFutas.setOnCheckedChangeListener { _, isChecked ->
            Toast.makeText(this, "isChecked = $isChecked", Toast.LENGTH_SHORT).show()
        }

        cbDulces.setOnCheckedChangeListener { _, isChecked ->
            Toast.makeText(this, "isChecked = $isChecked", Toast.LENGTH_SHORT).show()
        }
        /***************************************************************************************/
        //RADIOBUTTON

        //setOnCheckedChangeListener,se usa cuando cambia de estado.
        rgSabor.setOnCheckedChangeListener { view, checkedId ->
            when (checkedId) {
                R.id.rbDulces-> {
                    cbFutas.visibility = View.INVISIBLE
                }
                R.id.rbAgrias -> cbFutas.visibility = View.VISIBLE
                else -> "Desconocido"
            }

        //Toast.makeText(this, "checkedId = $idName", Toast.LENGTH_SHORT).show()
        }

        //RADIOBUTTON-2
        rgDulces.setOnCheckedChangeListener { view, checkedId ->
            when (checkedId) {
                R.id.rbPicositos-> {
                    //con el visibility le decimos que oculte el checkbox.
                    cbDulces.visibility = View.INVISIBLE
                }
                R.id.rbAmargos -> cbDulces.visibility = View.VISIBLE
                else -> "Desconocido"
            }

            //Toast.makeText(this, "checkedId = $idName", Toast.LENGTH_SHORT).show()
        }

        /***************************************************************************************/
        //SPINNER
        //Definimos nuestra coleccion de datos y agregamos nuestros elemento.
        //Hacemos la referencia de mis spinners.
        val spinner = findViewById<Spinner>(R.id.spinner)
        val datos = arrayListOf(
            "Uva",
            "Manzana",
            "Cereza",
            "Mango",
            "Platano",
            "Guayaba",
        )
        //La colección de datos se la debemos pasar a nuestro adaptador
        //y referenciamos nuestro componente con this  y le pasamos nuestra coleccion de datos
        val adaptador = ArrayAdapter(this, android.R.layout.simple_spinner_item, datos)
        //aquí esta como la animación
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adaptador
        /*Para tener el elemento seleccionado , le mandamos nuestra implementacion
        y le sobreescribimos los metódos (onItemSelected y onNothingSelected)*/
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, view: View?, position: Int, id: Long) {
                //Para obtener mi item seleccionado
                val itemSelected = datos[position]

                Toast.makeText(
                    this@SelectionComponentActivity,
                   //Obtenemos el item
                    "Item seleccionado: $itemSelected",
                    Toast.LENGTH_SHORT
                ).show()
            }
            //Cuando nada esta seleccionado
            override fun onNothingSelected(p0: AdapterView<*>?) {
                Toast.makeText(
                    //Hacemos referencia a la actividad
                    this@SelectionComponentActivity,
                    "Nada seleccionado",
                    Toast.LENGTH_SHORT
                ).show()
            }

        }

        //SPINNER2

        val spinner2 = findViewById<Spinner>(R.id.spinner2)
        val datos2 = arrayListOf(
            "Chetos",
            "Dulce de leche",
            "Mazapán",
            "Cocada",
            "Palanqueta",
            "Pulparindo",
        )
        val adaptador2 = ArrayAdapter(this, android.R.layout.simple_spinner_item, datos2)

        adaptador2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner2.adapter = adaptador2

        spinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val itemSelected = datos2[position]

                Toast.makeText(
                    this@SelectionComponentActivity,
                    "Item seleccionado: $itemSelected",
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                Toast.makeText(
                    this@SelectionComponentActivity,
                    "Nada seleccionado",
                    Toast.LENGTH_SHORT
                ).show()
            }

        }


    }
}