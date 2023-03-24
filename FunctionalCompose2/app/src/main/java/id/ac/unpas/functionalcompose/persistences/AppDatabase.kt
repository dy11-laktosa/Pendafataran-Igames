package id.ac.unpas.pendaftaranigames.persistences

import androidx.room.Database
import androidx.room.RoomDatabase
import id.ac.unpas.functionalcompose.model.DaftarIgames

@Database(entities = [DaftarIgames::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun daftarIgamesDao(): DaftarIgamesDao
}