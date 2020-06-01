package com.mantismink.anbuquizbeta

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import kotlin.random.Random

class TopCars : AppCompatActivity() {

    var cars = arrayOf("Porsche" , "Genesis" , "Subaru" , "Mazda" , "Lexus" , "Audi" , "Hyundai" , "BMW", "Kia" , "Mini" , "Tesla" , "Toyota" , "Lincoln" , "Infiniti" , "Honda" , "Volkswagen" , "Nissan" , "Chrysler" , "Buick" , "Mercedes-Benz" , "Dodge" , "Volvo" , "Ford" , "Acura" , "Chevrolet" , "GMC" , "Alfa Romeo" , "Jaguar" , "Cadillac" , "Land Rover" , " Jeep" , "Mitsubishi" , "Fiat")
    lateinit var answerPU: TextView
    lateinit var question: TextView
    lateinit var userInput: EditText
    lateinit var random: Random
    lateinit var brandNames:String
    lateinit var mAdView : AdView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_top_cars)

        MobileAds.initialize(this) {}
        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        answerPU = findViewById(R.id.carAnswerView)
        question = findViewById(R.id.carQuestionTextView)
        userInput = findViewById(R.id.carUserAnswer)

        startquiz()
    }
    fun startquiz() {
        answerPU.text = ""
        answerPU.visibility = View.INVISIBLE

        random = Random
        brandNames = cars[random.nextInt(cars.size)]
        question.text = randomLetters(brandNames)
    }
    fun carHint(view : View){
        Toast.makeText(this, "" + brandNames ,Toast.LENGTH_LONG).show()
    }

    fun answerCorrect() {

        answerPU.visibility = View.VISIBLE
        answerPU.setBackgroundColor(Color.CYAN)
        answerPU = findViewById(R.id.carUserAnswer)

        //Handler
        val handler = Handler()
        handler.postDelayed({
            startquiz()
        }, 3000)
    }

    fun answerWrong() {
        answerPU.visibility = View.VISIBLE
        answerPU.setBackgroundColor(Color.RED)
        answerPU.text = userInput.text
    }

    fun checkAnswer(view: View) {

        if (userInput.text.toString().equals(brandNames, ignoreCase = true)) {

            answerCorrect()
            Toast.makeText(this, "Yeah Eh!?", Toast.LENGTH_LONG).show()
        }else{
            answerWrong()
            Toast.makeText(this, "Press check to start", Toast.LENGTH_LONG).show()
        }

    }

    fun nextBrand(view: View) {

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
