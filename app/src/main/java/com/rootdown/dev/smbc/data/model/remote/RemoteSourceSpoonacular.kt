package com.rootdown.dev.smbc.data.model.remote


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.google.gson.annotations.Expose

@JsonClass(generateAdapter = true)
data class RemoteSourceSpoonacular(
    @Json(name = "number")
    @Expose
    val number: Int?, // 10
    @Json(name = "offset")
    @Expose
    val offset: Int?, // 0
    @Json(name = "results")
    @Expose
    val results: List<Result?>?,
    @Json(name = "totalResults")
    @Expose
    val totalResults: Int? // 61
) {
    @JsonClass(generateAdapter = true)
    data class Result(
        @Json(name = "id")
        @Expose
        val id: Int?, // 20444
        @Json(name = "image")
        @Expose
        val image: String?, // uncooked-white-rice.png
        @Json(name = "name")
        @Expose
        val name: String? // rice
    )
}