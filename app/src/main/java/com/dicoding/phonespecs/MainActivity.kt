package com.dicoding.phonespecs

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvPhone: RecyclerView
    private val list = ArrayList<Phone>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //splash screen
        Thread.sleep(3000)
        installSplashScreen()

        setContentView(R.layout.activity_main)

        rvPhone = findViewById(R.id.rv_phone)
        rvPhone.setHasFixedSize(true)

        list.addAll(getListPhone())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        // Sembunyikan item menu kecuali ID R.id.action_about
        for (i in 0 until menu?.size()!!) {
            val menuItem = menu.getItem(i)
            menuItem.isVisible = menuItem.itemId == R.id.about_page
        }
        return true
    }

    //menu item selected
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection.
        return when (item.itemId) {
            R.id.about_page -> {
                val intentAbout = Intent(this@MainActivity, About::class.java)
                startActivity(intentAbout)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun getListPhone(): ArrayList<Phone> {
        val dataName = resources.getStringArray(R.array.data_phone)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val dataDescriptionTwo = resources.getStringArray(R.array.data_description2)
        val listPhone = ArrayList<Phone>()
        for (i in dataName.indices) {
            val phone = Phone(dataName[i], dataDescription[i], dataDescriptionTwo[i] , dataPhoto.getResourceId(i, -1))
            listPhone.add(phone)
        }
        return listPhone
    }

    private fun showRecyclerList() {
        rvPhone.layoutManager = LinearLayoutManager(this)
        val listPhoneAdapter = ListPhoneAdapter(list)
        rvPhone.adapter = listPhoneAdapter
    }
}