package kg.damir.carollection.data.repository

import android.app.Application
import androidx.lifecycle.LiveData
import kg.damir.carollection.data.database.AppDatabase
import kg.damir.carollection.data.database.model.CarDbModel
import kg.damir.carollection.domain.CarRepository


class CarRepositoryImpl(
    private val application: Application
) : CarRepository {
    private val dao = AppDatabase.getInstance(application)

    override fun getCarList(text: String): LiveData<List<CarDbModel>> {
        return dao.carDao().getCarList(text)
    }
    override fun getCarList(): LiveData<List<CarDbModel>> {
        return dao.carDao().getCarList()
    }

    override suspend fun addCar(carDbModel: CarDbModel) {
        dao.carDao().insertCar(carDbModel)
    }

    override suspend fun editCar(carDbModel: CarDbModel) {
        dao.carDao().updateCar(carDbModel)
    }

    override suspend fun deleteCar(carDbModel: CarDbModel) {
        dao.carDao().deleteCar(carDbModel)
    }


}