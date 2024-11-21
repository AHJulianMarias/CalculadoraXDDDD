package com.example.calculadora

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var listaNumeros: MutableList<Any>
    var boolSuma: Boolean = false
    var boolResta: Boolean = false
    var boolMulti: Boolean = false
    var boolDiv: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val TAG = "BotonAccion"
        val textoIntro = findViewById<TextView>(R.id.entranNumeros)
        val textoRes = findViewById<TextView>(R.id.resultado)
        var boolFirstTime = true
        val boton0 = findViewById<Button>(R.id.button0)
        val boton1 = findViewById<Button>(R.id.button1)
        val boton2 = findViewById<Button>(R.id.button2)
        val boton3 = findViewById<Button>(R.id.button3)
        val boton4 = findViewById<Button>(R.id.button4)
        val boton5 = findViewById<Button>(R.id.button5)
        val boton6 = findViewById<Button>(R.id.button6)
        val boton7 = findViewById<Button>(R.id.button7)
        val boton8 = findViewById<Button>(R.id.button8)
        val boton9 = findViewById<Button>(R.id.button9)
        val botonBorrarTodo = findViewById<Button>(R.id.buttonDEL)
        val botonBorrar1 = findViewById<Button>(R.id.buttonBorrar1Numero)
        val botonDiv = findViewById<Button>(R.id.buttonDiv)
        val botonMulti = findViewById<Button>(R.id.buttonX)
        val botonResta = findViewById<Button>(R.id.buttonResta)
        val botonSuma = findViewById<Button>(R.id.buttonSuma)
        val botonComa = findViewById<Button>(R.id.buttonComma)
        val botonEq = findViewById<Button>(R.id.buttonEq)
        var op1 = 0.0
        var op2 = 0.0
        listaNumeros = mutableListOf()
        val botones = listOf(boton0, boton1, boton2, boton3, boton4, boton5, boton6, boton7, boton8, boton9)
        val botonesAcciones = listOf(botonBorrar1,botonBorrarTodo,botonDiv,botonMulti,botonResta,botonSuma,botonComa,botonEq)
        botones.forEach { boton ->
            boton.setOnClickListener {
                listaNumeros.add(boton.text.toString().toInt())
                Log.d("Lista Numeros", "onCreate: $listaNumeros")
                Log.d("Lista Numeros Str", "onCreate: ${listaNumeros.joinToString ("")}")
                textoIntro.text = listaNumeros.joinToString ("")
            }
        }
        botonesAcciones.forEach{ botonAccion ->
            botonAccion.setOnClickListener{
                when (botonAccion.text.toString()){
                    "DEL"->{
                        Log.d(TAG, "DEL")
                        listaNumeros.clear()
                        textoIntro.text=listaNumeros.joinToString("")
                        op1 = 0.0
                        op2 = 0.0
                        textoRes.text=""
                        boolFirstTime = true

                    }
                    "C"->{
                        Log.d(TAG, "C")
                        if(listaNumeros.size != 0){
                            listaNumeros.removeLast()
                            textoIntro.text=listaNumeros.joinToString("")

                        }

                    }
                    "/"->{
                        Log.d(TAG, "/")
                        booleanosFalse()
                        boolDiv = true
                        if(boolFirstTime){
                            if(textoIntro.text.toString()!= ""){
                                op1 = textoIntro.text.toString().toDouble()
                                boolFirstTime = false
                            }
                        }
                        textoIntro.text = ""
                        listaNumeros.clear()
                    }
                    "X"->{
                        Log.d(TAG, "X")
                        booleanosFalse()
                        boolMulti = true
                        if(boolFirstTime){
                            if(textoIntro.text.toString()!= ""){
                                op1 = textoIntro.text.toString().toDouble()
                                boolFirstTime = false
                            }
                        }
                        textoIntro.text = ""
                        listaNumeros.clear()
                    }
                    "+"->{
                        Log.d(TAG, "+")
                        booleanosFalse()
                        boolSuma = true
                        if(boolFirstTime){
                            if(textoIntro.text.toString()!= ""){
                                op1 = textoIntro.text.toString().toDouble()
                                boolFirstTime = false
                            }
                        }

                        textoIntro.text = ""
                        listaNumeros.clear()



                    }
                    "-"->{
                        Log.d(TAG, "-")
                        booleanosFalse()
                        boolResta = true
                        if(boolFirstTime){
                            if(textoIntro.text.toString()!= ""){
                                op1 = textoIntro.text.toString().toDouble()
                                boolFirstTime = false
                            }
                        }
                        textoIntro.text = ""
                        listaNumeros.clear()
                    }
                    "="->{
                        Log.d(TAG, "=")
                        if(textoIntro.text.toString()!= ""){
                            op2 = textoIntro.text.toString().toDouble()
                        }
                        if(boolSuma){
                            Log.d(TAG, "Haciendo suma")
                            textoRes.text = (op1 + op2).toString()
                            op1 = textoRes.text.toString().toDouble()
                        }else if(boolResta){
                            Log.d(TAG, "Haciendo resta")
                            textoRes.text =  (op1 - op2).toString()
                            op1 = textoRes.text.toString().toDouble()
                        }else if(boolDiv){
                            Log.d(TAG, "Haciendo division")
                            if(op2 > 0){
                                textoRes.text = (op1/op2).toString()
                            }
                            op1 = textoRes.text.toString().toDouble()
                        }else if(boolMulti){
                            textoRes.text = (op1 * op2).toString() }
                            op1 = textoRes.text.toString().toDouble()
                    }
                    ","->{
                        if(!(listaNumeros.contains(".")) && listaNumeros.size != 0){
                            listaNumeros.add(".")
                            textoIntro.text = listaNumeros.joinToString ("")
                            Log.d(TAG, ",")
                        } else{
                            Log.d(TAG, "Ya contiene ,")
                        }


                    }


                }

            }



        }


    }
    private fun booleanosFalse(){
        boolSuma = false
        boolResta = false
        boolMulti = false
        boolDiv = false
    }

}