package com.junjunjun.mememomo.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.junjunjun.mememomo.ui.memo.MemoDestination
import com.junjunjun.mememomo.ui.memo.MemoScreen


@Composable
fun MememomoNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
){
    NavHost(
        navController = navController,
        startDestination = MemoDestination.route,
        modifier = modifier
    ) {
        composable(route = MemoDestination.route) {
            MemoScreen()
        }
    }
}