package com.example.hondanaoyuki.progressbarapp;

import android.content.Context;
import android.widget.ProgressBar;

public class MyProgressBar extends ProgressBar {
    public MyProgressBar(Context context) {
        super(context);
    }

    @Override
    public void setProgress(int progress)
    {
        super.setProgress(progress);
        if(progress == this.getMax())
        {
            //Do stuff when progress is max
        }
    }
}
