package com.stackoverflow.pages

import com.codeborne.selenide.Selectors.*
import com.codeborne.selenide.Selenide.*


class SignUpPage {
    private val displayNameInput = `$`(byXpath("//*[@id='display-name']"))
    private val emailInput = `$`(byXpath("//*[@id='email']"))
    private val passwordInput = `$`(byXpath("//*[@id='password']"))
    private val submitButton = `$`(byXpath("//*[@id='submit-button']"))

    internal val verifyLabel = `$`(byXpath("//div[contains(@class, 'mb8')]"))
    internal val errorMessages = `$$`(byXpath("//p[contains(@class, 'js-error-message')]"))

    fun open(): SignUpPage {
        open("/users/signup")
        return this
    }

    fun typeDisplayName(name: String): SignUpPage {
        displayNameInput.value = name
        return this
    }

    fun typeEmail(email: String): SignUpPage {
        emailInput.value = email
        return this
    }

    fun typePassword(password: String): SignUpPage {
        passwordInput.value = password
        return this
    }

    fun clickSubmit(): SignUpPage {
        submitButton.click()
        return this
    }
}
