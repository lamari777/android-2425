package es.usj.jjhernandez.mainapplication

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import es.usj.jjhernandez.mainapplication.databinding.ActivityMainBinding

import android.content.Intent

class MainActivity : AppCompatActivity() {

    private val view by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(view.root)
        view.etUsername.setOnKeyListener { v, keyCode, event ->
            validateForm()
            true
        }
        view.etPassword.setOnKeyListener { v, keyCode, event ->
            validateForm()
            true
        }
        view.btnLogin.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
        view.btnLogin.isEnabled = false
    }

    private fun validateForm() {
        view.btnLogin.isEnabled = !(view.etUsername.text.isNullOrBlank() || view.etPassword.text.isNullOrBlank())
    }
}
