package com.example.attackontitancharacterswiki

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.ImageButton

class AboutActivity : AppCompatActivity() {
    private var title: String = "My Profile"
    private lateinit var buttonLink: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        setActionBar(title)

        buttonLink = findViewById(R.id.link_btn)

        buttonLink.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                buttonLink("https://attackontitan.fandom.com/wiki/Attack_on_Titan_Wiki")
            }
        })

    }

    private fun buttonLink(url: String) {
        val moveIntentLink = Intent(Intent.ACTION_VIEW)
        moveIntentLink.setData(Uri.parse(url))
        startActivity(moveIntentLink)
    }

    private fun setActionBar(title: String) {
        supportActionBar?.title = title
    }


    /*override fun onContextItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item_list -> {
                val moveIntent = Intent(this@AboutActivity, MainPageActivity::class.java)
                startActivity(moveIntent)
                return true
            }
        }
        return super.onContextItemSelected(item)
    }*/
}