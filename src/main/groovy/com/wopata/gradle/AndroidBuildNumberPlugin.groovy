package com.wopata.gradle

import org.gradle.api.InvalidUserDataException
import org.gradle.api.Project
import org.gradle.api.Plugin

class AndroidBuildNumberPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {

        project.ext.computeVersion = { versionName ->
            def version = versionName
            println("version : ${version}")
            if (project.hasProperty("buildNumber")) {
                version += "(${project.property("buildNumber")})"
            }
            println("ComputedVersion name : ${version}")
            return version
        }

        project.ext.buildVersionCode = { versionName ->
            return buildVersionCode(versionName)
        }

    }

    static int buildVersionCode(String versionName) {
        if (!(versionName ==~ /^\d+\.\d+\.\d+$/)) {
            throw new InvalidUserDataException("versionName must be 0.0.0 format")
        }

        def (major, minor, patch) = versionName.tokenize('.')
        (major, minor, patch) = [major, minor, patch].collect{it.toInteger()}
        def versionCode = (major * 10000) + (minor * 100) + patch

        println("versionCode: $versionCode")

        return versionCode
    }

}