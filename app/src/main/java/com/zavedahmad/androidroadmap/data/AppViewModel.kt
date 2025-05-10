package com.zavedahmad.androidroadmap.data

import androidx.lifecycle.ViewModel

class AppViewModel: ViewModel(){
    val sampleCategories =
        com.zavedahmad.androidroadmap.data.sampleCategories
    var selectedCategory: Category? = null
    var selectedCategoryId: String? =null
}