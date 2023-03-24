package id.ac.unpas.functionalcompose.persistences

import androidx.lifecycle.LiveData
import androidx.room.*
import id.ac.unpas.functionalcompose.model.DaftarIgames

@Dao
interface DaftarIgamesDao {
    @Query("SELECT * FROM DaftarIgames")
    fun loadAll(): LiveData<List<DaftarIgames>>
    @Query("SELECT * FROM DaftarIgames WHERE id = :id")
    fun find(id: String): DaftarIgames?
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg items: DaftarIgames)
    @Delete
    fun delete(item: DaftarIgames)
}