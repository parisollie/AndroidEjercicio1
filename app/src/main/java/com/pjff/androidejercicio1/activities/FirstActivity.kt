package com.pjff.androidejercicio1.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.pjff.androidejercicio1.R
import com.pjff.androidejercicio1.componentesgraficos.animallist.Animal

class FirstActivity : AppCompatActivity() {

    private val register = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->

        if (result.resultCode == RESULT_OK){

            if (result.data?.getBooleanExtra("EXTRA_IS_ACTIVITY_BACK", false) == true){
                onBackPressedDispatcher.onBackPressed()
            }else{
                Toast.makeText(this, "resultCode = ${result.resultCode} EXTRA_IS_OK = ${result.data?.getBooleanExtra("EXTRA_IS_OK", false)}", Toast.LENGTH_LONG).show()
            }
            Toast.makeText(this, "resultCode = ${result.resultCode} EXTRA_IS_OK = ${result.data?.getBooleanExtra("EXTRA_IS_OK", false)}", Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(this, "CANCELLED", Toast.LENGTH_LONG).show()
        }
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        //Instancia de nuestro botón
        val btCall = findViewById<Button>(R.id.btCall)

        btCall.setOnClickListener{
            //6/junio/2023
            //Pasamos este activity a otro
            val animal = Animal("Leon", "Amarillo","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRM1-2B5wjpFuyYrSCslCd0do7Do5-wcCwnOQ&usqp=CAU")

            val secondIntent = Intent(this, SecondActivity::class.java).apply {
                putExtra("EXTRA_NAME","Paul")
                putExtra("EXTRA_LASTNAME","Felix Flores")
                putExtra("EXTRA_AGE",25)
                putExtra("EXTRA_DIR","Aldea de la arena")
                putExtra("EXTRA_TEL",12345678)
                putExtra("EXTRA_SEX","M")
                //6/junio/2023
                putExtra("EXTRA_ANIMAL", animal)
            }
            // startActivity(secondIntent)
            register.launch(secondIntent)
        }
    }
}