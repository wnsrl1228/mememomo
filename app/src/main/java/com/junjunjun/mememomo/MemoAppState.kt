package com.junjunjun.mememomo

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.junjunjun.mememomo.navigation.TopLevelDestination
import com.junjunjun.mememomo.ui.memo.memoRoute

/**
 * App 상태관리
 */
@Composable
fun rememberMemoAppState(
    navController: NavHostController = rememberNavController(),
): MemoAppState {
    return remember(
        navController,
    ) {
        MemoAppState(
            navController,
        )
    }
}

@Stable
class MemoAppState(
    val navController: NavHostController,
) {

    val currentDestination: NavDestination?
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination

    val currentTopLevelDestination: TopLevelDestination?
        @Composable get() = when (currentDestination?.route) {
            memoRoute -> TopLevelDestination.MEMO
            else -> null
        }
}