package com.example.appgarcom.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appgarcom.constants.MesaConstants

@Composable
fun CardMesa(
    nMesa: Int,
    mesaConstants: MesaConstants,
    status: MesaConstants,
    click: () -> Unit
) {

    Card(
        modifier = Modifier
            .size(100.dp, 100.dp)
            .clickable(onClick = click),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        ),
        border = when (status) {
            MesaConstants.LIVRE -> BorderStroke(2.dp, MaterialTheme.colorScheme.secondary)
            MesaConstants.OCUPADA -> BorderStroke(2.dp, MaterialTheme.colorScheme.error)
            MesaConstants.RESERVADA -> BorderStroke(
                2.dp,
                MaterialTheme.colorScheme.tertiary
            )

            else -> BorderStroke(2.dp, MaterialTheme.colorScheme.onSurface)
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "$nMesa",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Text(
                text = mesaConstants.toString(),
            )
        }
    }
}

@Preview
@Composable
private fun CardMesaPreview() {
    CardMesa(
        nMesa = 1,
        mesaConstants = MesaConstants.LIVRE,
        status = MesaConstants.LIVRE,
        click = {}
    )

}
