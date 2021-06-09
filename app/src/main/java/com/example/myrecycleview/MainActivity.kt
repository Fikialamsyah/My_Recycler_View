package com.example.myrecycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvHeroes: RecyclerView
    private lateinit var rvAdapter: ListHeroAdapter
    private var list: ArrayList<Hero> = arrayListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvHeroes = findViewById(R.id.rv_hero)

        rvHeroes.setHasFixedSize(true)

        list.addAll(HeroesData.listData)

        showRecyclerList()

    }

    private fun showRecyclerList(){
        rvHeroes.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ListHeroAdapter(list)
        rvHeroes.adapter = listHeroAdapter

        listHeroAdapter.seOnItemClickCallback(object : ListHeroAdapter.OnItemClickCallBack{
            override fun onItemClicked(data: Hero) {
                showSelectedHero(data)
            }
        })
    }

    private fun showRecyclerGrid(){
        rvHeroes.layoutManager = GridLayoutManager(this, 2)
        val gridHeroAdapter = GridHeroAdapter(list)
        rvHeroes.adapter = gridHeroAdapter

        gridHeroAdapter.setOnItemClickCallBack(object : GridHeroAdapter.OnItemClickCallBack{
            override fun onItemCliked(data: Hero) {
                showSelectedHero(data)
            }
        })
    }

    private fun showRecyclerCard(){
        rvHeroes.layoutManager = LinearLayoutManager(this)
        val cardHeroAdapter = CardViewHeroAdapter(list)
        rvHeroes.adapter = cardHeroAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun showSelectedHero(hero: Hero){
        Toast.makeText(this, "Kamu memilih " + hero.name, Toast.LENGTH_SHORT).show()
    }

    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.action_list -> showRecyclerList()
            R.id.action_grid -> showRecyclerGrid()
            R.id.action_cardview -> showRecyclerCard()
        }
    }

}