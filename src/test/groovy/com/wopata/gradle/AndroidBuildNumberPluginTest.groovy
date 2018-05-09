package com.wopata.gradle

import org.gradle.api.InvalidUserDataException


class AndroidBuildNumberPluginTest extends GroovyTestCase {

    void testBuildVersionCodeReturnOk() {
        def result = AndroidBuildNumberPlugin.buildVersionCode("1.4.7")
        def expected = 10407
        assertEquals(result, expected)
    }

    void testBuildVersionCodeReturnOk2() {
        def result = AndroidBuildNumberPlugin.buildVersionCode("1.4.70")
        def expected = 10470
        assertEquals(result, expected)
    }


    void testBuildVersionCodeThrowException() {
        shouldFail(InvalidUserDataException) {
            AndroidBuildNumberPlugin.buildVersionCode("1.4.7-SNAPSHOT")
        }
    }

    void testBuildVersionCodeThrowException2() {
        shouldFail(InvalidUserDataException) {
            AndroidBuildNumberPlugin.buildVersionCode("1.4")
        }
    }

    void testBuildVersionCodeThrowException3() {
        shouldFail(InvalidUserDataException) {
            AndroidBuildNumberPlugin.buildVersionCode("1..0")
        }
    }

    void testBuildVersionCodeThrowException4() {
        shouldFail(InvalidUserDataException) {
            AndroidBuildNumberPlugin.buildVersionCode(".4.6")
        }
    }
}
