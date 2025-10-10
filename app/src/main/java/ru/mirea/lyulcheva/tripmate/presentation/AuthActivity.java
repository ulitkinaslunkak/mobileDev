package ru.mirea.lyulcheva.tripmate.presentation;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import ru.mirea.lyulcheva.tripmate.R;
import ru.mirea.lyulcheva.data.repository.FirebaseAuthRepositoryImpl;
import ru.mirea.lyulcheva.domain.repository.AuthRepository;
import ru.mirea.lyulcheva.domain.usecases.LoginUserUseCase;
import ru.mirea.lyulcheva.domain.usecases.RegisterUserUseCase;
import ru.mirea.lyulcheva.data.repository.ClientPreferencesRepository;

public class AuthActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        EditText email = findViewById(R.id.editEmail);
        EditText password = findViewById(R.id.editPassword);
        Button btnLogin = findViewById(R.id.btnLogin);
        Button btnRegister = findViewById(R.id.btnRegister);
        TextView tvStatus = findViewById(R.id.tvStatus);

        AuthRepository repo = new FirebaseAuthRepositoryImpl();
        LoginUserUseCase loginUseCase = new LoginUserUseCase(repo);
        RegisterUserUseCase registerUseCase = new RegisterUserUseCase(repo);

        ClientPreferencesRepository prefs = new ClientPreferencesRepository(this);

        btnLogin.setOnClickListener(v -> {
            String userEmail = email.getText().toString();
            String userPassword = password.getText().toString();

            loginUseCase.execute(userEmail, userPassword, new AuthRepository.AuthCallback() {
                @Override
                public void onSuccess() {
                    prefs.saveClient(userEmail, userEmail);
                    tvStatus.setText("Успешный вход");
                }

                @Override
                public void onError(String message) {
                    tvStatus.setText("Ошибка входа: " + message);
                }
            });
        });

        btnRegister.setOnClickListener(v -> {
            String userEmail = email.getText().toString();
            String userPassword = password.getText().toString();

            registerUseCase.execute(userEmail, userPassword, new AuthRepository.AuthCallback() {
                @Override
                public void onSuccess() {
                    prefs.saveClient(userEmail, userEmail);
                    tvStatus.setText("Успешная регистрация");
                }

                @Override
                public void onError(String message) {
                    tvStatus.setText("Ошибка регистрации: " + message);
                }
            });
        });
    }
}
