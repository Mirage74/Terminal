package com.balex.terminal.presentation.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.balex.terminal.domain.entity.Bar

@Composable
fun QuotesScreen(
    quotesList: List<Bar>
) {
    LazyColumn(
        contentPadding = PaddingValues(
            top = 16.dp,
            start = 8.dp,
            end = 8.dp,
            bottom = 32.dp
        ),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(
            items = quotesList,
            key = { it.calendar.toString() }
        ) { bar ->
            Row ()
            {
                Text(
                    text = bar.high.toString() + "   "
                )
                Text(
                    text = bar.low.toString() + "   "
                )
                Text(
                    text = bar.open.toString() + "   "
                )
                Text(
                    text = bar.close.toString() + "   "
                )

            }
            
        }

    }
}