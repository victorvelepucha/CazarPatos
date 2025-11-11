package com.epn.fis.cazarpatos

import android.os.Bundle
import android.util.Patterns
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class LoginActivity : AppCompatActivity() {
    private lateinit var emailInputLayout: TextInputLayout
    private lateinit var emailEditText: TextInputEditText
    private lateinit var passwordInputLayout: TextInputLayout
    private lateinit var passwordEditText: TextInputEditText
    private lateinit var loginButton: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Initialize views
        emailInputLayout = findViewById(R.id.emailInputLayout)
        emailEditText = findViewById(R.id.emailEditText)
        passwordInputLayout = findViewById(R.id.passwordInputLayout)
        passwordEditText = findViewById(R.id.passwordEditText)
        loginButton = findViewById(R.id.loginButton)

        // Set up login button click listener
        loginButton.setOnClickListener {
            validateAndLogin()
        }
    }

    private fun validateAndLogin() {
        val email = emailEditText.text.toString().trim()
        val password = passwordEditText.text.toString()

        var isValid = true

        // Validate email
        if (!isValidEmail(email)) {
            emailInputLayout.error = getString(R.string.email_error)
            isValid = false
        } else {
            emailInputLayout.error = null
        }

        // Validate password
        if (!isValidPassword(password)) {
            passwordInputLayout.error = getString(R.string.password_error)
            isValid = false
        } else {
            passwordInputLayout.error = null
        }

        // If all validations pass, proceed with login
        if (isValid) {
            // Login logic would go here
            // For now, just clear errors
            emailInputLayout.error = null
            passwordInputLayout.error = null
        }
    }

    private fun isValidEmail(email: String): Boolean {
        return email.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun isValidPassword(password: String): Boolean {
        // Password must be at least 8 characters and contain only numbers
        return password.length >= 8 && password.all { it.isDigit() }
    }
}
