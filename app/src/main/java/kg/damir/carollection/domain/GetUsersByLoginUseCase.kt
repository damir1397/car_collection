package kg.damir.carollection.domain

class GetUsersByLoginUseCase(val impl: UsersRepository) {
     operator fun invoke(login: String) = impl.getUsersByLogin(login)
}