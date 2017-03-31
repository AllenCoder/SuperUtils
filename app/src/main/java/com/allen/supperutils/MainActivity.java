package com.allen.supperutils;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("---" ,"onCreate: "+this.getFilesDir().getPath());
        Log.d("---" ,"onCreate: "+this.getDatabasePath("").getAbsolutePath());
    }
}
