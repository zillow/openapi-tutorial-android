package com.example.petstore.presentation

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.petstore.R
import com.example.petstore.domain.model.PetDomainModel
import kotlinx.android.synthetic.main.layout_pet_list_item.view.*

class PetsAdapter : RecyclerView.Adapter<PetsAdapter.PetViewHolder>() {

    private val asyncListDiffer = AsyncListDiffer(this, PetDiffUtil())

    fun setPets(pets: List<PetDomainModel>) = asyncListDiffer.submitList(pets)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PetViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_pet_list_item, parent, false)
        return PetViewHolder(itemView)
    }

    override fun getItemCount() = asyncListDiffer.currentList.size

    override fun onBindViewHolder(holder: PetViewHolder, position: Int) {
        getPet(position)?.let {
            holder.bind(it)
        } ?: Log.e(PetsAdapter::javaClass.name, "Null item at $position")
    }

    private fun getPet(index: Int) = asyncListDiffer.currentList.getOrNull(index)


    class PetViewHolder(private val container: View) : RecyclerView.ViewHolder(container) {
        fun bind(pet: PetDomainModel) {
            with(container.resources) {
                container.pet_name.text = getString(R.string.pet_name, pet.name)
                container.pet_age.text = getString(R.string.pet_age, pet.age)
                container.pet_type.text = getString(R.string.pet_type, pet.type)
            }
        }
    }


    class PetDiffUtil : DiffUtil.ItemCallback<PetDomainModel>() {
        override fun areItemsTheSame(oldItem: PetDomainModel, newItem: PetDomainModel) =
            oldItem === newItem

        override fun areContentsTheSame(oldItem: PetDomainModel, newItem: PetDomainModel) =
            oldItem == newItem
    }
}