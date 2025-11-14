package ru.mirea.lyulcheva.fragmentapp.presentation;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.widget.TextView;

import ru.mirea.lyulcheva.fragmentapp.R;

public class BlankFragment extends Fragment {

    public BlankFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        int numberStudent = requireArguments().getInt("my_number_student");
        TextView textView = view.findViewById(R.id.textNumberStudent);
        textView.setText("Мой номер по списку: " + numberStudent);
        Log.d("BlankFragment", "Я студент № " + numberStudent);
    }
}
