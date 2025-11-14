package ru.mirea.lyulcheva.fragmentapp.presentation;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import ru.mirea.lyulcheva.fragmentapp.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {

            Bundle args = new Bundle();
            args.putInt("my_number_student", 10);

            BlankFragment fragment = new BlankFragment();

            fragment.setArguments(args);

            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.setReorderingAllowed(true);
            ft.add(R.id.fragment_container, fragment);
            ft.commit();
        }
    }
}
