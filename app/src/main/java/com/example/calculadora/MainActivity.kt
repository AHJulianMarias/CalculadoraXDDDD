package com.example.calculadora

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }
    fun suma(op1 : Double, op2: Double) : Double{
        return op1 + op2
    }
    fun resta(op1: Double, op2: Double):Double{
        return op1-op2
    }
    fun multiplica(op1 : Double, op2: Double) : Double{
        return op1 * op2
    }
    fun divide(op1: Double, op2: Double):Double{
        return op1/op2
    }
}