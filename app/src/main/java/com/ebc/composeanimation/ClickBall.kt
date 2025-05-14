package com.ebc.composeanimation

import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun ClickBall(
    containerWidth: Dp = 300.dp,
    ballSize: Dp = 50.dp,
    animationDuration: Int = 1000
) {

    var moved by remember {mutableStateOf(false)}

    val offsetX by animateDpAsState(
        targetValue = if(moved) containerWidth - ballSize else 0.dp,
        animationSpec = tween(
            durationMillis = animationDuration,
            easing = LinearOutSlowInEasing
        )
    )

    Box(
        modifier = Modifier
            .width(containerWidth)
            .height(ballSize)
            .clickable { moved =  !moved }
            .padding(horizontal = 4.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        Box(
            modifier = Modifier
                .offset(x = offsetX)
                .size(ballSize)
                .aspectRatio(1f)
                .background(
                    color = Color.Red,
                    shape = CircleShape
                )
        )
    }

}