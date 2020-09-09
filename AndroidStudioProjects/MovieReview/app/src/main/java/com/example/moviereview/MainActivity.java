package com.example.moviereview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    TextView verifymessage, verifybutton;
    FirebaseAuth fauth;

    Button review_btn, add_btn;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fauth=FirebaseAuth.getInstance();

        verifymessage=findViewById(R.id.verifymsg);
        verifybutton=findViewById(R.id.verifybtn);

        review_btn=findViewById(R.id.review_movie);
        add_btn=findViewById(R.id.add_movie);

        review_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent r=getPackageManager().getLaunchIntentForPackage("com.example.reveiwyourmovies");
                startActivity(r);
            }
        });

        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent t=getPackageManager().getLaunchIntentForPackage("com.example.addinganewmovie");
                startActivity(t);
            }
        });

        final FirebaseUser user = fauth.getCurrentUser();

        if (!user.isEmailVerified()) {
            verifymessage.setVisibility(View.VISIBLE);
            verifybutton.setVisibility(View.VISIBLE);

            verifybutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View v) {
                    user.sendEmailVerification().addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(v.getContext(), "Verification Email Has Been Sent", Toast.LENGTH_SHORT).show();

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.d("tag", " OnFailure: Email Not Sent" + e.getMessage());
                        }
                    });
                }
            });
        } else {
            return;
        }


    }

    public void logout (View view){
        FirebaseAuth.getInstance().signOut();//logout
        startActivity(new Intent(getApplicationContext(),Loginactivity.class));
        finish();
    }
}
