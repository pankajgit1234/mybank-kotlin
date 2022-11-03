package com.mybank.mybank.kotlin.datasource

import com.mybank.mybank.kotlin.exception.BadRequestException
import com.mybank.mybank.kotlin.model.Bank
import org.springframework.stereotype.Repository

@Repository
class BankDataSourceImpl : BankDataSource {

    var banks = mutableListOf(
        Bank(1, "SBI", "abcd1", 100.23),
        Bank(2, "HDFC", "abcd2", 10.0),
        Bank(3, "Allica", "1234", 1.00)
    )

    override fun retrieveBanks(): Collection<Bank> {
        return banks
    }

    @Throws(BadRequestException::class)
    override fun retrieveBankByAccountNumber(accountNumber: String): Bank {
        return banks.find { bank -> accountNumber == bank.accountNumber }
            ?: throw BadRequestException("No account found for this account number")

    }

    override fun saveBank(bank: Bank): Bank {
        var id: Int
        banks.sortBy { it.id }
        val lastAddedBank = banks.last()
        id = lastAddedBank.id
        id += 1;
        val newBank = Bank(id, bank.bankName, bank.accountNumber, bank.transactionCharge)
        banks.add(newBank)
        return newBank
    }

    override fun delete(accountNumber:String):Boolean{
      val bank=  banks.find{bank->accountNumber==bank.accountNumber}?:throw BadRequestException("No account preset to delete")
        banks.remove(bank)
        return true
    }
}