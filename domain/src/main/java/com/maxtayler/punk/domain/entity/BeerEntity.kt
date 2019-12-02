package com.maxtayler.punk.domain.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class BeerEntity(
    @PrimaryKey val id: Long,
    val title: String,
    val imageUrl: String,
    val tagLine: String,
    val isBookmarked: Boolean
)