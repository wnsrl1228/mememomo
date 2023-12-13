package com.junjunjun.mememomo.component

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * 일단은 bottomBar
 */
@Composable
fun RowScope.MemoNavigationBarItem(
    selected: Boolean,
    onClick: () -> Unit,
    icon: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    selectedIcon: @Composable () -> Unit = icon,
    enabled: Boolean = true,
    label: @Composable (() -> Unit)? = null,
    alwaysShowLabel: Boolean = true,
) {
    NavigationBarItem(
        selected = selected,
        onClick = onClick,
        icon = if (selected) selectedIcon else icon,
        modifier = modifier,
        enabled = enabled,
        label = label,
        alwaysShowLabel = alwaysShowLabel,
        colors = NavigationBarItemDefaults.colors(
            selectedIconColor = MemoNavigationDefaults.navigationSelectedItemColor(),
            unselectedIconColor = MemoNavigationDefaults.navigationContentColor(),
            selectedTextColor = MemoNavigationDefaults.navigationSelectedItemColor(),
            unselectedTextColor = MemoNavigationDefaults.navigationContentColor(),
            indicatorColor = MemoNavigationDefaults.navigationIndicatorColor(),
        ),
    )
}

@Composable
fun MemoNavigationBar(
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit,
) {
    NavigationBar(
        modifier = modifier,
        tonalElevation = 10.dp,
        content = content,
    )
}

/**
 * Navigation 컬러, 현재는 복붙해온 상태 그대로임
 */
object MemoNavigationDefaults {
    @Composable
    fun navigationContentColor() = MaterialTheme.colorScheme.onSurfaceVariant

    @Composable
    fun navigationSelectedItemColor() = MaterialTheme.colorScheme.onPrimaryContainer

    @Composable
    fun navigationIndicatorColor() = MaterialTheme.colorScheme.primaryContainer
}
