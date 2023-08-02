package com.casemodule.repository;

import com.casemodule.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IAccountRepo extends JpaRepository<Account, Integer> {
    @Query(nativeQuery = true, value = "SELECT * FROM Account where username= :username and password= :password")
    Account getAccountLogin(@Param("username") String username, @Param("password") String password);

    @Query(value = "SELECT a FROM Account a where a.username= :username and a.password= :password")
    Account getAccountLoginHQL(@Param("username") String username,@Param("password") String password);


    Account getAccountByUsername(String username);
}
