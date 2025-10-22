package ru.mirea.lyulcheva.tripmate.presentation;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import ru.mirea.lyulcheva.data.repository.ClientPreferencesRepository;
import ru.mirea.lyulcheva.data.repository.FirebaseAuthRepositoryImpl;
import ru.mirea.lyulcheva.domain.repository.AuthRepository;
import ru.mirea.lyulcheva.domain.usecases.LoginUserUseCase;
import ru.mirea.lyulcheva.domain.usecases.RegisterUserUseCase;

public class AuthViewModel extends ViewModel {

    private final LoginUserUseCase loginUseCase;
    private final RegisterUserUseCase registerUseCase;
    private final ClientPreferencesRepository prefs;

    private final MutableLiveData<String> status = new MutableLiveData<>();
    private final Executor executor = Executors.newSingleThreadExecutor();

    public AuthViewModel(ClientPreferencesRepository prefs) {
        AuthRepository repo = new FirebaseAuthRepositoryImpl();
        this.loginUseCase = new LoginUserUseCase(repo);
        this.registerUseCase = new RegisterUserUseCase(repo);
        this.prefs = prefs;
    }

    public LiveData<String> getStatus() {
        return status;
    }

    public void login(String email, String password) {
        executor.execute(() -> {
            loginUseCase.execute(email, password, new AuthRepository.AuthCallback() {
                @Override
                public void onSuccess() {
                    prefs.saveClient(email, email);
                    status.postValue("Успешный вход");
                }

                @Override
                public void onError(String message) {
                    status.postValue("Ошибка входа: " + message);
                }
            });
        });
    }

    public void register(String email, String password) {
        executor.execute(() -> {
            registerUseCase.execute(email, password, new AuthRepository.AuthCallback() {
                @Override
                public void onSuccess() {
                    prefs.saveClient(email, email);
                    status.postValue("Успешная регистрация");
                }

                @Override
                public void onError(String message) {
                    status.postValue("Ошибка регистрации: " + message);
                }
            });
        });
    }
}
