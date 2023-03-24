package id.ac.unpas.pendaftaranigames.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.benasher44.uuid.uuid4
import id.ac.unpas.pendaftaranigames.model.DaftarIgames
import id.ac.unpas.pendaftaranigames.persistences.DaftarIgamesDao
import id.ac.unpas.pendaftaranigames.ui.theme.Purple700
import id.ac.unpas.pendaftaranigames.ui.theme.Teal200
import kotlinx.coroutines.launch
@Composable
fun FormPendaftaranIgames(daftarIgamesDao: DaftarIgamesDao) {
    val tanggalbeli = remember { mutableStateOf(TextFieldValue("")) }
    val namatim = remember { mutableStateOf(TextFieldValue("")) }
    val jeniscabor = remember { mutableStateOf(TextFieldValue("")) }
    val harga = remember { mutableStateOf(TextFieldValue("")) }
    val scope = rememberCoroutineScope()
    Column(modifier = Modifier
        .padding(10.dp)
        .fillMaxWidth()) {
        OutlinedTextField(
            label = { Text(text = "Tanggal Beli") },
            value = tanggalbeli.value,
            onValueChange = {
                tanggalbeli.value = it
            },
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth(),
            placeholder = { Text(text = "yyyy-mm-dd") }
        )
        OutlinedTextField(
            label = { Text(text = "Nama Tim") },
            value = namatim.value,
            onValueChange = {
                namatim.value = it
            },
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(capitalization =
            KeyboardCapitalization.Characters, keyboardType = KeyboardType.Text),
            placeholder = { Text(text = "XXXXX") }
        )
        OutlinedTextField(
            label = { Text(text = "jenis Cabor") },
            value = jeniscabor.value,
            onValueChange = {
                jeniscabor.value = it
            },
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType =
            KeyboardType.Decimal),
            placeholder = { Text(text = "5") }
        )
        OutlinedTextField(
            label = { Text(text = "Harga") },
            value = harga.value,
            onValueChange = {
                harga.value = it
            },
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType =
            KeyboardType.Decimal),
            placeholder = { Text(text = "Rp.") }
        )
        val loginButtonColors = ButtonDefaults.buttonColors(
            backgroundColor = Purple700,
            contentColor = Teal200
        )
        val resetButtonColors = ButtonDefaults.buttonColors(
            backgroundColor = Teal200,
            contentColor = Purple700
        )
        Row (modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()) {
            Button(modifier = Modifier.weight(5f), onClick = {
                val id = uuid4().toString()
                val item = DaftarIgames(id, tanggalbeli.value.text, namatim.value.text, jeniscabor.value.text, harga.value.text)
                scope.launch {
                    daftarIgamesDao.insertAll(item)
                }
                tanggalbeli.value = TextFieldValue("")
                namatim.value = TextFieldValue("")
                jeniscabor.value = TextFieldValue("")
                harga.value = TextFieldValue("")
            }, colors = loginButtonColors) {
                Text(
                    text = "Simpan",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 18.sp
                    ), modifier = Modifier.padding(8.dp)
                )
            }
            Button(modifier = Modifier.weight(5f), onClick = {
                tanggalbeli.value = TextFieldValue("")
                namatim.value = TextFieldValue("")
                jeniscabor.value = TextFieldValue("")
                harga.value = TextFieldValue("")
            }, colors = resetButtonColors) {
                Text(
                    text = "Reset",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 18.sp
                    ), modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
}