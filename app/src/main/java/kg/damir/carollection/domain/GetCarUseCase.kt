package kg.damir.carollection.domain

class GetCarUseCase(val impl: CarRepository) {
    operator fun invoke(text: String) = impl.getCarList(text)
    operator fun invoke() = impl.getCarList()
}