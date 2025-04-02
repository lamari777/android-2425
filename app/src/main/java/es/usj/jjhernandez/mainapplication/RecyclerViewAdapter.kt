package es.usj.jjhernandez.mainapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView


class RecyclerViewAdapter : ListAdapter<Item, RecyclerViewAdapter.RVAViewHolder>(DiffCallback()) {

    class RVAViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txt1: TextView = itemView.findViewById(R.id.txt_1)
        val txt2: TextView = itemView.findViewById(R.id.txt_2)
    }

    class DiffCallback : DiffUtil.ItemCallback<Item>() {
        override fun areItemsTheSame(oldItem: Item, newItem: Item) = oldItem == newItem
        override fun areContentsTheSame(oldItem: Item, newItem: Item) = oldItem.toString() == newItem.toString()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RVAViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.single_item_layout, parent, false)
        return RVAViewHolder(view)
    }

    override fun onBindViewHolder(holder: RVAViewHolder, position: Int) {
        holder.txt1.text = getItem(position).name
        holder.txt2.text = getItem(position).surname
        holder.itemView.setOnClickListener {
            val elementToRemove = getItem(position)
            Toast.makeText(holder.itemView.context, "Item $elementToRemove clicked", Toast.LENGTH_SHORT).show()
        }
    }
}
