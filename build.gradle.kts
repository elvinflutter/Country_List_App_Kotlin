// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.1.1" apply false
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false

}

//buildscript {
//    repositories {
//        google()
//    }
//    dependencies {
//        classpath ("com.android.tools.build:gradle:8.1.1")
//        classpath ("org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.61")
//        val navVersion = "2.7.2"
//        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:$navVersion")
//    }
//}
buildscript {

    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath ("com.android.tools.build:gradle:8.1.1")
        classpath ("org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.61")

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
        val navVersion = "2.7.2"
        classpath ("androidx.navigation:navigation-safe-args-gradle-plugin:$navVersion")

    }
}


