package com.rootdown.dev.smbc.data.net

import com.rootdown.dev.smbc.data.model.remote.RemoteSourceComplexSearch
import com.rootdown.dev.smbc.data.model.remote.RemoteSourceSpoonacular
import retrofit2.Response
import retrofit2.http.GET


interface ApiService {
    @GET("/food/ingredients/search?apiKey=&query=rice")
    suspend fun getRiceRecipes() : Response<RemoteSourceSpoonacular>

    @GET("/recipes/complexSearch?apiKey=&includeIngredients=rice")
    suspend fun getRiceRecipesComplex() : Response<RemoteSourceComplexSearch>
}
