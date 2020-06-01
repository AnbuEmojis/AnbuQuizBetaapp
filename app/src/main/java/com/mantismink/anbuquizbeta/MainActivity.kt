package com.mantismink.anbuquizbeta

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val nav = findViewById<BottomNavigationView>(R.id.aESNavBar)
        val frame = findViewById<FrameLayout>(R.id.anbuFrame)
        val store = AESFragment()
        val home = HomeFragment()
        val game = GameFragment()

        nav.setOnNavigationItemSelectedListener { item ->

            when (item.itemId) {

                R.id.homeIcon -> {
                    val fragmentChanger = supportFragmentManager.beginTransaction()
                    fragmentChanger.replace(R.id.anbuFrame, home)
                    fragmentChanger.commit()

                    true
                }
                R.id.gameIcon -> {
                    val fragmentChanger = supportFragmentManager.beginTransaction()
                    fragmentChanger.replace(R.id.anbuFrame, game)
                    fragmentChanger.commit()

                    true
                }

                R.id.aESIcon -> {
                    val fragmentChanger = supportFragmentManager.beginTransaction()
                    fragmentChanger.replace(R.id.anbuFrame, store)
                    fragmentChanger.commit()

                    true
                }
                else -> false
            }
        }
    }
    fun topcities(view: View) {
        startActivity(Intent(this@MainActivity, TopAnime::class.java))
    }
    fun topcars(view: View) {
        startActivity(Intent(this@MainActivity, TopCities::class.java))
    }
    fun topanime(view: View) {
        startActivity(Intent(this@MainActivity, TopAnime::class.java))
    }
    fun alltimeactivity(view: View) {
        startActivity(Intent(this@MainActivity, TopSong::class.java))
    }
}
