package com.example.hondanaoyuki.progressbarapp

import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity()  {

    var mTask : SampleAsyncTask ?= null;

    var intValues : Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myProgressBar = findViewById<ProgressBar>(R.id.progressbar)
        myProgressBar.setMax(100);

        val myprogress = MyProgressBar(this);
        myprogress.setProgress(10);

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener{
            intValues += 10;
            val myProgressBar = findViewById<ProgressBar>(R.id.progressbar)
            myProgressBar.setProgress(intValues);
            mTask = SampleAsyncTask(this);
            mTask?.execute("param");

        }
    }

}