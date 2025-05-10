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
        ),
        Category(
            id = "6",
            name = "Design & Architecture",
        ),
        Category(
            id = "7",
            name = "Storage",
        ),
        Category(
            id = "8",
            name = "Network",
        ),
        Category(
            id = "9",
            name = "Asynchronism",
        ),
        Category(
            id = "10",
            name = "Common Services",
        ),
        Category(
            id = "11",
            name = "Linting",
        ),
        Category(
            id = "12",
            name = "Testing",
        ),
        Category(
            id = "13",
            name = "Debugging",
        ),
        Category(
            id = "14",
            name = "Distribution",
        )


    )
