package ru.mirea.lyulcheva.tripmate;
import android.util.Log;

import android.app.Application;
import com.google.firebase.FirebaseApp;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("MyApp", "MyApplication.onCreate called!");
        FirebaseApp.initializeApp(this);
    }
}