package com.example.petstore.domain.usecase

import com.example.petstore.data.repository.PetStoreDataRepository
import com.example.petstore.domain.model.PetStoreDomainModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class GetPetStoreUseCase {

    interface Callbacks {
        fun onPetStoreLoaded(petStore: PetStoreDomainModel)
        fun onError(exception: Throwable)
    }

    private val repository: PetStoreDataRepository by lazy { PetStoreDataRepository() }

    fun getPetStore(callbacks: Callbacks) = repository.getStoreInfo()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({ callbacks.onPetStoreLoaded(it) }, { callbacks.onError(it) })

}