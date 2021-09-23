package com.example.androidlearning.network

import com.example.androidlearning.model.ClinicalNotesResponse
import com.example.androidlearning.model.RequestPayload
import com.example.androidlearning.model.ResponsePayload
import retrofit2.Response

interface ApiHelper {

    suspend fun getUsers(): Response<ClinicalNotesResponse>

    suspend fun createNotes(requestPayload: RequestPayload): Response<ResponsePayload>
}