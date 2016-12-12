package com.schooloutreach.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.schooloutreach.R;

/**
 * Created by prasang7 on 12/12/16.
 */
public class Profile extends AppCompatActivity {

    Button bt_school, bt_teacher, bt_student, bt_proceed;
    int choice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        init();

        bt_school.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bt_school.setBackground(getDrawable(R.drawable.custom_button_green));
                bt_teacher.setBackground(getDrawable(R.drawable.custom_button_green_hollow));
                bt_student.setBackground(getDrawable(R.drawable.custom_button_green_hollow));
                choice = 1;
            }
        });

        bt_teacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bt_school.setBackground(getDrawable(R.drawable.custom_button_green_hollow));
                bt_teacher.setBackground(getDrawable(R.drawable.custom_button_green));
                bt_student.setBackground(getDrawable(R.drawable.custom_button_green_hollow));
                choice = 2;
            }
        });

        bt_student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bt_school.setBackground(getDrawable(R.drawable.custom_button_green_hollow));
                bt_teacher.setBackground(getDrawable(R.drawable.custom_button_green_hollow));
                bt_student.setBackground(getDrawable(R.drawable.custom_button_green));
                choice = 3;
            }
        });

        bt_proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (choice == 0) {
                    Toast.makeText(Profile.this, "Please select a profile!", Toast.LENGTH_SHORT).show();
                }
                else if (choice == 1) {
                    startActivity(new Intent(Profile.this, LoginSchool.class));
                }
                else if (choice == 2) {
                    startActivity(new Intent(Profile.this, LoginTeacher.class));
                }
                else if(choice == 3) {

                }
            }
        });
    }

    void init() {
        setContentView(R.layout.activity_profile);
        bt_school = (Button)findViewById(R.id.bt_profile_schoolAuth);
        bt_teacher = (Button)findViewById(R.id.bt_profile_teacher);
        bt_student = (Button)findViewById(R.id.bt_profile_student);
        bt_proceed = (Button)findViewById(R.id.bt_profile_proceed);
        choice = 0;
    }
}
