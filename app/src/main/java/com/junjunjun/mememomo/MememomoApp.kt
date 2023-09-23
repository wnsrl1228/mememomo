package com.junjunjun.mememomo

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.junjunjun.mememomo.navigation.MememomoNavHost

@Composable
fun MememomoApp(navController: NavHostController = rememberNavController()) {
    // TODO : 이 곳에서 배경, topbar, 테마, 초기 상태를 설정함
    MememomoNavHost(navController = navController)
}

