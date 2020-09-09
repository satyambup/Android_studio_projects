package com.example.a17thdecember1stproject;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener {
    TextView tv;
    GestureDetector gd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.textveiw);
        gd = new GestureDetector(this, this);
        gd.setOnDoubleTapListener(this);


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gd.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {

        tv.setText("single click");
        Toast.makeText(getApplicationContext(), "single click", Toast.LENGTH_LONG).show();
        return false;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        tv.setText("double click event");
        Toast.makeText(getApplicationContext(), "double click event", Toast.LENGTH_LONG).show();
        return false;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        tv.setText("motion event");
        Toast.makeText(getApplicationContext(), "motion event", Toast.LENGTH_LONG).show();
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {


    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        tv.setText("press long");
        Toast.makeText(getApplicationContext(), "press long", Toast.LENGTH_LONG).show();


    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float X, float Y) {
        if (e2.getX() - e1.getX() > 50)
            Toast.makeText(getApplicationContext(), "swipe right", Toast.LENGTH_LONG).show();
        if (e1.getX() - e2.getX() > 50)
            Toast.makeText(getApplicationContext(), "swipe left", Toast.LENGTH_LONG).show();
        if (e2.getY() - e1.getY() > 50)
            Toast.makeText(getApplicationContext(), "swipe down", Toast.LENGTH_LONG).show();
        if (e1.getY() - e2.getY() > 50)
            Toast.makeText(getApplicationContext(), "SWIPE UP", Toast.LENGTH_LONG).show();
        return false;

    }

}






