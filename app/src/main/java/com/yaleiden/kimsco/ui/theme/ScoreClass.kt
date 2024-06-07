package com.yaleiden.kimsco.ui.theme

import android.util.Log
import org.w3c.dom.Text

class ScoreClass() {
    val TAG = "ScoreClass"

    private var scoreArraySize = 31

    /** Scoring format for ASA 3D archery
     * Represents each of the values an arrow can score on
     * a target.  Except you can have a 14 in a shootoff.
     */
    val scoreArrayASA: IntArray = intArrayOf(0, 5, 8, 10, 12)

    /**
     * Array of Integers
     * Position 1-30 represent target number
     * Position 0 is the 12 count
     * Nulls needed for targets that have not been scored
     */
    var scores: Array<Int?> = arrayOfNulls(scoreArraySize)

    /**
     * Target number that is ready to be scored
     */
    var activeTarget: Int = 1 //
    var totalScore: Int = 0

    /**
     * @param int position in array (target number)
     * @param int  value (points scored with arrow)
     */
    fun addScore(position: Int, value: Int){
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
                tot = tot + scores[i]!!
            }
        }
        return tot
    }

    /**
     * @return int - count of values = 12
     * Counts values = 12 in positions 1 - 30 in array
     * In case of a tie score 12 count is a tie breaker
     */
    fun twelveCount(): Int{
        var tot = 0
        for (i in 1..scores.size - 1){
            if (scores[i] == 12){
                tot = tot + 1
            }
        }
        return tot
    }


    /**
     * add null value into every scoreArray index
     * add zero into index 0 - 12 count
     * set totalScore = 0
     * set activeTarget = 1
     */
    fun clearAllScores(){
        scores = arrayOfNulls(scoreArraySize)
        Log.d(TAG, "scores[5] = " + scores[5].toString())
        scores[0] = 0 // value for 12 count starts at zero
        totalScore = 0 // value for totalScore starts at zero
        activeTarget = 1 // target to be scored
    }


}