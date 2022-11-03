package com.mybank.mybank.kotlin.service

import com.mybank.mybank.kotlin.datasource.BankDataSource
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test

internal class MyBankServiceImplTest {


    private val bankDataSource: BankDataSource = mockk()
    private val myBankServiceImpl = MyBankServiceImpl(bankDataSource)

    @Test
    fun `should call its data source to retrieve banks`() {
        every { bankDataSource.retrieveBanks() } returns emptyList()
        val banks = myBankServiceImpl.getBanks()
        verify(exactly = 1) { bankDataSource.retrieveBanks() }
        assertNotNull(banks)
    }
}