package com.pjff.androidejercicio1.fragments.params

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pjff.androidejercicio1.R
import com.pjff.androidejercicio1.activities.FirstActivity
import com.pjff.androidejercicio1.componentesgraficos.animallist.Animal
import com.pjff.androidejercicio1.databinding.FragmentReceiveParamsBinding

class ReceiveParamsFragment : Fragment(R.layout.fragment_receive_params) {
    private lateinit var binding :FragmentReceiveParamsBinding

    private var name : String? = ""
    private var animal : Animal? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Los fragments tienen argumentos
        //recupero mis argumentos, let es para que vea que no lleva cero
        arguments?.let {
            name = it.getString("ARG_NAME")
            animal = it.getSerializable("ARG_ANIMAL") as Animal
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentReceiveParamsBinding.bind(view)
        //Mostramos la informacion
        binding.tvName.text = name
        binding.tvAnimalName.text = animal?.name
        //Mandamos a llamar nuestra actividad
        binding.btSendActivity.setOnClickListener {
            val intent = Intent(requireContext(), FirstActivity::class.java).apply {
                putExtra("EXTRA_NAME", name)
            }
            startActivity(intent)
        }

    }

    companion object {

        @JvmStatic
        //le pasamos nuestros parametros ,el objeto ya lo tenemos serializable
        fun newInstance(name : String, animal : Animal) =
            //Le pasamos los atributos con apply
            ReceiveParamsFragment().apply {
                arguments = Bundle().apply {
                    //Arg nuestros argumentos
                    putString("ARG_NAME", name)
                    putSerializable("ARG_ANIMAL", animal)
                }
            }
    }
}