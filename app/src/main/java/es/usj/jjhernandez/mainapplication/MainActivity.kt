package es.usj.jjhernandez.mainapplication

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
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
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, items)
        view.ltCountries.adapter = adapter
        view.ltCountries.setOnItemClickListener { _, _, position, _ ->
            val elementToRemove = items[position]
            adapter.remove(elementToRemove)
            adapter.notifyDataSetChanged()
            Toast.makeText(this, "$elementToRemove removed", Toast.LENGTH_SHORT).show()
        }
        view.fabAdd.setOnClickListener {
            adapter.add("New Item ${items.size + 1}")
            adapter.notifyDataSetChanged()
        }
    }
}
