package com.example.utspam

import java.io.Serializable

data class MenuItem(
    val name: String,
    val description: String,
    val price: Int,
    var isSelected: Boolean = false
) : Serializable
