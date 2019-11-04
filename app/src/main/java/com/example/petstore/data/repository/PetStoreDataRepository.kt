package com.example.petstore.data.repository

import com.example.petstore.data.network.PetStoreApi
import com.example.petstore.data.network.PetsApi
import com.example.petstore.data.network.model.mapper.toDomain
import com.example.petstore.domain.error.PetStoreError
import com.example.petstore.domain.model.PetDomainModel
import com.example.petstore.domain.model.PetStoreDomainModel
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class PetStoreDataRepository {

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("http://your.server.url")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private val petStoreApi: PetStoreApi by lazy { retrofit.create(PetStoreApi::class.java) }
    private val petsApi: PetsApi by lazy { retrofit.create(PetsApi::class.java) }

    fun getStoreInfo(): Single<PetStoreDomainModel> = petStoreApi.getPetList()
        .map { it.body() ?: throw PetStoreError(it.code(), it.message()) }
        .map { it.toDomain() }

    fun getAllPets(): Single<List<PetDomainModel>> = petsApi.getPetList()
        .map { it.body() ?: throw PetStoreError(it.code(), it.message()) }
        .map { it.map { pets -> pets.toDomain() } }

}