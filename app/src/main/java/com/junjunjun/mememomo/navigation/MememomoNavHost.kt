package com.junjunjun.mememomo.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.junjunjun.mememomo.MemoAppState
import com.junjunjun.mememomo.ui.addeditmemo.AddEditMemoRoute
import com.junjunjun.mememomo.ui.addeditmemo.addEditMemoRoute
import com.junjunjun.mememomo.ui.memo.MemoRoute
import com.junjunjun.mememomo.ui.memo.memoRoute


@Composable
fun MememomoNavHost(
    appState: MemoAppState,
    modifier: Modifier = Modifier
){
    val navController = appState.navController
    NavHost(
        navController = navController,
        startDestination = memoRoute,
        modifier = modifier
    ) {
        composable(route = memoRoute) {
            MemoRoute(onAddMemo = { navController.navigate(addEditMemoRoute) })
        }

        composable(route = addEditMemoRoute) {
            AddEditMemoRoute()
        }
    }
}