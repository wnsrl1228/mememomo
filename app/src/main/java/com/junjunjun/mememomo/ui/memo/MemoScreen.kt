package com.junjunjun.mememomo.ui.memo

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.junjunjun.mememomo.MememomoTopAppBar
import com.junjunjun.mememomo.R
import com.junjunjun.mememomo.navigation.NavigationDestination


object MemoDestination : NavigationDestination {
    override val route = "memo"
    override val titleRes = R.string.app_name

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MemoScreen(
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            MememomoTopAppBar(title = "메메모모", canNavigateBack = false)
        },
        modifier = modifier
    ) { innerPadding ->
        Memobody(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        )
    }
}

@Composable
fun Memobody(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Text("안녕")
    }
}