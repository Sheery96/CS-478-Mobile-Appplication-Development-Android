package com.example.project1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button address;
    private Button map;
    final int Request_Code = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        address = findViewById(R.id.button);
        address.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this,Second_Activity.class);
                startActivityForResult(i,Request_Code);


            }


        });


    }


    @Override

    protected void onActivityResult(int request_code, int result_code, Intent data)
    {
        if( request_code == 10 &&  result_code == Activity.RESULT_OK)
        {
            final String res = data.getStringExtra("ADDRESS");

            map = findViewById(R.id.button1);
            map.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {

                    Uri map = Uri.parse("Hamza Amjad");
                    Intent map_intent = new Intent(Intent.ACTION_VIEW,map);
                    startActivity(map_intent);
                }


            });


        }

        else
        {

            map = findViewById(R.id.button1);
            map.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {

                    Toast.makeText(MainActivity.this,"Error: Failed to enter the address",Toast.LENGTH_LONG).show();

                }


            });


        }

    }

}
