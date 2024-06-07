package com.yaleiden.kimsco

import android.util.Log
import androidx.lifecycle.ViewModel
import com.yaleiden.kimsco.ui.theme.VegasScoreClass

class VegasActivityViewModel  : ViewModel() {
    val TAG = "VegasActivityViewModel"

    init {
        Log.d(TAG, TAG + " created!")
    }

    val mScores: VegasScoreClass = VegasScoreClass()


    /**
     * @param int position in array (target number)
     * @param String  value (points scored)
     */
    fun addScore(position: Int, value: String) {
        mScores.addScore(position, value)
    }

    fun totalScore(): Int {

        return mScores.totalScore()
    }

    fun xCount(): Int {

        return mScores.xCount()
    }

    fun clearAllScores() {
        Log.d(TAG, "clearAllScores activeTarget = "+ mScores.activeTarget)
        mScores.clearAllScores()
    }

}