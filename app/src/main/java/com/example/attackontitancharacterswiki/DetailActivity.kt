package com.example.attackontitancharacterswiki

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_PHOTO = "extra_photo"
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_GENDER = "extra_gender"
        const val EXTRA_SPECIES = "extra_species"
        const val EXTRA_STATUS = "extra_status"
        const val EXTRA_ABOUT = "extra_about"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar?.title = "Character Detail"

        val imgCharPhoto: ImageView = findViewById(R.id.char_profile)
        val txtNameChar: TextView = findViewById(R.id.char_name)
        val txtGenderChar: TextView = findViewById(R.id.char_gender)
        val txtSpeciesChar: TextView = findViewById(R.id.char_species)
        val txtStatusChar: TextView = findViewById(R.id.char_status)
        val txtAboutChar: TextView = findViewById(R.id.char_about)


        val imgPhoto = intent.getIntExtra(EXTRA_PHOTO, 0)
        val name = intent.getStringExtra(EXTRA_NAME)
        val gender = intent.getStringExtra(EXTRA_GENDER)
        val species = intent.getStringExtra(EXTRA_SPECIES)
        val status = intent.getStringExtra(EXTRA_STATUS)
        val about = intent.getStringExtra(EXTRA_ABOUT)

        imgCharPhoto.setImageResource(imgPhoto)
        txtNameChar.text = name
        txtGenderChar.text = gender
        txtSpeciesChar.text = species
        txtStatusChar.text = status
        txtAboutChar.text = about

    }

}