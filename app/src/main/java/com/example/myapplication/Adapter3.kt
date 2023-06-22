package com.example.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.databinding.NewsListItemBinding
import com.example.myapplication.news.NewsUSItem

class Adapter3(private val newsUSList: MutableList<NewsUSItem>)
    : RecyclerView.Adapter<Adapter3.ViewHolderCustom>() {

    inner class ViewHolderCustom(private val binding: NewsListItemBinding)
        : RecyclerView.ViewHolder(binding.root) {

        fun bind(newsUS: NewsUSItem) {
            with(binding) {
                Glide.with(itemView.context)
                    .load("${newsUS.urlToImage}")
                    .into(gambarBerita)
                namaBerita.text = "${newsUS.title}"
                deskripsiBerita.text = "${newsUS.description}"
                authorBerita.text = "Author: ${newsUS.author}"
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
        holder.bind(newsUSList[position])
    }

    override fun getItemCount(): Int {
        return newsUSList.size
    }

}