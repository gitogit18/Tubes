package com.example.tubes.data

data class ChatData (
    val model: String,
    val prompt: String,
    val temperature: Double
)
data class ChatResponse(val choices: List<Choice>)

data class Choice(val message: String)
