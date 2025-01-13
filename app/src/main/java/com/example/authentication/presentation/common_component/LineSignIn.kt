package com.example.authentication.presentation.common_component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LineSignInComponent() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .drawBehind {
                drawLine(
                    color = Color.Gray,
                    start = Offset(0f, size.height / 2),
                    end = Offset(size.width / 2.2f, size.height / 2),
                    strokeWidth = 1.dp.toPx()
                )
                drawLine(
                    color = Color.Gray,
                    start = Offset(size.width / 1.8f, size.height / 2),
                    end = Offset(size.width, size.height / 2),
                    strokeWidth = 1.dp.toPx()
                )
            },
        horizontalArrangement = Arrangement.Center
    ) {
        BasicText(
            text = "Or",
            style = TextStyle(
                color = MaterialTheme.colorScheme.secondary,
                fontSize = 20.sp
            )
        )
    }
}