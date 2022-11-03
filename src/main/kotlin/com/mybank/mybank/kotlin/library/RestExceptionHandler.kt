package com.mybank.mybank.kotlin.library

import com.mybank.mybank.kotlin.exception.BadRequestException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class RestExceptionHandler:ResponseEntityExceptionHandler() {

    @ExceptionHandler(BadRequestException::class)
    fun handleBadRequestException(ex:BadRequestException):ResponseEntity<Any>{
     return ResponseEntity(ex.message,HttpStatus.BAD_REQUEST)
    }
}