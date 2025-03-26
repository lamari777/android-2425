package es.usj.jjhernandez.mainapplication

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import es.usj.jjhernandez.mainapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val view by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val items by lazy {
        (1 .. 1000).map { Item("Name $it", "Surname $it") }
    }

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(view.root)
        val adapter = CustomAdapter(items)
        view.ltCountries.adapter = adapter
        view.ltCountries.setOnItemClickListener{ _, _, position, _ ->
            val element_to_remove = items[position]
            // adapter.remove(element_to_remove)
            adapter.notifyDataSetChanged()
            Toast.makeText(this, "Item $element_to_remove removed", Toast.LENGTH_SHORT).show()
        }

        view.fbtnAdd.setOnClickListener {
            // adapter.add("New item: ${items.size + 1}")
            adapter.notifyDataSetChanged()
        }
    }
}

class CustomAdapter(var items: List<Item>) : BaseAdapter() {
    override fun getCount() : Int {
        return items.size
    }

    override fun getItem(position : Int) : Item {
        return items[position]
    }

    override fun getItemId(position : Int) : Long {
        return position.toLong()
    }

    override fun getView(
        position : Int,
        convertView : View?,
        parent : ViewGroup?
    ) : View {
        val item = getItem(position)
        val view = LayoutInflater.from(
            parent?.context
                ?: Activity()
        ).inflate(R.layout.single_item_layout, parent,
            false)
        val txt_1 = view.findViewById<TextView>(R.id.txt_1)
        val txt_2 = view.findViewById<TextView>(R.id.txt_2)
        txt_1.text = item.name
        txt_2.text = item.surname
        return view
    }

}

data class Item(var name: String, var surname: String) {

    override fun toString(): String {
        return "$name $surname"
    }
}