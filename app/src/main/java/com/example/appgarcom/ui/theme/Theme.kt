package com.example.appgarcom.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFFFACB11),
    secondary = Color(0xFF66BB6A),

    tertiary = Color(0xFFFFB74D),
    error = Color(0xFFE57373),
    background = Color(0xFF0D0D0D),
    surface = Color(0xFF1C1C1C),

    onPrimary = Color(0xFF000000),
    onSecondary = Color(0xFF000000),
    onTertiary = Color(0xFF000000),

    onBackground = Color(0xFFEAEAEA),
    onSurface = Color(0xFFEAEAEA),
    onError = Color(0xFF000000),

    outline = Color(0xFF3A3A3A),
    scrim = Color(0xFF000000)
)

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF502392),
    secondary = Color(0xFF2E7D32),

    tertiary = Color(0xFFFF9800),
    error = Color(0xFFD32F2F),

    background = Color(0xFFF5F5F5),
    surface = Color(0xFFFFFFFF),

    onPrimary = Color(0xFFFFFFFF),
    onSecondary = Color(0xFFFFFFFF),

    onTertiary = Color(0xFF1C1C1C),
    onBackground = Color(0xFF1C1C1C),
    onSurface = Color(0xFF1C1C1C),

    onError = Color(0xFFFFFFFF),

    outline = Color(0xFFBDBDBD),
    scrim = Color(0xFF000000)
)

@Composable
fun AppGarcomTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {

    val colorScheme = when {

        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context)
            else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}