package kg.damir.carollection.domain

import kg.damir.carollection.data.database.model.CarDbModel

class EditCarUseCase (val impl:CarRepository){
    operator fun invoke(carDbModel: CarDbModel) = impl.editCar(carDbModel)
}