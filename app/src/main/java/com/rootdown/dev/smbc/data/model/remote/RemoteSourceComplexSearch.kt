package com.rootdown.dev.smbc.data.model.remote


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.google.gson.annotations.Expose

@JsonClass(generateAdapter = true)
data class RemoteSourceComplexSearch(
    @Json(name = "number")
    @Expose
    val number: Int?, // 2
    @Json(name = "offset")
    @Expose
    val offset: Int?, // 0
    @Json(name = "results")
    @Expose
    val results: List<Result?>?,
    @Json(name = "totalResults")
    @Expose
    val totalResults: Int? // 86
) {
    @JsonClass(generateAdapter = true)
    data class Result(
        @Json(name = "calories")
        @Expose
        val calories: Int?, // 584
        @Json(name = "carbs")
        @Expose
        val carbs: String?, // 84g
        @Json(name = "fat")
        @Expose
        val fat: String?, // 20g
        @Json(name = "id")
        @Expose
        val id: Int?, // 716429
        @Json(name = "image")
        @Expose
        val image: String?, // https://spoonacular.com/recipeImages/716429-312x231.jpg
        @Json(name = "imageType")
        @Expose
        val imageType: String?, // jpg
        @Json(name = "protein")
        @Expose
        val protein: String?, // 19g
        @Json(name = "title")
        @Expose
        val title: String? // Pasta with Garlic, Scallions, Cauliflower & Breadcrumbs
    )
}