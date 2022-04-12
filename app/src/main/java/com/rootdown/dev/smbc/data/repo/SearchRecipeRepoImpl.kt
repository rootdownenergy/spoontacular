package com.rootdown.dev.smbc.data.repo

import com.rootdown.dev.smbc.data.model.remote.RemoteSourceSpoonacular
import com.rootdown.dev.smbc.data.net.ApiService
import com.rootdown.dev.smbc.lib.helpers.Resource
import java.lang.Exception
import javax.inject.Inject

class SearchRecipeRepoImpl @Inject constructor(
    private val api: ApiService
) : SearchRecipeRepo {
    override suspend fun searchRecipes(): Resource<RemoteSourceSpoonacular> {
        return try {
            val response = api.getRiceRecipes()
            if(response.isSuccessful){
                response.body().let {
                    return@let Resource.success(it)
                }
            } else {
                Resource.error("Unknown Error", null)
            }
        } catch (e: Exception){
            Resource.error("Network Unreachable",null)
        }
    }
}