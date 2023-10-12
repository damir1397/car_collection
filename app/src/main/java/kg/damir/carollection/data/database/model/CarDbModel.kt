package kg.damir.carollection.data.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "car")
data class CarDbModel(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    val carName: String,
    val photo: String,
    val yearIssue: String,
    val engineCapacity: String,
    val userId: Long,
    val createDate: String
)