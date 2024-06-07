package com.yaleiden.kimsco.ui.theme

import android.util.Log

class VegasScoreClass() {
    val TAG = "VegasScoreClass"

    private var scoreArraySize = 31

    /** Scoring format for Vegas archery
     * Represents each of the values an arrow can score on
     * a target. There is also an "X" value that adds 10
     * to score and tallied as "X" count.
     */
    //val scoreArrayVegas: IntArray = intArrayOf(6, 7, 8, 9, 10, 10)
    val scoreArrayVegas = arrayOf("6","7","8","9","10","X")

    /**
     * Array of Strings - The X count is the problem..
     * Position 1-30 represent target number
     * Position 0 is the 12 count
     * Nulls needed for targets that have not been scored
     */
    var scores: Array<String?> = arrayOfNulls(scoreArraySize)

    /**
     * Target number that is ready to be scored
     */
    var activeTarget: Int = 1 //
    var totalScore: Int = 0

    /**
     * @param int position in array (target number)
     * @param int  value (points scored with arrow)
     */
    fun addScore(position: Int, value: String){
        scores[position] = value
    }

    /**
     * @return int - total score
     * Counts values in position 1 - 30 in array
     */
    fun totalScore(): Int {
        var tot = 0
        for (i in 1..scores.size - 1){
            if (scores[i] != null){
                if (scores[i] != "X") {
                    tot = tot + scores[i]!!.toInt()
                }
                if (scores[i] == "X") {
                    tot = tot + 10
                }

            }
        }
        return tot
    }

    /**
     * @return int - count of values = X
     * Counts values = X in positions 1 - 30 in array
     * In case of a tie score X count is a tie breaker
     */
    fun xCount(): Int{
        var tot = 0
        for (i in 1..scores.size - 1){
            if (scores[i] == "X"){
                tot = tot + 1
            }
        }
        return tot
    }


    /**
     * add null value into every scoreArray index
     * add zero into index 0 - X count
     * set totalScore = 0
     * set activeTarget = 1
     */
    fun clearAllScores(){
        scores = arrayOfNulls(scoreArraySize)
        Log.d(TAG, "scores[5] = " + scores[5].toString())
        scores[0] = "0" // value for 12 count starts at zero
        totalScore = 0 // value for totalScore starts at zero
        activeTarget = 1 // target to be scored
    }


}