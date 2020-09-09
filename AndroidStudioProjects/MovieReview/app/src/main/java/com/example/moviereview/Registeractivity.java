package com.example.moviereview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Registeractivity extends AppCompatActivity {
    EditText rfullname, remail, rpassword, rphone;
    Button rregisterbtn;
    FirebaseAuth fauth;
    ProgressBar progressBar;
    String userID;
    TextView r_login;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeractivity);

        rfullname=findViewById(R.id.rname);
        remail=findViewById(R.id.remailid);
        rpassword=findViewById(R.id.rpassword);
        rphone=findViewById(R.id.rphoneno);
        rregisterbtn=findViewById(R.id.rregister);
        r_login=findViewById(R.id.rlogin);

        fauth=FirebaseAuth.getInstance();
        progressBar=findViewById(R.id.progressBar_1);

        if ((fauth.getCurrentUser() != null)){
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            finish();
        }


        rregisterbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = remail.getText().toString().trim();
                String password = rpassword.getText().toString().trim();
                //String fullName = rfullname.getText().toString();
                //String phone = rphone.getText().toString()

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

                fauth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {

                            FirebaseUser fuser =fauth.getCurrentUser();
                            fuser.sendEmailVerification().addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Toast.makeText(Registeractivity.this, "Verification Email Has Been Sent",Toast.LENGTH_SHORT).show();

                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                                        @Override
                                                        public void onFailure(@NonNull Exception e) {
                                                            Log.d("TAG", " OnFailure: Email Not Sent" + e.getMessage());


                                                        }
                                                    });


                                    Toast.makeText(Registeractivity.this, "User Created.", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));

                        }else{
                            Toast.makeText(Registeractivity.this, "ERROR !" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);
                        }

                    }

                });



            }

        });

        r_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Loginactivity.class));
            }
        });




    }
}
