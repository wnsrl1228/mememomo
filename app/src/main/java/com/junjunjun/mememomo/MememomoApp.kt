package com.junjunjun.mememomo

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.junjunjun.mememomo.component.MememomoTopAppBar
import com.junjunjun.mememomo.navigation.MememomoNavHost

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MememomoApp(navController: NavHostController = rememberNavController()) {
    // TODO : 이 곳에서 배경, topbar, 테마, 초기 상태를 설정함
    Scaffold() { padding ->
        Row(
            Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            // TODO : 추후 NavigationRail 추가
            Column(
                Modifier
                    .fillMaxSize()
                    .padding(padding)) {
                MememomoTopAppBar(
                    title = "메메모모",
                    actionIcon = Icons.Rounded.MoreVert,
                    actionIconContentDescription = ""
                )
                MememomoNavHost(navController = navController)
            }
        }
    }
}

