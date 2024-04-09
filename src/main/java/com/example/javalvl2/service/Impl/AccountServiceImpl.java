package com.example.javalvl2.service.Impl;

import com.example.javalvl2.dto.AccountDto;
import com.example.javalvl2.entity.Account;
import com.example.javalvl2.entity.mapper.AccountMapper;
import com.example.javalvl2.exception.ApiNotFoundException;
import com.example.javalvl2.exception.ApiRequestException;
import com.example.javalvl2.repository.AccountRepository;
import com.example.javalvl2.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account  = AccountMapper.mapToAccount(accountDto);

        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto getAccountById(Long id) {
        Account account = accountRepository.findById(id).orElseThrow(()-> new ApiNotFoundException("Account not found."));

        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto deposit(Long id, double amount) {
        Account account = accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account not found."));
        double total = account.getBalance() + amount;

        account.setBalance(total);

        Account savedAccount = accountRepository.save(account);


        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto withdraw(Long id, double amount) {
        Account account = accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account not found."));

        if(account.getBalance() < amount ) throw new RuntimeException("Insufficient Balance");

        double total = account.getBalance() - amount;

        account.setBalance(total);

        Account savedAccount = accountRepository.save(account);


        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public List<AccountDto> getAccounts() {
        List<Account> accounts = accountRepository.findAll();

        return accounts.stream().map((AccountMapper::mapToAccountDto)).collect(Collectors.toList());
    }


    @Override
    public AccountDto deleteAccount(Long id) {
        accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account not found."));

         accountRepository.deleteById(id);
        return null;
    }
}
