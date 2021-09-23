package com.example.androidlearning.worker

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.work.CoroutineWorker
import androidx.work.ForegroundInfo
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import com.example.androidlearning.network.ApiClient
import com.example.androidlearning.network.ApiInterface
import com.example.androidlearning.R
import com.example.androidlearning.Room.AppDatabase
import com.example.androidlearning.model.RequestPayloadItem
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ForegroundWorker(
    appContext: Context,
    params: WorkerParameters
) : CoroutineWorker(appContext, params) {

    private val notificationManager = appContext.getSystemService(NotificationManager::class.java)
    private var appDatabase:AppDatabase? = null
    private var apiInterface:ApiInterface? = null



    init {
         appDatabase = AppDatabase(appContext)
         apiInterface = ApiClient.apiService
    }

    override suspend fun doWork(): Result {
        Log.d(TAG, "Start job")

        coroutineScope {

            launch {
                putData(appDatabase?.gnotesDao()?.getAll() as ArrayList<RequestPayloadItem>)
                appDatabase?.gnotesDao()?.clearCinicalData()
            }


        }

        createNotificationChannel()
        val notification = NotificationCompat.Builder(applicationContext, CHANNEL_ID)
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentTitle("Important background job")
            .build()

        val foregroundInfo = ForegroundInfo(NOTIFICATION_ID, notification)
        setForeground(foregroundInfo)

        for (i in 0..100) {
            setProgress(workDataOf(ARG_PROGRESS to i))
            showProgress(i)
            delay(DELAY_DURATION)
        }

        Log.d(TAG, "Finish job")
        return Result.success()
    }


    private suspend fun putData(data: ArrayList<RequestPayloadItem>)
    {
        apiInterface?.createNotes("en","Bearer e222c12c-e0d1-3b8b-acaa-4ca9431250e2",28869,data)


    }

    private fun showProgress(progress: Int) {
        val notification = NotificationCompat.Builder(applicationContext, CHANNEL_ID)
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentTitle("Important background job")
            .setProgress(100, progress, false)
            .build()
        notificationManager?.notify(NOTIFICATION_ID, notification)
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            var notificationChannel = notificationManager?.getNotificationChannel(CHANNEL_ID)
            if (notificationChannel == null) {
                notificationChannel = NotificationChannel(
                    CHANNEL_ID, TAG, NotificationManager.IMPORTANCE_LOW
                )
                notificationManager?.createNotificationChannel(notificationChannel)
            }
        }
    }




    companion object {

        const val TAG = "ForegroundWorker"
        const val NOTIFICATION_ID = 42
        const val CHANNEL_ID = "Job progress"
        const val ARG_PROGRESS = "Progress"
        private const val DELAY_DURATION = 100L // ms
    }
}