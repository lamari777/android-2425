package es.usj.jjhernandez.mainapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
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
        val adapter = RecyclerViewAdapter()
        view.rvCountries.adapter = adapter
        view.rvCountries.layoutManager = LinearLayoutManager(this)
        adapter.submitList(items)
        view.rvCountries.adapter?.notifyDataSetChanged()
    }
}

class CustomAdapter(var items: List<Item>) : BaseAdapter() {

    class CustomAdapterViewHolder {
        lateinit var txt1 : TextView
        lateinit var txt2 : TextView
    }

    fun add(item : Item) {
        items += item
    }

    fun remove(item : Item) {
        items -= item
    }

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
        var holderView = convertView
        if(holderView == null) {
            holderView = LayoutInflater.from(parent?.context!!).inflate(R.layout.single_item_layout, parent, false)
            val viewHolder = CustomAdapterViewHolder()
            viewHolder.txt1 = holderView.findViewById(R.id.txt_1)
            viewHolder.txt2 = holderView.findViewById(R.id.txt_2)
            holderView.tag = viewHolder
        }
        val item = getItem(position)
        val viewHolder = holderView?.tag as CustomAdapterViewHolder
        viewHolder.txt1.text = item.name
        viewHolder.txt2.text = item.surname
        return holderView
    }

}

data class Item(var name: String, var surname: String) {

    override fun toString(): String {
        return "$name $surname"
    }
}