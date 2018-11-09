package com.nikhilz.sam.ui

import android.os.Bundle
import android.widget.AdapterView.OnItemClickListener
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.nikhilz.empire.Castle
import com.nikhilz.empire.Kingdom
import com.nikhilz.sam.R
import com.nikhilz.sam.TypeCast
import com.nikhilz.sam.adapter.AutoCompleteAdapter
import com.nikhilz.sam.model.AutoCompleteModel
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast


class MainActivity : AppCompatActivity() {

    var model = MainAndroidViewModel()

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                message.setText(R.string.title_home)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                message.setText(R.string.title_dashboard)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                message.setText(R.string.title_notifications)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        autoCompleteTextView.onItemClickListener =
                OnItemClickListener { parent, view, position, l ->

                    val item = parent.getItemAtPosition(position)
                    if (item is AutoCompleteModel) {
                        val student = item
                        Toast.makeText(
                            this,
                            " ${student.subtitle}",
                            Toast.LENGTH_LONG
                        ).show()

                    }
                }

        button.setOnClickListener {
            //  model.remember(autoCompleteTextView.text.toString())
            val time = System.currentTimeMillis()
            Castle.kingdom().add(Kingdom.PRINCESS, "MASTER $time", 1000)
            Castle.kingdom().add(Kingdom.PRINCE, "BLASTER $time", 1000)
        }

        predictions()


        model.scrap(
            "MASTER BLASTER",
            TypeCast.TOMMOROW, 1000
        )

        model.managers.observe(this, Observer {
            //  toast("" + it.size)
        })

        toast(describe(100))


        Castle.kingdom().kings.observe(this, Observer {
            toast("Hey ${it.size}")
        })


    }


    private fun predictions() {
        model.predicitions.observe(this, Observer { t ->

            t.let {

                val contents = mutableListOf<AutoCompleteModel>()

                for (predictableEntity in t) {

                    val autoCompleteModel = AutoCompleteModel()
                    val time = System.currentTimeMillis()
                    autoCompleteModel.subtitle = "MAX $time"
                    autoCompleteModel.title = predictableEntity.title
                    contents.add(autoCompleteModel)
                }

                val departmentArrayAdapter =
                    AutoCompleteAdapter(this, R.layout.item, contents)
                autoCompleteTextView.setAdapter(departmentArrayAdapter)

            }
        })
    }


    fun describe(obj: Any): String =
        when (obj) {
            1 -> "One"
            "Hello" -> "Greeting"
            is Long -> "Long"
            !is String -> "Not a string"
            else -> "Unknown"
        }

}
