package com.example.segundoejercicio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var isAnagram: Boolean = anagram("corcho","seno" )
        println("Is Anagram: $isAnagram")
    }
    private fun anagram(fWord: String, sWord: String): Boolean{
        if( fWord == sWord ){
            return false
        }

        var cont: Int = 0
        for( firstL in fWord ){

            for( secondL in sWord ){
                if( firstL == secondL ){
                    cont++
                    break
                }
            }
        }

        if( fWord.length == cont){
            return true
        }
        return false
    }
}