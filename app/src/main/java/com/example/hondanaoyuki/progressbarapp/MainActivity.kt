package com.example.hondanaoyuki.progressbarapp

import android.app.ProgressDialog
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import com.example.hondanaoyuki.progressbarapp.SampleAsyncTask
import android.os.AsyncTask;
import android.util.Log;

class MainActivity : AppCompatActivity()  {

    var mContext : Context = this;
    var mDialog : ProgressDialog ?= null;
    var mTask : SampleAsyncTask ?= null;

    var intValues : Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myProgressBar = findViewById<ProgressBar>(R.id.progressbar)
        myProgressBar.setProgress(2);
        myProgressBar.setMax(100);

        val myprogress = MyProgressBar(this);
        myprogress.setProgress(10);

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener { v: View? ->
            intValues += 10;

            val myProgressBar = findViewById<ProgressBar>(R.id.progressbar)
            myProgressBar.setProgress(intValues);
            mTask = SampleAsyncTask(this);
            mTask?.execute("param");

//            myProgressBar.setMax(100);

            // セカンダリ値
//            myProgressBar.setSecondaryProgress(70);
        }
    }

}