package com.example.android.navigationadvancedsample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
//        Log.d("Test", "${javaClass.simpleName} onCreate")
        super.onCreate(savedInstanceState)
    }

    override fun onStart() {
//        Log.d("Test", "${javaClass.simpleName} onStart")
        super.onStart()
    }

    override fun onResume() {
//        Log.d("Test", "${javaClass.simpleName} onResume")
        super.onResume()
    }

    override fun onPause() {
//        Log.d("Test", "${javaClass.simpleName} onPause")
        super.onPause()
    }

    override fun onRestart() {
//        Log.d("Test", "${javaClass.simpleName} onRestart")
        super.onRestart()
    }

    override fun onStop() {
//        Log.d("Test", "${javaClass.simpleName} onStop")
        super.onStop()
    }

    override fun onDestroy() {
//        Log.d("Test", "${javaClass.simpleName} onDestroy")
        super.onDestroy()
    }

    override fun onSaveInstanceState(outState: Bundle) {
//        Log.d("Test", "${javaClass.simpleName} onSaveInstanceState")
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
//        Log.d("Test", "${javaClass.simpleName} onRestoreInstanceState")
        if (savedInstanceState != null)
            super.onRestoreInstanceState(savedInstanceState)
    }
}