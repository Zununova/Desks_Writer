package com.example.deskswriter.presentation.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.desks_writer.domain.medels.FileModel
import com.example.deskswriter.R
import com.example.deskswriter.presentation.screen.BaseIcon
import com.example.deskswriter.presentation.screen.BaseText
import com.example.deskswriter.presentation.ui.theme.DarkViolet
import com.example.deskswriter.presentation.ui.theme.LightViolet
import com.example.deskswriter.presentation.ui.theme.Violet1

@Composable
fun HomeScreen(modifier: Modifier = Modifier, homeViewModel: HomeViewModel) {
    val fileListState = homeViewModel.getFiles().collectAsState(initial = listOf()).value
    Box(modifier = modifier) {
        Column {
            Toolbar()
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(
                    8.dp,
                    Alignment.CenterVertically
                )
            ) {
                items(fileListState) { fileModel ->
                    FileItem(fileModel = fileModel)
                }
            }
        }
        AddButton(modifier = Modifier.align(Alignment.BottomEnd)) {
            homeViewModel.addFile(FileModel("title", "description", "data"))
        }
    }
}

@Composable
fun Toolbar() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
    ) {
        BaseIcon(
            modifier = Modifier.align(Alignment.CenterStart),
            iconId = R.drawable.ui_home_screen_ic_menu
        )

        BaseText(
            modifier = Modifier.align(Alignment.Center),
            text = stringResource(R.string.desk_s_writer),
            fontSize = 20
        )

        BaseIcon(
            modifier = Modifier.align(Alignment.CenterEnd),
            iconId = R.drawable.ui_home_screen_ic_search
        )
    }
}

@Composable
fun FileItem(fileModel: FileModel) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(color = Violet1, shape = RoundedCornerShape(20.dp))
            .padding(16.dp)
    ) {
        BaseText(modifier = Modifier.align(Alignment.TopStart), text = fileModel.title)
        BaseText(
            modifier = Modifier.align(Alignment.BottomEnd),
            text = fileModel.data,
            fontSize = 12,
            color = LightViolet
        )
    }
}

@Composable
fun AddButton(modifier: Modifier = Modifier, addFile: () -> Unit) {
    Button(
        modifier = modifier.size(60.dp),
        onClick = { addFile() },
        shape = RoundedCornerShape(40.dp),
        colors = ButtonDefaults.buttonColors(
            LightViolet
        )
    ) {
        BaseIcon(iconId = R.drawable.ui_home_screen_ic_add, tintColor = DarkViolet)
    }
}