package com.example.deskswriter.presentation.activity

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import com.example.deskswriter.App
import com.example.deskswriter.presentation.screen.home.HomeScreen
import com.example.deskswriter.presentation.screen.home.HomeViewModel
import com.example.deskswriter.presentation.screen.home.HomeViewModelFactory
import com.example.deskswriter.presentation.ui.theme.DarkViolet
import com.example.deskswriter.presentation.ui.theme.DesksWriterTheme
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    @Inject
    lateinit var homeViewModelFactory: HomeViewModelFactory

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (applicationContext as App).appComponent.inject(this)
        homeViewModel = ViewModelProvider(this, homeViewModelFactory).get(HomeViewModel::class.java)
        val boxModifier = Modifier
            .fillMaxSize()
            .background(color = DarkViolet)
            .padding(16.dp)
        setContent {
            DesksWriterTheme {
                HomeScreen(modifier = boxModifier, homeViewModel = homeViewModel)
            }
        }
    }
}