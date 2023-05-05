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
    ProgressBar pgbProgresso;


    public ContarTask(Button btnContar,TextView txtContar, TextView txtStatus, ProgressBar pgbProgresso) {
        this.btnContar = btnContar;
        this.txtContar = txtContar;
        this.txtStatus = txtStatus;
        this.pgbProgresso = pgbProgresso;

    }

    @Override
    protected void onPreExecute() {
        btnContar.setEnabled(false);
        txtContar.setText(R.string.num);
        txtStatus.setText(R.string.contando);
        pgbProgresso.setProgress(0);
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
        txtContar.setText(p);
        pgbProgresso.setProgress(p);
    }

    protected Void doInBackground(Integer... integers) {
        int max = integers[0];
        for (int i = 10; i <=max ; i--) {
            SystemClock.sleep(1000);
            publishProgress(i);
        }

        return null;
    }
}
