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

class TopSong : AppCompatActivity() {


    var titles = arrayOf("Gimme Shelter" , "One", "No Woman, No Cry" , "You’ve Lost That Lovin’ Feeling" , "Sympathy For The Devil" , "I Walk The Line" , "River Deep – Mountain High" , "Help!" , "People Get Ready" , "In My Life" , "Layla" , "(Sittin’ On) The Dock Of The Bay" , "Let It Be" , "The Times They Are A-Changin" , "Baba O’Riley" , "Be My Baby" , "Born To Run" , "Behind Blue Eyes" , "La Bamba" , "Hound Dog" , "Rock Around The Clock" , "Break On Through (To The Other Side)" , "Here Comes The Sun" , "Rebel Rebel" , "You Really Got Me" , "Purple Haze" , "London Calling" , "What A Wonderful World" , "A Change Is Gonna Come" , "The Sound Of Silence" , "A Day In The Life" , "My Generation" , "Light My Fire" , "What’d I Say" , "Paint It Black" , "Respect" , "All Along The Watchtower" , "What’s Going On" , "Stairway To Heaven" , "Like A Rolling Stone" , "God Only Knows" , " Blowin’ In The Wind" , "I Want To Hold Your Hand" , "Johnny B. Goode" , "Smells Like Teen Spirit" , "Good Vibrations" , "Yesterday" , "(I Can’t Get No) Satisfaction" , "Hey Jude" , "Imagine")
    lateinit var answer: TextView
    lateinit var question: TextView
    lateinit var userAnswer: EditText
    lateinit var random: Random
    lateinit var questionTitles: String
    lateinit var mAdView : AdView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_top_song)

        MobileAds.initialize(this) {}
        mAdView = findViewById(R.id.adRView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)


        answer = findViewById(R.id.answerView)
        question = findViewById(R.id.questionTextview)
        userAnswer = findViewById(R.id.userAnswer)

        startQuiz()
    }
    fun startQuiz() {
        answer.text = ""
        answer.visibility = View.INVISIBLE

        random = Random
        questionTitles = titles[random.nextInt(titles.size)]
        question.text = randomLetters(questionTitles)
    }
    fun songHint(view : View){
        Toast.makeText(this, "" + questionTitles ,Toast.LENGTH_LONG).show()
    }

    fun answerCorrect() {

        answer.visibility = View.VISIBLE
        answer.setBackgroundColor(Color.BLUE)
        answer = findViewById(R.id.userAnswer)

        //Handler
        val handler = Handler()
        handler.postDelayed({
            startQuiz()
        }, 3000)
    }

    fun answerWrong() {
        answer.visibility = View.VISIBLE
        answer.setBackgroundColor(Color.RED)
        answer.text = userAnswer.text
    }

    fun checkAnswer(view: View) {

        if (userAnswer.text.toString().equals(questionTitles, ignoreCase = true)) {

            answerCorrect()
            Toast.makeText(this, "Yeah Eh!?", Toast.LENGTH_LONG).show()
        } else {
            answerWrong()
            Toast.makeText(this, "Please spell the correct answer, when ready", Toast.LENGTH_LONG).show()
        }


    }

    fun nextTitle(view: View) {

        startQuiz()
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
