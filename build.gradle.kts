import org.jetbrains.kotlin.gradle.targets.js.ir.DefaultIncrementalSyncTask
import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpack
import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig

plugins {
    alias(libs.plugins.compose)
    alias(libs.plugins.detekt)
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.ksp)
    application
}

group = "me.leptonquark"
version = "1.0"

repositories {
    google()
    gradlePluginPortal()
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/kotlin/p/kotlin/dev")
    maven("https://maven.pkg.jetbrains.space/kotlin/p/wasm/experimental")
    maven("https://maven.pkg.jetbrains.space/public/p/kotlinx-html/maven")
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

kotlin {
    js {
        moduleName = "personal-webpage"
        binaries.executable()
        browser {
            commonWebpackConfig {
                cssSupport {
                    enabled.set(true)
                }
                outputFileName = "personal-webpage.js"
            }
        }
    }
    @OptIn(org.jetbrains.kotlin.gradle.targets.js.dsl.ExperimentalWasmDsl::class)
    wasmJs {
        moduleName = "personal-webpage"
        browser {
            commonWebpackConfig {
                devServer = (devServer ?: KotlinWebpackConfig.DevServer()).copy(
                    static = (devServer?.static ?: mutableListOf()).apply {
                        add(project.rootDir.path)
                    },
                )
            }
        }
        binaries.executable()
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(compose.runtime)
                implementation(compose.ui)
                implementation(compose.foundation)
                implementation(compose.material3)
                implementation(compose.materialIconsExtended)
                @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
                implementation(compose.components.resources)
            }
        }
        val jsMain by getting {
            dependencies {
                implementation(libs.inject.runtime)
                implementation(libs.bundles.ktor.js)
                kotlin.srcDir("build/generated/ksp/js/jsMain/kotlin")
            }
        }
        val wasmJsMain by getting {
            dependencies {
                implementation(libs.serialization.wasm)
            }
        }
    }
}

dependencies {
    add("kspJs", libs.inject.compiler)
}


compose {
    experimental {
        web.application
    }
    kotlinCompilerPlugin.set(libs.versions.composecompiler.get())
    kotlinCompilerPluginArgs.add("suppressKotlinVersionCompatibilityCheck=${libs.versions.kotlin.get()}")
}

detekt {
    config.setFrom("detekt-config.yml")
    source.setFrom("src/commonMain/kotlin", "src/wasmMain/kotlin")
}



project.tasks.whenTaskAdded {
    if (name == "compileCommonMainKotlinMetadata") {
        enabled = false
    }
}

tasks.named<KotlinWebpack>("jsBrowserProductionWebpack") {
    dependsOn(tasks.named<DefaultIncrementalSyncTask>("wasmJsProductionExecutableCompileSync"))
}

tasks.named<Copy>("wasmJsBrowserProductionExecutableDistributeResources") {
    dependsOn(tasks.named<DefaultIncrementalSyncTask>("jsProductionExecutableCompileSync"))
}

configurations.all {
    resolutionStrategy.eachDependency {
        if (requested.module.name.startsWith("kotlin-stdlib")) {
            useVersion(libs.versions.kotlin.get())
        }
    }
}
