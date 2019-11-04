package com.example.petstore.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.petstore.R
import com.example.petstore.domain.model.PetStoreDomainModel
import com.example.petstore.domain.usecase.GetPetStoreUseCase
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.fragment_pet_store.*

class StoreFragment : Fragment(), GetPetStoreUseCase.Callbacks {

    private val useCase = GetPetStoreUseCase()
    private val adapter = PetsAdapter()

    private var disposable: Disposable? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_pet_store, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        pet_list.adapter = adapter
        all_pets_link.setOnClickListener { launchAllPets() }
    }

    override fun onStart() {
        super.onStart()
        disposable?.dispose()
        disposable = useCase.getPetStore(this)
    }

    override fun onStop() {
        disposable?.dispose()
        super.onStop()
    }

    override fun onPetStoreLoaded(petStore: PetStoreDomainModel) {
        address.text = getString(R.string.store_address, petStore.address)
        phone_number.text = getString(R.string.store_phone, petStore.phoneNumber)
        adapter.setPets(petStore.recentPets)
    }

    override fun onError(exception: Throwable) {
        Toast.makeText(context, "Error: ${exception.message}", Toast.LENGTH_LONG).show()
    }

    private fun launchAllPets() {
        fragmentManager
            ?.beginTransaction()
            ?.add(R.id.container_view, PetsFragment())
            ?.addToBackStack(null)
            ?.commit()
    }

}