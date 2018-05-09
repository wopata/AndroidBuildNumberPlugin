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
    classpath "gradle.plugin.com.wopata.gradle:android-buildnumber-plugin:1.0.0"
  }
}

apply plugin: "com.wopata.gradle.AndroidBuildNumberPlugin"
```

To add buildnumber capability simply change your version name : 
```
versionCode buildVersionCode("1.1.1")
versionName computeVersion("1.1.1")
```

Now when building you can add the build number property : 
```
./gradlew assemble -PbuildNumber=123
```
