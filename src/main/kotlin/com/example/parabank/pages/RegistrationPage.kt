package com.example.parabank.pages

import com.codeborne.selenide.Condition.exactText
import com.codeborne.selenide.Selenide.`$`
import com.codeborne.selenide.Selenide.element
import com.codeborne.selenide.SelenideElement
import com.example.parabank.model.UserData

class RegistrationPage {
    private val firstNameInput: SelenideElement = `$`("input[name='customer.firstName']")
    private val lastNameInput: SelenideElement = `$`("input[name='customer.lastName']")
    private val addressInput: SelenideElement = `$`("input[name='customer.address.street']")
    private val cityInput: SelenideElement = `$`("input[name='customer.address.city']")
    private val stateInput: SelenideElement = `$`("input[name='customer.address.state']")
    private val zipCodeInput: SelenideElement = `$`("input[name='customer.address.zipCode']")
    private val phoneNumberInput: SelenideElement = `$`("input[name='customer.phoneNumber']")
    private val ssnInput: SelenideElement = `$`("input[name='customer.ssn']")
    private val usernameInput: SelenideElement = `$`("input[name='customer.username']")
    private val passwordInput: SelenideElement = `$`("input[name='customer.password']")
    private val confirmPasswordInput: SelenideElement = `$`("#repeatedPassword")
    private val submitButton: SelenideElement = `$`("input[value='Register']")

    fun fillForm(userData: UserData) {
        // Fill in the registration form with the provided user data
        firstNameInput.setValue(userData.firstName)
        lastNameInput.setValue(userData.lastName)
        addressInput.setValue(userData.address)
        cityInput.setValue(userData.city)
        stateInput.setValue(userData.state)
        zipCodeInput.setValue(userData.zipCode)
        phoneNumberInput.setValue(userData.phoneNumber)
        ssnInput.setValue(userData.ssn)
        usernameInput.setValue(userData.username)
        passwordInput.setValue(userData.password)
        confirmPasswordInput.setValue(userData.confirmPassword)
    }

    fun submitForm() {
        // Submit the registration form
        submitButton.click()
    }

    fun verifyRegistrationCompletePage(username: String) {
        // Verify that the user is redirected to the "Registration Complete" page
        element("h1").shouldHave(exactText("Welcome $username"))
        // Verify that the user receives a confirmation email with their login information (not tested here)
    }

}
