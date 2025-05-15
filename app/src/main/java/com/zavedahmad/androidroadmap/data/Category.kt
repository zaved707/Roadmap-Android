package com.zavedahmad.androidroadmap.data

data class Link(
    val item: String,
    val link: String
)

data class Category(
    val id: String,
    val name: String,
    val info: String? = null,
    val subItems: List<Category> = emptyList(),
    val childrenVisible: Boolean = false,
    val links: List<Link>? = null

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
            id = "1",
            name = "Pick a Language",
            info = "When developing for Android, one crucial step is picking a programming language to use. There are multiple languages you can choose from, but the three most popular ones are Java, Kotlin, and C++.\n" +

                    "Java is the original language used for Android development and is widely used, making it a good choice for beginners due to the wealth of resources and developer communities. Kotlin is a newer option that is fully supported by Google and Android Studio, and addressing many of the drawbacks of Java which makes it a popular choice for many developers.",
            subItems = listOf(
                Category(
                    id = "1_1",
                    name = "Java",
                    info = "Java is a popular programming language used for Android development due to its robustness and ease of use. Its object-oriented structure allows developers to create modular programs and reusable code. The language was built with the philosophy of \"write once, run anywhere\" (WORA), meaning compiled Java code can run on all platforms without the need for recompilation. Android’s API and core libraries are primarily written in Java, therefore understanding Java is fundamental in creating diverse and powerful Android apps."
                ),
                Category(
                    id = "1_2",
                    name = "Kotlin",
                    info = "Kotlin is a cross-platform, statically typed general-purpose programming language with type inference. Developed by JetBrains, the makers of the world’s leading IDEs, Kotlin has a syntax, which is more expressive and concise. This allows for more readable and maintainable code. It is fully interoperable with Java and comes with no limitations. It can be used almost everywhere Java is used today, for server-side development, Android apps, and much more. Kotlin introduces several improvements for programmers over Java, which makes it a preferred choice for many developers. With more concise code base and modern programming concept support - it's certainly a future of Android app development.",

                    )

            )
        ),
        Category(
            id = "2",
            name = "The Fundamentals",
            subItems = listOf(
                Category(
                    id = "2_1",
                    name = "Development IDE",
                    info = "Development IDE refers to Development Integrated Development Environment that is vital for Android App development. For Android, the primary IDE is Android Studio. This official IDE from Google includes everything you need to build an Android app, such as a code editor, code analysis tools, emulators for all of Android's supported OS versions and hardware configurations, and more. Other popular IDEs include Eclipse (with an Android Developer Tools plugin), NetBeans, and IntelliJ IDEA. Each of these IDEs tends to have its own set of specialized features, but all are designed to provide the tools and services needed for Android development. The choice of IDE often depends on the specific needs and preferences of the developer or development team."
                ),
                Category(
                    id = "2_2",
                    name = "Basics Of Kotlin",
                    info = "Kotlin is a concise, multi-platform, and fun language developed by JetBrains. Learn how to use Kotlin for Android, server-side, and cross-platform development, and explore its features, news, and community. Kotlin is a statically-typed programming language that runs on the Java Virtual Machine (JVM) and can be used to develop all types of Android apps. It is Google's preferred language for Android app development."
                ),
                Category(
                    id = "2_3",
                    name = "Basics Of OOP",
                    info = "Understanding the Basics of Object-Oriented Programming (OOP) is crucial. OOP is a programming paradigm that uses \"Objects\" - entities that contain both data and functions that manipulate the data.\n" +
                            "Key concepts include Classes, which are blueprints from which objects are created; Objects, instances of a class; Inheritance, where one class acquires properties from another; Polymorphism, the ability of an object to take many forms; Abstraction, showing only necessary details and hiding implementation from the user; and Encapsulation, the concept of wrapping data and the methods that work on data within one unit."
                ),
                Category(
                    id = "2_4",
                    name = "Data Structures and Algorithms",
                    info = "Data Structures are primarily used to collect, organize and perform operations on the stored data more effectively. They are essential for designing advanced-level Android applications. Examples include Array, Linked List, Stack, Queue, Hash Map, and Tree.\n" + "Algorithms are a sequence of instructions or rules for performing a particular task. In Android, algorithms can be used for data searching, sorting, or performing complex business logic. Some commonly used algorithms are Binary Search, Bubble Sort, Selection Sort, etc. A deep understanding of data structures and algorithms is crucial in optimizing the performance and the memory consumption of the Android applications."
                ),
                Category(
                    id = "2_5",
                    name = "What is and how to use Gradle?",
                    info = "Gradle is a powerful build system used in Android development that allows you to define your project and dependencies, and distinguish between different build types and flavors. Gradle uses a domain-specific language (DSL) which gives developers almost complete control over the build process. When you trigger a build in Android Studio, Gradle is the tool working behind the scenes to compile and package your app. It looks at the dependencies you declared in your build.gradle files and create a build script accordingly. Using Gradle in Android development requires continuous editing of the build.gradle files to manage app dependencies, build variants, signing configurations, and other essential aspects related to building your app."
                ),
                Category(
                    id = "2_6",
                    name = "Create a Basic Hello World App",
                    info = "The \"Hello World\" app is a simple project that you can build when you're getting started with Android development. It's often the first program that beginners learn to build in a new system. It's usually considered the simplest form of program that displays a message to the user - \"Hello, World!\" In Android, this involves creating a new project from the Android Studio and setting up the main activity. The main activity file is primarily written in Java or Kotlin where you can code for the display message, while the layout design view can be created in the XML file."
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
                    info = "Git is a highly efficient and flexible distributed version control system that was created by Linus Torvalds, the creator of Linux. It allows multiple developers to work on a project concurrently, providing tools for non-linear development and tracking changes in any set of files. Git has a local repository with a complete history and version-tracking capabilities, allowing offline operations, unlike SVN. It ensures data integrity and provides strong support for non-linear development with features such as branching and merging."
                ),
                Category(
                    id = "3_2",
                    name = "GitHub",
                    info = "GitHub is a cloud-based hosting service for managing software version control using Git. It provides a platform for enabling multiple developers to work together on the same project at the same time. With GitHub, codes can be stored publicly, allowing for collaboration with other developers or privately for individual projects. Key features of GitHub include code sharing, task management, and version control, among others. GitHub also offers functionalities such as bug tracking, feature requests, and task management for the project."
                ),
                Category(
                    id = "3_3",
                    name = "GitLab",
                    info = "Gitlab is a web-based DevOps lifecycle tool which provides a Git-repository manager, along with continuous integration and deployment pipeline features, using an open-source license, developed by GitLab Inc. Users can manage and create their software projects and repositories, and collaborate on these projects with other members. Gitlab also allows users to view analytics and open issues of their project. It stands next to other version control tools like GitHub and Bitbucket, but comes with its own set of additional features and nuances. For Android development, Gitlab can be particularly useful owing to its continuous integration and deployment system which can automate large parts of the app testing and deployment."
                ),
                Category(
                    id = "3_4",
                    name = "BitBucket",
                    info = "Bitbucket is a web-based hosting service that is owned by Atlassian. Bitbucket uses either Mercurial or Git revision control systems, allowing users to manage and maintain their code. This platform is mainly used for code and code review. Bitbucket provides both commercial plans and free accounts. It offers free accounts with an unlimited number of private repositories (which can have up to five users in the case of free accounts) as of September 2010. It originally offered only Mercurial support. Bitbucket integrates with other Atlassian software like JIRA, HipChat, Confluence and Bamboo."
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
                    info = "Services: A service in Android is an app component that performs operations in the background without a user interface. It can be started by an application component, like an activity, and it will continue to run in the background even if the user switches to another application. There are two types of services in Android, namely, Started Service and Bound Service. A Started Service is used to perform a single operation, such as downloading a large file. On the other hand, a Bound Service offers a client-server interface that allows components to interact with the service, send requests, receive results, and even perform interprocess communication (IPC)."
                ),
                Category(
                    id = "4_2",
                    name = "Content Provider",
                    info = "A Content Provider in Android is a key component that allows applications to securely share data with other applications. They act as a layer between databases and applications to enhance data security. Content providers manage access to a structured set of data by handling data transactions, implementing data security, and maintaining isolation between applications. They provide an abstracted interface which is used to access data, while the underlying storage method (Like SQLite database, web, or any other method) remains hidden. This mechanism aids in retrieving data from a non-relational source in a structured way. They're used primarily when data needs to be shared between multiple applications, not just within a single application."
                ),
                Category(
                    id = "4_3",
                    name = "Broadcast Receiver",
                    info = "Broadcast Receivers in Android are components that respond to system-wide broadcast announcements. They can be registered to respond to a specific type of broadcasts or implement a user-defined broadcast. While you can initiate a broadcast from your app, they are generally used for receiving system notifications or communicating with other applications. However, keep in mind that they cannot display a user interface, but they can start activities if necessary, which do have a user interface. A BroadcastReceiver class must override the onReceive() method where each message is received as an Intent object parameter"
                ),
                Category(
                    id = "4_4",
                    name = "Intent",
                    info = "Intent in Android is a software mechanism used for late runtime binding between components, such as activities, content providers, and services. It is essentially a passive data structure holding an abstract description of an operation that the Android system is requested to perform.",
                    childrenVisible = true,
                    subItems = listOf(
                        Category(
                            id = "4_4_1",
                            name = "Implicit Intents",
                            info = "Implicit Intents do not specify the target component explicitly like Explicit Intents. Instead, they allow the system to find a suitable component matching the Intent description to handle the request. The system will find an activity that can handle this intent by comparing the <intent-filter> section in the AndroidManifest.xml of all apps installed on the device against the Implicit Intent."
                        ),
                        Category(
                            id = "4_4_2",
                            name = "Explicit Intents",
                            info = "Explicit Intents are primarily used within an application's own boundaries. In explicit intents you specify the component that needs to be responded to the intent. Therefore, the target component must be specified by calling methods such as setComponent(ComponentName), setClass(Context, Class), or setClassName(String, String). This means that explicit intents are typically used for launching activities, broadcasting messages, starting services within the app. Explicit intents are not resolved by the system but are passed to the component identified in the intent."
                        ),
                        Category(
                            id = "4_4_3",
                            name = "Intent Filters",
                            info = "Intent Filters in Android are essential components of the Android system where you can declare the capabilities of your activities, services, and broadcast receivers. An intent filter is an expression found in your app's manifest file, defined in the <intent-filter> XML element. Android uses these filters to determine the appropriate components for incoming intents, which can be either explicit or implicit. Your app's ability to respond to intents depends on the filters you define. The filters are set of conditions comprised of action, category, and data which your activity or service is able to perform. If the incoming Intent matches with defined Intent Filters, Android system will permit that Intent to your Component (Activity, Service, or Broadcast Receiver)."
                        )

                    )
                ),
                Category(
                    id = "4_5",
                    name = "Activity",
                    info = "Activity in Android is a crucial component that represents a single screen with a user interface. It is just like a window in a desktop application. Android apps are typically made up of one or more activities, each having its interface which allows user interaction. When an app is launched, an instance of Activity is created, starting the lifecycle of that app. Every activity has its own lifecycle (create, start, resume, pause, stop, destroy) that keeps the state of a user's progress, and Android manages these states automatically. Activities can also have Intent, which allows them to interact with other components, such as starting another activity or getting a result from that activity.",
                    childrenVisible = true,
                    subItems = listOf(
                        Category(
                            id = "4_5_1",
                            name = "Activity LifeCycle",
                            info = "The Activity Lifecycle in Android represents a series of states or events that an activity can go through from its creation to its destruction. The primary states or events are onCreate(), onStart(), onResume(), onPause(), onStop(), onDestroy(), and onRestart(). The method onCreate() is called when the activity is first created, followed by onStart() when the activity becomes visible to the user. The onResume() method executes when the user starts interacting with the application. onPause() and onStop() methods are invoked when the application is no longer in the foreground or visible to the user. The onDestroy() method is used when the activity is being completely removed from the memory. The onRestart() method is called after the system stops the activity and is about to start it again. The proper handling of these states ensures the efficient use of resources and a smooth user experience.",
                            links = listOf(
                                Link(
                                    "Activity Lifecycle",
                                    "https://developer.android.com/guide/components/activities/activity-lifecycle"
                                )
                            )
                        ),
                        Category(
                            id = "4_5_2",
                            name = "State Changes",
                            info = "\"Activity\" is a crucial component that represents a single screen with a user interface. One or more active activities make up an Application. These activities can go through different states in their lifecycle, often due to user interaction or system interruption. The primary states of an Activity include Created, Started, Resumed, Paused, Stopped, Restarted, and Destroyed. The \"Created\" state occurs when an activity instance is being created. The \"Started\" state is when the activity is visible to the user, while \"Resumed\" is when the activity is interacting with the user. An activity is \"Paused\" when it loses focus but is partly visible, \"Stopped\" when it's not visible, \"Restarted\" when the activity is about to be started, and \"Destroyed\" when the activity is finished or the system is temporarily destroying it.",
                            links = listOf(
                                Link(
                                    "Activity Lifecycle",
                                    "https://developer.android.com/guide/components/activities/activity-lifecycle"
                                )
                            )

                        ),
                        Category(
                            id = "4_5_3",
                            name = "Tasks & Backstack",
                            info = "The tasks backstack in Android refers to the way Android manages and arranges tasks in a stack-like structure. Every task has a stack of activities, which is referred to as the task's back stack. The activities are placed in the order they are opened. When a new activity is started, it is placed at the top of the stack and becomes the running activity, while the previous activity is paused and put into the back stack. When you press the back button, the current activity is destroyed and the activity at the top of the back stack becomes active again. Android defines how to navigate between tasks and activities using this back stack concept.",
                            links = listOf(
                                Link(
                                    "Tasks and Backstack",
                                    "https://developer.android.com/guide/components/activities/tasks-and-back-stack"
                                )
                            )
                        )

                    )
                )
            )
        ),
        Category(
            id = "5",
            name = "Interface & Navigation",
            info = "In Android development, the concepts of \"Interface\" and \"Navigation\" are crucial. The \"Interface\" often refers to the Graphical User Interface (GUI) that users interact with. This includes buttons, text fields, image views, scroll views and other UI elements that the users can interact with to perform certain tasks. Tools like XML and Material Designs are used for interface design in Android.",
            links = listOf(
                Link(
                    "Android Developers: Interface",
                    "https://developer.android.com/guide/topics/ui/declaring-layout.html"
                ),
                Link(
                    "Android Developers: Navigation",
                    "https://developer.android.com/guide/navigation"
                )
            ),
            subItems = listOf(
                Category(
                    id = "5_1",
                    name = "Elements",
                    childrenVisible = true,
                    subItems = listOf(
                        Category(
                            id = "5_1_1",
                            name = "TextView",
                            info = "TextView is a widget that is seen in every android application. This widget is used to display simple text within the android application.",
                            links = listOf(
                                Link(
                                    "TextView",
                                    "https://developer.android.com/reference/android/widget/TextView"
                                ),
                            )
                        ),

                        Category(
                            id = "5_1_2",
                            name = "Toast",
                            info = "A toast provides simple feedback about an operation in a small popup. It only fills the amount of space required for the message and the current activity remains visible and interactive. Toasts automatically disappear after a timeout.",
                            links = listOf(
                                Link(
                                    "Toast",
                                    "https://developer.android.com/guide/topics/ui/notifiers/toasts"
                                )
                            )
                        ),
                        Category(
                            id = "5_1_3",
                            name = "Fragments",
                            info = "A Fragment represents a reusable portion of your app's UI. A fragment defines and manages its own layout, has its own lifecycle, and can handle its own input events. Fragments can't live on their own. They must be hosted by an activity or another fragment. The fragment’s view hierarchy becomes part of, or attaches to, the host’s view hierarchy.",
                            links = listOf(
                                Link(
                                    "Android Developers: Fragments",
                                    "https://developer.android.com/guide/fragments"
                                )
                            )
                        ),
                        Category(
                            id = "5_1_4",
                            name = "Dialogs",
                            info = "A DialogFragment is a special fragment subclass that is designed for creating and hosting dialogs. Although you don't need to host your dialog within a fragment, doing so lets the FragmentManager manage the state of the dialog and automatically restore the dialog when a configuration change occurs.",
                            links = listOf(
                                Link(
                                    "Android Developers: Dialogs",
                                    "https://developer.android.com/guide/fragments/dialogs"
                                )
                            )
                        ),
                        Category(
                            id = "5_1_5",
                            name = "Buttons",
                            info = "A button consists of text or an icon, or both, that communicates what action occurs when the user taps it.\n" +
                                    "\n" +
                                    "Buttons are UI widgets that allow users to interact with an application by tapping on them. A button typically consists of text, an icon, or a combination of both, and communicates what action will occur when the user taps it.",
                            links = listOf(
                                Link(
                                    "Android Developers: Button",
                                    "https://developer.android.com/develop/ui/views/components/button"
                                ),
                                Link(
                                    "Create a Button - Android",
                                    "https://developer.android.com/quick-guides/content/create-button"
                                )
                            )
                        ),
                        Category(
                            id = "5_1_6",
                            name = "Bottom Sheet",
                            info = "Bottom sheets are surfaces containing supplementary content that are anchored to the bottom of the screen.\n" +
                                    "\n" +
                                    "There are several attributes that can be used to adjust the behavior of both standard and modal bottom sheets.\n" +
                                    "\n" +
                                    "Behavior attributes can be applied to standard bottom sheets in xml by setting them on a child View set to app:layout_behavior or programmatically.",
                            links = listOf(
                                Link(
                                    "Android developers : Bottom Sheets",
                                    "https://developer.android.com/reference/com/google/android/material/bottomsheet/BottomSheetDialog"
                                )
                            )
                        ),
                        Category(
                            id = "5_1_7",
                            name = "ImageView",
                            info = "Displays image resources, for example Bitmap or Drawable resources. ImageView is also commonly used to apply tints to an image and handle image scaling.",
                            links = listOf(
                                Link(
                                    "Android Developers: ImageView",
                                    "https://developer.android.com/reference/android/widget/ImageView"
                                )
                            )
                        ),
                        Category(
                            id = "5_1_8",
                            name = "Tabs",
                            info = "Tabs in Android Studio are a UI component used to organize content into multiple sections, allowing users to navigate between them by selecting the corresponding tab. This component is commonly used when there is a need to present different types of content in a single screen, like different categories, settings, or pages within an app.",
                            links = listOf(
                                Link(
                                    "Material Tabs",
                                    "https://developer.android.com/reference/com/google/android/material/tabs/package-summary"
                                )
                            )
                        ),
                        Category(
                            id = "5_1_9",
                            name = "EditText",
                            info = "EditText is a fundamental UI element in Android Studio, used for allowing users to input and edit text within an application. It is a subclass of TextView that provides additional features to handle user input.",
                            links = listOf(
                                Link(
                                    "Android developers: EditText",
                                    "https://developer.android.com/reference/android/widget/EditText"
                                )
                            )
                        ),
                        Category(
                            id = "5_1_10",
                            name = "Drawer",
                            info = "The Navigation Drawer in Android is a sliding menu from the left that simplifies navigation between important app links. It opens by sliding or via an icon in the ActionBar. It’s an overlay panel that replaces a screen dedicated to displaying options.",
                            links = listOf(
                                Link(
                                    "Android developers: DrawerLayout",
                                    "https://developer.android.com/reference/androidx/drawerlayout/widget/DrawerLayout"
                                ),
                                Link(
                                    "Navigate Drawer Tutorial",
                                    "https://www.digitalocean.com/community/tutorials/android-navigation-drawer-example-tutorial"
                                )
                            )
                        ),
                        Category(
                            id = "5_1_11",
                            name = "ListView",
                            info = "Displays a vertically-scrollable collection of views, where each view is positioned immediately below the previous view in the list.\n" +
                                    "\n" +
                                    "For a more modern, flexible, and performant approach to displaying lists, use RecyclerView.",
                            links = listOf(
                                Link(
                                    "ListView",
                                    "https://developer.android.com/reference/android/widget/ListView"
                                )
                            )
                        ),
                        Category(
                            id = "5_1_12",
                            name = "Animations",
                            info = "Animations can add visual cues that notify users about what's going on in your app. They are especially useful when the UI changes state, such as when new content loads or new actions become available. Animations also add a polished look to your app, which gives it a higher quality look and feel.",
                            links = listOf(
                                Link(
                                    "Google developers: Animations",
                                    "https://developer.android.com/develop/ui/views/animations/overview"
                                )
                            )
                        )
                    )
                ),
                Category(
                    id = "5_2",
                    name = "Layouts",
                    childrenVisible = true,
                    subItems = listOf(
                        Category(
                            id = "5_2_1",
                            name = "Frame",
                            info = "FrameLayout is a simple ViewGroup subclass in Android that is designed to hold a single child view or a stack of overlapping child views. It positions each child in the top-left corner by default and allows them to overlap on top of each other, which makes it useful for situations where you need to layer views on top of one another.",
                            links = listOf(
                                Link(
                                    "Android Developers: Frame Layout",
                                    "https://developer.android.com/reference/android/widget/FrameLayout"
                                )
                            )
                        ),
                        Category(
                            id = "5_2_2",
                            name = "Linear",
                            info = "LinearLayout is a view group that aligns all children in a single direction, vertically or horizontally. You can specify the layout direction with the android:orientation attribute.\n" +
                                    "\n" +
                                    "LinearLayout was commonly used in earlier Android development, but with the introduction of ConstraintLayout, it’s less frequently used in modern apps.",
                            links = listOf(
                                Link(
                                    "Linear Layout",
                                    "https://developer.android.com/develop/ui/views/layout/linear"
                                )
                            )
                        ),
                        Category(
                            id = "5_2_3",
                            name = "Relative",
                            info = "A RelativeLayout in Android is a type of ViewGroup that allows you to position child views relative to each other or relative to the parent layout. It's a flexible layout where you can arrange the child views in relation to one another based on certain rules, making it suitable for creating complex UI designs.\n" +
                                    "RelativeLayout was commonly used in earlier Android development, but with the introduction of ConstraintLayout, it's less frequently used in modern apps.",
                            links = listOf(
                                Link(
                                    "Relative Layout",
                                    "https://developer.android.com/develop/ui/views/layout/relative"
                                )
                            )
                        ),
                        Category(
                            id = "5_2_4",
                            name = "Constraint",
                            info = "Lets you create large, complex layouts with a flat view hierarchy—no nested view groups. It's similar to RelativeLayout in that all views are laid out according to relationships between sibling views and the parent layout, but it's more flexible than RelativeLayout and easier to use. Its available on xml and jetpack compose.",
                            links = listOf(
                                Link(
                                    "Android: ConstraintLayout in XML",
                                    "https://developer.android.com/develop/ui/views/layout/constraint-layout"
                                ),
                                Link(
                                    "Android: ConstraintLayout in Compose",
                                    "https://developer.android.com/develop/ui/compose/layouts/constraintlayout"
                                )
                            )
                        ),
                        Category(
                            id = "5_2_5",
                            name = "RecyclerView",
                            info = "RecyclerView is the most commonly used and powerful list management tool in Android development. Witch makes it easy to efficiently display large sets of data. You supply the data and define how each item looks, and the RecyclerView library dynamically creates the elements when they're needed.\n" +
                                    "\n" +
                                    "As the name implies, RecyclerView recycles those individual elements. When an item scrolls off the screen, RecyclerView doesn't destroy its view. Instead, RecyclerView reuses the view for new items that have scrolled onscreen. RecyclerView improves performance and your app's responsiveness, and it reduces power consumption.",
                            links = listOf(
                                Link(
                                    "Create Dynamic Lists with RecyclerView",
                                    "https://developer.android.com/develop/ui/views/layout/recyclerview"
                                )
                            )
                        )
                    )
                ),
                Category(
                    id = "5_3",
                    name = "Jetpack Compose", info = "Jetpack Compose is a modern toolkit for building native Android UI. It simplifies and accelerates UI development on Android with less code, powerful tools, and intuitive Kotlin APIs. Jetpack Compose offers a declarative approach to designing UI, where you can simply describe what your UI should look like at any given point of your app’s state, and Compose takes care of updating the view hierarchy, making UI development more efficient. It also integrates well with existing Android apps, letting you adopt its benefits at your own pace.", links = listOf(Link("Jetpack Compose","https://developer.android.com/jetpack/compose"))
                ),
                Category(
                    id = "5_4",
                    name = "App Shortcuts", info = "App shortcuts in Android are designed to provide quick and convenient routes to specific actions or functions within your app from the device home screen. To use them, long-press an app's icon and a pop-up menu will appear with the available shortcuts. Depending on the app, you might be able to send a message, make a booking, navigate home, or perform some other specific task without having to first open the app and navigate to the desired function. These shortcuts can also be moved and placed individually on the home screen for even faster access.", links=listOf(Link("App Shortcuts","https://developer.android.com/guide/topics/ui/shortcuts"))

                    ),
                Category(
                    id = "5_5",
                    name = "Navigation Components",info="The Navigation Components are part of Android Jetpack and are designed to simplify the implementation of navigation in your Android app. These components help you follow best practices, handle deep linking, and provide a consistent user experience across deep and conditional navigation. They also automate many common tasks, such as handling Up and Back actions correctly across many different types of devices. The Navigation component consists of three key parts which are Navigation graph, NavHost, and NavController.",links=listOf(Link("Navigation Components","https://developer.android.com/guide/navigation"))
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
                    info = "Design Architecture refers to structuring the code in a way that increases its readability, maintainability, and testability. There are several ways to design architecture like Model-View-Controller (MVC), Model-View-Intent (MVI). Each of these define the interaction between the data, the logic, and the UI layers. Google’s recommended architectural pattern is Android Architecture Components which follow the principles of the MVVM pattern. Bear in mind that an architecture is not a rigid structure that fits all solutions. Rather, it serves as a guideline and can be tweaked as necessary.",
                    links = listOf(Link("Android Architecture Comopnents","https://developer.android.com/topic/libraries/architecture")),
                    childrenVisible = true,
                    subItems = listOf(
                        Category(id = "6_1_1", name = "MVI", info = "The MVI Model-View-Intent pattern is a reactive architectural pattern, similar to MVVM and MVP, focusing on immutability and handling states in unidirectional cycles. The data flow is unidirectional: Intents update the Model's state through the ViewModel, and then the View reacts to the new state. This ensures a clear and predictable cycle between logic and the interface.\n" +

                                "Model: Represents the UI state. It is immutable and contains all the necessary information to represent a screen.\n" +
                                "View: Displays the UI state and receives the user's intentions.\n" +
                                "Intent: The user's intentions trigger state updates, managed by the ViewModel.", links = listOf(Link("MVI with Kotlin","https://proandroiddev.com/mvi-architecture-with-kotlin-flows-and-channels-d36820b2028d"))),
                        Category(id = "6_1_2", name = "MVVM", info = "The Model-View-ViewModel (MVVM) pattern is a software architectural pattern commonly used in UI development. It is designed to separate the concerns of an application, making the code more modular, testable, and maintainable.\n" +
                                "Components:\n" +

                                "Model: Refers either to a domain model, which represents real state content (an object-oriented approach), or to the data access layer, which represents content.\n" +
                                "View: The view is the structure, layout, and appearance of what a user sees on the screen.\n" +
                                "View model: The view model is an abstraction of the view exposing public properties and commands. The view model has been described as a state of the data in the model.", links = listOf(Link("Android Developers: View Model","https://developer.android.com/topic/libraries/architecture/viewmodel"))),
                        Category(id = "6_1_3", name = "MVP", info = "The MVP Model View Presenter pattern is a derivative of the well-known MVC Model View Controller pattern and is one of the most popular patterns for organizing the presentation layer in Android applications.\n" +

                                "MVP is divided into three components:\n" +
                                "\n" +
                                "Model: Responsible for managing the data input to the app. This can often be an Interactor or UseCase, handling the business logic and data operations.\n" +
                                "View: Takes care of updating the graphical part of the application. It acts as a passive view, only receiving data and requesting actions to be performed.\n" +
                                "Presenter: Handles all the logic related to the graphical interface that the View requests. It provides the View with the data it needs to display on the screen.", links = listOf(Link("Model View Presenter","https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93presenter"))),
                        Category(id = "6_1_4", name = "MVC", info = "MVC or Model View Controller is a software design pattern commonly used for developing user interfaces that divides the related program logic into three interconnected components.\n" +

                                "Components:\n" +
                                "Model: The internal representations of information. This can often be an Interactor or UseCase\n" +
                                "View: The interface that presents information to and accepts it from the user\n" +
                                "Controller: The controller contains logic that updates the model and/or view in response to input from the users of the app.", links = listOf(Link("MVC","https://developer.mozilla.org/en-US/docs/Glossary/MVC")))
                    )
                ),
                Category(
                    id = "6_2", name = "Design Patterns", childrenVisible = true, subItems = listOf(
                        Category(id = "6_2_1", name = "Repository Pattern",  info = "The Repository Pattern separates the data sources from the rest of the application. It acts as a mediator between different data sources, such as persistent models, web services, or caches. Instead of having the network and database calls spread out throughout your ViewModel, they are encapsulated within a Repository class. This separation will make the code clean, easy to read and testable. It provides a simple API for data access, the rest of the app doesn't need to know where the data is coming from it just asks the repository.", links = listOf(Link("Repository Pattern","https://en.wikipedia.org/wiki/Repository_pattern"))),
                        Category(id = "6_2_2", name = "Builder Pattern", info = "The Builder Pattern in Android is used to construct complex objects step by step. It separates the construction of an object from its representation. The pattern involves a Builder class which is used to construct the Product class. The Builder class typically has a method for each part that may be used to construct a Product. It also has a method for returning the final product. The Builder pattern is useful in situations where you might have multiple ways to create an object or when an object requires a large number of parameters for its constructor.", links = listOf(Link("Builder Pattern","https://developer.android.com/kotlin/style-guide#builder-pattern"))),
                        Category(id = "6_2_3", name = "Factory Pattern", info = "The Factory Pattern is part of the Creational Design Patterns. This pattern provides an interface for creating objects in a superclass, but allows subclasses to alter the type of objects that will be created. It introduces an abstraction layer between the client code and the concrete objects. Normally, this is achieved by using a factory method to create objects instead of using constructors. The instance of the class is usually created by a method, referred to as a factory method, which is either specified in an interface and implemented in implementing classes or implemented in a base class which may be optionally overridden by derived classes. The Factory Method is used when we want to provide users with a way to create an instance of a class from one of several possible classes that share a common super class.", links = listOf(Link("Factory Pattern","https://developer.android.com/guide/components/intents-filters#factory"))),
                        Category(
                            id = "6_2_4",
                            name = "Observer Pattern", info = "The Observer Pattern is a software design pattern in which an object, known as the subject, maintains a list of its dependents, called observers, and notifies them automatically of any state changes. This is usually done by calling one of their methods. It's mainly used for implementing distributed event handling systems and is viewed as a good practice to follow, making your design more robust, flexible, and scalable. The subject to be observed triggers events and observers react to the change or the event that they are listening to. In Android, observable libraries like LiveData, RxJava, Flow, and other reactive streams allow the implementation of observer pattern.",
                            links = listOf(Link("Observer Pattern","https://en.wikipedia.org/wiki/Observer_pattern")),
                            childrenVisible = true,
                            subItems = listOf(
                                Category(id = "6_2_4_1", name = "Flow", info = "Flow in Android development is part of the Kotlin Coroutines library. It is a type that can emit multiple values sequentially, making it perfect for working with any data streams or any streams of events that aren't instantaneous. Like Observables, Flow is also based on the observer pattern, meaning it can emit values and these emissions can be observed and reacted to. However, Flow comes with built-in back pressure handling and the ability to transform, filter, or combine these flows in a sequence. Along with Coroutines, Flow encourages a more predictable and simplified concurrency design without callback hell problem.", links = listOf(Link("Flow","https://kotlinlang.org/docs/flow.html"),Link("Flow:Coroutines","https://kotlinlang.org/docs/flow-coroutines.html"))),
                                Category(id = "6_2_4_2", name = "RxKotlin", info = "RxKotlin is a lightweight library that adds convenient extension functions to RxJava. It allows developers to use RxJava with Kotlin in a more idiomatic way, thus making code more readable and understandable. While RxJava is a Java-based implementation of Reactive Extensions, RxKotlin is essentially a wrapper that includes extension functions and other constructs to take full advantage of Kotlin's features, such as its syntactic simplicity and ease of use.", links = listOf(Link("RxKotlin","https://github.com/ReactiveX/RxKotlin"))),
                                Category(id = "6_2_4_3", name = "RxJava", info = "RxJava, standing for Reactive Extensions for the JVM, is a library in the Java and Android ecosystem that allows developers to write asynchronous, event-based programs. It is developed according to reactive programming principles and it supports multi-threading operations. One can create data streams from just about anything - variables, data structures, inputs, etc. and these streams could be used with functional programming methods to process the data.", links = listOf(Link("RxJava on Github","https://github.com/ReactiveX/RxJava"))),
                                Category(id = "6_2_4_4", name = "LiveData", info = "LiveData is a data holder class that can be observed within a given lifecycle. This means that an Observer can be added in a pair with a LifecycleOwner, and this observer will be notified about modifications of the LiveData object only if the associated LifecycleOwner is in active state. LiveData respects the lifecycle state of app components, such as activities, fragments, or services, and it only updates app-component observers that are in an active lifecycle state. Furthermore, LiveData automatically removes the observers when their associated LifecycleOwner moves to the Destroyed state. This combination of LiveData and LifecycleOwner helps you to manage appropriate and efficient updates because LiveData takes into consideration the lifecycle state of your app components.", links = listOf(Link("LiveData","https://developer.android.com/topic/libraries/architecture/livedata"))),
                            )
                        ),
                        Category(
                            id = "6_2_5",
                            name = "Dependency Injection", info = "Dependency Injection is a technique where an object does not need to create its own dependencies; instead, dependencies are provided (or injected) at runtime. This technique is highly beneficial in Android Development. It helps in creating loosely coupled and easily testable code. For example, the Retrofit instance that your application requires to make network calls can be created somewhere else and can be injected whenever required using libraries like Dagger, Koin or Hilt. The ViewModel instances can also be injected rather than being created in the required classes directly. Through dependency injection, plugins ensure the code becomes easier to change, understand, and maintain, hence, improving the quality of the code.", links = listOf(Link("Dependency Injection","https://developer.android.com/training/dependency-injection")),
                            childrenVisible = true,
                            subItems = listOf(
                                Category(id = "6_2_5_1", name = "Dagger", info = "Dagger is a fully static, compile-time dependency injection framework for both Java and Android. It is an adaptation of an earlier version created by Square that's focused on simplicity and speed. Dagger's primary focus is on compile-time analysis of dependencies, code simplicity, and clarity. It uses annotations to define dependencies, thus aiding in easy readability and understanding of the code. Dagger also eliminates the use of reflection to inject dependencies, thus boosting performance. It offers custom scopes to control the lifespan of instances and ensures that dependencies are Singleton across the entire lifespan of certain scopes.", links = listOf(Link("Dagger","https://dagger.dev/"))),
                                Category(id = "6_2_5_2", name = "Hilt", info = "Hilt is a dependency injection library for Android that reduces the boilerplate code that you would normally need to write when setting up manual dependency injection in your project. It is based on the Dagger library, but it simplifies the implementation process and streamlines the use of Dagger in Android apps. To set it up, you must annotate your Android classes and Hilt will automatically generate and provide the necessary dependencies for you.", links = listOf(Link("Hilt","https://developer.android.com/training/dependency-injection/hilt-android"))),
                                Category(id = "6_2_5_3", name = "Koin", info = "Koin is a lightweight dependency injection framework developed specifically for Kotlin developers. It uses functional resolution only - no proxy, no code generation, no reflection, and offers simplicity by leveraging Kotlin's language features. While Koin is not related to the Android platform, it provides specific extensions enabling an efficient integration into your Android applications, including Android Architecture Components and Kotlin Coroutines amongst others.", links = listOf(Link("Koin","https://insert-koin.io/"))),
                                Category(id = "6_2_5_4", name = "Kodein", info = "Kodein is one of the recommended dependency injection frameworks suitable for Android development. This open-source Kotlin library simplifies the DI process by allowing developers to bind various types of dependencies, such as singleton, factory, or provider bindings into containers or Kodein modules. It promotes dependency declaration where used, instead of prior declaration. It follows a \"Define in Use\" principle that enables easy-to-use, easy-to-debug and very idiomatic Kotlin code. It's also worth noting that Kodein works hand in hand with Android's lifecycle and provides easy integration with popular libraries such as Android Architecture Components, leveraging their functionality.", links = listOf(Link("Kodein","https://insert-kodein.io/")))
                            )
                        ),

                        )
                )
            )
        ),
        Category(
            id = "7",
            name = "Storage", info = "On Android devices, storage refers to where your data such as apps, photos, videos, and music are saved. It can be categorized into two types: internal and external storage. Internal Storage is where data is stored that's tied directly to your app. This data is private by default and not accessible by other apps. External Storage, on the other hand, is a shared space where all apps can read and write data. It can be further sub-categorized into Public and Private directories. Public directories are shared among all apps while private directories are specific to your app but can be accessed by other apps if they have the appropriate permissions.", links = listOf(Link("Storage","https://developer.android.com/guide/topics/data/data-storage")), subItems = listOf(
                Category(id = "7_1", name = "Shared Preferences", info = "Shared Preferences in Android are used to store data in key-value pairs. It works similar to a tiny database where you can save small pieces of data such as settings or the state of an application. When data is saved to Shared Preferences, it persists across user sessions, even if your application is killed or gets deleted. Data in Shared Preferences is not typically used for large amounts of data. To perform actions such as saving, retrieving, or editing data in Shared Preferences, you use an instance of SharedPreferences.Editor.", links = listOf(Link("Shared Preferences docs","https://developer.android.com/training/data-storage/shared-preferences"))),
                Category(id = "7_2", name = "DataStore", info = "DataStore is a new and improved data storage solution by Android, meant to supersede SharedPreferences. It is important to understand that it comes in two different implementations: Preferences DataStore and Proto DataStore. Preferences DataStore uses key-value pairs similar to SharedPreferences, but it's more robust and handles runtime exceptions more efficiently. On the other hand, Proto DataStore uses custom data types to provide type safety. It lets you leverage the power of Protocol Buffers, a language-neutral, platform-neutral mechanism for serializing structured data, as the data storage format. Operating on data in DataStore is transactional, meaning that if an error occurs during an operation, all changes are rolled back, so the data remains in a consistent state.", links = listOf(Link("Documentation","https://developer.android.com/topic/libraries/architecture/datastore"))),
                Category(id = "7_3", name = "Room Database", info = "\"Room\" is a persistence library introduced by Google that provides an abstraction layer over SQLite to help with robust database access while harnessing the full power of SQLite. Room supports the creation of databases and defines queries in compile-time-checked SQL strings. These databases belong to the data classes that you create representing your app's data. Room comprises three main components: Database, a container that holds your app's data tables; Entity, representing a table within the database; and DAO (Data Access Object), containing SQL query methods to interact with the database.", links = listOf(Link("Room Database","https://developer.android.com/training/data-storage/room"))),
                Category(id = "7_4", name = "File System", info = "The Android operating system uses a specific File System structure to store and manage files. It’s primarily based on the Linux File system, with some specific Android features. The File System includes several key directories that are used for specific purposes. For instance, directories such as /system hold system apps and firmware, while /data contains user data, settings and installed applications, and /sdcard usually represents an internal or external SD card for additional storage. It's worth mentioning directories like /proc, /dev, and /sys which are virtual file systems and house important system files. As an Android developer, understanding these directories can help you interact with Android's file system more effectively. Note that access to some of these directories may be restricted depending on system permissions.", links = listOf(Link("Android File System","https://developer.android.com/training/data-storage/")))
            )
        ),
        Category(
            id = "8",
            name = "Network",info="In Android, the Network component offers vital capabilities that enable communication and interaction among users, between users and remote servers, and between users and cloud services. Android provides a variety of APIs and services to interact with networks. The primary APIs are the ConnectivityManager, WifiManager, TelephonyManager, and BluetoothManager APIs, among others. ConnectivityManager, for example, can tell you about network connectivity changes.",links=listOf(Link("Network","https://developer.android.com/guide/topics/connectivity"),Link("ConnectivityManager","https://developer.android.com/reference/android/net/ConnectivityManager"),Link("WifiManager","https://developer.android.com/reference/android/net/wifi/WifiManager")),
            subItems = listOf(
                Category(id = "8_1", name = "Retro", info = "Retrofit is a type-safe HTTP client for Android. It's designed to connect your application with an API or a back-end web service. Retrofit uses annotations to encode details about the API's operations and requests, such as the HTTP method (GET, POST, PUT, DELETE, HEAD) and the query parameters. The main advantage of Retrofit over other similar libraries is in its simplicity and intuitiveness, and it efficiently handles all network calls.", links = listOf(Link("Retro Documentation","https://square.github.io/retrofit/"))),
                Category(id = "8_2", name = "OKHttp", info = "OkHttp is an HTTP client that's extremely efficient, enabling several advanced features in Android app or other platforms that use Java. Developed by Square, it's built for high efficiency and capacity, simplifying many networking tasks, including connection pooling, response caching, and request retries. OkHttp allows seamless recovery from network issues, minimizing the loss of data. The library ensures fewer errors and higher quality of service by using the modern TLS encryption, extensible request and response models, and a fluent API for ease of use and integration.", links = listOf(Link("OkHttp","https://square.github.io/okhttp/"))),
                Category(id = "8_3", name = "Apollo-Android", info = "Apollo Android is a set of tools for using GraphQL with Android, made by the Apollo community developers. It's fully written in Kotlin and it was designed to seamlessly integrate with any Android app, making fetching data across network and handling data in the client-side a breeze. Apollo Android runs your queries and mutations and returns results as generated Kotlin types. It also normalizes your data and caches your results for further speed enhancements. It operates both on Android and Kotlin/JVM backend environment. It's also coroutines-first making handling concurrency easy and effective. To use Apollo Android, you'll set up the plugin, point it at your GraphQL schema, and write GraphQL queries.", links = listOf(Link("Apollo","https://www.apollographql.com/docs/kotlin/v2/")))
            )
        ),
        Category(
            id = "9",
            name = "Asynchronism",info="Asynchronism in Android is a practice that defines operations, which can run independently from the main operation without following the program's linear flow. The Android system uses threads to handle asynchronous processes. These threads function independently, ensuring that complex or time-consuming operations do not interfere with the user interface or other essential parts of the application. Android provides various tools for carrying out asynchronous tasks, such as Handler, ThreadPoolExecutor, IntentService, AsyncTask, and Loader etc. These tools provide ways to execute tasks on different threads and communicate the results back to the main thread.",links=listOf(Link("Asynchronous Tasks","https://developer.android.com/guide/background")), subItems = listOf(
                Category(id = "9_1", name = "Coroutines", info = "Coroutines refer to a concurrency design pattern that you can use on Android to simplify code that executes asynchronously. Coroutines provide a way to write asynchronous, non-blocking code in a natural, sequential manner. The fundamental building blocks of coroutines are suspend functions which are simply functions that can be paused and resumed at later times. They are the key to writing non-blocking asynchronous code and represent a single unit of asynchronous computation. This aspect of coroutines makes them useful for managing long-running tasks that might otherwise block the main thread and cause your application to become unresponsive.", links = listOf(Link("coroutines","https://kotlinlang.org/docs/coroutines-overview.html"))),
                Category(id = "9_2", name = "Threads", info = "In Android, a Thread is a concurrent unit of execution. It has its own call stack, but can share its state with other threads in the same process, i.e., they can share the same memory area. They're primarily used in Android to perform operations in the background. One important aspect to note is that Android UI operations are not thread-safe, meaning they should always be done on the UI thread. Operations on Threads are typically managed through Handler, Looper and MessageQueue classes. Android also provides high-level constructs like AsyncTask and Loader for managing threads in relation to the UI.", links = listOf(Link("Threads","https://developer.android.com/guide/components/processes-and-threads"))),
                Category(id = "9_3", name = "RxJava", info = "RxJava (Reactive Extensions for the JVM) is a powerful library for composing asynchronous and event-based programs using observable sequences in Java. If you are an Android developer, you might be familiar with callbacks and async tasks to perform long-running operations in the background. However, handling multiple async tasks and nested callbacks can produce code that's complicated to read and maintain. To alleviate such complexities, RxJava provides tools and methods to create, transform and chain Observable sequences in a clean and declarative manner.", links = listOf(Link("RxJava on GitHub","https://github.com/ReactiveX/RxJava"))),
                Category(id = "9_4", name = "RxKotlin", info = "RxKotlin is a lightweight language extension to Java for Android development, enabling Android apps to be built using Kotlin with Reactivex. It brings the power of reactive programming paradigm to Kotlin, extending its capabilities for processing asynchronous streams of data. It allows you to express static (e.g., already known) or dynamic (e.g., future unknown) data streams, and perform various operations on them easily. Key concepts of RxKotlin include Observables, Observers and Schedulers. Observables represent the data streams, Observers interact with the data stream, and Schedulers determine on which thread operations are performed. RxKotlin helps manage background tasks, handle asynchronous data streams, and implement complex UIs, among others.", links = listOf(Link("RxKotlin on GitHub","https://github.com/ReactiveX/RxKotlin"))),
                Category(id = "9_5", name = "WorkManager", info = "WorkManager is an Android library introduced by Google to execute tasks in a predictable and reliable manner. It's designed for tasks that require guaranteed execution, even if the app has been closed or the device restarts. It is backwards compatible up to API 14 and uses JobScheduler for API 23 and above, whilst using a combination of BroadcastReceiver + AlarmManager for APIs 14 and up. Regardless of the device API level, WorkManager works for all Android devices. Three types of work are supported by WorkManager - OneTimeWorkRequest, PeriodicWorkRequest, and DelayedWorkRequest.", links = listOf(Link("WorkManager","https://developer.android.com/topic/libraries/architecture/workmanager")))
            )
        ),
        Category(
            id = "10",
            name = "Common Services",info="Common Services are functional units or components provided by the Android system for use by developers. These services include things such as Location Services (used to determine the device's geographical location), Notification Services (handles the display and management of user notifications), and Sensor Services (interacts with hardware sensors). Other common services are Network and Connectivity Services, Account Manager, and Data Storage Services among others. They simplify the development process by handling complex functionalities behind the scenes, allowing developers to focus on the application's specific needs.",links=listOf(Link("Common Services","https://developer.android.com/guide/components/services")), subItems = listOf(
                Category(id = "10_1", name = "Firebase", info = "FireBase", links = listOf(Link("",""))),
                Category(id = "10_2", name = "Google AdMob", info = "Google AdMob is a mobile advertising platform designed for app developers to monetize their apps by displaying ads from over 1 million Google advertisers. AdMob supports a wide range of ad formats, such as banner ads, interstitial ads, video ads, and more. It offers a powerful mediator that enables you to display ads from multiple sources, which includes the Google Mobile Ads SDK, third-party ad networks, and house ad campaigns. Furthermore, AdMob provides analytical tools to better understand your users and maximize ad revenue.", links = listOf(Link("Google Admob","https://admob.google.com/home/"))),
                Category(id = "10_3", name = "Google Play Services", info = "Google Play Services is a proprietary background service and API package for Android devices from Google. Operated by Google, the service provides core functionalities like authentication for Google services, synchronized contacts, access to all the latest user privacy settings, and higher quality, lower-powered location-based services. It also speeds up offline searches, provides more immersive maps, and improves gaming experiences. Google Play Services play a crucial role in the operation of various other applications, including those not developed by Google. Moreover, it improves the overall Android experience by speeding up offline searches, providing more detailed maps, enhancing gaming experiences, and more.", links = listOf(Link("Google Play Services","https://developer.android.com/google/play-services"))),
                Category(id = "10_4", name = "Google Maps", info = "Google Maps is a crucial service on Android, offering powerful, user-friendly mapping technology and local business information. Google Maps features include street maps, satellite imagery, 360° panoramic views of streets (Street View), real-time traffic conditions (Google Traffic), and route planning for traveling by foot, car, bicycle and air, or public transportation. The service's interface includes a function to overlay various layers such as traffic density, public transit lines, and cycling paths. Google Maps for Android also provides an API, which allows developers to interface with and control certain aspects of the Google Maps service in their applications. This capability subjects to certain usage limits and requirements set by Google.", links = listOf(Link("Google Maps","https://developers.google.com/maps/documentation/android-sdk/overview")))
            )
        ),
        Category(
            id = "11",
            name = "Linting",info="Linting in Android is a tool that analyzes the source code of your application to identify potential errors, bugs, stylistic errors, and suspicious constructs. The term Linting came from a Unix utility that examined C language source code. In Android, it not only checks for potential Java issues but also for XML layout files and provides alerts for issues it encounters regarding usability, performance, and accessibility. For instance, it may scrutinize a draft of your AndroidManifest.xml file for potential duplication of elements or other anomalies that would cause the app to crash.",links=listOf(Link("Linting","https://developer.android.com/studio/write/lint")),
            subItems = listOf(
                Category(id = "11_1", name = "Ktlint", info = "ktlint is a static code analysis tool. It enforces a highly consistent style and adheres extensively to the official Kotlin coding conventions. ktlint does not have any configuration options (by design). The only exceptions are disabling specific rule(s) and specifying indentation size. ktlint can check, as well as automatically fix your code. Its main goal is to bring unified code style to your project. It works on the command line as well, so it can be hooked up into your continuous integration pipeline. It also has Ant, Gradle and Maven wrappers. You can use Ktlint on any Android/Kotlin project, as long as you have Gradle or Maven installed.", links = listOf(Link("Ktlint","https://ktlint.github.io/"))),
                Category(id = "11_2", name = "Detekt", info = "Detekt is a static code analysis tool for the Kotlin programming language. It operates on the abstract syntax tree provided by the Kotlin compiler and can run in the command line or as a task in your Gradle build script. Detekt provides complexity reports that can be used to identify overly complex code and help simplify it. It also checks for a variety of potential bugs and code smells, including issues with formatting, naming conventions, exception handling, and more. Moreover, Detekt is highly configurable, allowing you to enable, disable, or modify the behavior of its checks to suit your project's needs.", links = listOf(Link("Detekt","https://detekt.dev/")))
            )
        ),
        Category(
            id = "12",
            name = "Testing",info="Testing is a crucial part of the app development process. It involves validating the functionality, performance, usability, and consistency of your app before deploying it to the Play Store. There are two types of testing methods notably used: Unit testing and Instrumentation Testing. Unit testing, as the name suggests, tests each unit or segment of your code separately. It doesn't require Android dependencies and hence, runs faster. Instrumentation testing, on another hand, requires Android dependencies and is slower. Instrumentation testing tests the UIs, simulates user interactions and validates the navigation between different parts of your app. Android provides built-in testing frameworks like JUnit for unit testing and Espresso for Instrumentation testing.",links=listOf(Link("Testing","https://developer.android.com/training/testing")),
            subItems = listOf(
                Category(id = "12_1", name = "Espresso", info = "Espresso is a testing framework provided by Android to create UI tests for Android applications. It automatically synchronizes your test actions with the UI of your application, ensuring that your test will only proceed when the necessary UI activities have been completed. In Espresso, you can programmatically simulate user interactions like clicking buttons, typing text, or swiping screens, and then examine the UI's state to confirm it's as expected. Espresso tests can run on devices running Android 4.3 (API level 18) or higher.", links = listOf(Link("Espresso","https://developer.android.com/training/testing/espresso"))),
                Category(id = "12_2", name = "JUnit", info = "JUnit is a popular testing framework for Java programming. It forms the basis for many other testing libraries and tools in the Android ecosystem, making it important for any Android developer to become familiar with. The basic use of JUnit involves annotations such as @Test, indicating methods that represent a single test case. Other useful features include @Before and @After which allow for setup and teardown processes to be defined clearly. Another powerful feature in JUnit is the ability to create parameterized tests, effectively running the same test multiple times with different inputs.", links = listOf(Link("Documentation","https://developer.android.com/training/testing/local-tests")))
            )
        ),
        Category(
            id = "13",
            name = "Debugging",info="Debugging is a critical step in the app development process. In Android development, it includes identifying and fixing errors, or bugs, in your code. You can debug Android apps using several tools and techniques. For example, Android Studio, the primary integrated development environment (IDE) for Android, comes with a built-in debugging tool, the Android Debug Bridge (ADB). This command-line tool allows you to communicate your device and perform various actions like installing and debugging apps. Android Studio also supports step-by-step debugging, where you can set breakpoints in your code and inspect the application state at those points.",links=listOf(Link("Debugging","https://developer.android.com/studio/debug")), subItems = listOf(
                Category(id = "13_1", name = "Timber", info = "Timber is a logging utility tool that has been specifically extended from the Log class of Android. It has been built to simplify the logging process while aiming to reduce the amount of boilerplate code the developer has to write. It was designed and is maintained by Jake Wharton, a renowned contributor in the Android Developer community. In Timber, each log message is directed to the next available logger, reducing the redundancy of manually assigning log tags. The simplicity of Timber is highlighted by its ability to log without defining any tag. Most importantly, Timber only logs messages in debug builds by default, avoiding potential data leaks in your production application.", links = listOf(Link("Timber on GitHub","https://github.com/JakeWharton/timber"))),
                Category(id = "13_2", name = "Leak Canary", info = "LeakCanary is a powerful open-source memory leak detection library for Android and Java. It is integrated into your app, and once you run your app, LeakCanary immediately starts watching for memory leaks and captures a memory dump if it detects one. After investigation, it will present a full stack trace to help you pinpoint the exact location of the memory leak. With the LeakCanary's user-friendly interface, you can then analyze the memory leak right in your app. The most recent version of LeakCanary also includes other improvements like automatic detection of leaks in Activity, Fragment, View, ViewModel, LiveData, etc.", links = listOf(Link("Leak Canary","https://square.github.io/leakcanary/"))),
                Category(id = "13_3", name = "Chucker", info = "Chucker is an open-source debugging library created for Android applications. It has been designed to be easy to use and convenient for developers. This library intercepts and records all HTTP requests and responses inside your application, which helps to visualize and share this information in an understandable and easy-to-read format. Using Chucker's distinct features, you can inspect all the HTTP and HTTPS traffic going in and out of your app directly. In addition, it provides other nifty features such as a user-friendly interface to view the server's raw response. It's like having a built-in network inspector in your debugging tool, enabling you to solve network-related issues more efficiently.", links = listOf(Link("Chucker GitHub","https://github.com/ChuckerTeam/chucker"))),
                Category(id = "13_4", name = "Jetpack Benchmark", info = "Jetpack Benchmark is a library within the Android Jetpack Suite that allows developers to quickly and accurately measure the performance of their apps. This library can help measure CPU, memory, and IO performance of code in Android apps. Developers can define some specific code paths to be benchmarked by wrapping the code in BenchmarkRule.measureRepeated {}. In addition, it automatically takes care of warmup, measures your code performance, and outputs benchmarking results to the Android Studio's logcat.", links = listOf(Link("Jetpack Benchmark","https://developer.android.com/studio/profile/benchmark")))
            )
        ),
        Category(
            id = "14",
            name = "Distribution",info="Distribution in Android refers to the methods and channels you can use to get your Android application into the hands of users. You can choose to distribute your app on the Google Play Store, which is the official app store for the Android operating system. This platform makes your app available to users in various countries around the world. Additionally, you can also opt to distribute your app through other third-party app stores or even your own website. Furthermore, Google provides a range of distribution options such as country targeting, device targeting, and staged roll-outs, which can be customized according to your distribution strategy. Remember, when you submit your application for distribution, you must adhere to the respective app store's policy and content guidelines.",links=listOf(Link("Google Play Developer Distribution","https://developer.android.com/distribute")), subItems = listOf(
                Category(id = "14_1", name = "Signed APK", info = "A Signed APK is a version of your app that you prepare for distribution in the Play Store or other Android markets. When you sign your app using a private key, you authenticate your identity as the developer of the app. It is a required step by the Android system that ensures only updates to the APK that are from the original developer will be accepted. The Android system refuses to install an app if it's not signed appropriately, thereby protecting users from potential security risks.", links = listOf(Link("Signing Your App","https://developer.android.com/studio/publish/app-signing"))),
                Category(id = "14_2", name = "Firebase Distribution", info = "Firebase Distribution is a development tool within the Google Firebase suite that allows you to share pre-release versions of your Android apps with your development team. It enables you to distribute your app binaries to multiple testers and teams to get feedback before the app's official launch. Firebase Distribution supports both Android and iOS applications and works in tandem with other features, like Firebase Crashlytics, to effectively manage the testing and debugging aspects of your application's lifecycle.", links = listOf(Link("Firebase Distribution","https://firebase.google.com/docs/app-distribution"))),
                Category(id = "14_3", name = "Google Playstore", info = "Google Play Store is the official distribution channel for Android apps and other digital media content. It is a global online software store developed and operated by Google. Developers submit their applications to Google Play through the Play Console where Google Play's automated systems scan for potentially malicious code and content violations, before they are published on the Play Store. Users can then browse, download, and use these applications on their Android devices or via the web. Purchases, downloads, and user feedback can be tracked via the Google Play Console. Owners of Android devices can also configure automatic updates for the applications they have installed from the store. This platform supports multiple languages and multiple forms of payment methods, making it accessible and customer-friendly.", links = listOf(Link("Google Playstore","https://play.google.com/store")))
            )
        )


    )
