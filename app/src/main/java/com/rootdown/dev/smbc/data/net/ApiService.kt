package com.rootdown.dev.smbc.data.net

import com.rootdown.dev.smbc.data.model.remote.RemoteSourceSpoonacular
import retrofit2.Response
import retrofit2.http.GET


interface ApiService {
    @GET("/food/ingredients/search?apiKey=76a84ec229a14bb995183a1c8c2ed8da&query=rice")
    suspend fun getRiceRecipes() : Response<RemoteSourceSpoonacular>
}