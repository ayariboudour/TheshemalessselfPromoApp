package com.example.selfpromoapp

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.Spinner
import com.google.android.material.textfield.TextInputEditText
import androidx.appcompat.app.AppCompatActivity

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

        val spinnerValue = arrayOf("Android Developer", "Android Engineer")
        val spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,spinnerValue)
        jobTitleSpinner?.adapter = spinnerAdapter


        val previewButton: Button = findViewById(R.id.button_preview_mesage)
        previewButton.setOnClickListener {
            onPreviewClicked()
        }
    }

    private fun onPreviewClicked() {
        val contactName = contactNameEditText?.text?.toString() ?: ""
        val contactNumber = contactNumberEditText?.text?.toString() ?: ""
        val myDisplayName = myDisplayNameEditText?.text?.toString() ?: ""
        val includeJunior = includeJuniorCheckBox?.isChecked ?: false
        val jobTitle = jobTitleSpinner?.selectedItem?.toString() ?: ""
        val immediateStart = immediateStartCheckBox?.isChecked ?: false
        val startDate = startDateEditText?.text?.toString() ?: ""

        val juniorString = if (includeJunior) "Junior " else ""
        val startString = if (immediateStart) "immediately" else "from $startDate"

        val message = "Hi $contactName, I'm $myDisplayName. I'm interested in the ${juniorString}${jobTitle} position. I can start $startString. You can reach me at $contactNumber."

        val previewActivityIntent = Intent(this, PreviewActivity::class.java)
        previewActivityIntent.putExtra("Message", message)
        startActivity(previewActivityIntent)
    }
}