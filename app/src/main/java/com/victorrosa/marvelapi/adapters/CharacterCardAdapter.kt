package com.victorrosa.marvelapi.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.victorrosa.marvelapi.MainActivity
import com.victorrosa.marvelapi.R

class CharacterCardAdapter (
    private val mainActivity: MainActivity,
    private val list: List<Character>
) : BaseAdapter() {

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val inflater = parent?.context?.
            getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.character_card,null)

        val charName = view.findViewById<TextView>(R.id.char_name)
        charName.text = list[position].name

        view.setOnClickListener {
            mainActivity.callDetail(list[position].name.toString())
        }

        return view
    }

    override fun getItem(position: Int): Any {
        return list[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return list.size
    }
}