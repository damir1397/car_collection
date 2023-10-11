package kg.damir.carollection.domain

class GetUsersUseCase (val impl:UsersRepository){
    operator fun invoke() = impl.getUsersList()
}