plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("org.jetbrains.compose")
    kotlin("plugin.serialization").version("1.9.20")
//    id("dev.icerock.mobile.multiplatform-resources")
}

kotlin {
    androidTarget()

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "shared"
            isStatic = true
            export("dev.icerock.moko:resources:0.23.0")
            export("dev.icerock.moko:graphics:0.9.0")
        }
    }

    val coroutinesVersion = "1.7.3"
    val ktorVersion = "2.3.5"
    val sqlDelightVersion = "1.5.5"
    val dateTimeVersion = "0.4.1"
    sourceSets {
        val commonMain by getting {
            dependencies {
                api(compose.foundation)
                api(compose.animation)
                implementation(compose.ui)
                implementation(compose.runtime)
                implementation(compose.material)
                implementation(compose.material3)
                implementation(compose.materialIconsExtended)
                @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
                implementation(compose.components.resources)

                implementation(libs.voyager.navigator)
                implementation(libs.voyager.tab.navigator)
                implementation(libs.voyager.transitions)
                implementation(libs.voyager.androidx)
                implementation(libs.voyager.koin)

                implementation(libs.kotlinx.dateTime)
                implementation(libs.koin.core)
                implementation(libs.koin.compose)

                api(libs.mvvm.core)
                api(libs.mvvm.compose)
                api(libs.mvvm.flow)
                api(libs.mvvm.flow.compose)
                api(libs.precompose)


                implementation(libs.coroutines.core)
                implementation(libs.ktor.client.core)
                implementation(libs.ktor.client.content.negotiation)
                implementation(libs.ktor.serialization.kotlinx.json)
                implementation(libs.runtime)

                api(libs.image.loader)
                api("io.github.qdsfdhvh:image-loader-extension-moko-resources:1.7.1")
//                implementation("dev.icerock.moko:resources-compose:0.23.0")
            }
        }
        val androidMain by getting {
            dependencies {
                api(libs.compose.activity)
                api(libs.androidx.appcompat)
                api(libs.androidx.core)
                implementation(libs.ktor.client.android)
            }
        }
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
            dependencies {
                implementation(libs.ktor.client.darwin)
            }
        }
    }
}

//dependencies {
//    commonMainApi(libs.resources)
//    commonMainApi(libs.resources.compose) // for compose multiplatform
//    commonTestImplementation(libs.resources.test)
//}

//multiplatformResources {
//    multiplatformResourcesPackage = "resource"
//    multiplatformResourcesClassName = "R"
//    multiplatformResourcesVisibility = dev.icerock.gradle.MRVisibility.Internal
//    iosBaseLocalizationRegion = "en"
//}

android {
    compileSdk = (findProperty("android.compileSdk") as String).toInt()
    namespace = "com.myapplication.common"

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    sourceSets["main"].res.srcDirs("src/androidMain/res")
    sourceSets["main"].resources.srcDirs("src/commonMain/resources")

    defaultConfig {
        minSdk = (findProperty("android.minSdk") as String).toInt()
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlin {
        jvmToolchain(17)
    }
}
