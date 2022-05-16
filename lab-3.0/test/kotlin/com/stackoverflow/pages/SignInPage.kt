package com.stackoverflow.pages

import com.codeborne.selenide.Selectors.*
import com.codeborne.selenide.Selenide.*


class SignInPage {
    private val emailInput = `$`(byXpath("//*[@id='email']"))
    private val passwordInput = `$`(byXpath("//*[@id='password']"))
    private val submitButton = `$`(byXpath("//*[@id='submit-button']"))

    internal val profileBadge = `$`(byXpath("//a[contains(@class, 'm0')]"))
    internal val errorMessages = `$$`(byXpath("//p[contains(@class, 'js-error-message')]"))

    fun open(): SignInPage {
        open("/users/login")
        return this
    }

    fun typeEmail(email: String): SignInPage {
        emailInput.value = email
        return this
    }

    fun typePassword(password: String): SignInPage {
        passwordInput.value = password
        return this
    }

    fun clickSubmit(): SignInPage {
        submitButton.click()
        return this
    }
}
