package kg.damir.carollection.domain

import androidx.lifecycle.LiveData
import kg.damir.carollection.data.database.model.CarDbModel

interface CarRepository {

    fun getCarList(text: String): LiveData<List<CarDbModel>>
    fun getCarList(): LiveData<List<CarDbModel>>

    suspend fun addCar(carDbModel: CarDbModel)

    suspend fun editCar(carDbModel: CarDbModel)

    suspend fun deleteCar(carDbModel: CarDbModel)

}