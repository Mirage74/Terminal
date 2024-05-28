package com.balex.terminal.samples

import android.os.Parcelable
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.listSaver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.parcelize.Parcelize

@Composable
fun TestSaver() {
    var testData by rememberSaveable(saver = TestData.saver) {
        mutableStateOf(TestData(0, "1"))
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .clickable {
                testData = testData.copy(number = testData.number + 1, text = testData.text + testData.number)
            },
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Text: $testData")

    }
}

//@Parcelize
//data class TestData(val number: Int): Parcelable


data class TestData(val number: Int, val text: String) {
    companion object {
        val saver: Saver<MutableState<TestData>, Any> = listSaver(
            save = {
                val testData = it.value
                listOf(testData.number, testData.text)
            },
            restore = {
                val testData = TestData(
                    number = it[0] as Int,
                    text = it[1] as String
                )
                mutableStateOf(testData)
            }
        )
    }
}