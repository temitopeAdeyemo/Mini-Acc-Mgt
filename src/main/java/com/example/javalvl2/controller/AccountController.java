package com.example.javalvl2.controller;

import com.example.javalvl2.dto.AccountDto;
import com.example.javalvl2.dto.ApiResponse;
import com.example.javalvl2.service.AccountService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/account")
public class AccountController {
    private final AccountService accountService;

    @Autowired
    private AccountController(AccountService accountService/*, ApiResponse<AccountDto> apiResponse*/){
        this.accountService = accountService;
    }

    // Add account rest api
    @PostMapping(value = "/")
    public ResponseEntity<ApiResponse<AccountDto>> AddAccount(@RequestBody @Valid AccountDto accountDto) {
        ApiResponse<AccountDto> response;
        HttpStatus status;

        AccountDto account = accountService.createAccount(accountDto);
        status = HttpStatus.CREATED;
        response = new ApiResponse<>( "", account);

//      return ResponseEntity.ok(response1);

        return new ResponseEntity<>(response, status);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<AccountDto>> getAccountById(@PathVariable Long id){
        AccountDto account = accountService.getAccountById(id);

        ApiResponse<AccountDto> apiResponse = new ApiResponse<>("Fetched Successfully.", account);

        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PutMapping("/{id}/deposit")
    public ResponseEntity<ApiResponse<AccountDto>> deposit(@PathVariable Long id, @RequestBody Map<String, Double> request) {
        AccountDto account = accountService.deposit(id, request.get("amount"));

        ApiResponse<AccountDto> apiResponse = new ApiResponse<>("", account);

        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PutMapping("/{id}/withdraw")
    public ResponseEntity<ApiResponse<AccountDto>> withdraw(@PathVariable Long id, @RequestBody Map<String, Double> request) {
        AccountDto account = accountService.withdraw(id, request.get("amount"));

        ApiResponse<AccountDto> apiResponse = new ApiResponse<>("", account);

        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<AccountDto>> deleteAccount(@PathVariable Long id) {
        AccountDto account = accountService.deleteAccount(id);

        ApiResponse<AccountDto> apiResponse = new ApiResponse<>("", account);

        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<AccountDto>> allAccount() {
        List<AccountDto> accounts = accountService.getAccounts();

        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }
}
