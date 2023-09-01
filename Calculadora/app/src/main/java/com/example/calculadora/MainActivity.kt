package com.example.calculadora

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    var txtInput: TextInputEditText? = null
    var txtResult: TextView? = null
    var txtNum: TextView? = null
    var operated: Boolean = true
    var numb: Float = 0.0F
    var lastOperation: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txtInput = findViewById(R.id.txtOperation)
        txtResult = findViewById(R.id.txtResult)
        txtNum = findViewById(R.id.txtNum)
    }

    fun clickButton(view: View){
        try {
            when (lastOperation) {
                "-" -> txtResult?.text = (numb - (txtInput?.text.toString().toFloat())).toString()
                "+" -> txtResult?.text = (numb + (txtInput?.text.toString().toFloat())).toString()
                "*" -> txtResult?.text = (numb * (txtInput?.text.toString().toFloat())).toString()
                "/" -> txtResult?.text = (numb / (txtInput?.text.toString().toFloat())).toString()
            }
            txtInput?.setText("")
            txtNum?.text = "0.0"
        } catch (e: Exception){
            txtResult?.text = "Ah ocurrido un error"
            println(e)
        }
    }

    fun operation(view: View){
        try{
            when(lastOperation){
                "+" -> numb += txtInput?.text.toString().toFloat()
                "-" -> numb -= txtInput?.text.toString().toFloat()
                "/" -> numb /= txtInput?.text.toString().toFloat()
                "*" -> numb *= txtInput?.text.toString().toFloat()
                else -> numb += txtInput?.text.toString().toFloat()
            }

            when(view.id){
                R.id.btnAdd -> lastOperation = "+"
                R.id.btnSub -> lastOperation = "-"
                R.id.btnMult -> lastOperation = "*"
                R.id.btnDiv -> lastOperation = "/"
            }
            //Agregar las demas operaciones dependiendo del ID del view
            txtNum?.text = numb.toString()
            txtInput?.setText("")
        } catch (e:Exception){
            lastOperation = ""
            numb = 0.0F
            txtInput?.text = Editable.Factory.getInstance().newEditable("")
            txtNum?.text = ""
            txtResult?.text = "Ah ocurrido un error"
            println(e)
        }
    }

    fun restart(vew: View){
        lastOperation = ""
        numb = 0.0F
        txtInput?.text = Editable.Factory.getInstance().newEditable("")
        txtNum?.text = ""
        txtResult?.text = ""
    }


}