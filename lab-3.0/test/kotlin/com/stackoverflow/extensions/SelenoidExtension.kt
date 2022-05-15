package com.stackoverflow.extensions

import com.codeborne.selenide.Configuration.*
import org.junit.jupiter.api.extension.BeforeAllCallback
import org.junit.jupiter.api.extension.ExtensionContext
import java.util.Properties


class SelenoidExtension : BeforeAllCallback {
    private val props = Properties()

    override fun beforeAll(content: ExtensionContext?) {
        props.load(this::class.java.classLoader.getResourceAsStream("selenide.properties"))

        remote = this.props.getProperty("selenide.remote")
        browser = this.props.getProperty("selenide.browser")
        browserVersion = this.props.getProperty("selenide.browser-version")

        browserCapabilities.setCapability("selenoid:options", mapOf("enableVNC" to true, "enableVideo" to true))
    }
}
