package com.example.hedgehog

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hedgehog.retrofit.Jokes

class JokesAdapter(private val jokes: Jokes?) :
    RecyclerView.Adapter<JokesAdapter.JokesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.jokes_item, parent, false)
        return JokesViewHolder(view)
    }
class JokesViewHolder(view: View):RecyclerView.ViewHolder(view) {
    val textView: TextView = view.findViewById(R.id.jokeText)
}
    override fun onBindViewHolder(holder: JokesViewHolder, position: Int) {
        holder.textView.text= jokes?.value?.get(position)?.joke
    }

    override fun getItemCount(): Int =jokes?.value?.size!!
}