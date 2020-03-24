package com.victorrosa.marvelapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.GridView
import com.victorrosa.marvelapi.adapters.Character
import com.victorrosa.marvelapi.adapters.CharacterCardAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.victorrosa.marvelapi.services.CharacterService


class MainActivity : AppCompatActivity() {

    private lateinit var gridView: GridView

    var charList: List<Character> = listOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pathParams = MarvelAPI.getPathParameters()

        val adapter = RetrofitInitializer().retrofit

        val client = adapter.create(CharacterService::class.java)

// Fetch a list of the Github repositories.
        val call = client.list(
            pathParams["hash"].toString(),
            pathParams["ts"].toString(),
            pathParams["apikey"].toString()
        )

        call.enqueue(object: Callback<List<Character>?> {
            override fun onResponse(
                call: Call<List<Character>?>,
                response: Response<List<Character>?>
            ) {

                response?.body()?.let {
                    val characters: List<Character> = it.subList(6,6).subList(4,4)
                    charList = characters
                    initializeGridView()
                }

            }

            override fun onFailure(call: Call<List<Character>?>, t: Throwable) {
                Log.e("onFailure error", t?.message)
            }
        })

    }

    private fun initializeGridView(){
        gridView = this.findViewById(R.id.grid_view)

        with(gridView) {
            numColumns = 2
            horizontalSpacing = 0
            verticalSpacing = 0
            adapter = CharacterCardAdapter(this@MainActivity, charList)
        }
    }

    fun callDetail(characterId: String) {

        Bundle().apply {
            putString(Constant.BUNDLE_CHARACTER_ID, characterId)
            goToActivityWithParams(
                true, CharacterDetailsActivity::class.java, this@apply
            )
        }
    }
}
