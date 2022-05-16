package com.stackoverflow.pages

import com.codeborne.selenide.Selectors.*
import com.codeborne.selenide.Selenide.*
import com.codeborne.selenide.SelenideElement


class OverviewPage {

    val links = listOf<SelenideElement>(
        `$`(byXpath("//a[.//p[text()='Connecting communities with the specific technologies they use the most']]")),
        `$`(byXpath("//a[contains(@data-ga, 'talent\",null,null]')]"))
    )

    val content = `$$`(byXpath("//h1[contains(@class, 'fs-display1')]"))

    fun open(): OverviewPage {
        open("/")
        return this
    }
}
