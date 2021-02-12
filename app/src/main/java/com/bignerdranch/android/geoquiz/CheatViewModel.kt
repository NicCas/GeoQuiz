package com.bignerdranch.android.geoquiz

import android.app.Activity
import android.content.Intent
import android.util.Log
import androidx.lifecycle.ViewModel

private const val TAG = "CheatViewModel"

class CheatViewModel : ViewModel() {

    init {
        Log.d(TAG, "ViewModel instance created")
    }

    override fun onCleared() {
        super.onCleared()
        Log.d(TAG, "ViewModel instance about to be destroyed")
    }

}