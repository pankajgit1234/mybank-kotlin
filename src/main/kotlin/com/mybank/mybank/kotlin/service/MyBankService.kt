package com.mybank.mybank.kotlin.service

import com.mybank.mybank.kotlin.model.Bank
import com.mybank.mybank.kotlin.model.BankRequestDto
import com.mybank.mybank.kotlin.model.BankResponseDto

interface MyBankService {
    fun getBanks(): Collection<Bank>

    fun getBankByAccountNumber(accountNumber: String): Bank

    fun createBank(bankRequestDto: BankRequestDto):BankResponseDto

    fun delete(accountNumber: String):Boolean
}