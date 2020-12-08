package com.bemal.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun butClick(view: View){
        val buSelected = view as Button
        var cellId = 0

        when( buSelected.id ){
            R.id.but1 -> cellId = 1
            R.id.but2 -> cellId = 2
            R.id.but3 -> cellId = 3
            R.id.but4 -> cellId = 4
            R.id.but5 -> cellId = 5
            R.id.but6 -> cellId = 6
            R.id.but7 -> cellId = 7
            R.id.but8 -> cellId = 8
            R.id.but9 -> cellId = 9
        }
        playGame(cellId,buSelected);
    }

    var activePlayer = 1;
    var player1 = mutableListOf<Int>()
    var player2 = mutableListOf<Int>()

    fun playGame(cellId: Int,butSelect: Button){
        if(activePlayer == 1){
            butSelect.text = "X"
            butSelect.setBackgroundResource(R.color.colorRed)
            player1.add(cellId)
            activePlayer = 2
            autoPlay()
        }else{
            butSelect.text = "o"
            butSelect.setBackgroundResource(R.color.colorGreen)
            player2.add(cellId)
            activePlayer = 1
        }
        butSelect.isEnabled = false
        checkWinner()
    }

    fun checkWinner(){
        var winner = -1

        // row 1
        if(player1.contains(1) && player1.contains(2) && player1.contains(3)){
            winner = 1
        }
        if(player2.contains(1) && player2.contains(2) && player2.contains(3)){
            winner = 2
        }

        // row 2
        if(player1.contains(4) && player1.contains(5) && player1.contains(6)){
            winner = 1
        }
        if(player2.contains(4) && player2.contains(5) && player2.contains(6)){
            winner = 2
        }

        // row 3
        if(player1.contains(7) && player1.contains(8) && player1.contains(9)){
            winner = 1
        }
        if(player2.contains(7) && player2.contains(8) && player2.contains(9)){
            winner = 2
        }

        // col 1
        if(player1.contains(1) && player1.contains(4) && player1.contains(7)){
            winner = 1
        }
        if(player2.contains(1) && player2.contains(4) && player2.contains(7)){
            winner = 2
        }

        // col 2
        if(player1.contains(2) && player1.contains(5) && player1.contains(8)){
            winner = 1
        }
        if(player2.contains(2) && player2.contains(5) && player2.contains(8)){
            winner = 2
        }

        // col 3
        if(player1.contains(3) && player1.contains(6) && player1.contains(9)){
            winner = 1
        }
        if(player2.contains(3) && player2.contains(6) && player2.contains(9)){
            winner = 2
        }

        // cross 1
        if(player1.contains(1) && player1.contains(5) && player1.contains(9)){
            winner = 1
        }
        if(player2.contains(1) && player2.contains(5) && player2.contains(9)){
            winner = 2
        }

        // cross 2
        if(player1.contains(3) && player1.contains(5) && player1.contains(7)){
            winner = 1
        }
        if(player2.contains(3) && player2.contains(5) && player2.contains(7)){
            winner = 2
        }

        if(winner == 1){
            Toast.makeText(this,"Player 1 win the game",Toast.LENGTH_LONG).show()
        }else if(winner == 2){
            Toast.makeText(this,"Machine win the game",Toast.LENGTH_LONG).show()
        }
    }

    fun autoPlay(){
        var emptyCells = mutableListOf<Int>()
        for (cellId in 1..9) {
            if(!player1.contains(cellId) && !player2.contains(cellId)){
                emptyCells.add(cellId)
            }
        }

        if(emptyCells.size == 0){
            Toast.makeText(this,"Game draw",Toast.LENGTH_LONG).show()
            return
        }

        val rIndex = Random.nextInt(emptyCells.size)
        val cellId = emptyCells[rIndex]

        var butSelected: Button = when(cellId){
            1 -> but1
            2 -> but2
            3 -> but3
            4 -> but4
            5 -> but5
            6 -> but6
            7 -> but7
            8 -> but8
            9 -> but9
            else -> but1
        }

        playGame(cellId,butSelected)

    }

}
