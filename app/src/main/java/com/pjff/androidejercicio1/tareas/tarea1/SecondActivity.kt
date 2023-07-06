package com.pjff.androidejercicio1.tareas.tarea1
//04
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import com.pjff.androidejercicio1.R

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second2)


        //Recibimos los valores
        val textview1 = findViewById<TextView>(R.id.textview1)
        val textview2 = findViewById<TextView>(R.id.textview2)

        val receivedMessage:String = intent.extras?.getString("EXTRA_MESSAGE").orEmpty()
        val receivedMessage2:String = intent.extras?.getString("EXTRA_MESSAGE2").orEmpty()

        textview1.text = receivedMessage.toString()
        textview2.text = receivedMessage2.toString()
    }
}