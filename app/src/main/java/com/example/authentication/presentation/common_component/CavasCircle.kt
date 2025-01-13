package com.example.authentication.presentation.common_component

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CircleCanvas() {
    Canvas(modifier=Modifier.fillMaxWidth().height(300.dp)) {
        val widthCircle=size.width
        val heightCircle=size.height
        val radius=widthCircle/2
        drawCircle(
            radius = radius,
            center = Offset(widthCircle/2,0f),
            color = Color(0xfff4c542)
        )
        drawCircle(
            radius = radius,
            center = Offset(widthCircle/2,heightCircle.times(1.24f)),
            color = Color(0xfff4c542)
        )
    }
}