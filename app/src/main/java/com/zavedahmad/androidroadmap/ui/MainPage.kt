package com.zavedahmad.androidroadmap.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.zavedahmad.androidroadmap.data.sampleCategories
import androidx.compose.foundation.lazy.items

import androidx.compose.material3.OutlinedCard
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun MainPage(modifier: Modifier,navHostController: NavHostController) {
    Box(modifier = modifier.fillMaxSize()) {
        LazyColumn {
            items(sampleCategories) { item ->
                OutlinedCard(modifier= Modifier.fillMaxWidth(),  onClick = {navHostController.navigate("detail")}) {
                    Text(
                        item.name,
                        modifier = Modifier.padding(10.dp)
                    )
                }
            }
        }
    }
}