package kg.damir.carollection.domain

import androidx.lifecycle.LiveData
import kg.damir.carollection.data.database.model.CarDbModel
import kg.damir.carollection.data.database.model.UsersDbModel

interface UsersRepository {

    fun getUsersList(): LiveData<List<UsersDbModel>>

    fun addUsers(user: UsersDbModel)

    fun editUsers(user: UsersDbModel)

    fun deleteUsers(user: UsersDbModel)

}