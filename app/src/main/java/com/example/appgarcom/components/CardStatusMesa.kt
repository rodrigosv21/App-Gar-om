package com.example.appgarcom.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.appgarcom.constants.MesaConstants

@Composable
fun CardStatusMesa(
    statusMesaConstants: MesaConstants,
) {
    Row(
        modifier = Modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            colors = RadioButtonColors(
                selectedColor = SelectStateColor(statusMesaConstants),
                unselectedColor = Color.White,
                disabledSelectedColor = Color.White,
                disabledUnselectedColor = Color.White
            ),
            selected = true,
            onClick = {}
        )

        Text(
            text = statusMesaConstants.toString(),
        )
    }
}

@SuppressLint("ComposableNaming")
@Composable
private fun SelectStateColor(statusMesaConstants: MesaConstants): Color {
    return when (statusMesaConstants) {
        MesaConstants.PENDENTE -> {
            MaterialTheme.colorScheme.onSurface
        }
        MesaConstants.OCUPADA -> {
            MaterialTheme.colorScheme.error
        }
        MesaConstants.RESERVADA -> {
            MaterialTheme.colorScheme.tertiary
        }
        else -> {
            MaterialTheme.colorScheme.secondary
        }
    }
}

@Preview
@Composable
private fun CardStatusMesaPreview() {
    CardStatusMesa(statusMesaConstants = MesaConstants.PENDENTE)

}