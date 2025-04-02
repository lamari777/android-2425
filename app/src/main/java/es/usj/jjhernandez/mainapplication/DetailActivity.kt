package es.usj.jjhernandez.mainapplication

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail)
        val position = intent.getStringExtra("position")?.toInt() ?: 0
        val tv = findViewById<TextView>(R.id.tvItem)
        tv.text = ItemsDataSource.getItemByPosition(position).name
        Toast.makeText(this, "Item: ${ItemsDataSource.getItemByPosition(position)}", Toast.LENGTH_SHORT).show()
    }
}