package com.mybank.mybank.kotlin.model

data class BankRequestDto(val bankName: String, val accountNumber: String, val transactionCharge: Double) {
}