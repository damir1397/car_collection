package kg.damir.carollection.presentation

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kg.damir.carollection.data.database.model.CarDbModel
import kg.damir.carollection.data.database.model.UsersDbModel
import kg.damir.carollection.data.repository.CarRepositoryImpl
import kg.damir.carollection.data.repository.UsersRepositoryImpl
import kg.damir.carollection.domain.AddCarUseCase
import kg.damir.carollection.domain.AddUsersUseCase
import kg.damir.carollection.domain.DeleteCarUseCase
import kg.damir.carollection.domain.EditCarUseCase
import kg.damir.carollection.domain.GetCarUseCase
import kg.damir.carollection.domain.GetUsersByLoginUseCase
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date

class ViewModelAdd(application: Application) : ViewModel() {

    private val repository = CarRepositoryImpl(application)
    private val repositoryUser = UsersRepositoryImpl(application)

    val getCarUseCase = GetCarUseCase(repository)
    val editCarUseCase = EditCarUseCase(repository)
    val deleteCarUseCase = DeleteCarUseCase(repository)
    val addCarUseCase = AddCarUseCase(repository)
    val getUsersByLoginUseCase = GetUsersByLoginUseCase(repositoryUser)
    val addUsersUseCase = AddUsersUseCase(repositoryUser)

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

    var getCarList = getCarUseCase()


    fun searchDatabase(searchQuery: String): LiveData<List<CarDbModel>> {
        return getCarUseCase(searchQuery)
    }


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
                        carName = carName,
                        photo = photo,
                        yearIssue = yearIssue,
                        engineCapacity = engineCapacity,
                        userId = 1,
                        createDate = SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Date())
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

    val getUsers = repositoryUser.getUsersList()
    fun getUsersByLogin(login: String): UsersDbModel? {
        return getUsersByLoginUseCase(login).value
    }

    fun addDefaultUser() {
        viewModelScope.launch {
            addUsersUseCase(
                UsersDbModel(
                    login = "UserCar",
                    password = "1234",
                    downloadCount = 2,
                    viewCount = 3
                )
            )
        }
    }

}