package com.example.a17thdecember2ndproject;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private RadioGroup rg;
    private RadioButton rgd;
    private Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rg=(RadioGroup)findViewById(R.id.radio);
        b=(Button)findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int selected_id= rg.getCheckedRadioButtonId();
                        rgd=(RadioButton)findViewById(selected_id);
                        Toast.makeText(MainActivity.this,rgd.getText().toString(),Toast.LENGTH_LONG).show();
                    }
                });


    }


}
