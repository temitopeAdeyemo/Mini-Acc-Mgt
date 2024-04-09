package com.example.javalvl2.entity.mapper;

import com.example.javalvl2.dto.AccountDto;
import com.example.javalvl2.entity.Account;

public class AccountMapper {
    public static Account mapToAccount(AccountDto accountDto){

        return new Account(
                accountDto.getId(),
                accountDto.getAccountHolderName(),
                accountDto.getEmail(),
                accountDto.getPhoneNumber(),
                accountDto.getBalance()
        );
    };

    public static AccountDto mapToAccountDto(Account account){

        return (AccountDto) new AccountDto(
                account.getId(),
                account.getAccountHolderName(),
                account.getEmail(),
                account.getPhoneNumber(),
                account.getBalance()
        );
    }
}
