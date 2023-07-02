package com.example.plastick.dataBase.buy
import android.app.Activity
import android.widget.ArrayAdapter
import com.example.plastick.R
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.ListAdapter
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class ListAdapter(private val arrayList : ArrayList<User>) : RecyclerView.Adapter<com.example.plastick.dataBase.buy.ListAdapter.MyViewHolder>()  {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.adapter_favourites,parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val curitem = arrayList[position]
        holder.price.text = curitem.price
        holder.item.text = curitem.item
        holder.company.text = curitem.company
        holder.imageid.setImageResource(curitem.Imageid)

    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        val price : TextView = itemView.findViewById(R.id.Price)
        val item : TextView = itemView.findViewById(R.id.itemname)
        val company : TextView = itemView.findViewById(R.id.Brand)
        val imageid : ImageView = itemView.findViewById(R.id.favImageView)
    }
}


