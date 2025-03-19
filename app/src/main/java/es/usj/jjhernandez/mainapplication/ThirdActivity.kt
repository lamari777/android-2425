package es.usj.jjhernandez.mainapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import es.usj.jjhernandez.mainapplication.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {

    private val view by lazy {
        ActivityThirdBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(view.root)


        val companyId = intent.extras?.get(COMPANY_ID_KEY).toString() ?: "Not received"
        view.tvCompanyId.text = companyId

        view.btnCall.setOnClickListener {  }
        view.btnOpen.setOnClickListener {  }
        view.btnSend.setOnClickListener {  }
    }
}