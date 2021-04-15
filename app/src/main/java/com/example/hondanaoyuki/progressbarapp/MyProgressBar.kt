package com.example.hondanaoyuki.progressbarapp

import android.content.Context
import android.widget.ProgressBar

class MyProgressBar(context: Context?) : ProgressBar(context) {

    override fun setProgress(progress: Int) {
        super.setProgress(progress)
        if (progress == this.max) {
            //Do stuff when progress is max
        }
    }
}