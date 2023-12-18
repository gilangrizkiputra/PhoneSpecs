package com.dicoding.phonespecs

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListPhoneAdapter(private val listPhone : ArrayList<Phone>) : RecyclerView.Adapter<ListPhoneAdapter.ListViewHolder>() {

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
        //val tvDescriptionTwo: TextView = itemView.findViewById(R.id.tv_item_description2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_phone, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listPhone.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, descriptionTwo, photo) = listPhone[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
        holder.tvDescription.text = description
        //holder.tvDescriptionTwo.text = descriptionTwo

        //parcelize intent on click halaman detail
        holder.itemView.setOnClickListener {
            val intentDetail = Intent(holder.itemView.context, DetailActivity::class.java)
            intentDetail.putExtra("key_phone", listPhone[holder.adapterPosition])
            holder.itemView.context.startActivity(intentDetail)
        }
        //onclick
//        holder.itemView.setOnClickListener {
//            Toast.makeText(holder.itemView.context, "Kamu memilih " + listPhone[holder.adapterPosition].name, Toast.LENGTH_SHORT).show()
//        }
    }
}


