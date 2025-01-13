package com.example.authentication.presentation.common_component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HaveAccount(
    modifier: Modifier=Modifier,
    accountState:String,
    onClickListener:() -> Unit
                ) {
    Text(
        modifier = Modifier
            .clickable {onClickListener()}
            .padding(top = 10.dp, start = 70.dp),
        text = accountState,
        fontSize = 15.sp,
        color = MaterialTheme.colorScheme.tertiary,
        style = MaterialTheme.typography.bodyMedium,
        textAlign = TextAlign.Center
    )
}