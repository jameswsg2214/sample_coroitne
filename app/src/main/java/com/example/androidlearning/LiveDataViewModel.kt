package com.example.androidlearning

import android.content.Context
import android.util.Log
import androidx.lifecycle.*
import androidx.work.*
import com.example.androidlearning.network.*
import com.example.androidlearning.model.ClinicalNotesResponse
import com.example.androidlearning.model.RequestPayload
import com.example.androidlearning.model.ResponsePayload
import com.example.androidlearning.repo.LiveDataRepo
import com.example.androidlearning.worker.ForegroundWorker
import kotlinx.coroutines.*
import retrofit2.Response


class LiveDataViewModel(private val liveDataRepo: LiveDataRepo, val app: Context) : ViewModel() {


    var networkHelper: NetworkHelper


    init {
        networkHelper = NetworkHelper(app)
    }


    private val result = MutableLiveData<Resource<Response<ClinicalNotesResponse>>>()

    val resultMy: LiveData<Resource<Response<ClinicalNotesResponse>>> = result


    private val createClinicalNotes_1 = MutableLiveData<Resource<Response<ResponsePayload>>>()

    val createClinicalNotes: LiveData<Resource<Response<ResponsePayload>>> = createClinicalNotes_1


    fun getLiveData() {
        viewModelScope.launch {
            result.value = Resource.loading(null)
            if (networkHelper.isNetworkConnected()) {
                Log.d("mythread", Thread.currentThread().name + { Thread.currentThread().id })
                result.value = Resource.success(liveDataRepo.login())
            } else {
                result.value = Resource.nointernet("Please check connectivity")
            }


        }
    }


    fun createNotes(requestPayload: RequestPayload) {
        viewModelScope.launch {
            createClinicalNotes_1.value = Resource.loading(null)
            if (networkHelper.isNetworkConnected()) {
                createClinicalNotes_1.value =
                    Resource.success(liveDataRepo.requestPayLoad(requestPayload))

            } else {
                liveDataRepo.insert(requestPayload)
                    createClinicalNotes_1.value =
                        Resource.dataInsert("Success Fully inserted in db")
                    val constrine = Constraints.Builder()
                        .setRequiredNetworkType(NetworkType.CONNECTED)
                        .build()
                    val workerdata = OneTimeWorkRequest.Builder(ForegroundWorker::class.java)
                        .setConstraints(constrine)
                        .build()
                        WorkManager.getInstance().enqueueUniqueWork("mywork",ExistingWorkPolicy.REPLACE,workerdata)
                }

                createClinicalNotes_1.value = Resource.nointernet("Please check connectivity")
            }
        }
    }


