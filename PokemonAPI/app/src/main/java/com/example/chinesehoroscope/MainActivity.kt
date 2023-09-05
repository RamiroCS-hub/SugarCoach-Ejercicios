package com.example.chinesehoroscope

import android.net.DnsResolver
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.chinesehoroscope.databinding.ActivityMainBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val retrofitTraer = RetrofitClient.consumirAPI.getTraer()

        retrofitTraer.enqueue(object: Callback<Form>{
            override fun onResponse(
                call: Call<Form>,
                response: Response<Form>
            ) {
                println(response.body()?.name)
            }

            override fun onFailure(call: Call<Form>, t: Throwable) {
                println("Algo fallo")
            }

        })

    } // https://github.com/square/retrofit/tree/master/retrofit-converters/moshi
    //https://api.bloom.be/api/
}