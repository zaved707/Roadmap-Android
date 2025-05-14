package com.zavedahmad.androidroadmap.data

data class Category(
    val id: String,
    val name: String,
    val subItems: List<Category> = emptyList(),
    val childrenVisible: Boolean = false,
    val link: String = "www.google.com"
)


fun findCategoryById(categories: List<Category>, id: String?): Category? {
    return categories.find { it.id == id }
}

fun findCategoryByNestedId(categories: List<Category>, id: String?): Category? {
    if (id == null) return null
    val idParts = id.split("_").filter { it.isNotEmpty() }
    var category: Category? = null
    var currentCategories = categories
    var currentId: String? = ""
    for (x in 0..idParts.size - 1) {
        if (x == 0) {
            currentId += "${idParts[x]}"
        } else {
            currentId += "_${idParts[x]}"
        }
        println(currentId)
        category = findCategoryById(currentCategories, currentId) ?: return null

        currentCategories = category.subItems

    }
    return category

}


fun main() {
    val answer =
        findCategoryByNestedId(sampleCategories, "1_2_2")
    println(answer)
}

val sampleCategories =
    listOf(
        Category(
            id = "1", name = "Pick a Language", subItems = listOf(
                Category(id = "1_1", name = "Java"),
                Category(
                    id = "1_2",
                    name = "Kotlin",
                    subItems = listOf(
                        Category(id = "1_2_1", "zaved"),
                        Category(id = "1_2_2", "sabreen")
                    )
                )

            )
        ),
        Category(
            id = "2",
            name = "The Fundamentals",
            subItems = listOf(
                Category(id = "2_1", name = "Development IDE"),
                Category(id = "2_2", name = "Basics Of Kotlin"),
                Category(id = "2_3", name = "Basics Of OOP"),
                Category(
                    id = "2_4",
                    name = "Data Structures and Algorithms",
                ),
                Category(
                    id = "2_5",
                    name = "What is and how to use Gradle?",
                ),
                Category(
                    id = "2_6",
                    name = "Create a Basic Hello World App",
                )

            )
        ),
        Category(
            id = "3",
            name = "Version Control",
            subItems = listOf(
                Category(
                    id = "3_1",
                    name = "Git",
                ),
                Category(
                    id = "3_2",
                    name = "GitHub",
                ),
                Category(
                    id = "3_3",
                    name = "GitLab",
                ),
                Category(
                    id = "3_4",
                    name = "BitBucket",
                )
            )
        ),
        Category(
            id = "4",
            name = "App Components",
            subItems = listOf(
                Category(
                    id = "4_1",
                    name = "Services",
                ),
                Category(
                    id = "4_2",
                    name = "Content Provider",
                ),
                Category(
                    id = "4_3",
                    name = "Broadcast Receiver",
                ),
                Category(
                    id = "4_4",
                    name = "Intent",
                    childrenVisible = true,
                    subItems = listOf(
                        Category(
                            id = "4_4_1",
                            name = "Implicit Intents"
                        ),
                        Category(
                            id = "4_4_2",
                            name = "Explicit Intents",
                        ),
                        Category(
                            id = "4_4_3",
                            name = "Intent Filters",
                        )

                    )
                ),
                Category(
                    id = "4_5",
                    name = "Activity",
                    childrenVisible = true,
                    subItems = listOf(
                        Category(
                            id = "4_5_1",
                            name = "Activity LifeCycle",
                        ),
                        Category(
                            id = "4_5_2",
                            name = "State Changes",

                            ),
                        Category(
                            id = "4_5_3",
                            name = "Tasks & Backstack",
                        )

                    )
                )
            )
        ),
        Category(
            id = "5",
            name = "Interface & Navigation",
            subItems = listOf(
                Category(
                    id = "5_1",
                    name = "elements",
                    childrenVisible = true,
                    subItems = listOf(
                        Category(id = "5_1_1", name = "TextView"),
                        Category(id = "5_1_2", name = "Toast"),
                        Category(id = "5_1_3", name = "Fragments"),
                        Category(id = "5_1_4", name = "Dialogs"),
                        Category(id = "5_1_5", name = "Buttons"),
                        Category(id = "5_1_6", name = "Bottom Sheet"),
                        Category(id = "5_1_7", name = "ImageView"),
                        Category(id = "5_1_8", name = "Tabs"),
                        Category(id = "5_1_9", name = "EditText"),
                        Category(id = "5_1_10", name = "Drawer"),
                        Category(id = "5_1_11", name = "ListView"),
                        Category(id = "5_1_12", name = "Animations")
                    )
                ),
                Category(
                    id = "5_2",
                    name = "Layouts",
                    childrenVisible = true,
                    subItems = listOf(
                        Category(id = "5_2_1", name = "Frame"),
                        Category(id = "5_2_2", name = "Linear"),
                        Category(id = "5_2_3", name = "Relative"),
                        Category(id = "5_2_4", name = "Constraint"),
                        Category(id = "5_2_5", name = "RecyclerView")
                    )
                ),
                Category(
                    id = "5_3",
                    name = "Jetpack Compose",
                ),
                Category(
                    id = "5_4",
                    name = "App Shortcuts",

                    ),
                Category(
                    id = "5_5",
                    name = "Navigation Components",
                )

            )
        ),
        Category(
            id = "6",
            name = "Design & Architecture",

            subItems = listOf(
                Category(
                    id = "6_1",
                    name = "Architectural Patterns",
                    childrenVisible = true,
                    subItems = listOf(
                        Category(id = "6_1_1", name = "MVI"),
                        Category(id = "6_1_2", name = "MVVM"),
                        Category(id = "6_1_3", name = "MVP"),
                        Category(id = "6_1_4", name = "MVC")
                    )
                ),
                Category(
                    id = "6_2", name = "Design Patterns", childrenVisible = true, subItems = listOf(
                        Category(id = "6_2_1", name = "Repository Pattern"),
                        Category(id = "6_2_2", name = "Builder Pattern"),
                        Category(id = "6_2_3", name = "Factory Pattern"),
                        Category(
                            id = "6_2_4",
                            name = "Observer Pattern",
                            childrenVisible = true,
                            subItems = listOf(
                                Category(id = "6_2_4_1", name = "Flow"),
                                Category(id = "6_2_4_2", name = "RxKotlin"),
                                Category(id = "6_2_4_3", name = "RxJava"),
                                Category(id = "6_2_4_4", name = "LiveData"),
                            )
                        ),
                        Category(
                            id = "6_2_5",
                            name = "Dependency Injection",
                            childrenVisible = true,
                            subItems = listOf(
                                Category(id = "6_2_5_1", name = "Dagger"),
                                Category(id = "6_2_5_2", name = "Hilt"),
                                Category(id = "6_2_5_3", name = "Koin"),
                                Category(id = "6_2_5_4", name = "Kodein")
                            )
                        ),

                        )
                )
            )
        ),
        Category(
            id = "7",
            name = "Storage", subItems = listOf(
                Category(id = "7_1", name = "Shared Preferences"),
                Category(id = "7_2", name = "DataStore"),
                Category(id = "7_3", name = "Room Database"),
                Category(id = "7_4", name = "File System")
            )
        ),
        Category(
            id = "8",
            name = "Network",
            subItems = listOf(
                Category(id = "8_1", name = "Retro"),
                Category(id = "8_2", name = "OKHttp"),
                Category(id = "8_3", name = "Apollo-Android")
            )
        ),
        Category(
            id = "9",
            name = "Asynchronism", subItems = listOf(
                Category(id = "9_1", name = "Coroutines"),
                Category(id = "9_2", name = "Threads"),
                Category(id = "9_3", name = "RxJava"),
                Category(id = "9_4", name = "RxKotlin"),
                Category(id = "9_5", name = "WorkManager")
            )
        ),
        Category(
            id = "10",
            name = "Common Services", subItems = listOf(
                Category(id = "10_1", name = "Firebase"),
                Category(id = "10_2", name = "Google AdMob"),
                Category(id = "10_3", name = "Google Play Services"),
                Category(id = "10_4", name = "Google Maps")
            )
        ),
        Category(
            id = "11",
            name = "Linting",
            subItems = listOf(
                Category(id = "11_1", name = "Ktlint"),
                Category(id = "11_2", name = "Detekt")
            )
        ),
        Category(
            id = "12",
            name = "Testing",
            subItems = listOf(
                Category(id = "12_1", name = "Espresso"),
                Category(id = "12_2", name = "JUnit")
            )
        ),
        Category(
            id = "13",
            name = "Debugging", subItems = listOf(
                Category(id = "13_1", name = "Timber"),
                Category(id = "13_2", name = "Leak Canary"),
                Category(id = "13_3", name = "Chucker"),
                Category(id = "13_4", name = "Jetpack Benchmark")
            )
        ),
        Category(
            id = "14",
            name = "Distribution", subItems = listOf(
                Category(id = "14_1", name = "Signed APK"),
                Category(id = "14_2", name = "Firebase Distribution"),
                Category(id = "14_3", name = "Google Playstore")
            )
        )


    )
