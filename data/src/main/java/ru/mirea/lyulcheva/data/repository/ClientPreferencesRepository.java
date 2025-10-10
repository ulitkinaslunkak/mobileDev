package ru.mirea.lyulcheva.data.repository;

import android.content.Context;
import android.content.SharedPreferences;

public class ClientPreferencesRepository {
    private static final String PREF_NAME = "client_prefs";
    private static final String KEY_NAME = "client_name";
    private static final String KEY_EMAIL = "client_email";

    private final SharedPreferences prefs;

    public ClientPreferencesRepository(Context context) {
        prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public void saveClient(String name, String email) {
        prefs.edit()
                .putString(KEY_NAME, name)
                .putString(KEY_EMAIL, email)
                .apply();
    }

    public String getClientName() {
        return prefs.getString(KEY_NAME, "Неизвестный клиент");
    }

    public String getClientEmail() {
        return prefs.getString(KEY_EMAIL, "Не указан");
    }

    public void clear() {
        prefs.edit().clear().apply();
    }
}
