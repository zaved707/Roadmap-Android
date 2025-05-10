package com.zavedahmad.androidroadmap.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import androidx.compose.foundation.lazy.items

import androidx.compose.material3.OutlinedCard
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.zavedahmad.androidroadmap.data.AppViewModel

@Composable
fun MainPage(modifier: Modifier, viewModel: AppViewModel, navHostController: NavHostController) {
    Box(modifier = modifier.fillMaxSize()) {
        LazyColumn {
            items(viewModel.sampleCategories) { item ->
                OutlinedCard(modifier = Modifier.fillMaxWidth(), onClick = {
                    viewModel.selectedCategoryId = item.id
                    navHostController.navigate("detail/${viewModel.selectedCategoryId}")
                }) {
                    Text(
                        item.name,
                        modifier = Modifier.padding(10.dp)
                    )
                }
            }
        }
    }
}