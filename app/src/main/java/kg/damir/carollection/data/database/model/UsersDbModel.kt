package kg.damir.carollection.data.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UsersDbModel(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    val login: String,
    val password: String,
    val viewCount: Long,
    val downloadCount: Long,
    val isSubscribed: Boolean =  false
)
