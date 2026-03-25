package com.example.appgarcom.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.appgarcom.R
import com.example.appgarcom.components.CardTable
import com.example.appgarcom.components.CardTableStatus
import com.example.appgarcom.components.HorizontalDividerExample
import com.example.appgarcom.components.TopAppBarUser
import com.example.appgarcom.type.TableStatus

@Composable
fun HomeView(navController: NavController = rememberNavController()) {


    val tableStatuses by remember { mutableStateOf(TableStatus.entries) }
    val tablesCount by remember { mutableIntStateOf(15) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding()
            .padding(13.dp)
            .background(MaterialTheme.colorScheme.background)

    ) {

        TopAppBarUser()

        HorizontalDividerExample()

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = stringResource(R.string.title_section_tables),
            fontWeight = FontWeight.Bold,
            fontSize = 22.sp,
            color = MaterialTheme.colorScheme.primary,
        )

        Spacer(modifier = Modifier.height(8.dp))

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(horizontal = 4.dp)
        ) {
            itemsIndexed(tableStatuses) { _, mesa ->
                CardTableStatus(
                    tableStatus = mesa,
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        LazyVerticalGrid(
            columns = GridCells.Adaptive(minSize = 90.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(8.dp),
            modifier = Modifier.weight(1f),
        ) {
            itemsIndexed(List(tablesCount) { it + 1 }) { _, nMesa ->
                val statusMesa = TableStatus.entries.random()

                CardTable(
                    tableNumber = nMesa,
                    tableStatus = statusMesa,
                    status = statusMesa,
                    click = {
                        navController.navigate("categories")
                    },
                )
            }
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun HomeViewPreview() {
    HomeView()
}