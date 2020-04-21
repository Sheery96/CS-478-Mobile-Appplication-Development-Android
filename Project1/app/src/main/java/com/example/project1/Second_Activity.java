package com.example.project1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

public class Second_Activity extends AppCompatActivity {
        EditText editText;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        editText = findViewById(R.id.editText);


        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView arg1, int actionId, KeyEvent keyEvent) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {

                    if(editText.getText().toString().trim().isEmpty())
                    {

                        //Log.i("APP", "ERROR");
                        Intent r_intent = new Intent();
                        setResult(Activity.RESULT_CANCELED,r_intent);

                        finish();



                    }
                    else
                    {

                       // Log.i("APP", "OK");
                        Intent ret_intent = new Intent();
                        ret_intent.putExtra("ADDRESS",editText.getText().toString().trim());
                        setResult(Activity.RESULT_OK,ret_intent);
                        finish();



                    }

                }
                return false;
            }
        });
    }

}
