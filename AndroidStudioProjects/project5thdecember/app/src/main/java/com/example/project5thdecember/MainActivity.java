package com.example.project5thdecember;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView TextView;
    Button button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=(Button)findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText et1, et2;
                et1=(EditText)findViewById(R.id.editText);
                et2=(EditText)findViewById(R.id.editText2);

                TextView= findViewById(R.id.textView3);
                int x =Integer.parseInt(et1.getText().toString());
                int y =Integer.parseInt((et2.getText().toString()));
                int sum = x+y;
                TextView.setText("sum="+Integer.toString(sum));
                Toast toast = Toast.makeText(getApplicationContext(),"sum="+Integer.toString(sum), Toast.LENGTH_LONG);
                toast.show();

            }
        });

        button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText et1, et2;
                et1=(EditText)findViewById(R.id.editText);
                et2=(EditText)findViewById(R.id.editText2);


                et1.setText("0");
                et2.setText("0");

            }
        });
    }

  /*  public void onsubmit(View view)
    {
        EditText et1, et2;
        et1=(EditText)findViewById(R.id.editText);
        et2=(EditText)findViewById(R.id.editText2);

        TextView= findViewById(R.id.textView3);
        int x =Integer.parseInt(et1.getText().toString());
        int y =Integer.parseInt((et2.getText().toString()));
        int sum = x+y;
        TextView.setText("sum="+Integer.toString(sum));
        Toast toast = Toast.makeText(getApplicationContext(),"sum="+Integer.toString(sum), Toast.LENGTH_LONG);
        toast.show();

    }
*/

}