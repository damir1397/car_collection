package kg.damir.carollection.domain

import androidx.lifecycle.LiveData
import kg.damir.carollection.data.database.model.CarDbModel
import kg.damir.carollection.data.database.model.UsersDbModel

interface UsersRepository {

    fun getUsersList(): LiveData<List<UsersDbModel>>
    fun getUsersByLogin(login: String): LiveData<UsersDbModel>

    suspend fun addUsers(user: UsersDbModel)

    suspend fun editUsers(user: UsersDbModel)

    suspend fun deleteUsers(user: UsersDbModel)

}