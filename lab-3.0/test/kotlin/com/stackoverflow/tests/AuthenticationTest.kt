package com.stackoverflow.tests

import com.codeborne.selenide.Condition.*
import com.stackoverflow.extensions.SelenoidExtension
import com.stackoverflow.pages.SignInPage
import com.stackoverflow.pages.SignUpPage
import org.junit.jupiter.api.*
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvFileSource
import org.junit.jupiter.params.provider.ValueSource


@DisplayName("Authentication Tests")
@ExtendWith(SelenoidExtension::class)
class AuthenticationTest {

    @DisplayName("Signing-In functionality Tests")
    @TestMethodOrder(OrderAnnotation::class)
    @Nested
    inner class SignInTest {
        private val page = SignInPage()

        @DisplayName("Test with empty fields")
        @Test
        @Order(1)
        internal fun testWithEmptyFields() {
            page.open()
                .clickSubmit()

            page.errorMessages
                .findBy(text("Email cannot be empty."))
                .shouldBe(visible)
            page.errorMessages
                .findBy(text("Password cannot be empty."))
                .shouldBe(visible)
        }

        @DisplayName("Test with empty password field")
        @ParameterizedTest(name = "email: {0}")
        @Order(2)
        @ValueSource(strings = ["example@mail.ru", "another@yan.ru"])
        internal fun testWithEmptyPasswordField(email: String) {
            page.open()
                .typeEmail(email)
                .clickSubmit()

            page.errorMessages
                .findBy(text("Password cannot be empty."))
                .shouldBe(visible)
        }

        @DisplayName("Test with empty email field")
        @ParameterizedTest(name = "password: {0}")
        @Order(3)
        @ValueSource(strings = ["s8cr8tKey", "maestro0x"])
        internal fun testWithEmptyEmailField(password: String) {
            page.open()
                .typePassword(password)
                .clickSubmit()

            page.errorMessages
                .findBy(text("Email cannot be empty."))
                .shouldBe(visible)
        }

        @DisplayName("Test with invalid credentials")
        @ParameterizedTest(name = "email: {0}, password: {1}")
        @Order(4)
        @CsvFileSource(
            files = ["lab-3.0/test/resources/login/invalid-credentials.csv"],
            numLinesToSkip = 1
        )
        internal fun testWithInvalidCredentials(
            email: String,
            password: String
        ) {
            page.open()
                .typeEmail(email)
                .typePassword(password)
                .clickSubmit()

            page.errorMessages
                .findBy(text("The email or password is incorrect."))
                .shouldBe(visible)
        }

        @Disabled
        @DisplayName("Test with valid credentials")
        @ParameterizedTest(name = "email: {0}, password: ******, username: {2}")
        @Order(5)
        @CsvFileSource(
            files = ["lab-3.0/test/resources/login/valid-credentials.csv"],
            numLinesToSkip = 1
        )
        internal fun testWithValidCredentials(
            email: String,
            password: String,
            username: String
        ) {
            page.open()
                .typeEmail(email)
                .typePassword(password)
                .clickSubmit()

            page.profileBadge
                .shouldHave(text(username))
        }
    }


    @DisplayName("Signing-Up functionality Tests")
    @TestMethodOrder(OrderAnnotation::class)
    @Nested
    inner class SignUpTest {
        private val page = SignUpPage()

        @DisplayName("Test with empty fields")
        @Test
        @Order(1)
        internal fun testWithEmptyFields() {
            page.open()
                .clickSubmit()

            page.errorMessages
                .findBy(text("Email cannot be empty."))
                .shouldBe(visible)
            page.errorMessages
                .findBy(text("Password cannot be empty."))
                .shouldBe(visible)
        }

        @DisplayName("Test with single display name field")
        @ParameterizedTest(name = "display name: {0}")
        @Order(2)
        @ValueSource(strings = ["monkey", "maestro", "rambo"])
        internal fun testWithSingleDisplayNameField(name: String) {
            page.open()
                .typeDisplayName(name)
                .clickSubmit()

            page.errorMessages
                .findBy(text("Email cannot be empty."))
                .shouldBe(visible)
            page.errorMessages
                .findBy(text("Password cannot be empty."))
                .shouldBe(visible)
        }

        @DisplayName("Test with single email field")
        @ParameterizedTest(name = "email: {0}")
        @Order(3)
        @ValueSource(strings = ["example@mail.com", "another@yan.ru"])
        internal fun testWithSingleEmailField(email: String) {
            page.open()
                .typeEmail(email)
                .clickSubmit()

            page.errorMessages
                .findBy(text("Password cannot be empty."))
                .shouldBe(visible)
        }

        @DisplayName("Test with single password field")
        @ParameterizedTest(name = "password: {0}")
        @Order(4)
        @ValueSource(strings = ["s8cr8tKey", "maestro0x"])
        internal fun testWithSinglePasswordField(password: String) {
            page.open()
                .typePassword(password)
                .clickSubmit()

            page.errorMessages
                .findBy(text("Email cannot be empty."))
                .shouldBe(visible)
        }

        @DisplayName("Test with equal display name and email field")
        @ParameterizedTest(name = "display name: {0}, email: {0}")
        @Order(5)
        @ValueSource(strings = ["maestro", "maestro@bum.bom"])
        internal fun testWithEqualDisplayNameAndEmailField(value: String) {
            page.open()
                .typeDisplayName(value)
                .typeEmail(value)
                .clickSubmit()

            page.errorMessages
                .findBy(text("Name and email address must be different. " +
                        "If you don't want to enter a name, just leave it blank."))
                .shouldBe(visible)
        }

        @DisplayName("Test with valid credentials")
        @ParameterizedTest(name = "display name: {0}, email: {1}, password: {2}")
        @Order(6)
        @CsvFileSource(
            files = ["lab-3.0/test/resources/register/valid-credentials.csv"],
            numLinesToSkip = 1
        )
        internal fun testWithValidCredentials(
            name: String,
            email: String,
            password: String
        ) {
            page.open()
                .typeDisplayName(name)
                .typeEmail(email)
                .typePassword(password)
                .clickSubmit()

            page.verifyLabel
                .shouldHave(text("Registration email sent to $email. " +
                        "Open this email to finish signup."))
                .shouldBe(visible)
        }
    }
}
