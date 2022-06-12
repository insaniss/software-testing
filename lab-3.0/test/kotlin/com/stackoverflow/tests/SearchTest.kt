package com.stackoverflow.tests

import com.codeborne.selenide.Condition.*
import com.stackoverflow.extensions.SelenoidExtension
import com.stackoverflow.pages.SearchPage
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource


@DisplayName("Search Tests")
@ExtendWith(SelenoidExtension::class)
class SearchTest {
    private val page = SearchPage()

    @DisplayName("Test searched tag found")
    @ParameterizedTest(name = "tag: {0}")
    @ValueSource(strings = [
        "java",
        "selenium",
        "junit",
    ])
    internal fun testSearchedTagFound(tag: String) {
        page.open("/tags")
            .typeTag(tag)
            .pressEnter(page.tagFilter)

        page.tagList
            .shouldBe(visible)
            .shouldNotBe(empty)
    }

    @DisplayName("Test searched tag not found")
    @ParameterizedTest(name = "tag: {0}")
    @ValueSource(strings = [
        "bimbo",
        "nikita",
        "qwertyuiop",
    ])
    internal fun testSearchedTagNotFound(tag: String) {
        page.open("/tags")
            .typeTag(tag)
            .pressEnter(page.tagFilter)

        page.emptyState
            .shouldNotHave()
    }

    @DisplayName("Test searched user found")
    @ParameterizedTest(name = "user: {0}")
    @ValueSource(strings = [
        "alex",
        "octoant",
        "maestro"
    ])
    internal fun testSearchedUserFound(user: String) {
        page.open("/users")
            .typeUser(user)
            .pressEnter(page.userFilter)

        page.userList
            .shouldBe(visible)
            .shouldNotBe(empty)
    }

    @DisplayName("Test searched user not found")
    @ParameterizedTest(name = "user: {0}")
    @ValueSource(strings = [
        "bimboad",
        "octoantas",
        "maestrooo"
    ])
    internal fun testSearchedUserNotFound(user: String) {
        page.open("/users")
            .typeUser(user)
            .pressEnter(page.userFilter)

        page.emptyState
            .shouldNotHave()
    }
}
