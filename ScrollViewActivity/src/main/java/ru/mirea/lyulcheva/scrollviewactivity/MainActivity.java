package ru.mirea.lyulcheva.scrollviewactivity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout wrapper = findViewById(R.id.wrapper);

        int value = 1;
        for (int i = 1; i <= 100; i++) {
            View view = getLayoutInflater().inflate(R.layout.item, wrapper, false);
            TextView text = view.findViewById(R.id.textView);
            text.setText("Элемент " + i + ": " + value);
            wrapper.addView(view);

            value *= 2;
        }
    }
}