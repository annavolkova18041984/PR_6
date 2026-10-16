package com.example.pr_6 // Ваш пакет

import android.content.Intent // Импорт класса Intent для реализации переходов между экранами (Activity)
import android.graphics.Color // Импорт класса Color для работы со стандартными системными цветами
import android.os.Bundle // Импорт класса для сохранения и восстановления состояния экрана
import android.widget.Button // Импорт стандартного компонента кнопки интерфейса
import androidx.appcompat.app.AlertDialog // Импорт класса для создания совместимых модальных диалоговых окон
import androidx.appcompat.app.AppCompatActivity // Импорт базового класса для обеспечения обратной совместимости интерфейса
import androidx.constraintlayout.widget.ConstraintLayout // Импорт корневого контейнера разметки для управления его свойствами

// Главный класс первого экрана, наследуемый от AppCompatActivity
class MainActivity : AppCompatActivity() {

    // Системный метод жизненного цикла, выполняемый при инициализации экрана в памяти устройства
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) // Вызов родительской реализации для развертывания базовых механизмов окна
        setContentView(R.layout.activity_main) // Привязка логического кода к визуальному XML-шаблону activity_main

        // Инициализация элементов интерфейса: связывание переменных с XML-компонентами по их ID
        val mainLayout: ConstraintLayout = findViewById(R.id.mainLayout1) // Поиск корневого контейнера для смены фона
        val btnStudent: Button = findViewById(R.id.btnStudent1) // Кнопка вызова модального окна с данными
        val btnToScreen2: Button = findViewById(R.id.btnToScreen2) // Кнопка запуска перехода на второй экран

        // Реализация смены фона экрана: меняем цвет корневого контейнера при запуске Activity
        mainLayout.setBackgroundColor(Color.parseColor("#E0F7FA")) // Установка светло-голубого фонового оттенка программным путем

        // Регистрация слушателя нажатия на кнопку "Студент"
        btnStudent.setOnClickListener {
            // Создание конструктора (Builder) для пошаговой сборки конфигурации модального окна
            val builder = AlertDialog.Builder(this)

            builder.setTitle("Студент") // Установка главного текстового заголовка модального окна
            // Формирование многострочного содержимого окна (ФИО и номер учебной группы)
            builder.setMessage("ФИО: Голдун Михаил алексеевич\nГруппа №: 354")

            // Настройка системной кнопки закрытия модального окна (кнопка "ОК")
            builder.setPositiveButton("ОК") { dialog, _ ->
                dialog.dismiss() // При нажатии полностью закрываем диалог и удаляем его из иерархии View
            }

            // Создание готового объекта диалога на основе параметров и немедленное отображение его поверх экрана
            val alertDialog: AlertDialog = builder.create()
            alertDialog.show()
        }

        // Регистрация слушателя нажатия на кнопку перехода на второй экран
        btnToScreen2.setOnClickListener {
            // Создание явного намерения (Explicit Intent), где жестко указывается текущий контекст и целевой класс экрана
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent) // Передача намерения операционной системе Android для запуска новой Activity
        }
    }
}