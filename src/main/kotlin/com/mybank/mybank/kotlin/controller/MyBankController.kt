package com.mybank.mybank.kotlin.controller

import com.mybank.mybank.kotlin.model.Bank
import com.mybank.mybank.kotlin.model.BankRequestDto
import com.mybank.mybank.kotlin.model.BankResponseDto
import com.mybank.mybank.kotlin.service.MyBankService
import org.springframework.http.HttpStatus.CREATED
import org.springframework.http.HttpStatus.OK
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/banks")
class MyBankController(private val myBankService: MyBankService) {

    @GetMapping("/", produces = ["application/json"])
    fun getBanks(): ResponseEntity<Collection<Bank>> {
        val banks: Collection<Bank> = myBankService.getBanks()
        return ResponseEntity(banks, OK)
    }

    @GetMapping("/{accountNumber}", produces = ["application/json"])
    fun getAccountByAccountNumber(@PathVariable accountNumber: String): ResponseEntity<Bank> {
        val bank = myBankService.getBankByAccountNumber(accountNumber)
        return ResponseEntity(bank, OK)
    }

    @PostMapping("/new-bank", produces =["application/json"],consumes = ["application/json"])
    fun createBank(@RequestBody bankRequestDto: BankRequestDto):ResponseEntity<BankResponseDto>{
        val bankResponseDto = myBankService.createBank(bankRequestDto)
        return ResponseEntity(bankResponseDto,CREATED)
    }

    @DeleteMapping("/delete/{accountNumber}")
    fun deleteByAccountNumber(@PathVariable accountNumber:String):ResponseEntity<String>{
        val isDeleted = myBankService.delete(accountNumber)
        return ResponseEntity("Deleted",OK)
    }
}