package com.example.midtermexam.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(
    primary = LightBurgundy,
    secondary = Rose,
    tertiary = SoftRose,

    background = DarkBackground,
    surface = DarkCard,

    onPrimary = White,
    onSecondary = White,
    onTertiary = DarkText,
    onBackground = White,
    onSurface = White
)

private val LightColorScheme = lightColorScheme(
    primary = Burgundy,
    secondary = Rose,
    tertiary = LightBurgundy,

    background = Cream,
    surface = CardWhite,

    onPrimary = White,
    onSecondary = White,
    onTertiary = White,
    onBackground = DarkText,
    onSurface = DarkText
)

@Composable
fun MyApplicationTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) {
        DarkColorScheme
    } else {
        LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}