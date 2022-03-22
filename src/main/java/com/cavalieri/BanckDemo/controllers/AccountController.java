package com.cavalieri.BanckDemo.controllers;

import com.cavalieri.BanckDemo.dtos.AccountDTO;
import com.cavalieri.BanckDemo.dtos.InputDTO;
import com.cavalieri.BanckDemo.dtos.WithdrawDTO;
import com.cavalieri.BanckDemo.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping
    public ResponseEntity<List<AccountDTO>> findAll(){
        List<AccountDTO> dto = accountService.findAllService();
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<AccountDTO> findByID(@PathVariable("id") Long id){
        AccountDTO dto = accountService.findByIDService(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping(value = "/withdraw")
    public ResponseEntity<AccountDTO> withdraw(@RequestBody WithdrawDTO withdrawDTO){
        AccountDTO dto = accountService.withdraw(withdrawDTO.getId(), withdrawDTO.getDraw());
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping(value = "/input")
    public ResponseEntity<AccountDTO> input(@RequestBody InputDTO inputDTO){
        AccountDTO dto = accountService.input(inputDTO.getId(), inputDTO.getInput());
        return ResponseEntity.ok().body(dto);
    }

}
