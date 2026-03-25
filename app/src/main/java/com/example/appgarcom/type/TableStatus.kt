package com.example.appgarcom.type

import com.example.appgarcom.R

enum class TableStatus(val resId: Int) {
    AVAILABLE(R.string.text_table_status_available),
    OCCUPIED(R.string.text_table_status_occupied),
    RESERVED(R.string.text_table_status_reserved),
    PENDING(R.string.text_table_status_pending),
}

