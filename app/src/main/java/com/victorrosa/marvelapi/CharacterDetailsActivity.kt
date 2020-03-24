package com.victorrosa.marvelapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.character_card.view.*

class CharacterDetailsActivity : AppCompatActivity() {

    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character_details)

        val characterId: String = intent.getStringExtra(Constant.BUNDLE_CHARACTER_ID).orEmpty()

        textView = findViewById(R.id.textView)
        textView.text = characterId
    }
}
