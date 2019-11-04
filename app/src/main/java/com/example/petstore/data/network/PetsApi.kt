package com.example.petstore.data.network

import com.example.petstore.data.network.model.PetNetworkModel
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET

interface PetsApi {

    @GET("/v1/pets")
    fun getPetList(): Single<Response<List<PetNetworkModel>>>

}