package kg.damir.carollection.data.repository

import android.app.Application
import androidx.lifecycle.LiveData
import kg.damir.carollection.data.database.AppDatabase
import kg.damir.carollection.data.database.model.CarDbModel
import kg.damir.carollection.data.database.model.UsersDbModel
import kg.damir.carollection.domain.CarRepository
import kg.damir.carollection.domain.UsersRepository


class UsersRepositoryImpl(
    private val application: Application
) : UsersRepository {
    private val dao = AppDatabase.getInstance(application).userDao()

    override fun getUsersList(): LiveData<List<UsersDbModel>> {
        return dao.getUsersList()
    }

    override fun addUsers(user: UsersDbModel) {
        dao.insertUsers(user)
    }

    override fun editUsers(user: UsersDbModel) {
        dao.updateUsers(user)
    }

    override fun deleteUsers(user: UsersDbModel) {
        dao.deleteUsers(user)
    }
}