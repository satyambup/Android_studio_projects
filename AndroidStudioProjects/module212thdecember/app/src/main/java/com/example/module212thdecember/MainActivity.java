package com.example.module212thdecember;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button b;
    private CheckBox c1,c2,c3,c4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        b=(Button)findViewById(R.id.button);

        c1=(CheckBox)findViewById(R.id.checkBox);
        c2=(CheckBox)findViewById(R.id.checkBox2);
        c3=(CheckBox)findViewById(R.id.checkBox3);
        c4=(CheckBox)findViewById(R.id.checkBox4);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (c1.isChecked()) {
                    Toast.makeText(getApplicationContext(), c1.getText(), Toast.LENGTH_LONG).show();
                }

                if (c2.isChecked()) {
                    Toast.makeText(getApplicationContext(), c2.getText(), Toast.LENGTH_LONG).show();
                }

                if (c3.isChecked()) {
                    Toast.makeText(getApplicationContext(), c3.getText(), Toast.LENGTH_LONG).show();
                }

                if (c4.isChecked()) {
                    Toast.makeText(getApplicationContext(), c4.getText(), Toast.LENGTH_LONG).show();
                }

                if(c1.isChecked() && c2.isChecked())
                {
                    Toast.makeText(getApplicationContext(), c1.getText(), Toast.LENGTH_LONG).show();
                    Toast.makeText(getApplicationContext(), c2.getText(), Toast.LENGTH_LONG).show();
                }



            }



        });




    }


}
