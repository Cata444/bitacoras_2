package com.example.bitacoras

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform