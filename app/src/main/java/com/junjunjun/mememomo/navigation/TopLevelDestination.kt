package com.junjunjun.mememomo.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.rounded.DateRange
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.ui.graphics.vector.ImageVector
import com.junjunjun.mememomo.R

/**
 * 앱에 있는 최상위 레벨의 목적지
 */
enum class TopLevelDestination(
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val iconTextId: Int,
    val titleTextId: Int,
) {

    MEMO(
        selectedIcon = Icons.Rounded.Edit,
        unselectedIcon = Icons.Outlined.Edit,
        iconTextId = R.string.memo,
        titleTextId = R.string.memo,
    ),
    CALENDER(
        selectedIcon = Icons.Rounded.DateRange,
        unselectedIcon = Icons.Outlined.DateRange,
        iconTextId = R.string.calendar,
        titleTextId = R.string.calendar,
    )
}