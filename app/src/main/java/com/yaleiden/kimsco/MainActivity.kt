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
    private lateinit var buttonArray: Array<Button>  // Score buttons
    private val tag = "MainActivity"

    private lateinit var textViewTargetVal: TextView  // Shows active target number
    private lateinit var textViewTotalVal: TextView  // Shows total score
    private lateinit var textViewScoreArray: Array<TextView>  // Holds score boxes

    //  Score boxes
    private lateinit var tVscr0: TextView
    private lateinit var tVscr1: TextView
    private lateinit var tVscr2: TextView
    private lateinit var tVscr3: TextView
    private lateinit var tVscr4: TextView
    private lateinit var tVscr5: TextView
    private lateinit var tVscr6: TextView
    private lateinit var tVscr7: TextView
    private lateinit var tVscr8: TextView
    private lateinit var tVscr9: TextView
    private lateinit var tVscr10: TextView
    private lateinit var tVscr11: TextView
    private lateinit var tVscr12: TextView
    private lateinit var tVscr13: TextView
    private lateinit var tVscr14: TextView
    private lateinit var tVscr15: TextView
    private lateinit var tVscr16: TextView
    private lateinit var tVscr17: TextView
    private lateinit var tVscr18: TextView
    private lateinit var tVscr19: TextView
    private lateinit var tVscr20: TextView
    private lateinit var tVscr21: TextView
    private lateinit var tVscr22: TextView
    private lateinit var tVscr23: TextView
    private lateinit var tVscr24: TextView
    private lateinit var tVscr25: TextView
    private lateinit var tVscr26: TextView
    private lateinit var tVscr27: TextView
    private lateinit var tVscr28: TextView
    private lateinit var tVscr29: TextView
    private lateinit var tVscr30: TextView

    //  bonus count box
    private lateinit var tVscr01: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        // Hide actionbar in landscape mode - it messes up the layout
        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            getActionBar()?.hide()
        }

        // Initialize textviews for Total and Active Target
        textViewTargetVal = findViewById(R.id.textViewTargetVal)
        textViewTotalVal = findViewById(R.id.textViewTotalVal)
        // Initialize scoring buttons
        val button1 = findViewById<Button>(R.id.button1)
        val button2 = findViewById<Button>(R.id.button2)
        val button3 = findViewById<Button>(R.id.button3)
        val button4 = findViewById<Button>(R.id.button4)
        val button5 = findViewById<Button>(R.id.button5)
        val button6 = findViewById<Button>(R.id.button6)
        //  Initialize individual target value textviews
        tVscr0 = findViewById(R.id.tVscr0)  // textview for 12 count
        tVscr1 = findViewById(R.id.tVscr1)  // textview for target number 1
        tVscr2 = findViewById(R.id.tVscr2)
        tVscr3 = findViewById(R.id.tVscr3)
        tVscr4 = findViewById(R.id.tVscr4)
        tVscr5 = findViewById(R.id.tVscr5)
        tVscr6 = findViewById(R.id.tVscr6)
        tVscr7 = findViewById(R.id.tVscr7)
        tVscr8 = findViewById(R.id.tVscr8)
        tVscr9 = findViewById(R.id.tVscr9)
        tVscr10 = findViewById(R.id.tVscr10)
        tVscr11 = findViewById(R.id.tVscr11)
        tVscr12 = findViewById(R.id.tVscr12)
        tVscr13 = findViewById(R.id.tVscr13)
        tVscr14 = findViewById(R.id.tVscr14)
        tVscr15 = findViewById(R.id.tVscr15)
        tVscr16 = findViewById(R.id.tVscr16)
        tVscr17 = findViewById(R.id.tVscr17)
        tVscr18 = findViewById(R.id.tVscr18)
        tVscr19 = findViewById(R.id.tVscr19)
        tVscr20 = findViewById(R.id.tVscr20)
        tVscr21 = findViewById(R.id.tVscr21)
        tVscr22 = findViewById(R.id.tVscr22)
        tVscr23 = findViewById(R.id.tVscr23)
        tVscr24 = findViewById(R.id.tVscr24)
        tVscr25 = findViewById(R.id.tVscr25)
        tVscr26 = findViewById(R.id.tVscr26)
        tVscr27 = findViewById(R.id.tVscr27)
        tVscr28 = findViewById(R.id.tVscr28)
        tVscr29 = findViewById(R.id.tVscr29)
        tVscr30 = findViewById(R.id.tVscr30)

        // Initialize bonus count
        tVscr01 = findViewById(R.id.tVscr01)

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

        textViewTargetVal.text = mainActivityViewModel.mScores.activeTarget.toString()

        textViewTotalVal.text = mainActivityViewModel.mScores.totalScore.toString()
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

    private fun startVegas(){
        startActivity(Intent(this@MainActivity,VegasActivity::class.java))
    }

    /**
     * Set the values displayed on the UI score buttons to the values in the scoreArray
     */
    private fun setButtons(buttonArray: Array<Button>, intArray: IntArray) {

        for (i in buttonArray.indices) {
            if (i < intArray.size) {
                // Set scoreArray value as text on button
                buttonArray[i].text = intArray[i].toString()
                // Set stringArray value as text on button
                buttonArray[i].text = intArray[i].toString()
                // Set addScore() as onClick() function
                buttonArray[i].setOnClickListener {
                    addScore(intArray[i])
                }
            } else {
                // Remove button if we don't have a value for it
                buttonArray[i].visibility = View.INVISIBLE
            }
        }

    }

    /**
     * set the onClick function for score textviews
     */
    private fun setScoreTextViews(textViewArray: Array<TextView>) {

        for (i in 1 until mainActivityViewModel.mScores.scores.size) {

            textViewArray[i].setOnClickListener {
                textViewOnClick(i)
            }
        }

    }

    /**
     * @param int: The number of the active target
     *         Changes background color of textview
     */
    private fun activeTargetHighlight(target: Int) {

        if (mainActivityViewModel.mScores.activeTarget <= mainActivityViewModel.mScores.scores.size - 1) {

            for (i in 1 until mainActivityViewModel.mScores.scores.size) {
                textViewScoreArray[i].setBackgroundResource(R.drawable.score_bkg_dark)
                if (i <= 5) {
                    textViewScoreArray[i].setBackgroundResource(R.drawable.score_bkg_light)
                }
                if (i in 16..20) {
                    textViewScoreArray[i].setBackgroundResource(R.drawable.score_bkg_light)
                }
                if (i in 21..25) {
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
            textViewScoreArray[mainActivityViewModel.mScores.activeTarget].text = score.toString()
            //activeTarget += 1 //Increment target count
            mainActivityViewModel.mScores.activeTarget += 1 //Increment target count
            setDisplayAfterScore()
            Log.d(tag, "mainActivityViewModel.totalScore = " + mainActivityViewModel.mScores.totalScore)
            Log.d(tag, "mainActivityViewModel.totalScore() = " + mainActivityViewModel.totalScore())
        } else {
            Toast.makeText(this, "30 targets scored", Toast.LENGTH_SHORT).show()
            Log.d(tag, "addScore Toast.makeText")
        }
    }

    /**
     * AlertDialog before clearing scores and reset UI
     */
    private fun clearScores() {

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
    private fun setDisplayAfterScore() {
        textViewTotalVal.text = mainActivityViewModel.mScores.totalScore.toString()
        Log.d(tag, "1 setDisplayAfterScore activeTarget = " + mainActivityViewModel.mScores.activeTarget)
        // get 12 count from array and update ui
        tVscr0.text = mainActivityViewModel.twelveCount().toString()
        // Avoid getting index out of bounds
        if (mainActivityViewModel.mScores.activeTarget > mainActivityViewModel.mScores.scores.size - 1){
            Toast.makeText(this, "30 targets scored", Toast.LENGTH_SHORT).show()
            mainActivityViewModel.mScores.activeTarget = mainActivityViewModel.mScores.scores.size - 1
        }
        if (mainActivityViewModel.mScores.activeTarget <= mainActivityViewModel.mScores.scores.size - 1) {
            Log.d(
                tag,
                "2 setDisplayAfterScore mainActivityViewModel.activeTarget = " + mainActivityViewModel.mScores.activeTarget
            )
            //activeTargetHighlight(activeTarget)
            textViewTargetVal.text = mainActivityViewModel.mScores.activeTarget.toString()
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

            for (i in 1 until mainActivityViewModel.mScores.scores.size) {
                 var text = ""
                 if (mainActivityViewModel.mScores.scores[i] != null) {
                     text = mainActivityViewModel.mScores.scores[i].toString()
                 }
                textViewScoreArray[i].text = text
            }
            textViewScoreArray[mainActivityViewModel.mScores.activeTarget].setBackgroundColor(
                ContextCompat.getColor(applicationContext,
                    R.color.highlight
                )
            )

            textViewTotalVal.text = mainActivityViewModel.mScores.totalScore.toString()
            Log.d(tag, "1 setInitialDisplay activeTarget = " + mainActivityViewModel.mScores.activeTarget)
            // get 12 count from array and update ui
            tVscr0.text = mainActivityViewModel.mScores.twelveCount().toString()
            // Avoid getting index out of bounds
            if (mainActivityViewModel.mScores.activeTarget <= mainActivityViewModel.mScores.scores.size - 1) {
                Log.d(
                    tag,
                    "2 setInitialDisplay mainActivityViewModel.activeTarget = " + mainActivityViewModel.mScores.activeTarget
                )
                textViewTargetVal.text = mainActivityViewModel.mScores.activeTarget.toString()
                activeTargetHighlight(mainActivityViewModel.mScores.activeTarget)
            }
        }

    }

    /**
     * @param int Position of score textview in array
     * highlight selected textview
     * change Target number to selected
     */
    private fun textViewOnClick(position: Int) {
        //activeTarget = position
        mainActivityViewModel.mScores.activeTarget = position
        activeTargetHighlight(position)
        textViewTargetVal.text = position.toString()
    }


}
