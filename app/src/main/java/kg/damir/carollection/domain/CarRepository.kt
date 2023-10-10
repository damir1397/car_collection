package kg.damir.carollection.domain

import androidx.lifecycle.LiveData
import kg.damir.carollection.data.database.model.CarDbModel

interface CarRepository {

    fun getCarList(): LiveData<List<CarDbModel>>

    fun addCar(carDbModel: CarDbModel)

    fun editCar(carDbModel: CarDbModel)

    fun deleteCar(carDbModel: CarDbModel)

}