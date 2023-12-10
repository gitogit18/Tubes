package com.example.tubes.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class HealthArticleData(
    val itemDetails: String,
    val itemImages: Int,
    val itemTitles: String
) : Parcelable
