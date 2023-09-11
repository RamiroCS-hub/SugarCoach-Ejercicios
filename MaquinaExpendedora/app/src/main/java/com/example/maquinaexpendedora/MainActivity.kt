package com.example.maquinaexpendedora

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.maquinaexpendedora.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import org.w3c.dom.Text
import java.io.Serializable
import java.text.DecimalFormat
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    //VIEWS
    private lateinit var txtMoney: TextView
    private lateinit var mainScreen: ConstraintLayout
    private lateinit var binding: ActivityMainBinding

    //VARIABLES GLOBALES
    private val decimalFormat = DecimalFormat("#.##")
    private var userInfo: MutableMap<Double, String> = mutableMapOf<Double, String>()
    private var mapOfDrinks = mutableMapOf<String, Double>(
        "Red Bull" to decimalFormat.format(Random.nextDouble(0.0,10.0)).toDouble(),
        "Coca" to decimalFormat.format(Random.nextDouble(0.0,10.0)).toDouble(),
        "Fanta" to decimalFormat.format(Random.nextDouble(0.0,10.0)).toDouble(),
        "Sprite" to decimalFormat.format(Random.nextDouble(0.0,10.0)).toDouble()
    )
    private var money = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        txtMoney = binding.txtMoney
        mainScreen = findViewById(R.id.mainScreen)
        val listOfDrinks = mapOfDrinks.map{
            println("El valor de ${it.key} es: ${it.value}")
            (Drink(it.key, it.value))
        }.toMutableList()
        setUpRecyclerView(listOfDrinks)
    }
    private fun setUpRecyclerView(drinks: MutableList<Drink>){
        val recyclerView = findViewById<RecyclerView>(R.id.rvDrinks)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = RecyclerAdapter(drinks)
    }
    fun getMoney (view: View) {
        txtMoney = binding.txtMoney
        userInfo[txtMoney.text.toString().toDouble()] = ""
        showSnack("Usted ingreso ${txtMoney.text.toString()}$")
        txtMoney.setText("")
    }

    fun chooseDrink (view: View) {
        if (userInfo.isNotEmpty()) {
            userInfo = userInfo.asIterable().associate {
                when (view.id) {
                    R.id.btnBull -> {
                        calculateMoney(it.key, "Red Bull")
                    }
                    R.id.btnCoke -> {
                        calculateMoney(it.key, "Coca")
                    }
                    R.id.btnFan -> {
                        calculateMoney(it.key, "Fanta")
                    }
                    R.id.btnSpri -> {
                        calculateMoney(it.key, "Sprite")
                    }else -> {
                      0.0 to ""
                    }
                }
            }.toMutableMap()
            if(money) changeView() else Log.i("OnMoney", "No se tuvo el suificiente dinero")
        }else{
            /*Toast.makeText(this, "Primero tiene que ingresar el dinero",Toast.LENGTH_LONG).show()
            mostrarNotificacion(this, "ERROR", "Primero tiene que ingresar el dinero", "Error")*/
            showSnack("Primero ingrese el dinero")
            Log.i("onChoosing", "Primero hay que ingresar el dinero")
        }
    }

    private fun calculateMoney(key: Double, drink: String): Pair<Double, String> {
        val change = decimalFormat.format((key - mapOfDrinks[drink]!!)).toDouble()
        Log.i("OnChange", "El vuelto fue: $change")
        return if(change >= 0.00) {
            money = true
            change to drink
        }else {
            money = false
            //Toast.makeText(this, "A usted le falta ingresar ${decimalFormat.format((0.0 - change))}", Toast.LENGTH_LONG).show()
            //Toast.makeText(this, "Se le devolvió ${decimalFormat.format(key)} $", Toast.LENGTH_LONG).show()
            showSnack("Le falta ingresar ${decimalFormat.format((0.0 - change))}$. Se le devolvió: ${decimalFormat.format(key)}$")
            0.0 to ""
        }
    }

    private fun changeView() {
        val intent = Intent(this, GetDrink::class.java).apply{ }
        intent.putExtra("sold", userInfo as Serializable)
        startActivity(intent)
    }

    private fun showSnack(mesg: String){
        Snackbar.make(mainScreen, mesg, Snackbar.LENGTH_LONG).show()
    }
}