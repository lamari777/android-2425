package es.usj.jjhernandez.mainapplication

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import es.usj.jjhernandez.mainapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), ItemAddedObserver {

    private val adapter = CustomAdapter()

    private val view by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(view.root)
        ItemsDataSource.addListener(this)
        view.ltCountries.adapter = adapter
        view.ltCountries.setOnItemClickListener{ _, _, position, _ ->
            ItemsDataSource.removeByPosition(position)
            adapter.notifyDataSetChanged()
        }

        view.fbtnAdd.setOnClickListener {
            ItemsDataSource.addItem(Item("Name", "Surname"))
        }
    }

    override fun notifyItemAdded() {
        adapter.notifyDataSetChanged()
        Toast.makeText(this, "Item added", Toast.LENGTH_SHORT).show()
    }
}

class CustomAdapter : BaseAdapter() {

    class CustomAdapterViewHolder {
        lateinit var txt1 : TextView
        lateinit var txt2 : TextView
    }

    fun add(item : Item) {
        ItemsDataSource.addItem(item)
    }

    override fun getCount() : Int {
        return ItemsDataSource.items.size
    }

    override fun getItem(position : Int) : Item {
        return ItemsDataSource.items[position]
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