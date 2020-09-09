package com.example.moviereviewer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class Registeractivity extends AppCompatActivity {
    EditText rfullname, remail, rpassword, rphone;
    Button rregisterbtn;
    FirebaseAuth fauth;
    ProgressBar progressBar;
    String userID;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeractivity);

        rfullname=findViewById(R.id.r_name);
        remail=findViewById(R.id.r_emailid);
        rpassword=findViewById(R.id.r_password);
        rphone=findViewById(R.id.r_phoneno);
        rregisterbtn=findViewById(R.id.r_register);

        fauth=FirebaseAuth.getInstance();
        progressBar=findViewById(R.id.progressBar1);

        if ((fauth.getCurrentUser() != null)){
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            finish();
        }

        rregisterbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = remail.getText().toString().trim();
                String password = rpassword.getText().toString().trim();
                final String fullName = rfullname.getText().toString();
                final String phone = rphone.getText().toString();

                if (TextUtils.isEmpty(email)) {
                    remail.setError("Email is Required.");
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    rpassword.setError("Password is Required.");
                    return;
                }

                if (password.length() < 6) {
                    rpassword.setError("Password Must be >= 6 Characters");
                    return;
                }


                progressBar.setVisibility(View.VISIBLE);


                // register the user in firebase
                fauth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(Registeractivity.this, "User Created.", Toast.LENGTH_SHORT).show();
                            userID = fauth.getCurrentUser().getUid();



                        }
                    }
                });



            }

        });



    }
}
