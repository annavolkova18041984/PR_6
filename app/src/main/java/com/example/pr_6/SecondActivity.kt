package com.example.pr_6 // Объявление единого пакета приложения

import android.graphics.Color // Импорт класса для динамического парсинга цветовых кодов
import android.os.Bundle // Импорт класса для управления состоянием жизненного цикла Activity
import android.widget.Button // Импорт UI-компонента кнопки
import androidx.appcompat.app.AlertDialog // Импорт компонента модального окна
import androidx.appcompat.app.AppCompatActivity // Импорт базового класса экрана с поддержкой Jetpack
import androidx.constraintlayout.widget.ConstraintLayout // Импорт контейнера для управления свойствами разметки

// Класс второго экрана приложения
class SecondActivity : AppCompatActivity() {

    // Метод, вызываемый при создании и отрисовке второго экрана
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) // Инициализация базовых системных структур Activity
        setContentView(R.layout.activity_second) // Привязка кода ко второй XML-разметке activity_second

        // Инициализация компонентов второго экрана по их уникальным идентификаторам
        val secondLayout: ConstraintLayout = findViewById(R.id.secondLayout) // Корневой контейнер второго экрана
        val btnStudent2: Button = findViewById(R.id.btnStudent2) // Кнопка "Студент" на втором экране
        val btnBack: Button = findViewById(R.id.btnBack) // Кнопка возврата на предыдущую Activity

        // Динамическое изменение фона второго экрана для визуального отличия от первого экрана
        secondLayout.setBackgroundColor(Color.parseColor("#FFF3E0")) // Установка светло-оранжевого фонового тона

        // Обработка клика по кнопке "Студент" на втором экране (дублирование модального окна)
        btnStudent2.setOnClickListener {
            val builder = AlertDialog.Builder(this) // Инициализация конструктора диалога в контексте текущего экрана
            builder.setTitle("Студент") // Задание заголовка
            builder.setMessage("ФИО: Голдун Михаил Алексеевич\nГруппа №: 354") // Задание текста с данными студента
            builder.setPositiveButton("ОК") { dialog, _ -> 
                dialog.dismiss() // Закрытие диалога без уничтожения самой Activity
            }
            builder.create().show() // Сборка и мгновенный вывод модального окна на экран устройства
        }

        // Обработка клика по кнопке "Назад"
        btnBack.setOnClickListener {
            finish() // Завершение жизненного цикла текущей Activity и её удаление из стека переходов. Происходит автоматический возврат на Экран 1.
        }
    }
}
