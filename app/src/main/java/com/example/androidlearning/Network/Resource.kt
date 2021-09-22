package com.example.androidlearning.Network

data class Resource<out T>(val status: Status, val data: T?, val message: String?) {

    enum class Status {
        SUCCESS,
        ERROR,
        LOADING,
        FAILURE,
        NOINTERNET,
        DATAINSETED
    }

    companion object {

        fun <T> success(data: T): Resource<T> {
            return Resource(Status.SUCCESS, data, "Success")
        }

        fun <T> nointernet(message: String ): Resource<T> {
            return Resource(Status.NOINTERNET, null,message)
        }

        fun <T> error(message: String, data: T? = null): Resource<T> {
            return Resource(Status.ERROR, data, message)
        }

        fun <T> loading(data: T?): Resource<T> {
            return Resource(Status.LOADING, data, null)
        }

        fun <T> failed(message: String, data: T? = null): Resource<T> {
            return Resource(Status.FAILURE, data, message)
        }

        fun <T> dataInsert(message: String ): Resource<T> {
            return Resource(Status.DATAINSETED, null, message)
        }



    }


}