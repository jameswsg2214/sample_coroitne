package com.example.androidlearning.repo

import com.example.androidlearning.network.ApiInterface
import com.example.androidlearning.Room.AppDatabase
import com.example.androidlearning.model.RequestPayload
import com.example.androidlearning.model.RequestPayloadItem

class LiveDataRepo(private val apiHelper: ApiInterface, private val db: AppDatabase)  {


    suspend fun login() = apiHelper.login("en","Bearer e222c12c-e0d1-3b8b-acaa-4ca9431250e2",28869)

    suspend fun requestPayLoad(requestPayload: RequestPayload) = apiHelper.createNotes("en","Bearer e222c12c-e0d1-3b8b-acaa-4ca9431250e2",28869,requestPayload)


    suspend fun insert(requestPayload: RequestPayload) = db.gnotesDao().insertAll(requestPayload as List<RequestPayloadItem>)


}