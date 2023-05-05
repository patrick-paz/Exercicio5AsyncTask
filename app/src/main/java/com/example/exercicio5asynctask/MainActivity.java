package com.example.exercicio5asynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private Button btnContar;
    private TextView txtStatus;
    private TextView txtContar;
    private ProgressBar pgbProgresso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnContar = findViewById(R.id.btnContar);
        txtStatus = findViewById(R.id.txtStatus);
        txtContar = findViewById(R.id.txtContar);
        pgbProgresso = findViewById(R.id.pgbProgresso);

        btnContar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        ContarTask task = new ContarTask(btnContar, txtContar, txtStatus);

        task.execute(0);

    }
}