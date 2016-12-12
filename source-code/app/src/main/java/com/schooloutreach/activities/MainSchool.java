package com.schooloutreach.activities;

import android.app.Activity;
import android.os.Bundle;

import com.schooloutreach.R;

/**
 * Created by prasang7 on 12/12/16.
 */
public class MainSchool extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        init();
    }

    void init() {
        setContentView(R.layout.activity_main_school);
    }
}

