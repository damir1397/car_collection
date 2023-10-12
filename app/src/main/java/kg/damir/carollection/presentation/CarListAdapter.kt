package kg.damir.carollection.presentation

import android.annotation.SuppressLint
import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.Glide
import kg.damir.carollection.data.database.model.CarDbModel
import kg.damir.carollection.databinding.CarItemBinding


class CarListAdapter(val context: Context) : ListAdapter<CarDbModel, CarItemViewHolder>(
    CarItemDiffCallback()
) {
    private val TAG = this.javaClass.name

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarItemViewHolder {
        val binding = CarItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CarItemViewHolder(binding)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: CarItemViewHolder, position: Int) {
        val item = getItem(position)
        with(holder) {

            binding.setPhoto.setImageURI(Uri.parse(item.photo))
            binding.carName.text= item.carName
            binding.yearIssue.text =item.yearIssue
            binding.engineCapacity.text =item.engineCapacity
        }

    }


    fun ImageView.loadImage(image: String) {
        Glide
            .with(context)
            .load(image)
            .into(this)
    }

}