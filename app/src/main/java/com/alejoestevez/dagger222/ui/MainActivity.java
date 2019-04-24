package com.alejoestevez.dagger222.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.alejoestevez.dagger222.R;

import dagger.android.AndroidInjection;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //Inyectamos la activity en la implementación de AndroidInjection que se encuentra en la aplicación.
        //AndroidInjector<Activity> activityInjector()...
        AndroidInjection.inject(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
