package com.yaleiden.kimsco

import android.util.Log
import androidx.lifecycle.ViewModel
import com.yaleiden.kimsco.ui.theme.ScoreClass

class MainActivityViewModel : ViewModel() {
    val TAG = "MainActivityViewModel"

    init {
        Log.d(TAG, "MainActivityViewModel created!")
    }

    val mScores: ScoreClass = ScoreClass()


    /**
     * @param int position in array (target number)
     * @param int  value (points scored)
     */
    fun addScore(position: Int, value: Int) {
        mScores.addScore(position, value)
    }

    fun totalScore(): Int {

        return mScores.totalScore()
    }

    fun twelveCount(): Int {

        return mScores.twelveCount()
    }

    fun clearAllScores() {
        Log.d(TAG, "clearAllScores activeTarget = "+ mScores.activeTarget)
        mScores.clearAllScores()
    }

}