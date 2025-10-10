package ru.mirea.lyulcheva.domain.usecases;

import ru.mirea.lyulcheva.domain.repository.AuthRepository;

public class LoginUserUseCase {
    private final AuthRepository repository;

    public LoginUserUseCase(AuthRepository repository) {
        this.repository = repository;
    }

    public void execute(String email, String password, AuthRepository.AuthCallback callback) {
        repository.login(email, password, callback);
    }
}