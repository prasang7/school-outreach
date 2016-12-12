package com.schooloutreach.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import com.schooloutreach.R;

/**
 * Created by prasang7 on 12/12/16.
 */
public class FirstPage extends Activity {

    AutoCompleteTextView actv_schoolSuggestions;
    Button bt_proceed;
    String[] schoolNames = {"School1", "School2", "School3", "School4"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        init();

        if (isInternetOn()) {
            getSchoolsFromServer();
        }
        else {
            noInternetConnectionPrompt();
        }

        bt_proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validSchool()) {
                    startActivity(new Intent(FirstPage.this, Profile.class));
                }
            }
        });
    }

    // Setting up Basic UI elements
    void init() {
        setContentView(R.layout.activity_firstpage);
        bt_proceed = (Button)findViewById(R.id.bt_firstPage_proceed);
        actv_schoolSuggestions = (AutoCompleteTextView)findViewById(R.id.actv_schoolNames);
    }

    // Get list of schools from server
    void getSchoolsFromServer(){

        /* code to fetch schools name from server!
        *
        *
        *
        *
        *
        */
        setAdapter();
    }

    void setAdapter() {
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,schoolNames);
        actv_schoolSuggestions.setAdapter(adapter);
        actv_schoolSuggestions.setThreshold(1);
    }

    boolean validSchool() {
        return true;
    }

    void noInternetConnectionPrompt() {
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(FirstPage.this);
        alertDialog.setTitle("No Internet Connection!");
        alertDialog.setMessage("Please connect to a working internet connection.");
        alertDialog.setCancelable(false);
        alertDialog.setPositiveButton("Retry", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                if (isInternetOn()) {
                    alertDialog.show().hide();
                    getSchoolsFromServer();
                }
                else {
                    alertDialog.show();
                }
            }
        });
        alertDialog.show();
    }

    public final boolean isInternetOn() {
        // get Connectivity Manager object to check connection
        ConnectivityManager connec = (ConnectivityManager)getSystemService(getBaseContext().CONNECTIVITY_SERVICE);

        // Check for network connections
        if ( connec.getNetworkInfo(0).getState() == android.net.NetworkInfo.State.CONNECTED ||
                connec.getNetworkInfo(0).getState() == android.net.NetworkInfo.State.CONNECTING ||
                connec.getNetworkInfo(1).getState() == android.net.NetworkInfo.State.CONNECTING ||
                connec.getNetworkInfo(1).getState() == android.net.NetworkInfo.State.CONNECTED ) {
            return true;
        }
        else if (connec.getNetworkInfo(0).getState() == android.net.NetworkInfo.State.DISCONNECTED ||
                        connec.getNetworkInfo(1).getState() == android.net.NetworkInfo.State.DISCONNECTED  ) {
            return false;
        }
        return false;
    }

}
