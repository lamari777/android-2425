package es.usj.jjhernandez.mainapplication

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import es.usj.jjhernandez.mainapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val items by lazy {
        (1..1000).map { "Item $it" }
    }
    private val view by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(view.root)
        view.ltCountries.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, items)
    }
}
