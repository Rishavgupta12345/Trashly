package com.example.plastick.dataBase.sell

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.plastick.R
import com.example.plastick.dataBase.buy.User
import java.util.ArrayList

class sellsAdapter(private val arrayList : ArrayList<Sells>) : RecyclerView.Adapter<sellsAdapter.MyViewHolder>() {

    private lateinit var mListener: onItemClickListner

    interface onItemClickListner{
        fun onItemCLick(position: Int)
    }

    fun setOnITemClickListner(listner: onItemClickListner){
        mListener = listner
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_sell,parent,false)
        return MyViewHolder(itemView,mListener)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val curitem = arrayList[position]

        holder.imageid.setImageResource(curitem.imagesell)
        holder.name.text = curitem.name




    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    class MyViewHolder(itemView: View,listner: onItemClickListner) : RecyclerView.ViewHolder(itemView)
    {

        val imageid : ImageView = itemView.findViewById(R.id.imageViewsell)
        val name : TextView = itemView.findViewById(R.id.Name)

        init {

            itemView.setOnClickListener {
                listner.onItemCLick(adapterPosition)
            }

        }


    }
}


