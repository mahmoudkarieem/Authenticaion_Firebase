package com.example.authentication.presentation.common_component

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TitleView(titleView:String) {
    Text(
        modifier = Modifier.padding(start = 75.dp),
        text = titleView,
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.displaySmall,
        color = MaterialTheme.colorScheme.secondary,
        fontWeight = FontWeight.SemiBold,
        fontSize = 45.sp,
    )
}