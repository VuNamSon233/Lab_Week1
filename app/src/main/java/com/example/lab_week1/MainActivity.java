package com.example.lab_week1;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {
    EditText name;
    EditText id;
    EditText class_num;
    EditText tel;
    Button submit_bt;
    RadioGroup year_select;
    CheckBox dt_check;
    CheckBox htn_check;
    CheckBox vt_check;
    EditText develop_plan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        name = findViewById(R.id.nameType);
        id = findViewById(R.id.idType);
        class_num = findViewById(R.id.classType);
        tel = findViewById(R.id.PhoneNumType);
        submit_bt = findViewById(R.id.submitButton);
        year_select = findViewById(R.id.yearradio);
        dt_check = findViewById(R.id.dtCheck);
        htn_check = findViewById(R.id.htnCheck);
        vt_check = findViewById(R.id.vtCheck);
        develop_plan = findViewById(R.id.planText);
        submit_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent second_activity = new Intent(MainActivity.this, com.example.lab_week1.SecondActivity.class);
                String name_received = name.getText().toString();
                int id_received = Integer.parseInt(id.getText().toString());
                String class_num_received = class_num.getText().toString();
                String tel_received = tel.getText().toString();
                String selected_year = "";
                String plan = develop_plan.getText().toString();
                int selected_id = year_select.getCheckedRadioButtonId();
                if (selected_id != -1) {
                    RadioButton selectedRadioButton = findViewById(selected_id);
                    selected_year = selectedRadioButton.getText().toString();
                }
                StringBuilder selected_major = new StringBuilder("Chuyên ngành:");
                if(dt_check.isChecked()) {
                    selected_major.append(" Điện tử,");
                }
                if(htn_check.isChecked()) {
                    selected_major.append(" Máy tính - Hệ thống nhúng,");
                }
                if(vt_check.isChecked()) {
                    selected_major.append(" Viễn thông - Mạng,");
                }
                second_activity.putExtra("name", name_received);
                second_activity.putExtra("id", id_received);
                second_activity.putExtra("class", class_num_received);
                second_activity.putExtra("tel", tel_received);
                second_activity.putExtra("year", selected_year);
                second_activity.putExtra("major", selected_major.toString());
                second_activity.putExtra("plan", plan);
                startActivity(second_activity);
            }

        });
    }
}