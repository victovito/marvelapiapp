package com.victorrosa.marvelapi.adapters

import com.google.gson.annotations.SerializedName

data class Character (
    @SerializedName("id")
    var id: Int? = null,

    @SerializedName("name")
    var name: String? = null,

    @SerializedName("thumbnail")
    var thumbnail: Thumbnail? = null

) {
    data class Thumbnail (
        @SerializedName("path")
        var path: String? = null

    )
}

