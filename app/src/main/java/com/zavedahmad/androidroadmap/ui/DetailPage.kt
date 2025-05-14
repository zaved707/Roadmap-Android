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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.zavedahmad.androidroadmap.data.AppViewModel
import com.zavedahmad.androidroadmap.data.Category

import com.zavedahmad.androidroadmap.data.findCategoryByNestedId

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailPage(modifier: Modifier, viewModel: AppViewModel, navHostController: NavHostController) {

    val category = findCategoryByNestedId(viewModel.sampleCategories, viewModel.selectedCategoryId)
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()

    BackHandler {

        navHostController.popBackStack() // Go to previous screen
    }
    Scaffold(
        topBar = { MyTopAppBar(scrollBehavior, category?.name ?: "null category") },
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection)
    ) { innerPadding ->


        Column(modifier = Modifier
            .padding(innerPadding)
            .padding(10.dp)) {
            if (category?.info != null && category?.subItems?.size == 0) {
                Text(category?.info ?: "hi")

                if (category?.links != null) {
                    for (x in category.links) {
                        Text(x.item, style = TextStyle(color = MaterialTheme.colorScheme.primary, textDecoration = TextDecoration.Underline))
                    }
                }
            }
            LazyColumn {
                if (category != null) {
                    items(category.subItems) { item ->
                        Card(
                            modifier = Modifier.fillMaxWidth(), onClick = {
                                viewModel.selectedCategoryId = item.id
                                navHostController.navigate("detail/${item.id}")
                            }) {
                            Column(modifier = Modifier.padding(10.dp)) {

                                Text(
                                    item.name, fontSize = 20.sp
                                )
                            }

                            if (item.childrenVisible) {
                                Column(modifier = Modifier.padding(10.dp)) {
                                    for (x in item.subItems) {
                                        OutlinedCard(modifier = Modifier.fillMaxWidth(), onClick = {
                                            viewModel.selectedCategoryId = x.id
                                            navHostController.navigate("detail/${x.id}")
                                        }) {
                                            Text(
                                                x.name,
                                                modifier = Modifier.padding(10.dp),
                                                fontSize = 18.sp
                                            )
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
                            text = "No category available", modifier = Modifier.padding(10.dp)
                        )
                    }
                }
            }
        }


    }
}