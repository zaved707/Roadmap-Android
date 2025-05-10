package com.zavedahmad.androidroadmap.ui

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.zavedahmad.androidroadmap.data.AppViewModel
import com.zavedahmad.androidroadmap.data.Category

import com.zavedahmad.androidroadmap.data.findCategoryByNestedId


@Composable
fun DetailPage(modifier: Modifier, viewModel: AppViewModel, navHostController: NavHostController) {
    val category = findCategoryByNestedId(viewModel.sampleCategories, viewModel.selectedCategoryId)

    BackHandler {

        navHostController.popBackStack() // Go to previous screen
    }
    Box(modifier = modifier
        .fillMaxSize()
        .padding(16.dp)) {

        Column {
            Text(category?.name ?: "null category")
            LazyColumn {
                if (category != null) {
                    items(category.subItems) { item ->
                        OutlinedCard(
                            modifier = Modifier.fillMaxWidth(),
                            onClick = {
                                viewModel.selectedCategoryId = item.id
                                navHostController.navigate("detail/${item.id}")
                            }
                        ) {
                            Column(modifier = Modifier.padding(10.dp)) {

                                Text(
                                    item.name,

                                    )
                            }
                            Column {
                                if (item.childrenVisible) {
                                    for (x in item.subItems) {
                                        Card(modifier = Modifier.fillMaxWidth()) {
                                            Text(x.name, modifier = Modifier.padding(10.dp))
                                        }
                                    }
                                }
                                }
                            }

                    }
                } else {
                    // Optional: Handle the case when category is null
                    item {
                        Text(
                            text = "No category available",
                            modifier = Modifier.padding(10.dp)
                        )
                    }
                }
            }
        }

    }
}