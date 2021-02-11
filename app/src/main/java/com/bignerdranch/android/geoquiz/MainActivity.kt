package com.bignerdranch.android.geoquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

//Store info for rotation
private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    //Declare Buttons and Text
    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    private lateinit var nextButton: Button
    private lateinit var questionTextView: TextView

    //Declare Buttons
    private val questionBank = listOf(
            Question(R.string.question_australia, true),
            Question(R.string.question_oceans, true),
            Question(R.string.question_mideast, false),
            Question(R.string.question_africa, false),
            Question(R.string.question_americas, true),
            Question(R.string.question_asia, true))

    //Question number
    private var currentIndex = 0

    //Main
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Store info for rotate
        Log.d(TAG, "onCreate(Bundle?) called")
        setContentView(R.layout.activity_main)

        //Find ID of buttons and text
        trueButton = findViewById(R.id.true_button)
        falseButton = findViewById(R.id.false_button)
        nextButton = findViewById(R.id.next_button)
        questionTextView = findViewById(R.id.question_text_view)

        //Define action of True Button when clicked
        trueButton.setOnClickListener { view: View ->
            checkAnswer(true)
        }

        //Define action of False Button when clicked
        falseButton.setOnClickListener { view: View ->
            checkAnswer(false)
        }

        //Define action of Next Button when clicked
        nextButton.setOnClickListener {
            currentIndex = (currentIndex + 1) % questionBank.size
            updateQuestion()
        }
    }

    //OVERRIDE LIFECYCLE FUNCTIONS TO PREVENT ROTATION ISSUES

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart() called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume() called")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause() called")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop() called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy() called")
    }

    //Function to update Question text
    private fun updateQuestion() {
        val questionTextResId = questionBank[currentIndex].textResId
        questionTextView.setText(questionTextResId)
    }

    //Check set answer to Question
    private fun checkAnswer(userAnswer: Boolean) {
        val correctAnswer = questionBank[currentIndex].answer

        val messageResId = if (userAnswer == correctAnswer) {
            R.string.correct_toast
        } else {
            R.string.incorrect_toast
        }

        Toast.makeText(
                this,
                messageResId,
                Toast.LENGTH_SHORT)
                .apply {
                    setGravity(Gravity.TOP, 0, 225);
                    show()
                }
    }
}
