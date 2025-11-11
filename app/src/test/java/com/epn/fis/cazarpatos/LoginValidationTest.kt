package com.epn.fis.cazarpatos

import android.util.Patterns
import org.junit.Test
import org.junit.Assert.*

/**
 * Unit tests for login validation logic
 */
class LoginValidationTest {

    // Email validation tests
    @Test
    fun validEmail_returnsTrue() {
        val email = "test@example.com"
        assertTrue(isValidEmail(email))
    }

    @Test
    fun emptyEmail_returnsFalse() {
        val email = ""
        assertFalse(isValidEmail(email))
    }

    @Test
    fun invalidEmail_noAtSign_returnsFalse() {
        val email = "testexample.com"
        assertFalse(isValidEmail(email))
    }

    @Test
    fun invalidEmail_noDomain_returnsFalse() {
        val email = "test@"
        assertFalse(isValidEmail(email))
    }

    @Test
    fun invalidEmail_noUsername_returnsFalse() {
        val email = "@example.com"
        assertFalse(isValidEmail(email))
    }

    // Password validation tests
    @Test
    fun validPassword_eightDigits_returnsTrue() {
        val password = "12345678"
        assertTrue(isValidPassword(password))
    }

    @Test
    fun validPassword_moreThanEightDigits_returnsTrue() {
        val password = "123456789012"
        assertTrue(isValidPassword(password))
    }

    @Test
    fun invalidPassword_lessThanEightCharacters_returnsFalse() {
        val password = "1234567"
        assertFalse(isValidPassword(password))
    }

    @Test
    fun invalidPassword_containsLetters_returnsFalse() {
        val password = "12345abc"
        assertFalse(isValidPassword(password))
    }

    @Test
    fun invalidPassword_containsSpecialCharacters_returnsFalse() {
        val password = "12345678!"
        assertFalse(isValidPassword(password))
    }

    @Test
    fun invalidPassword_empty_returnsFalse() {
        val password = ""
        assertFalse(isValidPassword(password))
    }

    @Test
    fun invalidPassword_onlyLetters_returnsFalse() {
        val password = "abcdefgh"
        assertFalse(isValidPassword(password))
    }

    // Helper methods matching LoginActivity logic
    private fun isValidEmail(email: String): Boolean {
        return email.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun isValidPassword(password: String): Boolean {
        return password.length >= 8 && password.all { it.isDigit() }
    }
}
