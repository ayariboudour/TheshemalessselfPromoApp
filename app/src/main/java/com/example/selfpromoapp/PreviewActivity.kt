package com.example.selfpromoapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PreviewActivity : AppCompatActivity() {

    private lateinit var message: Message
    private lateinit var messagePreviewText: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preview)
        displayMessage()
        setUpButton()
    }

    private fun displayMessage() {
        message = intent.getSerializableExtra("Message") as Message
        messagePreviewText = """
                Hi ${message.contactName} ,
                
                My Name us ${message.myDisplayName} and I am ${message.getFullJobDescription()}.
                
                I have a portfolio of apps to demonstrate my technical skills that i can show on request.
                
                I am able to start a new position ${message.getAvailability()}
                
                Please get in touch if you have any suitable roles for me.
                
                Thanks and best regards.
                Boudour.   
            """.trimIndent()

        val textViewMessage = findViewById<TextView>(R.id.text_view_message)
        textViewMessage.text = messagePreviewText
    }

    private fun setUpButton(){
        val buttonSendMessage = findViewById<Button>(R.id.button_send_message)
        buttonSendMessage.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("smsto: ${message.contactNumber}")  // Only SMS apps respond to this.
                putExtra("sms_body", messagePreviewText)
            }
            startActivity(intent)
        }
    }

}