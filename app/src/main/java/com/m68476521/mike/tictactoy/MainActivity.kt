package com.m68476521.mike.tictactoy

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    protected fun buttonClick(view: View) {
        val buttonSelected = view as Button
        var cellId = 0
        when (buttonSelected.id) {
            R.id.button1 -> cellId = 1
            R.id.button2 -> cellId = 2
            R.id.button3 -> cellId = 3
            R.id.button4 -> cellId = 4
            R.id.button5 -> cellId = 5
            R.id.button6 -> cellId = 6
            R.id.button7 -> cellId = 7
            R.id.button8 -> cellId = 8
            R.id.button9 -> cellId = 9
        }

        Toast.makeText(this, "ID: $cellId", Toast.LENGTH_LONG).show()

        playGame(cellId, buttonSelected)
    }

    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    var activePlayer = 1

    fun playGame(buttonSelected: Int, button: Button) {
        if (activePlayer == 1) {
            button.text = "X"
            button.setBackgroundColor(Color.GREEN)
            player1.add(buttonSelected)
            activePlayer = 2
        } else {
            button.text = "O"
            button.setBackgroundColor(Color.BLUE)
            player2.add(buttonSelected)
            activePlayer = 1
        }
        button.isEnabled = false
        checWinner()
    }

    fun checWinner() {
        var winner = -1
        //row 1
        if (player1.contains(1) && player1.contains(2) && player1.contains(3)) {
            winner = 1
        }

        if (player2.contains(1) && player2.contains(2) && player2.contains(3)) {
            winner = 2
        }

        //row 2
        if (player1.contains(5) && player1.contains(6) && player1.contains(7)) {
            winner = 1
        }

        if (player2.contains(5) && player2.contains(6) && player2.contains(7)) {
            winner = 2
        }

        //row 3
        if (player1.contains(7) && player1.contains(8) && player1.contains(9)) {
            winner = 1
        }

        if (player2.contains(7) && player2.contains(8) && player2.contains(9)) {
            winner = 2
        }

        //column 1
        if (player1.contains(1) && player1.contains(4) && player1.contains(7)) {
            winner = 1
        }

        if (player2.contains(1) && player2.contains(4) && player2.contains(7)) {
            winner = 2
        }

        //column 2
        if (player1.contains(2) && player1.contains(5) && player1.contains(8)) {
            winner = 1
        }

        if (player2.contains(2) && player2.contains(5) && player2.contains(8)) {
            winner = 2
        }

        //column 3
        if (player1.contains(3) && player1.contains(6) && player1.contains(9)) {
            winner = 1
        }

        if (player2.contains(3) && player2.contains(6) && player2.contains(9)) {
            winner = 2
        }

        //diagonal a
        if (player1.contains(1) && player1.contains(5) && player1.contains(9)) {
            winner = 1
        }

        if (player2.contains(1) && player2.contains(5) && player2.contains(9)) {
            winner = 2
        }

        //diagonal b
        if (player1.contains(3) && player1.contains(5) && player1.contains(7)) {
            winner = 1
        }

        if (player2.contains(3) && player2.contains(5) && player2.contains(7)) {
            winner = 2
        }

        if (winner != -1)
            Toast.makeText(this, "Winner is player $winner", Toast.LENGTH_LONG).show()
        else
            Toast.makeText(this, "No Winner", Toast.LENGTH_LONG).show()
    }
}
