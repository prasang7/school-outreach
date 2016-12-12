package com.schooloutreach.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.schooloutreach.R;

/**
 * Created by prasang7 on 12/12/16.
 */
public class LoginTeacher extends AppCompatActivity {

    Button bt_login;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();

        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginTeacher.this, MainTeacher.class));
            }
        });
    }

    void init(){
        setContentView(R.layout.activity_login_teacher);
        bt_login = (Button)findViewById(R.id.bt_loginTeacher_login);
    }
}
