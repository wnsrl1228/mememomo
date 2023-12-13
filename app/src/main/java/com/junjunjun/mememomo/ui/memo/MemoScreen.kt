package com.junjunjun.mememomo.ui.memo

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.junjunjun.mememomo.R
import com.junjunjun.mememomo.ui.theme.MememomoTheme


const val memoRoute = "memo_route"
@Composable
fun MemoRoute(
    modifier: Modifier = Modifier,
    onAddMemo: () -> Unit
) {
    MemoScreen(
        onAddMemo = onAddMemo,
        modifier = modifier
    )
}

@Composable
fun MemoScreen(
    onAddMemo: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(modifier = modifier
        .fillMaxSize()
    ) {
        Memobody(
            modifier = modifier
        )

        FloatingActionButton(
            onClick = onAddMemo,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp),
            containerColor = MaterialTheme.colorScheme.tertiaryContainer,
            contentColor = MaterialTheme.colorScheme.onTertiaryContainer
        ) {
            Icon(
                imageVector = Icons.Default.Edit,
                contentDescription = stringResource(id = R.string.edit),
                modifier = Modifier.size(28.dp)
            )
        }
    }
}

@Composable
fun Memobody(
    modifier: Modifier = Modifier
) {
    val arrs= listOf(1,2,3,4,5,6,7,9)

    Box(
        modifier = modifier
            .fillMaxSize(),
    ) {

        LazyVerticalGrid(
            columns = GridCells.Adaptive(minSize = 170.dp),  // 최소 셀 너비
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp), // 그리드 전체 패딩
            verticalArrangement = Arrangement.spacedBy(8.dp),   // 가로와 가로 사이 간격
            horizontalArrangement = Arrangement.spacedBy(16.dp)  // 세로와 세로 사이 간격
        ) {
            // TODO : Text하나 넣어야 되는데 이 안에 못 넣음.
            // LazyVerticalGrid 안에 개별적인 item 넣고 한 칸 전체를 차지하는 방법이 아래 방법.
            // item을 여러개 만드는 방법도 있음
            item(span = { GridItemSpan(maxLineSpan) }, contentType = "path") {
                Text(
                    text = "홈 / ... / 폴더1",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth()
                )
            }

            items(arrs) { arr ->
                MemoFolder(title = "안녕하세요반갑습니다저는저는안녕입니다앞으로 잘 지내용 ㅇㄴㅇ", content = "asd")
            }

            item(span = { GridItemSpan(maxLineSpan) }, contentType = "bottom-padding") {
                Spacer(modifier = modifier.padding(bottom = 120.dp))
            }
        }
    }



//    Column {
//        MemoFolder(title = "제목", content = "내용")
//        MemoNote(title = "제목", content = "내용")
//    }

}

private val cardWidth = 170.dp

@Composable
fun MemoFolder(
    title: String,
    content: String,
    modifier: Modifier = Modifier
) {
    MemoFile(
        title = title,
        content = content,
        painter = painterResource(id = R.drawable.folder_memo),
        contentDescription = "folder",
        modifier = modifier
    )
}

@Composable
fun MemoNote(
    title: String,
    content: String,
    modifier: Modifier = Modifier
) {
    MemoFile(
        title = title,
        content = content,
        painter = painterResource(id = R.drawable.note_memo),
        contentDescription = "note",
        modifier = modifier
    )
}

@Composable
private fun MemoFile(
    title: String,
    content: String,
    painter: Painter,
    contentDescription: String?,
    modifier: Modifier,
) {
    Column(
        modifier = modifier
            .size(
                width = cardWidth,
                height = 290.dp
            )
    ) {

        Icon(
            painter = painter,
            contentDescription = contentDescription,
            tint = Color.Unspecified,  // 추가해줘야 Icon 본래 색감이 나옴
            modifier = Modifier
                .padding(start = 8.dp)
                .offset(y = (20).dp)
                .zIndex(1f)
        )

        Card(
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.background,
            ),
            border = BorderStroke(0.5.dp, Color.LightGray),
            modifier = Modifier
                .height(170.dp)
                .shadow(
                    elevation = 4.dp,
                    shape = RoundedCornerShape(16.dp)
                )
                .offset(y = (-2).dp)
                .fillMaxWidth()

        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxSize()
            ) {

                FilePreviewContentText(
                    text = content,
                    modifier = Modifier
                        .padding(horizontal = 8.dp, vertical = 8.dp)
                )
            }
        }

        FileTitleText(
            text = title,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 6.dp)
                .padding(horizontal = 8.dp)
        )


        Text(
            text = "2023.10.13",
            color = Color.Gray,
            textAlign = TextAlign.Center,
            fontSize = 13.sp,
            maxLines = 1,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 2.dp)
                .padding(horizontal = 8.dp)
        )

    }
}
@Composable
fun FilePreviewContentText(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        fontSize = 10.sp ,
        overflow = TextOverflow.Ellipsis,
        lineHeight = 14.sp,
        modifier = modifier
    )
}
@Composable
fun FileTitleText(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        maxLines = 2,
        overflow = TextOverflow.Ellipsis,
        modifier = modifier
    )
}

@Preview
@Composable
private fun MemoBodyPreview() {
    MememomoTheme {
        Memobody()
    }
}

@Preview
@Composable
private fun MemoFolderPreview() {
    MememomoTheme {
        MemoFolder(title = "제목", content = "내용")
    }
}