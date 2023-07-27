package com.pjff.androidejercicio1.fragments.params

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pjff.androidejercicio1.R
import com.pjff.androidejercicio1.componentesgraficos.animallist.Animal
import com.pjff.androidejercicio1.databinding.FragmentSendParamsBinding


class SendParamsFragment : Fragment(R.layout.fragment_send_params) {
    private lateinit var binding: FragmentSendParamsBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSendParamsBinding.bind(view)

        binding.btSend.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .addToBackStack("ReceiveFragment")
                    //replace , ya cargo uno previamente
                .replace(R.id.fragmentContainerView,
                    ReceiveParamsFragment.newInstance(
                        "Paul Jaime Flores",
                        Animal("Orca", "Gris", "uhshs")
                    )
                )
                    //Siempre debe tener un commit para lanzarli
                .commit()
        }

    }

    companion object {

        @JvmStatic
        fun newInstance() = SendParamsFragment()
    }
}