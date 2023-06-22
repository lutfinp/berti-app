package com.example.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.databinding.NewsListItemBinding
import com.example.myapplication.news.NewsBBCItem

class Adapter(private val newsBBCList: MutableList<NewsBBCItem>)
    : RecyclerView.Adapter<Adapter.ViewHolderCustom>() {

    inner class ViewHolderCustom(private val binding: NewsListItemBinding)
        : RecyclerView.ViewHolder(binding.root) {

        fun bind(newsBBC: NewsBBCItem) {
            with(binding) {
                Glide.with(itemView.context)
                    .load("${newsBBC.urlToImage}")
                    .into(gambarBerita)
                namaBerita.text = "${newsBBC.title}"
                deskripsiBerita.text = "${newsBBC.description}"
                authorBerita.text = "Author: ${newsBBC.author}"
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderCustom {
        return ViewHolderCustom(
            NewsListItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolderCustom, position: Int) {
        holder.bind(newsBBCList[position])
    }

    override fun getItemCount(): Int {
        return newsBBCList.size
    }

}