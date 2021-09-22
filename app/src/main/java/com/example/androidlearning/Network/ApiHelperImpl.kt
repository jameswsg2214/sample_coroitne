package com.example.androidlearning.Network

import com.example.androidlearning.model.ClinicalNotesResponse
import com.example.androidlearning.model.RequestPayload
import com.example.androidlearning.model.ResponsePayload
import retrofit2.Response
import javax.inject.Inject

class ApiHelperImpl  (private val apiInterface: ApiInterface) : ApiHelper {

    override suspend fun getUsers(): Response<ClinicalNotesResponse> =
        apiInterface.login("en","Bearer e222c12c-e0d1-3b8b-acaa-4ca9431250e2",28869)

    override suspend fun createNotes(requestPayload: RequestPayload):Response<ResponsePayload> =
        apiInterface.createNotes("en","Bearer e222c12c-e0d1-3b8b-acaa-4ca9431250e2",28869,requestPayload)


}