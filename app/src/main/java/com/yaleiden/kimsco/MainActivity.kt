package com.yaleiden.kimsco

import android.app.AlertDialog
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.core.content.ContextCompat

class MainActivity : ComponentActivity() {

    private val mainActivityViewModel by viewModels<MainActivityViewModel>()
    lateinit var buttonArray: Array<Button>  // Score buttons
    val TAG = "MainActivity"

    lateinit var textViewTargetVal: TextView  // Shows active target number
    lateinit var textViewTotalVal: TextView  // Shows total score
    lateinit var textViewScoreArray: Array<TextView>  // Holds score boxes

    //  Score boxes
    lateinit var tVscr0: TextView
    lateinit var tVscr1: TextView
    lateinit var tVscr2: TextView
    lateinit var tVscr3: TextView
    lateinit var tVscr4: TextView
    lateinit var tVscr5: TextView
    lateinit var tVscr6: TextView
    lateinit var tVscr7: TextView
    lateinit var tVscr8: TextView
    lateinit var tVscr9: TextView
    lateinit var tVscr10: TextView
    lateinit var tVscr11: TextView
    lateinit var tVscr12: TextView
    lateinit var tVscr13: TextView
    lateinit var tVscr14: TextView
    lateinit var tVscr15: TextView
    lateinit var tVscr16: TextView
    lateinit var tVscr17: TextView
    lateinit var tVscr18: TextView
    lateinit var tVscr19: TextView
    lateinit var tVscr20: TextView
    lateinit var tVscr21: TextView
    lateinit var tVscr22: TextView
    lateinit var tVscr23: TextView
    lateinit var tVscr24: TextView
    lateinit var tVscr25: TextView
    lateinit var tVscr26: TextView
    lateinit var tVscr27: TextView
    lateinit var tVscr28: TextView
    lateinit var tVscr29: TextView
    lateinit var tVscr30: TextView

    //  bonus count box
    lateinit var tVscr01: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        // Hide actionbar in landscape mode - it messes up the layout
        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            getActionBar()?.hide()
        }

        // Initialize textviews for Total and Active Target
        textViewTargetVal = findViewById<TextView>(R.id.textViewTargetVal)
        textViewTotalVal = findViewById<TextView>(R.id.textViewTotalVal)
        // Initialize scoring buttons
        val button1 = findViewById<Button>(R.id.button1)
        val button2 = findViewById<Button>(R.id.button2)
        val button3 = findViewById<Button>(R.id.button3)
        val button4 = findViewById<Button>(R.id.button4)
        val button5 = findViewById<Button>(R.id.button5)
        val button6 = findViewById<Button>(R.id.button6)
        //  Initialize individual target value textviews
        tVscr0 = findViewById<TextView>(R.id.tVscr0)  // textview for 12 count
        tVscr1 = findViewById<TextView>(R.id.tVscr1)  // textview for target number 1
        tVscr2 = findViewById<TextView>(R.id.tVscr2)
        tVscr3 = findViewById<TextView>(R.id.tVscr3)
        tVscr4 = findViewById<TextView>(R.id.tVscr4)
        tVscr5 = findViewById<TextView>(R.id.tVscr5)
        tVscr6 = findViewById<TextView>(R.id.tVscr6)
        tVscr7 = findViewById<TextView>(R.id.tVscr7)
        tVscr8 = findViewById<TextView>(R.id.tVscr8)
        tVscr9 = findViewById<TextView>(R.id.tVscr9)
        tVscr10 = findViewById<TextView>(R.id.tVscr10)
        tVscr11 = findViewById<TextView>(R.id.tVscr11)
        tVscr12 = findViewById<TextView>(R.id.tVscr12)
        tVscr13 = findViewById<TextView>(R.id.tVscr13)
        tVscr14 = findViewById<TextView>(R.id.tVscr14)
        tVscr15 = findViewById<TextView>(R.id.tVscr15)
        tVscr16 = findViewById<TextView>(R.id.tVscr16)
        tVscr17 = findViewById<TextView>(R.id.tVscr17)
        tVscr18 = findViewById<TextView>(R.id.tVscr18)
        tVscr19 = findViewById<TextView>(R.id.tVscr19)
        tVscr20 = findViewById<TextView>(R.id.tVscr20)
        tVscr21 = findViewById<TextView>(R.id.tVscr21)
        tVscr22 = findViewById<TextView>(R.id.tVscr22)
        tVscr23 = findViewById<TextView>(R.id.tVscr23)
        tVscr24 = findViewById<TextView>(R.id.tVscr24)
        tVscr25 = findViewById<TextView>(R.id.tVscr25)
        tVscr26 = findViewById<TextView>(R.id.tVscr26)
        tVscr27 = findViewById<TextView>(R.id.tVscr27)
        tVscr28 = findViewById<TextView>(R.id.tVscr28)
        tVscr29 = findViewById<TextView>(R.id.tVscr29)
        tVscr30 = findViewById<TextView>(R.id.tVscr30)

        // Initialize bonus count
        tVscr01 = findViewById<TextView>(R.id.tVscr01)

        // Define array so we can use position to update text
        textViewScoreArray = arrayOf(
            tVscr0, tVscr1, tVscr2, tVscr3, tVscr4, tVscr5,
            tVscr6, tVscr7, tVscr8, tVscr9, tVscr10, tVscr11,
            tVscr12, tVscr13, tVscr14, tVscr15, tVscr16, tVscr17,
            tVscr18, tVscr19, tVscr20, tVscr21, tVscr22, tVscr23,
            tVscr24, tVscr25, tVscr26, tVscr27, tVscr28,
            tVscr29, tVscr30
        )

        //  Initialize clear button
        val buttonClear = findViewById<Button>(R.id.buttonClear)
        buttonClear.setOnClickListener {
            clearScores()
        }

        // Set bonus count title
        tVscr01.setText(R.string.twelve_count)

        // Set Scoring format
        //val scoreArray1: IntArray = mainActivityViewModel.mScores.scoreArrayASA
        val scoreArray1: IntArray = mainActivityViewModel.mScores.scoreArrayASA
        // Out of sequence to make buttons easier for right handed user
        buttonArray = arrayOf(button1, button2, button3, button6, button5, button4)

        textViewTargetVal.setText(mainActivityViewModel.mScores.activeTarget.toString())

        textViewTotalVal.setText(mainActivityViewModel.mScores.totalScore.toString())
        setButtons(buttonArray, scoreArray1)

        activeTargetHighlight(mainActivityViewModel.mScores.activeTarget)
        setScoreTextViews(textViewScoreArray)
        setInitialDisplay()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection.
        return when (item.itemId) {
            R.id.asa -> {
                //startASA()
                true
            }
            R.id.vegas -> {
                startVegas()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun startVegas(){
        startActivity(Intent(this@MainActivity,VegasActivity::class.java))
    }

    /**
     * Set the values displayed on the UI score buttons to the values in the scoreArray
     */
    fun setButtons(buttonArray: Array<Button>, intArray: IntArray) {

        for (i in 0..buttonArray.size - 1) {
            if (i < intArray.size) {
                // Set scoreArray value as text on button
                buttonArray.get(i).setText(intArray.get(i).toString())
                // Set stringArray value as text on button
                buttonArray.get(i).setText(intArray.get(i).toString())
                // Set addScore() as onClick() function
                buttonArray.get(i).setOnClickListener() {
                    addScore(intArray.get(i))
                }
            } else {
                // Remove button if we don't have a value for it
                buttonArray.get(i).visibility = View.INVISIBLE
            }
        }

    }

    /**
     * set the onClick function for score textviews
     */
    fun setScoreTextViews(textViewArray: Array<TextView>) {

        for (i in 1..mainActivityViewModel.mScores.scores.size - 1) {

            textViewArray.get(i).setOnClickListener() {
                textViewOnClick(i)
            }
        }

    }

    /**
     * @param int: The number of the active target
     *         Changes background color of textview
     */
    fun activeTargetHighlight(target: Int) {

        if (mainActivityViewModel.mScores.activeTarget <= mainActivityViewModel.mScores.scores.size - 1) {

            for (i in 1..mainActivityViewModel.mScores.scores.size - 1) {
                textViewScoreArray[i].setBackgroundResource(R.drawable.score_bkg_dark)
                if (i <= 5) {
                    textViewScoreArray[i].setBackgroundResource(R.drawable.score_bkg_light)
                }
                if (i >= 16 && i <= 20) {
                    textViewScoreArray[i].setBackgroundResource(R.drawable.score_bkg_light)
                }
                if (i >= 21 && i <= 25) {
                    textViewScoreArray[i].setBackgroundResource(R.drawable.score_bkg_light)
                }
            }
            textViewScoreArray[target].setBackgroundColor(ContextCompat.getColor(applicationContext,R.color.highlight))
        }

    }

    /**
     * @param int - value of the target
     * add value to ScoreClass.scores
     * update UI
     */
    fun addScore(score: Int) {
        if (mainActivityViewModel.mScores.activeTarget <= mainActivityViewModel.mScores.scores.size - 1) {
            // add score to array
            mainActivityViewModel.addScore(mainActivityViewModel.mScores.activeTarget, score)
            // tally scores in array
            mainActivityViewModel.mScores.totalScore = mainActivityViewModel.totalScore()
            //textViewScoreArray[activeTarget].setText(score.toString())
            textViewScoreArray[mainActivityViewModel.mScores.activeTarget].setText(score.toString())
            //activeTarget += 1 //Increment target count
            mainActivityViewModel.mScores.activeTarget += 1 //Increment target count
            setDisplayAfterScore()
            Log.d(TAG, "mainActivityViewModel.totalScore = " + mainActivityViewModel.mScores.totalScore)
            Log.d(TAG, "mainActivityViewModel.totalScore() = " + mainActivityViewModel.totalScore())
        } else {
            Toast.makeText(this, "30 targets scored", Toast.LENGTH_SHORT).show()
            Log.d(TAG, "addScore Toast.makeText")
        }
    }

    /**
     * AlertDialog before clearing scores and reset UI
     */
    fun clearScores() {

        val builder = AlertDialog.Builder(this, R.style.ThemeOverlay_AppCompat_Dialog_Alert)
        builder.setMessage("Do you want to clear all scores?")
            .setIcon(R.drawable.ic_launcher_foreground)
            .setTitle("Clear all scores")
            .setNegativeButton("No") { dialog, which ->
            }
            .setPositiveButton("Yes") { dialog, which ->
                mainActivityViewModel.clearAllScores()
                setInitialDisplay()

            }
        builder.show()

    }

    /**
     * after a score is added to array, move highlight to next textview
     * set new 12 count
     * set new Target value
     */
    fun setDisplayAfterScore() {
        textViewTotalVal.setText(mainActivityViewModel.mScores.totalScore.toString())
        Log.d(TAG, "1 setDisplayAfterScore activeTarget = " + mainActivityViewModel.mScores.activeTarget)
        // get 12 count from array and update ui
        tVscr0.setText(mainActivityViewModel.twelveCount().toString())
        // Avoid getting index out of bounds
        if (mainActivityViewModel.mScores.activeTarget > mainActivityViewModel.mScores.scores.size - 1){
            Toast.makeText(this, "30 targets scored", Toast.LENGTH_SHORT).show()
            mainActivityViewModel.mScores.activeTarget = mainActivityViewModel.mScores.scores.size - 1
        }
        if (mainActivityViewModel.mScores.activeTarget <= mainActivityViewModel.mScores.scores.size - 1) {
            Log.d(
                TAG,
                "2 setDisplayAfterScore mainActivityViewModel.activeTarget = " + mainActivityViewModel.mScores.activeTarget
            )
            //activeTargetHighlight(activeTarget)
            textViewTargetVal.setText(mainActivityViewModel.mScores.activeTarget.toString())
            activeTargetHighlight(mainActivityViewModel.mScores.activeTarget)
        }
    }

    /**
     *  Set score box text values to viewmodel.scores - should be null
     *  Highlight score box 1
     *  Set textviews for 12 Count, active target and total score
     */
    private fun setInitialDisplay() {

        if (mainActivityViewModel.mScores.activeTarget <= mainActivityViewModel.mScores.scores.size - 1) {

            for (i in 1..mainActivityViewModel.mScores.scores.size - 1) {
                 var text = ""
                 if (mainActivityViewModel.mScores.scores[i] != null) {
                     text = mainActivityViewModel.mScores.scores[i].toString()
                 }
                textViewScoreArray[i].setText(text)
            }
            textViewScoreArray[mainActivityViewModel.mScores.activeTarget].setBackgroundColor(
                getResources().getColor(
                    R.color.highlight
                )
            )

            textViewTotalVal.setText(mainActivityViewModel.mScores.totalScore.toString())
            Log.d(TAG, "1 setInitialDisplay activeTarget = " + mainActivityViewModel.mScores.activeTarget)
            // get 12 count from array and update ui
            tVscr0.setText(mainActivityViewModel.mScores.twelveCount().toString())
            // Avoid getting index out of bounds
            if (mainActivityViewModel.mScores.activeTarget <= mainActivityViewModel.mScores.scores.size - 1) {
                Log.d(
                    TAG,
                    "2 setInitialDisplay mainActivityViewModel.activeTarget = " + mainActivityViewModel.mScores.activeTarget
                )
                textViewTargetVal.setText(mainActivityViewModel.mScores.activeTarget.toString())
                activeTargetHighlight(mainActivityViewModel.mScores.activeTarget)
            }
        }

    }

    /**
     * @param int Position of score textview in array
     * highlight selected textview
     * change Target number to selected
     */
    fun textViewOnClick(position: Int) {
        //activeTarget = position
        mainActivityViewModel.mScores.activeTarget = position
        activeTargetHighlight(position)
        textViewTargetVal.setText(position.toString())
    }


}
