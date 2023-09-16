package com.deloitte.deloittetask.repository.remote_data_source.models

sealed class NetworkResponse<T>(
    val data: T? = null,
    val errorMessage: String? = null
) {
    class Success<T>(data: T) : NetworkResponse<T>(data)
    class Failure<T>(error: Int,errorMessage:String) : NetworkResponse<T>(errorMessage = errorMessage)
}
