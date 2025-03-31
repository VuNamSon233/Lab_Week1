package com.example.lab_week1;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    TextView received_info;
    Button btn;
    Intent myIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        received_info = findViewById(R.id.info);
        btn = findViewById(R.id.returnButton);
        myIntent = getIntent();
        String name_received = myIntent.getStringExtra("name");
        int id_received = myIntent.getIntExtra("id", 0);
        String class_received = myIntent.getStringExtra("class");
        String tel_received = myIntent.getStringExtra("tel");
        String year_received = myIntent.getStringExtra("year");
        String major_received = myIntent.getStringExtra("major");
        String plan_received = myIntent.getStringExtra("plan");
        received_info.setText("Họ và tên: " + name_received + "\n" +
                            "MSSV: " + id_received + "\n" +
                            "Lớp: " + class_received + "\n" +
                            "Số điện thoại" + tel_received + "\n" +
                            "Sinh viên năm: " + year_received + "\n" +
                            major_received + "\n" +
                            "Kế hoạch của bản thân: " + plan_received + "\n");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }




}