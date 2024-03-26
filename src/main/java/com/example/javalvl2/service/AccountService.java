package com.example.javalvl2.service;

import com.example.javalvl2.dto.AccountDto;
import java.util.List;

public interface AccountService {
    AccountDto createAccount(AccountDto account);

    AccountDto getAccountById(Long id);

    AccountDto deposit(Long id, double amount);

    AccountDto withdraw(Long id, double amount);

    List<AccountDto> getAccounts();

    AccountDto deleteAccount(Long id);
}
