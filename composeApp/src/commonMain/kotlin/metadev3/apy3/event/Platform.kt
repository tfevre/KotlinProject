package metadev3.apy3.event

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform