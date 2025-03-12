package es.usj.jjhernandez.mainapplication

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import es.usj.jjhernandez.mainapplication.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private val view by lazy {
        ActivitySecondBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(view.root)


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