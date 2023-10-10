package kg.damir.carollection.domain

class EditCarUseCase (val impl:CarRepository){
    operator fun invoke() = impl.getCarList()
}