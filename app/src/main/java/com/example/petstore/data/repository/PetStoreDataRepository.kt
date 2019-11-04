package com.example.petstore.data.repository

import com.example.petstore.data.network.model.mapper.toDomain
import com.example.petstore.domain.model.PetDomainModel
import com.example.petstore.domain.model.PetStoreDomainModel
import com.example.petstore.pets.api.PetsApi
import com.example.petstore.store.api.StoreApi
import io.reactivex.Single
import com.example.petstore.pets.ApiClient as PetsClient
import com.example.petstore.store.ApiClient as StoreClient


class PetStoreDataRepository {

    private val petStoreApi: StoreApi by lazy { StoreClient().createService(StoreApi::class.java) }
    private val petsApi: PetsApi by lazy { PetsClient().createService(PetsApi::class.java) }

    fun getStoreInfo(): Single<PetStoreDomainModel> = petStoreApi.storeInfo()
        .map { it.toDomain() }
        .firstOrError()

    fun getAllPets(): Single<List<PetDomainModel>> = petsApi.listPets()
        .map { it.map { pet -> pet.toDomain() } }
        .firstOrError()

}