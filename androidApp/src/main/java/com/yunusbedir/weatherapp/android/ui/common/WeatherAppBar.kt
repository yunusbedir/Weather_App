package com.yunusbedir.weatherapp.android.ui.common

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yunusbedir.weatherapp.android.MyApplicationTheme


@Composable
fun WeatherAppBar(
    canNavigateBack: Boolean,
    canMoreVert: Boolean,
    currentScreen: Destination,
    onNavigateBack: () -> Unit,
    onAddClicked: () -> Unit,
    onMoreVertClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp),
        color = Color.Transparent
    ) {

        Row(
            modifier = Modifier,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Box {
                this@Row.AnimatedVisibility(
                    visible = canNavigateBack
                ) {
                    IconButton(
                        onClick = onNavigateBack
                    ) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = null,
                            tint = MaterialTheme.colors.onBackground
                        )
                    }
                }
                this@Row.AnimatedVisibility(
                    visible = currentScreen.title == Home.title
                ) {
                    IconButton(
                        onClick = onAddClicked
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Add,
                            contentDescription = null,
                            tint = MaterialTheme.colors.onBackground
                        )
                    }
                }
            }
            Text(
                text = currentScreen.title,
                style = MaterialTheme.typography.h6,
                modifier = Modifier
                    .padding(12.dp),
                color = MaterialTheme.colors.onSurface
            )
            AnimatedVisibility(
                visible = canMoreVert
            ) {
                IconButton(
                    onClick = onMoreVertClicked,
                ) {
                    Icon(
                        imageVector = Icons.Filled.MoreVert,
                        contentDescription = null,
                        tint = MaterialTheme.colors.onBackground
                    )
                }
            }
        }

    }
}


@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        WeatherAppBar(
            canNavigateBack = false,
            canMoreVert = true,
            currentScreen = Home,
            onNavigateBack = {},
            onAddClicked = {},
            onMoreVertClicked = {}
        )
    }
}