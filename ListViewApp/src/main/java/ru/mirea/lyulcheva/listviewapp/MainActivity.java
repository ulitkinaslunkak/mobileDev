package ru.mirea.lyulcheva.listviewapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listView);

        List<String> books = new ArrayList<>();
        books.add("Фёдор Достоевский — Идиот");
        books.add("Фёдор Достоевский — Братья Карамазовы");
        books.add("Лев Толстой — Анна Каренина");
        books.add("Лев Толстой — Война и мир");
        books.add("Михаил Булгаков — Мастер и Маргарита");
        books.add("Джордж Оруэлл — 1984");
        books.add("Дж. Р. Р. Толкин — Властелин колец");
        books.add("Фрэнк Герберт — Дюна");
        books.add("Рэй Брэдбери — 451 градус по Фаренгейту");
        books.add("Айзек Азимов — Основание");
        books.add("Артур Кларк — 2001: Космическая Одиссея");
        books.add("Говард Лавкрафт — Зов Ктулху");
        books.add("Стивен Кинг — Оно");
        books.add("Стивен Кинг — Сияние");
        books.add("Сьюзен Коллинз — Голодные игры");
        books.add("Сьюзен Коллинз — И вспыхнет пламя");
        books.add("Сьюзен Коллинз — Сойка-пересмешница");
        books.add("Вероника Рот — Дивергент");
        books.add("Вероника Рот — Инсургенты");
        books.add("Вероника Рот — Элиссенты");
        books.add("Стефани Майер — Сумерки");
        books.add("Стефани Майер — Новолуние");
        books.add("Стефани Майер — Затмение");
        books.add("Стефани Майер — Рассвет");
        books.add("Рик Янси — Пятая волна");
        books.add("Рик Янси — Бесконечное море");
        books.add("Рик Янси — Последняя звезда");
        books.add("Энджи Томас — Скажи это громко");
        books.add("Ли Бардуго — Шестёрка воронов");
        books.add("Ли Бардуго — Продажное королевство");
        books.add("Сабаа Тахир — Жнец");
        books.add("Сабаа Тахир — Факел");
        books.add("Сабаа Тахир — Пылающие небеса");
        books.add("Кассандра Клэр — Город костей");
        books.add("Кассандра Клэр — Город праха");
        books.add("Кассандра Клэр — Город стекла");
        books.add("Кассандра Клэр — Город падших ангелов");
        books.add("Кассандра Клэр — Город потерянных душ");
        books.add("Кассандра Клэр — Город небесного огня");
        books.add("Патрик Несс — Голос монстра");
        books.add("Патрик Несс — Острее ножа");
        books.add("Джон Грин — Виноваты звезды");
        books.add("Джон Грин — Бумажные города");
        books.add("Джон Грин — В поисках Аляски");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                books
        );

        listView.setAdapter(adapter);
    }
}