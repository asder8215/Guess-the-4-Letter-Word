package com.example.wordle

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firstLetter = findViewById<TextView>(R.id.firstLetter)
        val secondLetter = findViewById<TextView>(R.id.secondLetter)
        val thirdLetter = findViewById<TextView>(R.id.thirdLetter)
        val fourthLetter = findViewById<TextView>(R.id.fourthLetter)
        val word = arrayOf(firstLetter, secondLetter, thirdLetter, fourthLetter)

        val input = findViewById<TextInputEditText>(R.id.wordInput)
        val submitBtn = findViewById<Button>(R.id.submit)

        val fourLetterWordList = FourLetterWordList
        val randomWord = fourLetterWordList.getRandomFourLetterWord()
        var counter = 0
        var lost = true

            submitBtn.setOnClickListener {
                if (input.text.toString().length == 4) {
                    checkGuess(word, input.text.toString(), randomWord)
                    counter++
                    if (input.text.toString() == randomWord) {
                        Toast.makeText(this, "You guessed the word!",
                            Toast.LENGTH_SHORT).show()
                        submitBtn.isEnabled = false
                        lost = false
                    }
                }
                else {
                    Toast.makeText(
                        this, "Please input a 4 letter word",
                        Toast.LENGTH_SHORT).show()
                }
                if(counter == 3 && lost){
                    Toast.makeText(this, "Game over", Toast.LENGTH_SHORT).show()
                    revealWord(word, randomWord)
                    submitBtn.isEnabled = false
                }
            }

    }
    private fun checkGuess(word: Array<TextView>, guess: String, wordToGuess: String){
        for(i in 0..3){
            if(guess[i] == wordToGuess[i]){
                word[i].text = guess.subSequence(i, i + 1)
                word[i].setBackgroundColor(Color.parseColor("#964B00"))
            }
            else if(guess[i] in wordToGuess){
                word[i].text = guess.subSequence(i, i + 1)
                word[i].setBackgroundColor(Color.parseColor("#FFFF00"))
            }
            else{
                word[i].text = guess.subSequence(i, i + 1)
                word[i].setBackgroundColor(Color.parseColor("#FF0000"))
            }
        }
    }
    private fun revealWord(word: Array<TextView>, wordToGuess: String){
        for(i in 0..3){
            word[i].text = wordToGuess.subSequence(i, i + 1)
            word[i].setBackgroundColor(Color.parseColor("#964B00"))
        }
    }

}