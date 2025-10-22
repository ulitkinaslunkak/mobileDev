package ru.mirea.lyulcheva.tripmate.presentation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import ru.mirea.lyulcheva.tripmate.R;
import ru.mirea.lyulcheva.data.repository.ClientPreferencesRepository;

public class AuthActivity extends AppCompatActivity {

    private AuthViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        EditText email = findViewById(R.id.editEmail);
        EditText password = findViewById(R.id.editPassword);
        Button btnLogin = findViewById(R.id.btnLogin);
        Button btnRegister = findViewById(R.id.btnRegister);
        TextView tvStatus = findViewById(R.id.tvStatus);

        ClientPreferencesRepository prefs = new ClientPreferencesRepository(this);

        viewModel = new ViewModelProvider(this, new ViewModelProvider.Factory() {
            @Override
            public <T extends androidx.lifecycle.ViewModel> T create(Class<T> modelClass) {
                return (T) new AuthViewModel(prefs);
            }
        }).get(AuthViewModel.class);

        viewModel.getStatus().observe(this, status -> tvStatus.setText(status));

        btnLogin.setOnClickListener(v -> {
            String userEmail = email.getText().toString();
            String userPassword = password.getText().toString();
            viewModel.login(userEmail, userPassword);
        });

        btnRegister.setOnClickListener(v -> {
            String userEmail = email.getText().toString();
            String userPassword = password.getText().toString();
            viewModel.register(userEmail, userPassword);
        });
    }
}
