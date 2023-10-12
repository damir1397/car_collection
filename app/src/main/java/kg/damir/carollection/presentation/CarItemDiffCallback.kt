package kg.damir.carollection.presentation

import androidx.recyclerview.widget.DiffUtil
import kg.damir.carollection.data.database.model.CarDbModel

class CarItemDiffCallback : DiffUtil.ItemCallback<CarDbModel>() {
    override fun areItemsTheSame(oldItem: CarDbModel, newItem: CarDbModel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: CarDbModel, newItem: CarDbModel): Boolean {
        return oldItem == newItem
    }
}