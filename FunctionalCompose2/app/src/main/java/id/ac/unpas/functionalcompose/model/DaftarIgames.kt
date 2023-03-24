package id.ac.unpas.pendaftaranigames.model

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
data class DaftarIgames(
    @PrimaryKey val id: String,
    val tanggalbeli: String,
    val namatim: String,
    val jeniscabor: String,
    val harga: String
)
