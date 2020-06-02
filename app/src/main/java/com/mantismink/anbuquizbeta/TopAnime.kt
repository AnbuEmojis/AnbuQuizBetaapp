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

class TopAnime : AppCompatActivity() {

    var titles = arrayOf("Samurai Champloo" , "Bleach" , "Hellsing Ultimate" , "Toradora!" , "Hellsing" , "Death Note" , "Fate/Zero" , "Fairy Tail Zero" , "Soul Eater" , "Mob Psycho 100" , "Overlord" , "Death Parade" ,"Kuroko's Basketball" , "Berserk" , "Psycho-Pass" , "Fairy Tail" , "High School DxD" , "Food Wars: Shokugeki No Soma" , "One-punch Man" , "Steins;Gate" , "Cowboy Bebop" , "Dragon Ball Z" , "Is It Wrong to Try to Pick Up Girls in a Dungeon?" , "Charlotte" , "One Piece" , "Dragon Ball" , "My Hero Academia" , "Code Geass" , "Magi" , "Ouran High School Host Club" , "Future Diary" , "Black Butler" , "Haikyuu!" , "Akame Ga Kill" , "Fullmetal Alchemist" , "Your Lie in April" , "The Devil is a Part-timer" , "Code Geass: Lelouch of the Rebellion R2", "Naruto", "No Game No Life" , "Parasyte" , "Attack on Titan" , "Noragami" , "Assassination Classroom" , "Fullmetal Alchemist: Brotherhood" , "The Seven Deadly Sins" , "Tokyo Ghoul" , "Hunter x Hunter" , "Naruto Shippuden")
    lateinit var answer: TextView
    lateinit var question: TextView
    lateinit var userInput: EditText
    lateinit var random: Random
    lateinit var bookVarietySelection:String
    lateinit var mAdView : AdView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_top_anime)

        MobileAds.initialize(this) {}
        mAdView = findViewById(R.id.adRView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        answer = findViewById(R.id.animeANswerView)
        question = findViewById(R.id.animeQuestionTextView)
        userInput = findViewById(R.id.animeUserAnswer)

        startQuiz()
    }
    fun startQuiz() {
        answer.text = ""
        answer.visibility = View.INVISIBLE

        random = Random
        bookVarietySelection = titles[random.nextInt(titles.size)]
        question.text = randomLetters(bookVarietySelection)
    }
    fun animeHint(view : View){
        Toast.makeText(this, "" + bookVarietySelection ,Toast.LENGTH_LONG).show()
    }
    fun answerCorrect() {

        answer.visibility = View.VISIBLE
        answer.setBackgroundColor(Color.YELLOW)
        answer = findViewById(R.id.animeUserAnswer)

        //Handler
        val handler = Handler()
        handler.postDelayed({
            startQuiz()
        }, 3000)
    }
    fun answerWrong() {

        answer.visibility = View.VISIBLE
        answer.setBackgroundColor(Color.RED)
        answer.text = userInput.text
    }
    fun animeAnswer(view: View) {

        if (userInput.text.toString().equals(bookVarietySelection, ignoreCase = true)) {
            answerCorrect()
            Toast.makeText(this, "Yeah Eh!?", Toast.LENGTH_LONG).show()
        }else {
            answerWrong()
            Toast.makeText(this, "Please spell the correct answer, when ready", Toast.LENGTH_LONG).show()
        }
    }
    fun nextAnime(view: View){
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
