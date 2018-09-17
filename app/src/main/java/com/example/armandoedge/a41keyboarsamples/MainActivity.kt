package com.example.armandoedge.a41keyboarsamples

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import android.widget.AdapterView
import android.widget.TextView
import android.widget.EditText
import android.widget.ArrayAdapter
import android.widget.Spinner


class MainActivity : AppCompatActivity(),AdapterView.OnItemSelectedListener {
    // Define mSpinnerLabel for the label (the spinner item that the user chooses).
    private var mSpinnerLabel = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Create the spinner.
        val spinner = findViewById<View>(R.id.label_spinner) as Spinner
        if (spinner != null) {
            spinner!!.setOnItemSelectedListener(this)
        }

        // Create ArrayAdapter using the string array and default spinner layout.
        val adapter = ArrayAdapter.createFromResource(this,R.array.labels_array, android.R.layout.simple_spinner_item)

        // Specify the layout to use when the list of choices appears.
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // Apply the adapter to the spinner.
        if (spinner != null) {
            spinner!!.setAdapter(adapter)
        }
    }
    fun showText(view: View) {
        val editText = findViewById<View>(R.id.editText_main) as EditText
        if (editText != null) {
            // Assign to showString both the entered string and mSpinnerLabel.
            val showString = editText!!.getText().toString() + " - " + mSpinnerLabel
            // Assign to phoneNumberResult the view for text_phonelabel to prepare to show it.
            val phoneNumberResult = findViewById<View>(R.id.text_phonelabel) as TextView
            // Show the showString in the phoneNumberResult.
            if (phoneNumberResult != null) phoneNumberResult!!.setText(showString)
        }
    }
    override fun onItemSelected(adapterView: AdapterView<*>, view: View, pos: Int, id: Long) {
        mSpinnerLabel = adapterView.getItemAtPosition(pos).toString()
        showText(view)
    }
    override fun onNothingSelected(adapterView: AdapterView<*>) {
        Log.d(TAG, getString(R.string.nothing_selected))
    }

    companion object {
        // Define TAG for logging.
        private val TAG = MainActivity::class.java.simpleName
    }
}