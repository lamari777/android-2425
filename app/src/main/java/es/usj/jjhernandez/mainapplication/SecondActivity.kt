package es.usj.jjhernandez.mainapplication

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import es.usj.jjhernandez.mainapplication.databinding.ActivitySecondBinding
import android.content.Intent

const val COMPANY_ID_KEY = "company-id"

class SecondActivity : AppCompatActivity() {

    private val view by lazy {
        ActivitySecondBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(view.root)

        view.btnExecute.setOnClickListener {
            if(view.rbCompany.isChecked) {
                val id = view.etCompanyId.text
                val intent = Intent(this, ThirdActivity::class.java)
                intent.putExtra(COMPANY_ID_KEY, id.toString())
                startActivity(intent)
            } else {
                val intent = Intent(this, FourthActivity::class.java)
                startActivity(intent)
            }
        }

        view.rgProfile.setOnCheckedChangeListener { _, selection ->
            when(selection) {
                R.id.rbCitizen -> displayCitizen()
                else -> displayCompany()
            }
        }

        view.rbCitizen.isChecked = true
        displayCitizen()
    }

    private fun displayCitizen() {
        view.citizenLayout.visibility = View.VISIBLE
        view.companyLayout.visibility = View.GONE
    }

    private fun displayCompany() {
        view.citizenLayout.visibility = View.GONE
        view.companyLayout.visibility = View.VISIBLE
    }
}