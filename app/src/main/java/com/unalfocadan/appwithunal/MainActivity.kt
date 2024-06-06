package com.unalfocadan.appwithunal

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.unalfocadan.appwithunal.ui.theme.AppwithunalTheme
import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import org.json.JSONObject

class MainActivity : Activity() {

    private lateinit var usernameEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var resultTextView: TextView
    private lateinit var signupButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        usernameEditText = findViewById(R.id.username)
        emailEditText = findViewById(R.id.email)
        passwordEditText = findViewById(R.id.password)
        resultTextView = findViewById(R.id.result)
        signupButton = findViewById(R.id.signupButton)

        signupButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            /*
            val result = """
                {
                    "name": "$username",
                    "email": "$email",
                    "password": "$password"
                }
            """.trimIndent()

            resultTextView.text = result
            */

            val jsonObject = JSONObject().apply {
                put("username", username)
                put("email", email)
                put("password", password)
            }

            resultTextView.text = jsonObject.toString(4) // Pretty print with indentation
            Log.d("MainActivity", jsonObject.toString(4))
        }
    }

    override fun onStop() {
        super.onStop()
        Log.d("MainActivity", "Process stopped !")
    }
}