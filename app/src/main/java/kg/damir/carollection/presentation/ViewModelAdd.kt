package kg.damir.carollection.presentation

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kg.damir.carollection.data.database.model.CarDbModel
import kg.damir.carollection.data.repository.CarRepositoryImpl
import kg.damir.carollection.domain.AddCarUseCase
import kg.damir.carollection.domain.DeleteCarUseCase
import kg.damir.carollection.domain.EditCarUseCase
import kg.damir.carollection.domain.GetCarUseCase
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import kotlin.coroutines.CoroutineContext

class ViewModelAdd(application: Application) : ViewModel() {

    private val repository = CarRepositoryImpl(application)
    val getCarUseCase = GetCarUseCase(repository)
    val editCarUseCase = EditCarUseCase(repository)
    val deleteCarUseCase = DeleteCarUseCase(repository)
    val addCarUseCase = AddCarUseCase(repository)

    private val _errorInputCarName = MutableLiveData<Boolean>()
    val errorInputCarName: LiveData<Boolean>
        get() = _errorInputCarName

    private val _errorInputPhoto = MutableLiveData<Boolean>()
    val errorInputPhoto: LiveData<Boolean>
        get() = _errorInputPhoto

    private val _errorInputYearIssue = MutableLiveData<Boolean>()
    val errorInputYearIssue: LiveData<Boolean>
        get() = _errorInputYearIssue

    private val _errorInputEngineCapacity = MutableLiveData<Boolean>()
    val errorInputEngineCapacity: LiveData<Boolean>
        get() = _errorInputEngineCapacity

    private val _shouldCloseScreen = MutableLiveData<Unit>()
    val shouldCloseScreen: LiveData<Unit>
        get() = _shouldCloseScreen

//    val editCar = editCarUseCase()
//    val deleteCar = deleteCarUseCase()


    val getCarList = getCarUseCase()



    fun addCar(
        inputCarName: String?,
        inputPhoto: String?,
        inputYearIssue: String?,
        inputEngineCapacity: String?
    ) {
        val carName = parseCarName(inputCarName)
        val photo = parsePhoto(inputPhoto)
        val yearIssue = parsePhoto(inputYearIssue)
        val engineCapacity = parseEngineCapacity(inputEngineCapacity)

        val fieldsValid = validateInput(
            carName,
            photo,
            yearIssue,
            engineCapacity
        )
        if (fieldsValid) {
            SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Date())


            viewModelScope.launch {
                addCarUseCase(
                    CarDbModel(
                        carName,
                        photo,
                        yearIssue,
                        engineCapacity,
                        1,
                        SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Date())
                    )
                )
                finishWork()
            }
        }
    }

    private fun parseCarName(inputName: String?): String {
        return inputName ?: ""
    }

    private fun parsePhoto(inputPhoto: String?): String {
        return inputPhoto ?: ""
    }

    private fun parseEngineCapacity(inputEngineCapacity: String?): String {
        return inputEngineCapacity ?: ""
    }

    private fun validateInput(
        carName: String,
        photo: String,
        yearIssue: String,
        engineCapacity: String
    ): Boolean {
        var result = true
        if (carName.isBlank()) {
            _errorInputCarName.value = true
            result = false
        }

        if (photo.isBlank()) {
            _errorInputPhoto.value = true
            result = false
        }

        if (yearIssue.isBlank()) {
            _errorInputYearIssue.value = true
            result = false
        }

        if (engineCapacity.isBlank()) {
            _errorInputEngineCapacity.value = true
            result = false
        }
        return result
    }

    private fun finishWork() {
        _shouldCloseScreen.value = Unit
    }
}