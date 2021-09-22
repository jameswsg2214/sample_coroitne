package com.example.androidlearning.Network

import com.example.androidlearning.model.ClinicalNotesResponse
import com.example.androidlearning.model.RequestPayload
import com.example.androidlearning.model.RequestPayloadItem
import com.example.androidlearning.model.ResponsePayload
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiInterface {

    //user login
    @GET(ApiClient.LOGIN)
    suspend fun login(
        @Header("Accept-Language") acceptLanguage: String?,
        @Header("Authorization") authorization: String?,
        @Header("user_uuid") user_uuid: Int,
    )     : Response<ClinicalNotesResponse>


    @POST(ApiClient.CREATE)
    suspend fun createNotes(
        @Header("Accept-Language") acceptLanguage: String?,
        @Header("Authorization") authorization: String?,
        @Header("user_uuid") user_uuid: Int,
        @Body  requestPayload: ArrayList<RequestPayloadItem>
    )     : Response<ResponsePayload>


}