package com.example.hondanaoyuki.progressbarapp

import android.app.ProgressDialog
import android.content.Context
import android.os.AsyncTask
import android.util.Log

// AsyncTaskのサブクラス
class SampleAsyncTask(var mContext: Context) : AsyncTask<String?, Int?, Long>() {
    var mDialog: ProgressDialog? = null
    val TAG = "SampleAsyncTask"
    var dialog: ProgressDialog? = null

    // バックグラウンド処理の前に実行される処理
    override fun onPreExecute() {
        // TODO Auto-generated method stub
        Log.v("AsyncTask", "onPreExecute")
        // Progress Dialogの表示
        mDialog = ProgressDialog(mContext)
        mDialog!!.setTitle("しばらくお待ちください")
        mDialog!!.setMessage("非同期処理テスト中....")
        mDialog!!.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL)
        mDialog!!.max = 100
        mDialog!!.progress = 0
        mDialog!!.show()
    }


    // バックグラウンド処理
    override fun doInBackground(vararg params: String?): Long {
        // TODO Auto-generated method stub
        Log.v("AsyncTask", "doInBackground")
        try {
            for (i in 0..9) {
                Thread.sleep(1000)
                // 進捗更新
                publishProgress((i + 1) * 10)
            }
        } catch (e: InterruptedException) {
            // TODO Auto-generated catch block
            e.printStackTrace()
        }
        return 100L
    }


    // バックグラウンド処理完了後に実行される処理
    override fun onPostExecute(result: Long) {
        // TODO Auto-generated method stub
        Log.v("AsyncTask", "onPostExecute")
        mDialog!!.dismiss()
    }


    // 更新処理
    override fun onProgressUpdate(vararg values: Int?) {
        // TODO Auto-generated method stub
        mDialog!!.progress = values[0]!!
    }


}