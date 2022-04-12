package com.rootdown.dev.smbc.data.repo

import com.rootdown.dev.smbc.data.model.remote.RemoteSourceSpoonacular
import com.rootdown.dev.smbc.lib.helpers.Resource

interface SearchRecipeRepo {
    suspend fun searchRecipes() : Resource<RemoteSourceSpoonacular>
}