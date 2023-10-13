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

    @Query("""SELECT * FROM car WHERE
       (carName         LIKE  :text 
    OR engineCapacity   LIKE  :text 
    OR yearIssue        LIKE  :text )
          """)
    fun getCarList(text: String?): LiveData<List<CarDbModel>>
    @Query("SELECT * FROM car ")
    fun getCarList(): LiveData<List<CarDbModel>>
    @Update
    suspend fun updateCar(carModel: CarDbModel)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCar(carModel: CarDbModel)

    @Delete
    suspend fun deleteCar(carModel: CarDbModel)
}
