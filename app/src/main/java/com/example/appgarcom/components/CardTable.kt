package com.example.appgarcom.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appgarcom.type.TableStatus

@Composable
fun CardTable(
    tableNumber: Int,
    tableStatus: TableStatus,
    status: TableStatus,
    click: () -> Unit
) {

    Card(
        colors = CardDefaults.cardColors(
            containerColor = colorScheme.surfaceVariant
        ),
        border = when (status) {
            TableStatus.AVAILABLE -> BorderStroke(2.dp, colorScheme.secondary)
            TableStatus.OCCUPIED -> BorderStroke(2.dp, colorScheme.error)
            TableStatus.RESERVED -> BorderStroke(2.dp, colorScheme.tertiary)
            else -> BorderStroke(2.dp, colorScheme.onSurface)
        },
        modifier = Modifier
            .size(100.dp, 100.dp)
            .clickable(onClick = click),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "$tableNumber",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = colorScheme.onSurfaceVariant
            )
            Text(
                text = stringResource(tableStatus.resId),
            )
        }
    }
}

