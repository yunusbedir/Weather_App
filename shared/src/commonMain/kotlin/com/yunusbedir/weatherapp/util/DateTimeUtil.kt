package com.yunusbedir.weatherapp.util

import kotlinx.datetime.*

object DateTimeUtil {

    fun now(): LocalDateTime {
        return Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())
    }

    fun toEpocMillis(dateTime: LocalDateTime): Long {
        return dateTime.toInstant(TimeZone.currentSystemDefault()).toEpochMilliseconds()
    }

    fun toLocalDateTime(time: Long): LocalDateTime {
        return Instant
            .fromEpochMilliseconds(time)
            .toLocalDateTime(TimeZone.currentSystemDefault())
    }


    /** "2023-05-01 21:00:00" **/
    fun formatUiForecast(dateText: String): String {
        val date = dateText.split(" ")[0]
        val day = date.split("-").last()
        val time = dateText.split(" ")[1]
        val hourAndMinute = time.split(":")[0] + ":" + time.split(":")[1]
        return buildString {
            appendLine(day)
            append(hourAndMinute)
        }

    }

    fun formatUiForecast(dateTime: LocalDateTime): String {
        val day = if (dateTime.dayOfMonth < 10) {
            "0${dateTime.dayOfMonth}"
        } else {
            dateTime.dayOfMonth
        }
        val hour = if (dateTime.hour < 10) {
            "0${dateTime.hour}"
        } else {
            dateTime.hour
        }
        val minute = if (dateTime.minute < 10) {
            "0${dateTime.minute}"
        } else {
            dateTime.minute
        }

        return buildString {
            appendLine(day)
            append(hour)
            append(":")
            append(minute)
        }
    }
}