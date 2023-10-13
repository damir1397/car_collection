package kg.damir.carollection.domain

import kg.damir.carollection.data.database.model.UsersDbModel

class DeleteUsersUseCase (val impl:UsersRepository){
    suspend operator fun invoke(user: UsersDbModel) = impl.deleteUsers(user)
}