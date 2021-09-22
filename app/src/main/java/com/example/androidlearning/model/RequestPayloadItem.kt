package com.example.androidlearning.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class RequestPayloadItem(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    val captured_by: String,
    val captured_on: String,
    val consultation_uuid: Int,
    val daily_note: String,
    val department_uuid: String,
    val encounter_type_uuid: String,
    val encounter_uuid: Int,
    val facility_uuid: String,
    val is_apap: Boolean,
    val is_bipap: Boolean,
    val is_cpap: Boolean,
    val is_o2: Boolean,
    val is_o2_con: Boolean,
    val is_ventilator: Boolean,
    val note_status_uuid: Int,
    val note_type_uuid: Int,
    val patient_uuid: Int,
    val progressnote_type_uuid: Int,
    val special_note: String
)