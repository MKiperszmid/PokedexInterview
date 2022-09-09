package com.mk.interviewprocess.util

import java.util.*

fun String.capitalize(): String {
    return this.replaceFirstChar { letter ->
        if (letter.isLowerCase()) letter.titlecase(Locale.getDefault()) else letter.toString()
    }
}
