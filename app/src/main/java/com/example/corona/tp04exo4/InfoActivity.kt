package com.example.corona.tp04exo4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.corona.tp04exo4.Data.Module
import com.example.corona.tp04exo4.Data.Prof
import com.example.corona.tp04exo4.Data.Seance

class InfoActivity : AppCompatActivity() {
    lateinit var module: Module
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        module = getIntent().getExtras()?.get("module") as Module

        val fragment : ModuleFragment = ModuleFragment()

        val b : Bundle = Bundle()
        b.putSerializable("module",module)
        fragment.arguments = b

        supportFragmentManager.beginTransaction().replace(R.id.infoFragment,fragment).commit()
    }
    fun getProf(){
        val fragment : ProfFragment = ProfFragment()
        val b : Bundle = Bundle()
        b.putSerializable("prof",module.profModule)
        fragment.arguments = b
        supportFragmentManager.beginTransaction().replace(R.id.infoFragment,fragment).commit()
    }
}
