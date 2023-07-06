package com.pjff.androidejercicio1.tareas.tarea2

//02

import android.content.Intent
import android.icu.text.Transliterator.Position
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.get
import com.pjff.androidejercicio1.R
import com.pjff.androidejercicio1.tareas.tarea1.SecondActivity

class TareaFormularioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tarea_formulario)

        val edittext1 = findViewById<TextView>(R.id.correoTar)
        val edittext2 = findViewById<TextView>(R.id.contraseniaTar)
        val edittext3 = findViewById<TextView>(R.id.nombreTar)
        val edittext4 = findViewById<TextView>(R.id.apellidoTar)
        val edittext5 = findViewById<TextView>(R.id.MasculinoTar)
        val edittext6 = findViewById<TextView>(R.id.FemeninoTar)
        val edittext7 = findViewById<TextView>(R.id.sexoTar)



        val button1 = findViewById<Button>(R.id.botonTar)
        //Cuando se esuche el click
        button1.setOnClickListener{
            //Recibimos un string que lo obtenga lo cambiamos a un string
            val message:String = edittext1.text.toString()
            val message2:String = edittext2.text.toString()
            val message3:String = edittext3.text.toString()
            val message4:String = edittext4.text.toString()
            val message5:String = edittext5.text.toString()
            val message6:String = edittext6.text.toString()
            val message7:String = edittext7.text.toString()


            //Le decimos que vaya a nuestra segunda actividad SecondActivitys
            val sendMessage= Intent(this, RecibirDatosFormularioTareaActivity::class.java)
            //le mandamos el mensaje
            sendMessage.putExtra("EXTRA_MESSAGE",message)
            sendMessage.putExtra("EXTRA_MESSAGE2",message2)
            sendMessage.putExtra("EXTRA_MESSAGE3",message3)
            sendMessage.putExtra("EXTRA_MESSAGE4",message4)
            sendMessage.putExtra("EXTRA_MESSAGE5",message5)
            sendMessage.putExtra("EXTRA_MESSAGE6",message6)
            sendMessage.putExtra("EXTRA_MESSAGE7",message7)



            startActivity(sendMessage)
        }
    }
}