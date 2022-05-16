package com.stackoverflow.tests

import com.codeborne.selenide.Condition.*
import com.stackoverflow.extensions.SelenoidExtension
import com.stackoverflow.pages.OverviewPage
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvFileSource


@DisplayName("Overview Tests")
@ExtendWith(SelenoidExtension::class)
class OverviewTest {
    private val page = OverviewPage()

    @DisplayName("Test opening overview links")
    @ParameterizedTest(name = "index: {0}, content: {1}")
    @CsvFileSource(
        files = ["lab-3.0/test/resources/overview/link-info.csv"],
        numLinesToSkip = 1
    )
    internal fun testOpeningLinks(i: Int, content: String) {
        page.open().links[i].click()

        page.content
            .findBy(text(content))
            .shouldBe(visible)
    }
}
