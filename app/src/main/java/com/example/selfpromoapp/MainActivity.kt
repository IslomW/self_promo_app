package com.example.selfpromoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import com.example.selfpromoapp.databinding.ActivityMainBinding
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
//
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.buttonPreviewMessage.setOnClickListener {
            onPreviewCicked()

        }

        val spinnerValues : Array<String> = arrayOf("Android Developer", "Back-end Developer", "Front-end Developer" )
        val spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, spinnerValues)
        binding.spinnerJobTitle.adapter = spinnerAdapter

    }

    private fun onPreviewCicked() {

        val message = Message(
            binding.editTextContactName.text.toString(),
            binding.editTextContactNumber.text.toString(),
            binding.editTextMyDisplayName.text.toString(),
            binding.checkboxJunior.isChecked,
            binding.spinnerJobTitle.selectedItem?.toString(),
            binding.checkboxImmediateStart.isChecked,
            binding.editTextDate.text.toString()
        )


        val previewActivityIntent = Intent(this, PreviewActivity::class.java);

        previewActivityIntent.putExtra("Message", message )




        startActivity(previewActivityIntent)
    }


}