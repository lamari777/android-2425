package es.usj.jjhernandez.mainapplication

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
            intent.putExtra(EXTRA_KEY, "Juanjo")
            setResult(RESULT_OK, intent)
            finish()
        }
    }

}