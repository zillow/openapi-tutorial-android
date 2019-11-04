package com.example.petstore.domain.usecase

import com.example.petstore.data.repository.PetStoreDataRepository
import com.example.petstore.domain.model.PetDomainModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class GetPetsUseCase {

    interface Callbacks {
        fun onPetsLoaded(pets: List<PetDomainModel>)
        fun onError(exception: Throwable)
    }

    private val repository: PetStoreDataRepository by lazy { PetStoreDataRepository() }

    fun getPets(callbacks: Callbacks) = repository.getAllPets()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({ callbacks.onPetsLoaded(it) }, { callbacks.onError(it) })

}