package com.claudiagerrits.higherlower

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class HigherLowerActivity : AppCompatActivity() {

    private var currentThrow: Int = 1
    private var lastThrow: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    /**
     * Set the initial (UI) state of the game.
     */
    private fun initViews() {
        buttonHigher.setOnClickListener { onHigherClick() }
        buttonLower.setOnClickListener { onLowerClick() }
        buttonEquals.setOnClickListener { onEqualClick() }
        updateUI()
    }

    /**
     * Update the last throw text and the dice image resource drawable with the current throw.
     */
    private fun updateUI() {
        tvLastThrow.text = getString(R.string.last_throw, lastThrow)

        when (currentThrow) {
            1 -> ivDice.setImageResource(R.drawable.dice1)
            2 -> ivDice.setImageResource(R.drawable.dice2)
            3 -> ivDice.setImageResource(R.drawable.dice3)
            4 -> ivDice.setImageResource(R.drawable.dice4)
            5 -> ivDice.setImageResource(R.drawable.dice5)
            6 -> ivDice.setImageResource(R.drawable.dice6)
        }
    }

    /**
     * Replaces the previous dice value with the current one and replaces the current dice with a new dice
     * with a random number between 1 and 6 (inclusive).
     */
    private fun rollDice() {
        lastThrow = currentThrow
        currentThrow = (1..6).random()
        updateUI()
    }

    /**
     * Calls [rollDice] and checks if the answer is correct.
     */
    private fun onHigherClick() {
        rollDice()
        if (currentThrow > lastThrow) {
            onAnswerCorrect()
        } else {
            onAnswerIncorrect()
        }
    }

    /**
     * Calls [rollDice] and checks if the answer is correct.
     */
    private fun onLowerClick() {
        rollDice()

        if (currentThrow < lastThrow) {
            onAnswerCorrect()
        } else {
            onAnswerIncorrect()
        }
    }

    /**
     * Calls [rollDice] and checks if the answer is correct.
     */
    private fun onEqualClick() {
        rollDice()
        if (currentThrow == lastThrow) {
            onAnswerCorrect()
        } else {
            onAnswerIncorrect()
        }
    }

    /**
     * Displays a successful Toast message.
     */
    private fun onAnswerCorrect() {
        Toast.makeText(this, getString(R.string.correct), Toast.LENGTH_SHORT).show()
    }

    /**
     * Displays a incorrect Toast message.
     */
    private fun onAnswerIncorrect() {
        Toast.makeText(this, getString(R.string.incorrect), Toast.LENGTH_SHORT).show()
    }

}
