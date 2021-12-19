package com.example.attackontitancharacterswiki

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainPageActivity : AppCompatActivity() {
    private lateinit var rvChar: RecyclerView
    private var list: ArrayList<Chars> = arrayListOf()
    private var title: String = "Main Page"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_page)
        setActionBar(title)

        rvChar = findViewById(R.id.rv_chars)
        rvChar.setHasFixedSize(true)

        list.addAll(CharsData.listData)
        showRecyclerList()
    }

    private fun setActionBar(title: String) {
        supportActionBar?.title = title
    }

    private fun showSelectedChar(char: Chars) {
        Toast.makeText(this,  "You choose  " + char.full_name, Toast.LENGTH_SHORT).show()
        val moveIntentDetail = Intent(this@MainPageActivity, DetailActivity::class.java)
        moveIntentDetail.putExtra(DetailActivity.EXTRA_PHOTO, char.photo)
        moveIntentDetail.putExtra(DetailActivity.EXTRA_NAME, char.full_name)
        moveIntentDetail.putExtra(DetailActivity.EXTRA_GENDER, char.biodata_gender)
        moveIntentDetail.putExtra(DetailActivity.EXTRA_SPECIES, char.biodata_species)
        moveIntentDetail.putExtra(DetailActivity.EXTRA_STATUS, char.biodata_status)
        moveIntentDetail.putExtra(DetailActivity.EXTRA_ABOUT, char.biodata_short)
        startActivity(moveIntentDetail)
    }

    private fun showRecyclerList() {
        rvChar.layoutManager  = LinearLayoutManager(this)
        val listCharsAdapter = ListCharsAdapter(list)
        rvChar.adapter = listCharsAdapter

        listCharsAdapter.setOnItemClickCallback(object : ListCharsAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Chars) {
                showSelectedChar(data)
            }
        })

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(itemId: Int) {
        when (itemId) {
            R.id.action_about -> {
                val moveIntent = Intent(this@MainPageActivity, AboutActivity::class.java)
                startActivity(moveIntent)
            }
        }
        setActionBar(title)
    }


}