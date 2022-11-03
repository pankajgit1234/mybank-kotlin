package com.mybank.mybank.kotlin

fun main(){
    val list = mutableListOf<Int>(1,2,3,4,5,6,1)
    val map = list.associateBy { it }
    map.forEach { println(it) }
}