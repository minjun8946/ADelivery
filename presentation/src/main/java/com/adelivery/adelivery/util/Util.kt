package com.adelivery.adelivery.util

fun day(date:String): String = date.substring(0..9)

fun time(date: String): String = date.substring(11..15)


fun locationName(name: String): String{
    val reName = name.replace("\t,\n","")
    return reName.replace(" ","")
}