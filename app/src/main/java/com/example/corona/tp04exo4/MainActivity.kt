package com.example.corona.tp04exo4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.content.res.Configuration
import android.widget.ArrayAdapter
import com.example.corona.tp04exo4.Data.Module
import com.example.corona.tp04exo4.Data.Prof
import com.example.corona.tp04exo4.Data.Seance
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    lateinit var listeSeance : ArrayList<Seance>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val prof1 : Prof = Prof("Mostfaie","Amine","40","Homme")
        val prof2 : Prof = Prof("Koudil","Mouloud","50","Homme")
        val prof3 : Prof = Prof("Cherrid","Imane","52","Femme")
        val module1 : Module = Module("IGL","120",prof1)
        val module2 : Module = Module("ARCHI2","60",prof2)
        val module3 : Module = Module("COMP","90",prof3)


        listeSeance = arrayListOf(Seance("1",module1),Seance("2",module2),Seance("3",module3))
        val numeroSeance : ArrayList<String> = ArrayList()
            for (i in listeSeance){
            numeroSeance.add("Seance ${i.number}")
        }

        val adptee = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            numeroSeance

        )
        mListView.adapter = adptee
        mListView.setOnItemClickListener { adapterView, view, i, l ->
            val intent = Intent(this, InfoActivity::class.java).apply {
                putExtra("module",listeSeance.get(i).module)
            }
            startActivity(intent)
        }

    }



    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)

        // Checks the orientation of the screen
        if (newConfig.orientation === Configuration.ORIENTATION_LANDSCAPE) {
            val intent = Intent(this, MainLandscapeActivity::class.java)
            startActivity(intent)
        }
    }
}
