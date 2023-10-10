package kg.damir.carollection.data.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "car")
data class CarDbModel(
    @PrimaryKey
    val carName: String,
    val photo: String,
    val yearIssue: Date,
    val engineCapacity: String,
    val createDate: Date = Date()
)