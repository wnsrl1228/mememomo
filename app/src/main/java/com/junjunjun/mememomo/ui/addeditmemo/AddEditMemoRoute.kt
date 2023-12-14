package com.junjunjun.mememomo.ui.addeditmemo

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.junjunjun.mememomo.ui.theme.MememomoTheme

const val addEditMemoRoute = "addEditMemo_route"

@Composable
fun AddEditMemoRoute(
    modifier: Modifier = Modifier,
) {
    AddEditScreen(
        modifier = modifier
    )
}

@Composable
fun AddEditScreen(
    modifier: Modifier = Modifier,
) {
    Box(modifier = modifier
        .fillMaxSize()
    ) {
        AddEditBody(
            modifier = modifier
        )
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddEditBody(
    modifier: Modifier = Modifier,
) {

    // 임시
    var title by remember { mutableStateOf("") }
    var content by remember { mutableStateOf("") }

    var focusRequester = remember {
        FocusRequester()
    }

    Column() {
        /**
         * TODO : 1. 제목 글자수 제한 경고 문구
         *        2. 글자가 자판에 가리는 문제 해결
         *           -
         *        3. 스크롤바 구현
         */
        TextField(
            value = title,
            onValueChange = { if (it.length < 51) title = it},
            keyboardActions = KeyboardActions(onDone = {focusRequester.requestFocus()}),
            placeholder = { Text("제목을 입력하세요", color = Color.LightGray, fontSize = 24.sp, fontWeight = FontWeight.Bold)},
            singleLine = true,
            textStyle = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold),
            modifier = modifier.fillMaxWidth(),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.Unspecified,
                focusedIndicatorColor = Color.Unspecified, // border
                unfocusedIndicatorColor = Color.Unspecified
            )
        )


        TextField(
            value = content,
            onValueChange = {content = it},
            placeholder = { Text("내용을 입력하세요", color = Color.LightGray)},
            modifier = modifier
                .fillMaxSize()
                .focusRequester(focusRequester)
            ,
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.Unspecified,
                focusedIndicatorColor = Color.Unspecified, // border
                unfocusedIndicatorColor = Color.Unspecified
            )
        )
    }


}

@Preview
@Composable
private fun AddEditBodyPreview() {
    MememomoTheme {
        AddEditBody()
    }
}