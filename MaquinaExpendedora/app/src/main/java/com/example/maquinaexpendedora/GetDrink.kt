package com.example.maquinaexpendedora

import android.annotation.SuppressLint
import android.content.Intent.getIntent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.maquinaexpendedora.databinding.ActivityMainBinding
import com.example.maquinaexpendedora.databinding.GetDrinkBinding
import java.text.DecimalFormat
class GetDrink :  AppCompatActivity() {

    private val decimalFormat = DecimalFormat("#.##")
    private lateinit var userInfo: MutableMap<Double, String>
    private lateinit var binding: GetDrinkBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = GetDrinkBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userInfo = getIntent().getSerializableExtra("sold") as MutableMap<Double, String>
        Log.i("OnIntent", "El intent fue: $userInfo")
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
            binding.txtMoneyChg.setText("Usted compro una ${info.value}. " +
                    "Su vuelto es: ${decimalFormat.format(info.key)}$")
        }
    }
    private fun changeImg(src: Int){
        binding.imgCan.setImageResource(src)
    }
}

