package com.example.hedgehog.retrofit




class JokesRepository {
    var jokesApi: ApiJokes = RetrofitBuilder.apiService

    suspend fun createRequest(number:Int) : Jokes {
        return jokesApi.getJokes(number)
    }
}