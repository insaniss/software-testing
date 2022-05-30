package com.stackoverflow.pages

import com.codeborne.selenide.Selectors.*
import com.codeborne.selenide.Selenide
import com.codeborne.selenide.Selenide.*
import com.codeborne.selenide.SelenideElement


class SearchPage {
    internal val tagFilter = `$`(byXpath("//*[@id='tagfilter']"))
    internal val userFilter = `$`(byXpath("//*[@id='userfilter']"))
    internal val tagList = `$`(byXpath("//*[@id='tags-browser']"))
    internal val userList = `$`(byXpath("//div[contains(@class, 'g12')]"))

    internal val emptyState = `$`(byXpath("//*[@id='user-browser']"))


    fun open(relativePath: String): SearchPage {
        Selenide.open(relativePath)
        return this
    }

    fun typeTag(tag: String): SearchPage {
        println(tagFilter)
        return this
    }

    fun typeUser(user: String): SearchPage {
        userFilter.value = user
        return this
    }

    fun pressEnter(elem: SelenideElement) {
        elem.pressEnter()
    }
}