package com.pjff.androidejercicio1.componentesgraficos.recycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.pjff.androidejercicio1.R
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioGroup
import android.widget.Spinner
import com.pjff.androidejercicio1.databinding.ActivitySelectorComponenteBinding


class SelectorComponenteActivity : AppCompatActivity() {
    private lateinit var binding:ActivitySelectorComponenteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySelectorComponenteBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_selector_componente)

        setContentView(binding.root)

        //CHECKBOX
        binding.cbCreditCard.setOnCheckedChangeListener { _, isChecked ->
            Toast.makeText(this, "isChecked = $isChecked", Toast.LENGTH_SHORT).show()
        }

        //RADIOBUTTON
        binding.rgSex.setOnCheckedChangeListener { view, checkedId ->
            when(checkedId){
                R.id.rbMan -> {
                    binding.cbCreditCard.visibility = View.INVISIBLE
                }
                R.id.rbWoman -> binding.cbCreditCard.visibility = View.VISIBLE
                else -> "Desconocido"
            }

//            Toast.makeText(this, "checkedId = $idName", Toast.LENGTH_SHORT).show()
        }

        //SPINNER

        val datos = arrayListOf("México","España", "Dinamarca", "Estados Unidos","Venezuela", "Colombia","México","España", "Dinamarca", "Estados Unidos","Venezuela", "Colombia","México","España", "Dinamarca", "Estados Unidos","Venezuela", "Colombia")
        val adaptador = ArrayAdapter(this, android.R.layout.simple_spinner_item, datos)

        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinner.adapter = adaptador

        binding.spinner.onItemSelectedListener = object : OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val itemSelected = datos[position]
                Toast.makeText(this@SelectorComponenteActivity, "Item seleccionado: $itemSelected", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                Toast.makeText(this@SelectorComponenteActivity, "Nada seleccionado", Toast.LENGTH_SHORT).show()
            }
        }


        binding.btSend.setOnClickListener {
            //CHECKBOX
            val cbStatus = binding.cbCreditCard.isChecked
            //RADIOBUTTON
            val selectedRbSex =  when(binding.rgSex.checkedRadioButtonId){
                R.id.rbMan -> "H"
                R.id.rbWoman -> "M"
                else -> "Desconocido"
            }
            Toast.makeText(this, "value = $selectedRbSex", Toast.LENGTH_SHORT).show()
        }

    }
}
