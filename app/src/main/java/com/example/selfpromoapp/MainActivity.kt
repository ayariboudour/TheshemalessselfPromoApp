package com.example.selfpromoapp

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    private var contactNameEditText: TextInputEditText? = null
    private var contactNumberEditText: TextInputEditText? = null
    private var myDisplayNameEditText: TextInputEditText? = null
    private var includeJuniorCheckBox: CheckBox? = null
    private var startDateEditText: TextInputEditText? = null
    private var immediateStartCheckBox: CheckBox? = null
    private var jobTitleSpinner: Spinner? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        contactNameEditText = findViewById(R.id.edit_text_contact_name)
        contactNumberEditText = findViewById(R.id.edit_text_contact_number)
        myDisplayNameEditText = findViewById(R.id.edit_text_contact_my_display_name)
        includeJuniorCheckBox = findViewById(R.id.check_box_junior)
        startDateEditText = findViewById(R.id.edit_text_start_date)
        immediateStartCheckBox = findViewById(R.id.check_box_immediate_start)
        jobTitleSpinner = findViewById(R.id.spinner_job_title)


        val previewButton: Button = findViewById(R.id.button_preview_mesage)
        previewButton.setOnClickListener {
            onPreviewClicked()
        }
    }

    private fun onPreviewClicked() {
        val testString = contactNameEditText!!.text.toString()+ ", "+ contactNumberEditText!!.text.toString()
        Log.e("MainActivity", "Preview button clicked: $testString")
        Toast.makeText(this, testString, Toast.LENGTH_LONG).show()

    }

}