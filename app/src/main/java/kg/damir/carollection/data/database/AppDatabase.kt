package kg.damir.carollection.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kg.damir.carollection.data.database.model.CarDbModel
import kg.damir.carollection.data.database.model.UsersDbModel
import kg.damir.carollection.data.database.repository.CarDao
import kg.damir.carollection.data.database.repository.UserDao

@Database(
    entities = [
        CarDbModel::class,
        UsersDbModel::class
    ], version = 12, exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    companion object {

        private var db: AppDatabase? = null
        private const val DB_NAME = "main.db"
        private val LOCK = Any()

        fun getInstance(context: Context): AppDatabase {
            synchronized(LOCK) {
                db?.let { return it }
                val instance =
                    Room.databaseBuilder(
                        context,
                        AppDatabase::class.java,
                        DB_NAME
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                db = instance
                return instance
            }
        }
    }

    abstract fun carDao(): CarDao
    abstract fun userDao(): UserDao

}
