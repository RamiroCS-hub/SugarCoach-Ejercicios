package com.example.maquinaexpendedora

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.DecimalFormat
class GetDrink : AppCompatActivity() {
    val decimalFormat = DecimalFormat("#.##")
    var imgCan: ImageView? = null
    var txtMoney: TextView? = null
    lateinit var userInfo: MutableMap<Double, String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.get_drink)
        imgCan = findViewById(R.id.imgCan)
        txtMoney = findViewById(R.id.txtMoneyChg)
        userInfo = getIntent().getSerializableExtra("sold") as MutableMap<Double, String>
        showInfo()
    }

    @SuppressLint("SetTextI18n")
    private fun showInfo(){
        for( info in userInfo){
            when(info.value){
                "Red Bull" -> changeImg(R.drawable.redbull_can)
                "Coca" -> changeImg(R.drawable.coke_can)
                "Fanta" -> changeImg(R.drawable.fanta_can)
                "Sprite" -> changeImg(R.drawable.sprite_can)
                else -> Log.i("OnShowImage", "No hay ninguna imagen")
            }
            txtMoney?.setText("Usted compro una ${info.value}. " +
                    "Su vuelto es: ${decimalFormat.format(info.key)}")
        }

    }
    private fun changeImg(src: Int){
        imgCan?.setImageResource(src)
    }
}