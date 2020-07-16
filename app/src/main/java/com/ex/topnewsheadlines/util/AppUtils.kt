package com.ex.topnewsheadlines.util

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

object AppUtils {

    fun getDate(dateString: String?): String? {
        return try {
            val format1 = SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss'Z'")
            val date: Date = format1.parse(dateString)
            val sdf: DateFormat = SimpleDateFormat("MMM d, yyyy")
            sdf.format(date)
        } catch (ex: Exception) {
            ex.printStackTrace()
            "xx"
        }
    }

    fun getTime(dateString: String?): String? {
        return try {
            val format1 = SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss'Z'")
            val date: Date = format1.parse(dateString)
            val sdf: DateFormat = SimpleDateFormat("h:mm a")
            val netDate: Date = date
            sdf.format(netDate)
        } catch (ex: Exception) {
            ex.printStackTrace()
            "xx"
        }
    }

}