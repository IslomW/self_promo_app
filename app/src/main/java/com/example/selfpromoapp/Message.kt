package com.example.selfpromoapp

import java.io.Serializable

data class Message(
    val contactName: String, val contactNumber: String,
    val displayName: String, val includeJunior: Boolean,
    val jobTitle: String?, val immediateStart: Boolean,
    val startDate: String?
) : Serializable {

    fun getFullJobDescription(): String {
        return if (includeJunior) {
            "a Junior $jobTitle"
        } else {
            "an $jobTitle"
        }
    }

    fun getAvailability() = if (immediateStart) "immediately" else "from $startDate"

}

