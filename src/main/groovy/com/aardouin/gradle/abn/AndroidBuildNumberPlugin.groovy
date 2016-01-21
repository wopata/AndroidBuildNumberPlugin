package com.aardouin.gradle.abn

import org.gradle.api.Project
import org.gradle.api.Plugin

class AndroidBuildNumberPlugin implements Plugin<Project> {
    @Override
    public void apply(Project project) {


        project.ext.computeVersion = { versionName ->
            def version = versionName
            println("version : ${version}")
            if (project.hasProperty("buildNumber")) {
                version += "(${project.property("buildNumber")})"
            }
            println("ComputedVersion name : ${version}")
            return version
        }

    }

}