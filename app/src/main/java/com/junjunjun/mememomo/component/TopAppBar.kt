package com.junjunjun.mememomo.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview

/**
 * actions(top end)와 navigationIcon(top start) 둘 다 있는 topbar
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MememomoTopAppBar(
    title: String,
    navigationIcon: ImageVector,
    navigationIconContentDescription: String?,
    actionIcon: ImageVector,
    actionIconContentDescription: String?,
    scrollBehavior: TopAppBarScrollBehavior? = null,
    onNavigationClick: () -> Unit = {},
    onActionClick: () -> Unit = {},
    modifier: Modifier = Modifier,
) {
    CenterAlignedTopAppBar(
        title = { Text(text = title) },
        modifier = modifier,
        scrollBehavior = scrollBehavior,
        navigationIcon = {
            IconButton(onClick = onNavigationClick) {
                Icon(
                    imageVector = navigationIcon,
                    contentDescription = navigationIconContentDescription
                )
            }
        },
        actions = {
            IconButton(onClick = onActionClick) {
                Icon(
                    imageVector = actionIcon,
                    contentDescription = actionIconContentDescription,
                    tint = MaterialTheme.colorScheme.onSurface,
                )
            }
        },
    )
}

/**
 * actions(top end)만 있는 topbar
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MememomoTopAppBar(
    title: String,
    actionIcon: ImageVector,
    actionIconContentDescription: String?,
    scrollBehavior: TopAppBarScrollBehavior? = null,
    onActionClick: () -> Unit = {},
    modifier: Modifier = Modifier,
) {
    CenterAlignedTopAppBar(
        title = { Text(text = title) },
        modifier = modifier,
        scrollBehavior = scrollBehavior,
        actions = {
            IconButton(onClick = onActionClick) {
                Icon(
                    imageVector = actionIcon,
                    contentDescription = actionIconContentDescription,
                    tint = MaterialTheme.colorScheme.onSurface,
                )
            }
        },
    )
}
@OptIn(ExperimentalMaterial3Api::class)
@Preview("Top App Bar")
@Composable
private fun MememomoTopAppBarPreview() {
    MememomoTopAppBar(
        title = "메메모모",
        actionIcon = Icons.Rounded.MoreVert,
        actionIconContentDescription = "list",
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview("Top App Bar")
@Composable
private fun MememomoTopAppBarPreview2() {
    MememomoTopAppBar(
        title = "메메모모",
        actionIcon = Icons.Rounded.MoreVert,
        actionIconContentDescription = "list",
        navigationIcon = Icons.Rounded.ArrowBack,
        navigationIconContentDescription = "back"
    )
}