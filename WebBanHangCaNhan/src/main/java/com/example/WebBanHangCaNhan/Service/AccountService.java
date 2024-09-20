package com.example.WebBanHangCaNhan.Service;

import com.example.WebBanHangCaNhan.Model.Accounts;
import com.example.WebBanHangCaNhan.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;
    public Accounts findById(String id) {
        return accountRepository.findById(id).orElseThrow();
    }
}
