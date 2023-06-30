package com.pjff.androidejercicio1.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.pjff.androidejercicio1.R

//metodos que cambian de una actividad a otra
class CicloVidaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Le decimos cual será nuestra interfaz gráfica con el metodo setContent view
        //Le pasamos nuestro recurso
        setContentView(R.layout.activity_main)

        Log.e( "CICLODEVIDA",  "OnCreate")

    }

    override fun onStart() {

        super.onStart()
        //This hace referencia a nuestro activity
        //Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show()
        Log.e( "CICLODEVIDA",  "OnStart")


    }

    override fun onResume() {
        super.onResume()
        //This hace referencia a nuestro activity
        //Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show()
        Log.e( "CICLODEVIDA",  "OnResume")
    }

    override fun onPause() {
        super.onPause()
        //This hace referencia a nuestro activity
        //Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show()
        Log.e( "CICLODEVIDA",  "OnPause")
    }

    override fun onStop() {
        super.onStop()
        //This hace referencia a nuestro activity
        //Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show()
        Log.e( "CICLODEVIDA",  "OnStop")
    }

    override fun onRestart() {
        super.onRestart()
        //This hace referencia a nuestro activity
        //Toast.makeText(this, "onRestart", Toast.LENGTH_SHORT).show()
        Log.e( "CICLODEVIDA",  "OnRestart")

    }

    override fun onDestroy() {
        super.onDestroy()
        //This hace referencia a nuestro activity
        //Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show()
        Log.e( "CICLODEVIDA",  "OnDestroy")
    }


}