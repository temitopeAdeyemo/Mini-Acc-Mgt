package com.example.javalvl2.repository;

import com.example.javalvl2.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long > {

}
