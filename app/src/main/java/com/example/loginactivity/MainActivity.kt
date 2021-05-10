package com.example.loginactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.loginactivity.databinding.ActivityMainBinding
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    var binding: ActivityMainBinding? = null
    var adapter: FactAdapter? = null
        override fun onCreate(saveInstanceState:Bundle?) {
            super.onCreate(saveInstanceState)
            setContentView(R.layout.activity_main)

            signIn()
            binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding?.root)
            setUpFact()
        }

    private fun setUpFact() {
            adapter = FactAdapter( this, DummyData.funFacts)
            binding?.factListView?.adapter = adapter
        }

        override fun onDestroy() {
            super.onDestroy()
            binding = null
    }

    private fun signIn() {
            val email = findViewById<TextInputEditText>(R.id.email_edit_text)
            val password = findViewById<TextInputEditText>(R.id.password_edit_text)
            val signinButton = findViewById<MaterialButton>(R.id.next_button)

            signinButton.setOnClickListener() {
                if (email.toString().isNullOrEmpty() || password.toString().isNullOrEmpty()) {
                    Toast.makeText(this, "Email or password is not provided", Toast.LENGTH_LONG).show()
                } else {
                    if (email.toString() == "osgun4christ@gmail.com" && password.toString() == "iLoveJESUS") {
                        val intent = Intent( this, LoginActivity::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this, "Email or password is not provided", Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
}

