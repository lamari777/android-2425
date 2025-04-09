package es.usj.jjhernandez.mainapplication

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.component1
import androidx.activity.result.component2
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import es.usj.jjhernandez.mainapplication.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

const val TAG = "LOG"
const val REQUEST_CODE = 999

class MainActivity : AppCompatActivity() {

    private val view by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private val scope by lazy {
        CoroutineScope(Dispatchers.IO)
    }

    private val contract = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { activityResult ->
        val (_, data) = activityResult
        Toast.makeText(this, "Well done ${data?.getStringExtra(EXTRA_KEY)}", Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(view.root)
        Log.v(TAG, "onCreate called")

        view.btnNavigateToSecond.setOnClickListener {
            Thread {
                while(true) {
                    Thread.sleep(100)
                    Log.v("LOOPING", "Sleeping from thread...")
                }
            }.start()

        }

        view.btnCall.setOnClickListener {
            val task = MyAsyncTask()
            task.execute()
        }

        view.btnForResult.setOnClickListener {
            scope.launch {
                while(true) {
                    Thread.sleep(100)
                    Log.v("LOOPING", "Sleeping from coroutine...")
                    runOnUiThread {
                        view.tvContent.text = "Sleeping from coroutine..."
                    }
                    withContext(Dispatchers.Main) {
                        view.tvContent.text = "Sleeping from coroutine but with context..."
                    }
                }
            }
        }
    }

    class MyAsyncTask : AsyncTask<Unit, Unit, Unit>() {
        override fun doInBackground(vararg params: Unit?) {
            while(true) {
                Thread.sleep(100)
                Log.v("LOOPING", "Sleeping from AsyncTask...")
            }
        }
    }

    @Deprecated("This method has been deprecated in favor of using the Activity Result API\n      which brings increased type safety via an {@link ActivityResultContract} and the prebuilt\n      contracts for common intents available in\n      {@link androidx.activity.result.contract.ActivityResultContracts}, provides hooks for\n      testing, and allow receiving results in separate, testable classes independent from your\n      activity. Use\n      {@link #registerForActivityResult(ActivityResultContract, ActivityResultCallback)}\n      with the appropriate {@link ActivityResultContract} and handling the result in the\n      {@link ActivityResultCallback#onActivityResult(Object) callback}.")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
            Toast.makeText(this, "Well done ${data?.getStringExtra(EXTRA_KEY)}", Toast.LENGTH_SHORT).show()
        }
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