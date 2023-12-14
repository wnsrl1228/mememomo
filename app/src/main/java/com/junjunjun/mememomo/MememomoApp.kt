package com.junjunjun.mememomo

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import com.junjunjun.mememomo.component.MememomoTopAppBar
import com.junjunjun.mememomo.component.MemoNavigationBar
import com.junjunjun.mememomo.component.MemoNavigationBarItem
import com.junjunjun.mememomo.navigation.MememomoNavHost
import com.junjunjun.mememomo.navigation.TopLevelDestination

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MememomoApp(
    appState: MemoAppState = rememberMemoAppState()
) {
    // TODO : 이 곳에서 배경, topbar, 테마, 초기 상태를 설정함

    Scaffold(
        bottomBar = {
            // Show the bottom app bar on top level destinations.
            val destination = appState.currentTopLevelDestination
            if (destination != null) {
                MemoBottomBar(
                    destinations = TopLevelDestination.values().asList(),
                    onNavigateToDestination = {}, // TODO : 목적지 이동 로직 추후 구현
                    currentDestination = NavDestination(""),
                    modifier = Modifier,
                )
            }
        }
    ) { padding ->
        Row(
            Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            // TODO : 추후 NavigationRail 추가
            Column(Modifier.fillMaxSize()) {
                MememomoTopAppBar(
                    title = "메메모모",
                    actionIcon = Icons.Rounded.MoreVert,
                    actionIconContentDescription = ""
                )
                MememomoNavHost(appState = appState)
            }
        }
    }
}

@Composable
private fun MemoBottomBar(
    destinations: List<TopLevelDestination>,
    onNavigateToDestination: (TopLevelDestination) -> Unit,
    currentDestination: NavDestination?,
    modifier: Modifier = Modifier,
) {
    MemoNavigationBar(
        modifier = modifier,
    ) {
        destinations.forEach { destination ->

            // 현재 목적지의 계층안에 어떤 최상위 목적지를 가지는지에 따라 bottomBar의 selected 여부를 파악할 수 있다.
            val selected = currentDestination?.hierarchy?.any {
                it.route?.contains(destination.name, true) ?: false
            } ?: false

            MemoNavigationBarItem(
                selected = selected,
                onClick = { onNavigateToDestination(destination) },
                icon = {
                    Icon(
                        imageVector = destination.unselectedIcon,
                        contentDescription = null,
                    )
                },
                selectedIcon = {
                    Icon(
                        imageVector = destination.selectedIcon,
                        contentDescription = null,
                    )
                },
                label = { Text(stringResource(destination.iconTextId)) },
//                modifier = if (hasUnread) Modifier.notificationDot() else Modifier,
                modifier = Modifier,
            )
        }
    }
}

