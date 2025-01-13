package com.example.authentication.presentation.common_component

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TitleAuthentication(titleAuth: String) {
    Text(
        modifier = Modifier
            .padding(bottom = 6.dp, start = 2.dp),
        text = titleAuth,
        style = MaterialTheme.typography.titleLarge.copy(
            color = MaterialTheme.colorScheme.secondary,
            fontSize = 22.sp
        ),
        textAlign = TextAlign.Start
    )
}