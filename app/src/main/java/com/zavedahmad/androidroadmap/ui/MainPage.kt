package com.zavedahmad.androidroadmap.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LargeTopAppBar

import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.zavedahmad.androidroadmap.data.AppViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainPage(modifier: Modifier, viewModel: AppViewModel, navHostController: NavHostController) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = { MyTopAppBar(scrollBehavior,"Android Roadmap") }) { innerpadding ->
        MyScreenContent(Modifier.padding(innerpadding), viewModel, navHostController)
    }
}


@Composable
fun MyScreenContent(
    modifier: Modifier,
    viewModel: AppViewModel,
    navHostController: NavHostController
) {
    LazyColumn(modifier = modifier) {
        items(viewModel.sampleCategories) { item ->
            OutlinedCard(modifier = Modifier.fillMaxWidth(), onClick = {
                viewModel.selectedCategoryId = item.id
                navHostController.navigate("detail/${viewModel.selectedCategoryId}")
            }) {
                Text(
                    item.name,
                    modifier = Modifier.padding(10.dp),
                    fontSize = 20.sp
                )
            }

        }
    }
}