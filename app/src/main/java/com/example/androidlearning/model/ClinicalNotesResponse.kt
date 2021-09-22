package com.example.androidlearning.model

data class ClinicalNotesResponse(
    val code: Int,
    val message: String,
    val responseContents: List<ResponseContent>
)