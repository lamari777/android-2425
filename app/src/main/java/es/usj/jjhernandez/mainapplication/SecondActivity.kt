package es.usj.jjhernandez.mainapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import es.usj.jjhernandez.mainapplication.databinding.ActivitySecondBinding

const val EXTRA_KEY = "key"

class SecondActivity : AppCompatActivity() {

    private val view by lazy {
        ActivitySecondBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(view.root)
        view.btnResult.setOnClickListener {
            val intent = Intent()
            intent.putExtra(EXTRA_KEY, "Hola")
            setResult(RESULT_OK, intent)
            finish()

        }
    }

}