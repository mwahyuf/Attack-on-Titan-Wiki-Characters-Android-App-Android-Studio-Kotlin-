package com.example.attackontitancharacterswiki

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListCharsAdapter(private val listChar: ArrayList<Chars>) : RecyclerView.Adapter<ListCharsAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtName: TextView = itemView.findViewById(R.id.txt_item_name)
        val txtDetail: TextView = itemView.findViewById(R.id.txt_item_detail)
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Chars)
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_list_chars, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val char = listChar[position]

        Glide.with(holder.itemView.context)
            .load(char.photo)
            .apply(RequestOptions().override(55, 55))
            .into(holder.imgPhoto)

        holder.txtName.text = char.full_name
        holder.txtDetail.text = char.biodata_short

        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listChar[holder.adapterPosition])
        }

    }

    override fun getItemCount(): Int {
        return listChar.size
    }

}