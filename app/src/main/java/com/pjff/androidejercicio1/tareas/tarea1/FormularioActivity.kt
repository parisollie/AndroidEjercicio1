package com.pjff.androidejercicio1.tareas.tarea1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import androidx.appcompat.app.AlertDialog
import com.pjff.androidejercicio1.R
import com.pjff.androidejercicio1.databinding.ActivityFormularioBinding
import com.pjff.androidejercicio1.databinding.ActivityMainBinding

class FormularioActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFormularioBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormularioBinding.inflate(layoutInflater)
        setContentView(binding.root)
        emailFocusListener()
        passwordFocusListener()
        phoneFocusListener()
        binding.submitButton.setOnClickListener {submitForm()}
    }

    private fun submitForm(){

        binding.emailContainer.helperText = validEmail()
        binding.passwordContainer.helperText = validPassword()
        binding.phoneContainer.helperText = validPhone()


        val validEmail = binding.emailContainer.helperText == null
        val validPassword = binding.passwordContainer.helperText == null
        val validPhone = binding.phoneContainer.helperText == null

        if(validEmail && validPassword && validPhone)
            resetForm()
        else
            invalidForm()
    }

    private fun invalidForm() {
        var message= ""
        if(binding.emailContainer.helperText != null)
            message += "\n\nEmail: " + binding.emailContainer.helperText
        if(binding.passwordContainer.helperText != null)
            message += "\n\nPhone: " + binding.passwordContainer.helperText
        if(binding.phoneContainer.helperText != null)
            message += "\n\nPhone: " + binding.phoneContainer.helperText

        AlertDialog.Builder(this)
            .setTitle("Formulario Invalido")
            .setMessage(message)
            .setPositiveButton("okay"){ _, _ ->
                //Do nothing
            }
            .show()
    }

    private fun resetForm() {
        var message = "Email: " + binding.emailEditText.text
            message += "\nPhone: " + binding.passwordEditText.text
            message += "\nPhone: " + binding.phoneEditText.text

        AlertDialog.Builder(this)
            .setTitle("Formulario validado")
            .setMessage(message)
            .setPositiveButton("okay"){ _, _ ->
                binding.emailEditText.text = null
                binding.passwordEditText.text = null
                binding.phoneEditText.text = null

                binding.emailContainer.helperText = getString(R.string.Requerido)
                binding.passwordContainer.helperText = getString(R.string.Requerido)
                binding.phoneContainer.helperText = getString(R.string.Requerido)
            }
            .show()
    }

    private fun emailFocusListener() {
        binding.emailEditText.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                binding.emailContainer.helperText = validEmail()
            }
        }
    }

    private fun validEmail(): String? {
        val emailText = binding.emailEditText.text.toString()

        if (!Patterns.EMAIL_ADDRESS.matcher(emailText).matches()) {
            return "Invalida Email agregado"
        }
        return null
    }


    private fun passwordFocusListener() {
        binding.passwordEditText.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                binding.passwordContainer.helperText = validPassword()
            }

        }
    }

    private fun validPassword(): String? {
        val passwordText = binding.passwordEditText.text.toString()

        if (passwordText.length <8 ){
            return "Son 8 letras necesarias"
        }
        if(!passwordText.matches(".*[A-Z].*".toRegex())){
            return "Debe contener una letra mayúscula"
        }
        if(!passwordText.matches(".*[a-z].*".toRegex())){
            return "Debe contener una letra minuscula"
        }
        if(!passwordText.matches(".*[@#\$%^&+=].*".toRegex())){
            return "Debe contener un carácter especial (@#\$%^&+=s)"
        }
        return null
    }


    private fun phoneFocusListener() {
        binding.phoneEditText.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                binding.phoneContainer.helperText = validPhone()
            }

        }
    }

    private fun validPhone(): String? {
        val phoneText = binding.phoneEditText.text.toString()

        if(!phoneText.matches(".*[0-9].*".toRegex())){
            return "Debe detener todos digitos"
        }

        if (phoneText.length !=10 ){
            return "El telefono debe contener 10 digitos"
        }


        return null
    }




}