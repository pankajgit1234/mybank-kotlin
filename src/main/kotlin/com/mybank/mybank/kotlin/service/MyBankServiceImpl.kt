package com.mybank.mybank.kotlin.service

import com.mybank.mybank.kotlin.datasource.BankDataSource
import com.mybank.mybank.kotlin.model.Bank
import com.mybank.mybank.kotlin.model.BankRequestDto
import com.mybank.mybank.kotlin.model.BankResponseDto
import org.springframework.stereotype.Service

@Service
class MyBankServiceImpl(private val bankDataSource: BankDataSource) : MyBankService {


    override fun getBanks(): Collection<Bank> {
        return bankDataSource.retrieveBanks()
    }

    override fun getBankByAccountNumber(accountNumber: String): Bank {
        return bankDataSource.retrieveBankByAccountNumber(accountNumber)
    }

    override fun createBank(bankRequestDto: BankRequestDto): BankResponseDto {
        val newBank = Bank(
            id = 0,
            bankName = bankRequestDto.bankName,
            accountNumber = bankRequestDto.accountNumber,
            transactionCharge = bankRequestDto.transactionCharge
        )
        val bank = bankDataSource.saveBank(newBank)
        return BankResponseDto(
            id = bank.id,
            bankName = bank.bankName,
            accountNumber = bank.accountNumber,
            transactionCharge = bank.transactionCharge

        )
    }

    override fun delete(accountNumber: String): Boolean {
        return bankDataSource.delete(accountNumber)
    }


}