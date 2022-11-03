package com.mybank.mybank.kotlin.datasource

import com.mybank.mybank.kotlin.model.Bank

interface BankDataSource {
    fun retrieveBanks(): Collection<Bank>

    fun retrieveBankByAccountNumber(accountNumber: String): Bank

    fun saveBank(bank:Bank):Bank

    fun delete(accountNumber:String):Boolean
}