package com.example.exercicio5asynctask;

import android.os.AsyncTask;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;


public class ContarTask extends AsyncTask <Integer, Integer, Void>{

    Button btnContar;
    TextView txtContar;
    TextView txtStatus;


    public ContarTask(Button btnContar,TextView txtContar, TextView txtStatus) {
        this.btnContar = btnContar;
        this.txtContar = txtContar;
        this.txtStatus = txtStatus;


    }

    @Override
    protected void onPreExecute() {
        btnContar.setEnabled(false);

    }

    @Override
    protected void onPostExecute(Void unused) {
        btnContar.setEnabled(true);
        txtStatus.setText(R.string.finalizado);

    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        int p = values[0];
        super.onProgressUpdate(values);
        txtStatus.setText(R.string.contando);
        txtContar.setText(String.valueOf(p));

    }

    protected Void doInBackground(Integer... integers) {
        int min = integers[0];
        for (int i = 10; i >=min ; i--) {
            SystemClock.sleep(1000);
            publishProgress(i);
        }

        return null;
    }
}
