package com.example.wordle

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.InputFilter
import android.text.InputFilter.AllCaps
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.google.android.material.textfield.TextInputEditText


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //const vals for all four textviews that display letters, fetch words from all 4
        //textviews in an array
        val firstLetter = findViewById<TextView>(R.id.firstLetter)
        val secondLetter = findViewById<TextView>(R.id.secondLetter)
        val thirdLetter = findViewById<TextView>(R.id.thirdLetter)
        val fourthLetter = findViewById<TextView>(R.id.fourthLetter)
        val word = arrayOf(firstLetter, secondLetter, thirdLetter, fourthLetter)

        //fetch editview input, submit and restart button
        val input = findViewById<TextInputEditText>(R.id.wordInput)
        val submitBtn = findViewById<Button>(R.id.submit)
        val restartBtn = findViewById<Button>(R.id.restartBtn)

        //instantiates FourLetterWordList and gets a random word
        //counter is used for determining # of guesses and lost is to confirm
        //if user guessed right at the end.
        val fourLetterWordList = FourLetterWordList
        val randomWord = fourLetterWordList.getRandomFourLetterWord()
        var counter = 0
        var lost = true

        //found out how to get make all letters cap no matter what here:
        //https://stackoverflow.com/questions/15961813/in-android-edittext-how-to-force-writing-uppercase
        input.filters = arrayOf<InputFilter>(AllCaps())

        /**
         * upon submitting button, checks input and calls on checkGuess function to determine
         * if user-inputted word is correct. Will only accept 4-letter inputs.
         * for restarting functionality, learned it from here:
         * https://www.geeksforgeeks.org/different-ways-to-programmatically-restart-an-android-app-on-button-click/
        **/
        submitBtn.setOnClickListener {
            if (input.text.toString().length == 4) {
                checkGuess(word, input.text.toString(), randomWord)
                counter++
                if (input.text.toString() == randomWord) {
                    Toast.makeText(this, "You guessed the word!",
                        Toast.LENGTH_LONG).show()
                    submitBtn.isEnabled = false
                    lost = false
                    restartBtn.isVisible = true
                    restartBtn.setOnClickListener{
                        navigateUpTo(Intent(this@MainActivity, MainActivity::class.java))
                        startActivity(intent)
                    }
                }
            }
            else {
                Toast.makeText(this, "Please input a 4 letter word",
                    Toast.LENGTH_SHORT).show()
            }
            if(counter == 3 && lost){
                Toast.makeText(this, "Game over", Toast.LENGTH_LONG).show()
                revealWord(word, randomWord)
                submitBtn.isEnabled = false
                restartBtn.isVisible = true
                restartBtn.setOnClickListener{
                    navigateUpTo(Intent(this@MainActivity, MainActivity::class.java))
                    startActivity(intent)
                }
            }
        }
    }

    /*
     * Changes the textview letters to display:
     *   - Green if letter is correct and in right position
     *   - Yellow if letter exist in word but not in right position
     *   - Red if letter does not exist in word
     * @param word - array of TextViews that separately makes up one letter for the four lettered-word
     * @param guess - given by user-inputted word from EditView
     * @param wordToGuess - the real word or answer to the Wordle game
     */

    private fun checkGuess(word: Array<TextView>, guess: String, wordToGuess: String){
        for(i in 0..3){
            if(guess[i] == wordToGuess[i]){
                word[i].text = guess.subSequence(i, i + 1)
                word[i].setBackgroundColor(Color.parseColor("#00FF00"))
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
    /* At the end of three guesses: display the actual word
     * (if user did not guess it in the third try)
     * @param word - array of TextViews that separately makes up one letter for the four lettered-word
     * @param wordToGuess - the real word or answer to the Wordle game
     */
    private fun revealWord(word: Array<TextView>, wordToGuess: String){
        for(i in 0..3){
            word[i].text = wordToGuess.subSequence(i, i + 1)
            word[i].setBackgroundColor(Color.parseColor("#964B00"))
        }
    }

}