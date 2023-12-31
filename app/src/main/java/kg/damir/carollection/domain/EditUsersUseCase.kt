package kg.damir.carollection.domain

import kg.damir.carollection.data.database.model.UsersDbModel

class EditUsersUseCase (val impl:UsersRepository){
    suspend operator fun invoke(user: UsersDbModel) = impl.editUsers(user)
}