# AndroidBuildNumberPlugin

Setup : 
```groovy
buildscript {
  repositories {
    maven {
      url "https://plugins.gradle.org/m2/"
    }
  }
  dependencies {
    classpath "gradle.plugin.com.aardouin.gradle:android-buildnumber-plugin:1.0-SNAPSHOT"
  }
}

apply plugin: "com.aardouin.gradle.AndroidBuildNumberPlugin"
```

To add buildnumber capability simply change your version name : 
```
versionName computeVersion("1.1.1")
```

Now when building you can add the build number property : 
```
./gradlew assemble -PbuildNumber=123
```
