package com.example.cat221stjanuaryswitchapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.net.wifi.WifiManager;
import android.net.wifi.aware.WifiAwareManager;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Switch aSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        aSwitch=(Switch)findViewById(R.id.switch1);
        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {
                if (b==true)
                {
                    //Toast.makeText(getApplicationContext(),"on",Toast.LENGTH_LONG).show();
                    WifiManager wifiManager=(WifiManager)getSystemService(getApplicationContext().WIFI_SERVICE);
                    wifiManager.setWifiEnabled(true);
                }
                else
                {
                    //Toast.makeText(getApplicationContext(), "off", Toast.LENGTH_LONG).show();
                    WifiManager wifiManager=(WifiManager)getSystemService(getApplicationContext().WIFI_SERVICE);
                    wifiManager.setWifiEnabled(false);
                }
            }
        });
    }
}
