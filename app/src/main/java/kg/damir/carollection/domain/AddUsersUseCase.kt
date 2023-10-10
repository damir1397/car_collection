package kg.damir.carollection.domain

import kg.damir.carollection.data.database.model.UsersDbModel

class AddUsersUseCase(val impl: UsersRepository) {
    operator fun invoke(user: UsersDbModel) = impl.addUsers(user)
}