package com.schooloutreach.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.schooloutreach.R;

/**
 * Created by prasang7 on 12/12/16.
 */
public class LoginTeacher extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();

    }

    void init(){
        setContentView(R.layout.activity_login_teacher);
    }
}
