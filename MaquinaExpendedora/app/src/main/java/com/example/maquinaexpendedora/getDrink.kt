package com.example.maquinaexpendedora

import android.annotation.SuppressLint
import android.content.Intent.getIntent
import android.content.Intent.getIntentOld
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import com.example.maquinaexpendedora.databinding.GetDrinkBinding
import java.text.DecimalFormat
class GetDrink :  Fragment(R.layout.get_drink){

    private val decimalFormat = DecimalFormat("#.##")
    private lateinit var userInfo: MutableMap<Double, String>
    private lateinit var binding: GetDrinkBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = GetDrinkBinding.bind(view)
        val dataBundle = arguments
        val user = dataBundle!!.getSerializable("sold") as MutableMap<Double, String>
        println(user)
        //userInfo = getIntentOld("sold")  as MutableMap<Double, String>
        Log.i("OnIntent", "El intent fue: $userInfo")
        //showInfo()
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