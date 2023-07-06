package com.pjff.androidejercicio1.tareas.tarea1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.pjff.androidejercicio1.R
import com.pjff.androidejercicio1.activities.SecondActivity

class FormsActivity : AppCompatActivity() {
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
        setContentView(R.layout.activity_forms)

        //Instancia de nuestro botón
        val btCall = findViewById<Button>(R.id.btCallp)

        btCall.setOnClickListener{
            val secondIntent = Intent(this, SecondActivity::class.java).apply {
                putExtra("EXTRA_NAME","@+id/Nombrep")
                putExtra("EXTRA_LASTNAME","")
                putExtra("EXTRA_EMAIL","")
                putExtra("EXTRA_SEX","")
                //putExtra("EXTRA_TEL",12345678)
                //putExtra("EXTRA_SEX","M")
            }
            // startActivity(secondIntent)
            register.launch(secondIntent)
        }
    }
}