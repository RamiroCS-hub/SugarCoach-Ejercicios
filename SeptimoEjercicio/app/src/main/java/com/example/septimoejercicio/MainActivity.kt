package com.example.septimoejercicio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var dwarveCant: EditText? = null
    var orcCant: EditText? = null
    var goblinCant: EditText? = null
    var goodSurCant: EditText? = null
    var resultDis: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        dwarveCant = findViewById(R.id.txtDwarve)
        orcCant = findViewById(R.id.txtOrc)
        goblinCant = findViewById(R.id.txtGoblin)
        goodSurCant = findViewById(R.id.txtGoodSur)
        resultDis = findViewById(R.id.txtResult)
    }
    fun pressButton(view: View){
        val goodSurCant = goodSurCant?.text.toString().toInt()
        val orcCant = orcCant?.text.toString().toInt()
        val goblinCant = goblinCant?.text.toString().toInt()
        val dwarveCant = dwarveCant?.text.toString().toInt()

        val mapOfSoldiers:Map<String, Int> = mapOf(
            "Sureño bueno" to goodSurCant,
            "Enano" to dwarveCant,
            "Goblin" to goblinCant,
            "Orc" to orcCant
        )
        val  result = goodAgainstBad(createSoldiers(mapOfSoldiers))
        println("El resultado fue ${result}")

        when(result){
            "Gano el mal" -> {
                resultDis?.setBackgroundColor(Integer.parseUnsignedInt("00000000",16))
                resultDis?.setTextColor(Integer.parseUnsignedInt("ffff0000",16))
                resultDis?.text = Editable.Factory.getInstance().newEditable(result)
            }
            "Gano el bien" -> {
                println("Gano el bien sisi")
                resultDis?.setBackgroundColor(Integer.parseUnsignedInt("00000000",16))
                resultDis?.setTextColor(Integer.parseUnsignedInt("ff0000ff",16))
                resultDis?.text = Editable.Factory.getInstance().newEditable(result)
            }else -> {
                resultDis?.setTextColor(Integer.parseUnsignedInt("00000000",16))
                resultDis?.text = Editable.Factory.getInstance().newEditable(result)
            }
        }
        resultDis?.visibility = View.VISIBLE

    }
    fun restartGame(view: View){
        dwarveCant?.text = changeFromView("")
        goodSurCant?.text = changeFromView("")
        goblinCant?.text = changeFromView("")
        orcCant?.text = changeFromView("")
        resultDis?.text = changeFromView("")
    }
    private fun changeFromView(value:String): Editable{
        return Editable.Factory.getInstance().newEditable(value)
    }
    private fun createSoldiers(mapOfSoldiers: Map<String,Int>): MutableList<Race>{
        val listOfSoldiers: MutableList<Race> = mutableListOf()

        for(soldier in mapOfSoldiers){
            when(soldier.key.lowercase()){
                "sureño bueno" -> {
                    val goodSur = GoodSur(soldier.value)
                    listOfSoldiers.add(goodSur)
                }
                "enano" -> {
                    val dwarve = Dwarves(soldier.value)
                    listOfSoldiers.add(dwarve)
                }
                "goblin" -> {
                    val goblin = Goblins(soldier.value)
                    listOfSoldiers.add(goblin)
                }
                "orc" -> {
                    val orc = Orcs(soldier.value)
                    listOfSoldiers.add(orc)
                }
                else -> println("Esa no es una raza permitida")

            }
        }

        return listOfSoldiers
    }
    private fun goodAgainstBad(soldiers: MutableList<Race>): String{
        var warResult: Int = 0
        soldiers.forEach {
            if(it.raceIdent){
                warResult += it.getTotalAttack()
            }else{
                warResult -= it.getTotalAttack()
            }
        }
        return if(warResult != 0) {
            if (warResult > 0) "Gano el bien" else "Gano el mal"
        }else{
            "Empate"
        }
    }
}