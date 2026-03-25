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
import androidx.compose.ui.res.stringResource
import com.example.appgarcom.type.TableStatus

@Composable
fun CardTableStatus(
    tableStatus: TableStatus,
) {
    Row(
        modifier = Modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            colors = RadioButtonColors(
                selectedColor = SelectStateColor(tableStatus),
                unselectedColor = Color.White,
                disabledSelectedColor = Color.White,
                disabledUnselectedColor = Color.White
            ),
            selected = true,
            onClick = {}
        )

        Text(
            text = stringResource(tableStatus.resId),
            color = MaterialTheme.colorScheme.onBackground,
        )
    }
}

@SuppressLint("ComposableNaming")
@Composable
private fun SelectStateColor(statusMesaConstants: TableStatus): Color {
    return when (statusMesaConstants) {
        TableStatus.PENDING -> {
            MaterialTheme.colorScheme.onSurface
        }

        TableStatus.OCCUPIED -> {
            MaterialTheme.colorScheme.error
        }

        TableStatus.RESERVED -> {
            MaterialTheme.colorScheme.tertiary
        }

        else -> {
            MaterialTheme.colorScheme.secondary
        }
    }
}
