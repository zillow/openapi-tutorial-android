package com.example.petstore.data.network

import com.example.petstore.data.network.model.StoreInfoNetworkModel
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET

interface PetStoreApi {

    @GET("/v1/store-info")
    fun getPetList(): Single<Response<StoreInfoNetworkModel>>

}