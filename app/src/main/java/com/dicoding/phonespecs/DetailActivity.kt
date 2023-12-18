package com.dicoding.phonespecs

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)


        //halaman detail intent
        val dataPhone = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Phone>("key_phone", Phone::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Phone>("key_phone")
        }

        val name = findViewById<TextView>(R.id.tv_item_name)
        val description = findViewById<TextView>(R.id.tv_item_description_detail)
        val phone = findViewById<ImageView>(R.id.img_item_photo)

        name.text = dataPhone?.name
        description.text = dataPhone?.descriptionTwo
        phone.setImageResource(dataPhone?.photo!!)

    }
    //menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    //menu item selected
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection.
        return when (item.itemId) {
            R.id.about_page -> {
                val intentAbout = Intent(this@DetailActivity, About::class.java)
                startActivity(intentAbout)
                true
            }
            R.id.action_share -> {
                val appMsg :String = "check out this app for share button:- " +
                "https://play.google.com/store/apps/details?id=com.dicoding.phonespecs"
                val intent = Intent()
                intent.action = Intent.ACTION_SEND
                intent.type = "text/plain"
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}