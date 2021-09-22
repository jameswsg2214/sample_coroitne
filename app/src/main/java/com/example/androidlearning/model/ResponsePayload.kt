package com.example.androidlearning.model

data class ResponsePayload(
    val code: Int,
    val message: String,
    val responseContents: List<ResponseContentX>
)