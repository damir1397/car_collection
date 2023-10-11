package kg.damir.carollection.domain

class GetCarUseCase (val impl:CarRepository){
    operator fun invoke() = impl.getCarList()
}