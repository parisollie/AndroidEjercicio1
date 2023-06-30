package com.pjff.androidejercicio1.activities

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.pjff.androidejercicio1.R

class IntentImplicitoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_implicito)

        /*Creamos una variable de tipo botón y mándamos hacer la referencia al botón
        y al id que le pusimos */

        val btSend = findViewById<Button>(R.id.btSend)

        //Botón para la url
        val btUrl = findViewById<Button>(R.id.btUrl)

        btSend.setOnClickListener{
            //Creamos un intent implicíto en nuestro método,declaramos nuestraccion
            val emailIntent = Intent (Intent.ACTION_SENDTO).apply {
                data = Uri.parse( "mailto:")
                putExtra(Intent.EXTRA_SUBJECT, "Aviso urgente")
                putExtra(Intent.EXTRA_TEXT, "Esto es una prueba para evitar correo mediante in intnet implicito")
            }

            startActivity(Intent.createChooser(emailIntent,"Enviar email"))
        }

        btUrl.setOnClickListener{
            //Creamos un intent implícito en nuestro método,declaramos nuestra acción
            val urlIntent = Intent (Intent.ACTION_VIEW, Uri.parse("https://www.last.fm/es/home"))
            startActivity(urlIntent)
        }
    }
}