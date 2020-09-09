package com.example.module212december2ndproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private CheckBox c1,c2,c3,c4;
    private Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b=(Button)findViewById(R.id.button);

        c1=(CheckBox)findViewById(R.id.checkBox);
        c2=(CheckBox)findViewById((R.id.checkBox2));
        c3=(CheckBox)findViewById((R.id.checkBox3));
        c4=(CheckBox)findViewById(R.id.checkBox4);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (c1.isChecked()) {

                    Toast toast
                }
            }
        });



    }
}
