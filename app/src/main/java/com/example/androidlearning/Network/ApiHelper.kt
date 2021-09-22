package com.example.androidlearning.Network

import com.example.androidlearning.model.ClinicalNotesResponse
import com.example.androidlearning.model.RequestPayload
import com.example.androidlearning.model.ResponsePayload
import com.example.androidlearning.model.UserModel
import dagger.hilt.android.scopes.ActivityRetainedScoped
import dagger.hilt.android.scopes.FragmentScoped
import retrofit2.Response
import javax.inject.Inject

interface ApiHelper {

    suspend fun getUsers(): Response<ClinicalNotesResponse>

    suspend fun createNotes(requestPayload: RequestPayload): Response<ResponsePayload>
}