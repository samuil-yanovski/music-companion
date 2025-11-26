package com.yanovski.musiccompanion.ui.theme

import android.app.Activity
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

private val DarkColorScheme =
    darkColorScheme(
        primary = Color(0xFFC6C3FF),
        onPrimary = Color(0xFF232159),
        primaryContainer = Color(0xFF363379),
        onPrimaryContainer = Color(0xFFE1E1FF),
        secondary = Color(0xFFFFB4A4),
        onSecondary = Color(0xFF5A1C12),
        secondaryContainer = Color(0xFF7A2B21),
        onSecondaryContainer = Color(0xFFFFDAD2),
        tertiary = Color(0xFF76DCEC),
        onTertiary = Color(0xFF00363D),
        tertiaryContainer = Color(0xFF004F58),
        onTertiaryContainer = Color(0xFFB8F0F6),
        background = Color(0xFF0F1115),
        onBackground = Color(0xFFE6E8F2),
        surface = Color(0xFF111318),
        onSurface = Color(0xFFE3E5F0),
        surfaceVariant = Color(0xFF2E3140),
        onSurfaceVariant = Color(0xFFC2C6D4),
        outline = Color(0xFF8C90A3),
        error = Color(0xFFFFB4AB),
        onError = Color(0xFF690005),
        errorContainer = Color(0xFF93000A),
        onErrorContainer = Color(0xFFFFDAD6),
    )

private val LightColorScheme =
    lightColorScheme(
        primary = Color(0xFF4F46E5),
        onPrimary = Color.White,
        primaryContainer = Color(0xFFE0E7FF),
        onPrimaryContainer = Color(0xFF1E1B4B),
        secondary = Color(0xFFFF6B6B),
        onSecondary = Color.White,
        secondaryContainer = Color(0xFFFFE8E8),
        onSecondaryContainer = Color(0xFF5F1414),
        tertiary = Color(0xFF06B6D4),
        onTertiary = Color(0xFF002B32),
        tertiaryContainer = Color(0xFFB8F0F6),
        onTertiaryContainer = Color(0xFF00363D),
        background = Color(0xFFFBFBFF),
        onBackground = Color(0xFF12131A),
        surface = Color(0xFFFFFFFF),
        onSurface = Color(0xFF1F2230),
        surfaceVariant = Color(0xFFE5E7F1),
        onSurfaceVariant = Color(0xFF44485A),
        outline = Color(0xFF767B8E),
        error = Color(0xFFBA1A1A),
        onError = Color.White,
        errorContainer = Color(0xFFFFDAD6),
        onErrorContainer = Color(0xFF410002),
    )

@Suppress("ktlint:standard:function-naming")
@Composable
fun MusicCompanionTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit,
) {
    val colorScheme =
        when {
            dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
                val context = LocalContext.current
                if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
            }

            darkTheme -> DarkColorScheme
            else -> LightColorScheme
        }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content,
    )
}
