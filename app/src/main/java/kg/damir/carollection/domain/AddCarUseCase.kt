package kg.damir.carollection.domain

class AddCarUseCase (val impl:CarRepository){
    operator fun invoke() = impl.getCarList()
}