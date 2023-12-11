package com.example.tubes.data

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface OpenAIAPI {
    @POST("completions")
    fun getChatResponse(
        @Header("Authorization") apiKey: String,
        @Body input: ChatData
    ): Call<ChatResponse>
}