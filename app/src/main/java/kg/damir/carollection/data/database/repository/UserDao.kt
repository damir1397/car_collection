package kg.damir.carollection.data.database.repository

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kg.damir.carollection.data.database.model.CarDbModel
import kg.damir.carollection.data.database.model.UsersDbModel

@Dao
interface UserDao {

    @Query("SELECT * FROM users ")
    fun getUsersList(): LiveData<List<UsersDbModel>>

    @Query("SELECT * FROM users where login = :login ")
    fun getUsersByLogin(login: String): LiveData<UsersDbModel>

    @Update
    suspend fun updateUsers(user: UsersDbModel)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUsers(user: UsersDbModel)

    @Delete
    suspend fun deleteUsers(user: UsersDbModel)
}
