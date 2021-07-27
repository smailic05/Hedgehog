package com.example.hedgehog.retrofit


import retrofit2.http.GET
import retrofit2.http.Path

public interface ApiJokes{
    @GET("/jokes/random/{id}")
    suspend fun getJokes(@Path("id") productId: Int): Jokes
}