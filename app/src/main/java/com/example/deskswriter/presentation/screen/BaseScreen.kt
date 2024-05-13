package com.example.deskswriter.presentation.screen

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.deskswriter.presentation.ui.theme.LightViolet

@Composable
fun BaseIcon(
    modifier: Modifier = Modifier,
    @DrawableRes iconId: Int,
    contentDescription: String = "",
    tintColor: Color = LightViolet
) {
    Icon(
        modifier = modifier.size(30.dp),
        painter = painterResource(id = iconId),
        contentDescription = "icon $contentDescription",
        tint = tintColor
    )
}

@Composable
fun BaseText(
    modifier: Modifier = Modifier,
    text: String,
    fontSize: Int = 16,
    color: Color = Color.White
) {
    Text(modifier = modifier, text = text, fontSize = fontSize.sp, color = color)
}