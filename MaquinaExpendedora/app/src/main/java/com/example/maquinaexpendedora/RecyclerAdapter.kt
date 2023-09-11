package com.example.maquinaexpendedora
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(private val drinkList: MutableList<Drink>): RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_drink, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = drinkList[position]
        Log.i("OnBind","El item es $item")
        holder.bind(item)
    }

    override fun getItemCount(): Int = drinkList.size

}