package br.unipar.atividade06

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val valorContaEditText: EditText = findViewById(R.id.valorContaEditText)
        val porcentagemGorjetaEditText: EditText = findViewById(R.id.porcentagemGorjetaEditText)
        val calcularButton: Button = findViewById(R.id.calcularButton)
        val resultadoTextView: TextView = findViewById(R.id.resultadoTextView)

        calcularButton.setOnClickListener {
            val valorContaStr = valorContaEditText.text.toString()
            val porcentagemGorjetaStr = porcentagemGorjetaEditText.text.toString()

            if (valorContaStr.isNotEmpty() && porcentagemGorjetaStr.isNotEmpty()) {
                val valorConta = valorContaStr.toDouble()
                val porcentagemGorjeta = porcentagemGorjetaStr.toDouble()

                val gorjeta = valorConta * (porcentagemGorjeta / 100)
                val total = valorConta + gorjeta

                resultadoTextView.text = "Gorjeta: %.2f\nTotal: %.2f".format(gorjeta, total)
            } else {
                resultadoTextView.text = "Por favor, preencha todos os campos."
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}



<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <EditText
        android:id="@+id/valorContaEditText"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:hint="Valor da Conta"
        android:inputType="numberDecimal"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintBottom_toTopOf="@id/porcentagemGorjetaEditText" />

    <EditText
        android:id="@+id/porcentagemGorjetaEditText"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:hint="Porcentagem da Gorjeta"
        android:inputType="number"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@id/valorContaEditText"
        app:layout_constraintBottom_toTopOf="@id/calcularButton" />

    <Button
        android:id="@+id/calcularButton"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Calcular"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@id/porcentagemGorjetaEditText"
        app:layout_constraintBottom_toTopOf="@id/resultadoTextView" />

    <TextView
        android:id="@+id/resultadoTextView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text=""
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@id/calcularButton"
        app:layout_constraintBottom_toBottomOf="parent" />

</androidx.constraintlayout.widget.ConstraintLayout>
