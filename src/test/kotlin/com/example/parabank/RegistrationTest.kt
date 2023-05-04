package com.example.parabank

import com.codeborne.selenide.Configuration
import com.codeborne.selenide.Selenide.open
import com.example.parabank.model.UserData
import com.example.parabank.pages.RegistrationPage
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.openqa.selenium.chrome.ChromeOptions


class RegistrationTest {
    private val registrationPage = RegistrationPage()

    companion object {
        @BeforeAll
        @JvmStatic
        fun setUp() {
            Configuration.browserCapabilities = ChromeOptions().addArguments("--remote-allow-origins=*")
        }
    }

    @Test
    fun `successful registration`() {
        val userData = UserData()

        open("https://parabank.parasoft.com/parabank/register.htm")
        registrationPage.fillForm(userData)
        registrationPage.submitForm()
        registrationPage.verifyRegistrationCompletePage(userData.username)
    }
}