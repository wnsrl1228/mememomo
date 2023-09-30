package com.junjunjun.mememomo.ui.memo

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
    modifier: Modifier = Modifier
) {
    MemoScreen(
        modifier = modifier
    )
}

@Composable
fun MemoScreen(
    modifier: Modifier = Modifier
) {
    Memobody(
        modifier = modifier
    )
}

@Composable
fun Memobody(
    modifier: Modifier = Modifier
) {
    Column {
        MemoFolder(title = "제목", content = "내용")
        MemoNote(title = "제목", content = "내용")
    }

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
                height = 280.dp
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