package com.example.proj_mad_sheet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    Button button;
    TextView text_View1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=(Button) findViewById(R.id.button);
        text_View1=(TextView) findViewById(R.id.textView);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String text = "";
                try{
                    InputStream inputStream;
                    inputStream = getAssets().open("project_MAD.csv");
                    int size=inputStream.available();
                    byte[] buffer=new byte[size];
                    inputStream.read(buffer);
                    inputStream.close();
                    text=new String(buffer);


                }catch (IOException ex){

                    ex.printStackTrace();
                }
                text_View1.setText(text);


            }
        });


    }
}

