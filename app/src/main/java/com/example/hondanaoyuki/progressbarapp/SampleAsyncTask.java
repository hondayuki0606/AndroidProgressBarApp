package com.example.hondanaoyuki.progressbarapp;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Button;

// AsyncTaskのサブクラス
public class SampleAsyncTask extends AsyncTask<String, Integer, Long> {

    Context mContext;
    ProgressDialog mDialog = null;

    final String TAG = "SampleAsyncTask";
    ProgressDialog dialog;

    public SampleAsyncTask(Context context){
        this.mContext = context;
    }

    // バックグラウンド処理の前に実行される処理
    @Override
    protected void onPreExecute() {
        // TODO Auto-generated method stub
        Log.v("AsyncTask", "onPreExecute");
        // Progress Dialogの表示
        mDialog = new ProgressDialog(mContext);
        mDialog.setTitle("しばらくお待ちください");
        mDialog.setMessage("非同期処理テスト中....");
        mDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        mDialog.setMax(100);
        mDialog.setProgress(0);
        mDialog.show();
    }

    // バックグラウンド処理
    @Override
    protected Long doInBackground(String... params) {
        // TODO Auto-generated method stub
        Log.v("AsyncTask", "doInBackground");
        try {
            for (int i=0; i<10; i++) {
                Thread.sleep(1000);
                // 進捗更新
                publishProgress((i+1)*10);
            }
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return 100L;
    }

    // バックグラウンド処理完了後に実行される処理
    @Override
    protected void onPostExecute(Long result) {
        // TODO Auto-generated method stub
        Log.v("AsyncTask", "onPostExecute");
        mDialog.dismiss();
    }

    // 更新処理
    @Override
    protected void onProgressUpdate(Integer... values) {
        // TODO Auto-generated method stub
        mDialog.setProgress(values[0]);
    }
}