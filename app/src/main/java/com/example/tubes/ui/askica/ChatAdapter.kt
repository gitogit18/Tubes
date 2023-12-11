package com.example.tubes.ui.askica

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tubes.databinding.ItemChatBinding


class ChatAdapter(private val chat: List<Pair<String, String>>): RecyclerView.Adapter<ChatAdapter.ViewHolder>() {
    class ViewHolder (val binding: ItemChatBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(ItemChatBinding.inflate(LayoutInflater.from(parent.context),parent,false))

    override fun getItemCount(): Int = chat.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = chat[position]

        holder.apply {
            binding.apply {
                tvMessage.text = currentItem.first
                tvSender.text = currentItem.second

            }
        }
    }


}