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
import android.widget.Toast
// import com.google.firebase.auth.FirebaseAuth
// import com.google.firebase.auth.FirebaseUser

class MainActivity : Activity() {

    private lateinit var usernameEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var resultTextView: TextView
    private lateinit var signupButton: Button
    private lateinit var loginButton: Button
    // private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        usernameEditText = findViewById(R.id.username)
        emailEditText = findViewById(R.id.email)
        passwordEditText = findViewById(R.id.password)
        resultTextView = findViewById(R.id.result)
        signupButton = findViewById(R.id.signupButton)
        loginButton = findViewById(R.id.loginButton)

        // auth = FirebaseAuth.getInstance()

        signupButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()
            val jsonObject = JSONObject().apply {
                put("username", username)
                put("email", email)
                put("password", password)
            }

            resultTextView.text = jsonObject.toString(4) // Pretty print with indentation
            Log.d("MainActivity", jsonObject.toString(4))

            signUp(email, password)
        }

        loginButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()
            val jsonObject = JSONObject().apply {
                put("username", username)
                put("email", email)
                put("password", password)
            }

            resultTextView.text = jsonObject.toString(4) // Pretty print with indentation
            Log.d("MainActivity", jsonObject.toString(4))
            signIn(email, password)
        }
    }

    private fun signUp(email: String, password: String) {
        /*
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Log.d("MainActivity", "createUserWithEmail:success")
                    val user = auth.currentUser
                    updateUI(user)
                } else {
                    Log.w("MainActivity", "createUserWithEmail:failure", task.exception)
                    Toast.makeText(baseContext, "Authentication failed.", Toast.LENGTH_SHORT).show()
                    updateUI(null)
                }
            }
         */
        Toast.makeText(baseContext, "Authentication failed.", Toast.LENGTH_SHORT).show()
        updateUI(email)
    }

    private fun signIn(email: String, password: String) {
        /*
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Log.d("MainActivity", "signInWithEmail:success")
                    // val user = auth.currentUser
                    updateUI(user)
                } else {
                    Log.w("MainActivity", "signInWithEmail:failure", task.exception)
                    Toast.makeText(baseContext, "Authentication failed.", Toast.LENGTH_SHORT).show()
                    updateUI(null)
                }
            }
         */
        Toast.makeText(baseContext, "Authentication failed.", Toast.LENGTH_SHORT).show()
        updateUI(email)
    }

    private fun updateUI(user: String) {
        if (user != null) {
            // resultTextView.text = "User: ${user.email}"
            resultTextView.text = "User: ${user}"
        } else {
            resultTextView.text = "No user logged in"
        }
    }

    override fun onStop() {
        super.onStop()
        Log.d("MainActivity", "Process stopped !")
    }
}