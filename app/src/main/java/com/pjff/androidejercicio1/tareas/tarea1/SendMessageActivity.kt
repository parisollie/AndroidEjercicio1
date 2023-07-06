package com.pjff.androidejercicio1.tareas.tarea1

//02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.pjff.androidejercicio1.R

class SendMessageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_send_message)

        val edittext1 = findViewById<TextView>(R.id.edittext1)
        val edittext2 = findViewById<TextView>(R.id.edittext2)

        val button1 = findViewById<Button>(R.id.button1)
        //Cuando se esuche el click
        button1.setOnClickListener{
            //Recibimos un string que lo obtenga lo cambiamos a un string
            val message:String = edittext1.text.toString()
            val message2:String = edittext2.text.toString()


            //Le decimos que vaya a nuestra segunda actividad SecondActivitys
            val sendMessage= Intent(this,SecondActivity::class.java)
            //le mandamos el mensaje
            sendMessage.putExtra("EXTRA_MESSAGE",message)
            sendMessage.putExtra("EXTRA_MESSAGE2",message2)
            startActivity(sendMessage)
        }
    }
}