package es.usj.jjhernandez.mainapplication

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import es.usj.jjhernandez.mainapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val view by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(view.root)
        view.tvHelloWorld.visibility = View.GONE
        view.tvHelloWorld.text = getString(R.string.helloworld)
        view.swComponents.isChecked = false
        view.swComponents.setOnCheckedChangeListener { _, isChecked ->
            val visibility = if (isChecked) View.VISIBLE else View.GONE
            view.tvHelloWorld.visibility = visibility
        }
    }
}
