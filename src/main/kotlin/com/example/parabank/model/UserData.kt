package com.example.parabank.model

import com.github.javafaker.Faker

val faker = Faker()
data class UserData(
    val firstName: String = faker.name().firstName(),
    val lastName: String = faker.name().lastName(),
    val address: String = faker.address().streetAddress(),
    val city: String = faker.address().city(),
    val state: String = faker.address().stateAbbr(),
    val zipCode: String = faker.address().zipCode(),
    val phoneNumber: String = faker.phoneNumber().cellPhone(),
    val ssn: String = faker.idNumber().ssnValid(),
    val username: String = faker.name().username(),
    val password: String = faker.internet().password(8, 20, true, true, true),
    val confirmPassword: String = password
)
