package com.example.listviewbasic;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Main2Activity extends AppCompatActivity {
    TextView txtTen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        anhXa();
        Bundle bundle = getIntent().getExtras();
        if(bundle != null) txtTen.setText(bundle.getString("dl", "sai key"));
    }
    void anhXa(){
        txtTen = findViewById(R.id.txtTen);
    }
}
