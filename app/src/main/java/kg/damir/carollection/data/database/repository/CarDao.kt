package kg.damir.carollection.data.database.repository

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kg.damir.carollection.data.database.model.CarDbModel

@Dao
interface CarDao {

    @Query("SELECT * FROM car ")
    fun getCarList(): LiveData<List<CarDbModel>>

    @Update
    fun updateCar(carModel: CarDbModel)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCar(carModel: CarDbModel)

    @Delete
    fun deleteCar(carModel: CarDbModel)
}
