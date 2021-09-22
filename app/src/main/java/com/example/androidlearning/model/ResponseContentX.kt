package com.example.androidlearning.model

data class ResponseContentX(
    val captured_by: String,
    val captured_on: String,
    val consultation_uuid: Int,
    val created_by: String,
    val created_date: String,
    val daily_note: String,
    val department_uuid: String,
    val encounter_type_uuid: String,
    val encounter_uuid: Int,
    val facility_uuid: String,
    val is_active: Boolean,
    val is_apap: Boolean,
    val is_bipap: Boolean,
    val is_cpap: Boolean,
    val is_o2: Boolean,
    val is_o2_con: Boolean,
    val is_ventilator: Boolean,
    val modified_by: String,
    val modified_date: String,
    val note_status_uuid: Int,
    val note_type_uuid: Int,
    val patient_uuid: Int,
    val revision: Int,
    val special_note: String,
    val status: Boolean,
    val uuid: Int
)