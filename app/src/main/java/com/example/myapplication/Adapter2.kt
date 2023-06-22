package com.example.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.databinding.NewsListItemBinding
import com.example.myapplication.news.NewsGermanItem

class Adapter2(private val newsGermanList: MutableList<NewsGermanItem>)
    : RecyclerView.Adapter<Adapter2.ViewHolderCustom>() {

    inner class ViewHolderCustom(private val binding: NewsListItemBinding)
        : RecyclerView.ViewHolder(binding.root) {

        fun bind(newsGerman: NewsGermanItem) {
            with(binding) {
                Glide.with(itemView.context)
                    .load("${newsGerman.urlToImage}")
                    .into(gambarBerita)
                namaBerita.text = "${newsGerman.title}"
                deskripsiBerita.text = "${newsGerman.description}"
                authorBerita.text = "Author: ${newsGerman.author}"
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
        holder.bind(newsGermanList[position])
    }

    override fun getItemCount(): Int {
        return newsGermanList.size
    }

}