package es.usj.jjhernandez.mainapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import es.usj.jjhernandez.mainapplication.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.BufferedInputStream
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

const val TAG = "LOG"
const val REQUEST_CODE = 999

data class HealthCheck(val status: String)

class MainActivity : AppCompatActivity() {

    private val view by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private val scope by lazy {
        CoroutineScope(Dispatchers.IO)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(view.root)


        view.btnRequest.setOnClickListener {
            scope.launch {
                val content = request()
                val obj = Gson().fromJson<HealthCheck>(content, HealthCheck::class.java)
                withContext(Dispatchers.Main) {
                    view.tvContent.text = obj.status
                }
            }
        }
    }

    private fun request() : String {
        var connection: HttpURLConnection? = null
        var inputStream: BufferedInputStream? = null
        try {
            val url = URL("http://10.0.2.2:8080/health-check")
            connection = url.openConnection() as HttpURLConnection
            inputStream = BufferedInputStream(connection.inputStream)
            return readContent(inputStream)
        } finally {
            inputStream?.close()
            connection?.disconnect()
        }
    }

    private fun readContent(inputStream: InputStream) : String {
        val reader = BufferedReader(InputStreamReader(inputStream))
        val stringBuilder = StringBuilder()
        var line: String
        while ((reader.readLine().also { line = it }) != null) {
            stringBuilder.append(line).append('\n')
        }
        return stringBuilder.toString()
    }
}