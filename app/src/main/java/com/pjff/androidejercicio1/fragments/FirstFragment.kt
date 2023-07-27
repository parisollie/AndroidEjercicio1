package com.pjff.androidejercicio1.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pjff.androidejercicio1.R
import com.pjff.androidejercicio1.databinding.FragmentFirstBinding

//Le pasamos al Fragment lo que necesita Fragment()
class FirstFragment : Fragment(R.layout.fragment_first) {

    //Para llamar a nuestro primer fragmento
    private lateinit var binding: FragmentFirstBinding
   //Ya nos devuelve el view que necesitamos
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Inicinializamos nuestro fragment
        binding = FragmentFirstBinding.bind(view)
        //Accedenis a loscomponentes,setOnlinetesner cuando el usario da tap
        binding.btNextFragment.setOnClickListener {
           //Aqui depende de donde esta el contendor que debmos cambiar,en este caso es el Manager
            //Debemos tener cuidado con el replace
            parentFragmentManager.beginTransaction()
                    //Podemos jugar con View y View2
                .replace(R.id.fragmentContainerView, SecondFragment.newInstance())
                .addToBackStack("SecondFragment")
                .commit()
        }

    }

    /*override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }*/

    companion object {

        @JvmStatic
        fun newInstance() = FirstFragment()

    }
}