package com.mantismink.anbuquizbeta

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import kotlin.random.Random

class TopCities : AppCompatActivity() {

    var cities = arrayOf("Los Angeles" , "Rome" , "San Francisco" , "Madrid", "Chicago" , "Abu Dhabi" , "Amsterdam" , "Beijing" , "Toronto" , "Doha" , "Hong Kong" , "San Diego" , "Boston" , "Sydney" , "Las Vegas" , "Miami" , "San Jose")
    lateinit var answerPU: TextView
    lateinit var question: TextView
    lateinit var userInput: EditText
    lateinit var random: Random
    lateinit var listofcities: String
    lateinit var mAdView : AdView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_top_cities)

        MobileAds.initialize(this) {}
        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        answerPU = findViewById(R.id.cityAnswerView)
        question = findViewById(R.id.cityQuestionTextView)
        userInput = findViewById(R.id.cityUserAnswer)



        startquiz()
    }
    fun startquiz() {

        answerPU.text = ""
        answerPU.visibility = View.INVISIBLE

        random = Random
        listofcities = cities[random.nextInt(cities.size)]
        question.text = randomLetters(listofcities)
    }
    fun cityHint(view : View){
        Toast.makeText(this, "" + listofcities ,Toast.LENGTH_LONG).show()
    }

    fun answerCorrect() {

        answerPU.visibility = View.VISIBLE
        answerPU.setBackgroundColor(Color.GREEN)
        answerPU = findViewById(R.id.cityUserAnswer)
    }

    fun answerWrong() {
        answerPU.visibility = View.VISIBLE
        answerPU.setBackgroundColor(Color.RED)
        answerPU.text = userInput.text
    }

    fun cityAnswer(view: View) {
        if (userInput.text.toString().equals(listofcities, ignoreCase = true)) {

            answerCorrect()
            Toast.makeText(this, "Yeah Eh!?", Toast.LENGTH_LONG).show()
        }else{
            answerWrong()
            Toast.makeText(this, "Please spell the correct answer, when ready", Toast.LENGTH_LONG).show()
        }
    }

    fun nextCity(view: View) {

        startquiz()
    }

    fun randomLetters(word: String): String {

        val characters: CharArray = word.toCharArray()
        for (i in characters.indices) {
            val randomIndex = (Math.random() * characters.size).toInt()
            val temp = characters[i]
            characters[i] = characters[randomIndex]
            characters[randomIndex] = temp
        }
        return String(characters)
    }

    override fun onBackPressed() {
        super.onBackPressed()

        startActivity(Intent(this, MainActivity::class.java))
    }
}
