package ru.mirea.lyulcheva.domain.usecases;

import ru.mirea.lyulcheva.domain.repository.AuthRepository;

public class RegisterUserUseCase {
    private final AuthRepository repository;

    public RegisterUserUseCase(AuthRepository repository) {
        this.repository = repository;
    }

    public void execute(String email, String password, AuthRepository.AuthCallback callback) {
        repository.register(email, password, callback);
    }
}
