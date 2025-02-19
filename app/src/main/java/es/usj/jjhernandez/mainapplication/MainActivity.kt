package es.usj.jjhernandez.mainapplication

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import es.usj.jjhernandez.mainapplication.databinding.ActivityMainBinding

const val TAG = "LOG"
class MainActivity : AppCompatActivity() {

    private val view by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(view.root)
        Log.v(TAG, "onCreate called")
    }

    override fun onStart() {
        super.onStart()
        Log.v(TAG, "onStart called")
    }

    override fun onResume() {
        super.onResume()
        Log.v(TAG, "onResume called")
    }

    override fun onPause() {
        super.onPause()
        Log.v(TAG, "onPause called")
    }

    override fun onStop() {
        super.onStop()
        Log.v(TAG, "onStop called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v(TAG, "onDestroy called")
    }

    override fun onRestart() {
        super.onRestart()
        Log.v(TAG, "onRestart called")
    }
}