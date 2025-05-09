package com.zavedahmad.androidroadmap.data

data class Category(
    val id: Int,
    val name: String,
    val subItems: List<Category> = emptyList()
)

val sampleCategories =
    listOf(
        Category(id = 1, name = "Pick a Language"),
        Category(
            id = 2,
            name = "step 2",
            subItems = listOf(
                Category(id = 21, name = "subTask1"),
                Category(id = 22, name = "subTask2"),
                Category(id = 23, name = "subTask3")
            )
        )
    )

