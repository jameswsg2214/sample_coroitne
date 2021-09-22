package com.example.androidlearning.Network

import com.example.androidlearning.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {


    private fun getRetrofit(): Retrofit {

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(
                OkHttpClient.Builder().also { client ->
                    val logging = HttpLoggingInterceptor()
                        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
                    client.addInterceptor(logging)
                }.build()
            )
            .addConverterFactory(GsonConverterFactory.create())
            .build()


    }

        val apiService: ApiInterface = getRetrofit().create(ApiInterface::class.java)


        private const val BASE_URL = "https://qahmisgateway.oasyshealth.co/DEVHMIS-EMR/v1/api/"
        const val LOGIN = "clinical/getAll?patient_uuid=95507"
        const val CREATE = "clinical/create"
}