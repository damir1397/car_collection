package kg.damir.carollection.data.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UsersDbModel(
    @PrimaryKey
    val login: String,
    val password: String,
    val viewCount: Long,
    val downloadCount: Long,
    val isSubscribed: Boolean
)
