package com.moanes.instabugtask.ui

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textview.MaterialTextView
import com.moanes.instabugtask.R

class WordViewHolder(view: View): RecyclerView.ViewHolder(view){
val wordTV:MaterialTextView =view.findViewById(R.id.wordTV)
val countTV:MaterialTextView =view.findViewById(R.id.countTV)
}