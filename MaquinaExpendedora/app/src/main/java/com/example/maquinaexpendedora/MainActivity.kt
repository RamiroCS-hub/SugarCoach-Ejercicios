package com.example.maquinaexpendedora

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import java.io.Serializable
import java.text.DecimalFormat
import kotlin.math.roundToLong
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    val decimalFormat = DecimalFormat("#.##")
    var txtMoney: EditText? = null
    var userInfo: MutableMap<Double, String> = mutableMapOf<Double, String>()
    var mapOfDrinks = mapOf<String, Double>(
        "Red Bull" to decimalFormat.format(Random.nextDouble(0.0,10.0)).toDouble(),
        "Coca" to decimalFormat.format(Random.nextDouble(0.0,10.0)).toDouble(),
        "Fanta" to decimalFormat.format(Random.nextDouble(0.0,10.0)).toDouble(),
        "Sprite" to decimalFormat.format(Random.nextDouble(0.0,10.0)).toDouble()
    )
    var money = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txtMoney = findViewById(R.id.txtMoney)
        mapOfDrinks.forEach{
            println("El valor de ${it.key} es: ${it.value}")
        }
    }

    fun calculateMoney (view: View){
        userInfo[txtMoney?.text.toString().toDouble()] = ""
        mostrarNotificacion(this, "Se Ingreso Dinero", "Usted Ingreso ${txtMoney?.text.toString()}$", "ngreso_dinero")
        txtMoney?.setText("")
    }
    /* FUNCION QUE MUESTRA UNA NOTIFICACION */
    private fun mostrarNotificacion(context: Context, titulo: String, contenido: String, chanId: String) {
        // ID único para la notificación
        val notificationId = 1 + (0..1000).random()

        // Crear un canal de notificación (necesario a partir de Android Oreo)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channelId = chanId
            val channelName = "Mi Canal de Notificación"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(channelId, channelName, importance)

            val notificationManager = context.getSystemService(NotificationManager::class.java)
            notificationManager.createNotificationChannel(channel)
        }

        // Crear la notificación
        val builder = NotificationCompat.Builder(context, "mi_canal_id")
            .setContentTitle(titulo)
            .setContentText(contenido)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setSmallIcon(R.drawable.messsage_icon)

        // Mostrar la notificación
        with(NotificationManagerCompat.from(context)) {
            if (ActivityCompat.checkSelfPermission(
                    context,
                    Manifest.permission.POST_NOTIFICATIONS
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                return
            }
            notify(notificationId, builder.build())
        }
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
            Toast.makeText(this, "Primero tiene que ingresar el dinero",Toast.LENGTH_LONG).show()
            mostrarNotificacion(this, "ERROR", "Primero tiene que ingresar el dinero", "Error")
            Log.i("onChoosing", "Primero hay que ingresar el dinero")
        }
    }

    private fun calculateMoney(key: Double, drink: String): Pair<Double, String>{
        var change = decimalFormat.format((key - mapOfDrinks[drink]!!)).toDouble()
        Log.i("OnChange", "El vuelto fue: $change")
        return if(change >= 0.00) {
            money = true
            change to drink
        }else {
            money = false
            Toast.makeText(this, "A usted le falta ingresar ${decimalFormat.format((0.0 - change))}", Toast.LENGTH_LONG).show()
            Toast.makeText(this, "Se le devolvió ${decimalFormat.format(key)} $", Toast.LENGTH_LONG).show()
            mostrarNotificacion(this, "Le falta ingresar ${decimalFormat.format((0.0 - change))}$",
                "Se le devolvió ${decimalFormat.format(key)} $",
                "money")
            0.0 to ""
        }
    }

    private fun changeView(){
        val intent = Intent(this, GetDrink::class.java).apply{ }
        intent.putExtra("sold", userInfo as Serializable)
        startActivity(intent)
    }
}