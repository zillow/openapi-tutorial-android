package com.example.petstore.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.petstore.R
import com.example.petstore.domain.model.PetDomainModel
import com.example.petstore.domain.usecase.GetPetsUseCase
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.fragment_pet_store.*

class PetsFragment : Fragment(), GetPetsUseCase.Callbacks {

    private val useCase = GetPetsUseCase()
    private val adapter = PetsAdapter()

    private var disposable: Disposable? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_all_pets, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pet_list.adapter = adapter
    }

    override fun onStart() {
        super.onStart()
        disposable?.dispose()
        disposable = useCase.getPets(this)
    }

    override fun onStop() {
        disposable?.dispose()
        super.onStop()
    }

    override fun onPetsLoaded(pets: List<PetDomainModel>) {
        adapter.setPets(pets)
    }

    override fun onError(exception: Throwable) {
        Toast.makeText(context, "Error: ${exception.message}", Toast.LENGTH_LONG).show()
    }

}