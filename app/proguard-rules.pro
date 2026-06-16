# This is a configuration file for ProGuard.
# http://proguard.sourceforge.net/index.html#manual/usage.html

-dontobfuscate

# Keep all public classes and methods
-keep public class * {
    public protected *;
}

# Kotlin
-keep class kotlin.** { *; }
-keep class kotlinx.** { *; }
-keepclasseswithmembernames class * {
    native <methods>;
}

# Preserve line numbers for debugging
-keepattributes SourceFile,LineNumberTable
-renamesourcefileattribute SourceFile

# Room
-keep class androidx.room.** { *; }
-keepclasseswithmembernames class androidx.room.** {
    <methods>;
}

# Gson
-keep class com.google.gson.** { *; }
-keep class * extends com.google.gson.TypeAdapter

# Retrofit
-keepattributes Signature, InnerClasses
-keep class retrofit2.** { *; }
-keepclasseswithmembernames interface * {
    @retrofit2.http.* <methods>;
}

# OkHttp
-keep class okhttp3.** { *; }
-keep interface okhttp3.** { *; }

# Moshi
-keep class com.squareup.moshi.** { *; }
-keepclasseswithmembernames class * {
    @com.squareup.moshi.* <methods>;
}
