package com.zavedahmad.androidroadmap.ui

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(scrollBehavior: TopAppBarScrollBehavior, title : String) {
    TopAppBar(title = { Text(title, fontSize = 25.sp) }, scrollBehavior = scrollBehavior)
}