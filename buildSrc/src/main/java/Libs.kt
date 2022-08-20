object Libs {

    // Ktor Libs
    const val KTOR_CLIENT = "io.ktor:ktor-client-core:${Version.KTOR_VERSION}"
    const val KTOR_SERIALIZATION = "io.ktor:ktor-client-serialization:${Version.KTOR_VERSION}"
    const val KTOR_CONTENT_NEGOTIATION =
        "io.ktor:ktor-client-content-negotiation:${Version.KTOR_VERSION}"
    const val KTOR_KOTLIN_SERIALIZATION =
        "io.ktor:ktor-serialization-kotlinx-json:${Version.KTOR_VERSION}"
    const val KTOR_LOGGING = "io.ktor:ktor-client-logging:${Version.KTOR_VERSION}"
    const val KTOR_MOCK = "io.ktor:ktor-client-mock:${Version.KTOR_VERSION}"
    const val KTOR_CLIENT_ANDROID = "io.ktor:ktor-client-android:${Version.KTOR_VERSION}"
    const val KTOR_CLIENT_JSON = "io.ktor:ktor-client-json:${Version.KTOR_VERSION}"
    const val KTOR_CLIENT_SERIALIZATION =
        "io.ktor:ktor-client-serialization-jvm:${Version.KTOR_VERSION}"

    // Koin Libs
    const val KOIN_CORE = "io.insert-koin:koin-core:${Version.KOIN_VERSION}"
    const val KOIN_TEST = "io.insert-koin:koin-test:${Version.KOIN_VERSION}"
    const val KOIN_ANDROID = "io.insert-koin:koin-android:${Version.KOIN_VERSION}"

    // Coroutine
    const val COROUTINE_TEST = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Version.KOTLIN_COROUTINE_TEST_VERSION}"

    // Coil
    const val COIL = "io.coil-kt:coil-compose:${Version.COIL_VERSION}"

    // Material
    const val COMPOSE_LIVEDATA = "androidx.compose.runtime:runtime-livedata:${Version.MATERIAL_VERSION}"
    const val COMPOSE_MATERIAL_UI = "androidx.compose.material:material:${Version.MATERIAL_VERSION}"

    // Jetpack Components
    const val COMPOSE_VIEWMODEL = "androidx.lifecycle:lifecycle-viewmodel-compose:${Version.JETPACK_COMPONENTS_VERSION}"
    const val COMPOSE_NAVIGATION = "androidx.navigation:navigation-compose:${Version.JETPACK_COMPONENTS_VERSION}"
    const val COMPOSE_ACTIVITY = "androidx.activity:activity-compose:${Version.COMPOSE_ACTIVITY_VERSION}"

    // Material Theme
    const val MATERIAL_THEME = "com.google.android.material:compose-theme-adapter:${Version.MATERIAL_THEME_VERSION}"
}