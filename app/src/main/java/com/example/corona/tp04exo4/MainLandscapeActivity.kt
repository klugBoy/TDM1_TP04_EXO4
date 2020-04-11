package com.example.corona.tp04exo4

import android.content.Intent
import android.content.res.Configuration
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.CalendarContract
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.corona.tp04exo4.Data.Module
import com.example.corona.tp04exo4.Data.Prof
import com.example.corona.tp04exo4.Data.Seance
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main_landscape.*
import me.jlurena.revolvingweekview.WeekView


class MainLandscapeActivity : AppCompatActivity() {

    lateinit var listeSeance : ArrayList<Seance>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_landscape)

        val prof1 : Prof = Prof("Mostfaie","Amine","40","Homme")
        val prof2 : Prof = Prof("Koudil","Mouloud","50","Homme")
        val prof3 : Prof = Prof("Cherrid","Imane","52","Femme")
        val module1 : Module = Module("IGL","120",prof1)
        val module2 : Module = Module("ARCHI2","60",prof2)
        val module3 : Module = Module("COMP","90",prof3)


        listeSeance = arrayListOf(Seance("1",module1), Seance("2",module2), Seance("3",module3))
        val numeroSeance : ArrayList<String> = ArrayList()
        for (i in listeSeance){
            numeroSeance.add("Seance ${i.number}")
        }

        val adptee = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            numeroSeance

        )
        listView.adapter = adptee
        listView.setOnItemClickListener { adapterView, view, i, l ->

            val fragment : ProfFragment = ProfFragment()
            val fragment2 : ModuleFragment = ModuleFragment()
            var b : Bundle = Bundle()
            b.putSerializable("prof",listeSeance.get(i).module.profModule)
            fragment.arguments = b
            b = Bundle()
            b.putSerializable("module",listeSeance.get(i).module)
            fragment2.arguments = b
            supportFragmentManager.beginTransaction().replace(R.id.mProfFragment,fragment).commit()
            supportFragmentManager.beginTransaction().replace(R.id.mModuleFragment,fragment2).commit()
        }


    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)

        // Checks the orientation of the screen
        if (newConfig.orientation === Configuration.ORIENTATION_PORTRAIT) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
