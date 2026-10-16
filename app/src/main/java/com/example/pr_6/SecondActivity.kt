package com.example.pr_6

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val secondLayout: ConstraintLayout = findViewById(R.id.secondLayout)
        val btnStudent2: Button = findViewById(R.id.btnStudent2)
        val btnBack: Button = findViewById(R.id.btnBack)

        // Меняем фон на светло-оранжевый
        secondLayout.setBackgroundColor(Color.parseColor("#FFF3E0"))

        btnStudent2.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Студент")
            // Для второго экрана группа 3385
            builder.setMessage("ФИО: Голдун Михаил алексевич\nГруппа №: 354")
            builder.setPositiveButton("ОК") { dialog, _ ->
                dialog.dismiss()
            }
            builder.create().show()
        }

        btnBack.setOnClickListener {
            finish() // Возврат на первый экран
        }
    }
}