package com.example.appgarcom.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.appgarcom.R

@Composable
fun TopAppBarUser(
) {
    Row(
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(R.drawable.outline_account_circle_24),
            contentDescription = null,
            modifier = Modifier.size(40.dp),
            tint = MaterialTheme.colorScheme.onTertiary
        )

        Text(
            text = "Rodrigo",
            modifier = Modifier.padding(start = 8.dp),
            color = MaterialTheme.colorScheme.onTertiary
        )

        Spacer(modifier = Modifier.weight(1f))

        IconButton(onClick = {}) {
            Icon(
                painter = painterResource(R.drawable.outline_logout),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary
            )
        }
    }
    Spacer(modifier = Modifier.height(16.dp))


}