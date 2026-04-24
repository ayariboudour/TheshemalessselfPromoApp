package com.example.selfpromoapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PreviewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preview)

        val message = intent.getStringExtra("Message")
        val messageTextView = findViewById<TextView>(R.id.text_view_message)
        messageTextView.text = message

        val sendMessageButton = findViewById<Button>(R.id.button_send_message)
        sendMessageButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("smsto:")  // This ensures only SMS apps respond
                putExtra("sms_body", message)
            }
            startActivity(intent)
        }
    }
}