package com.cavalieri.BanckDemo.services;

import com.cavalieri.BanckDemo.dtos.AccountDTO;
import com.cavalieri.BanckDemo.entities.Account;
import com.cavalieri.BanckDemo.repositories.AccountRepository;
import com.cavalieri.BanckDemo.repositories.ClientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Transactional
    public List<AccountDTO> findAllService(){
        List<Account> entity = accountRepository.findAll();
        List<AccountDTO> dto = entity.stream().map(x -> modelMapper.map(x, AccountDTO.class)).collect(Collectors.toList());
        return dto;
    }

    @Transactional
    public AccountDTO findByIDService(Long id){
        Account entity = accountRepository.findById(id).get();
        AccountDTO dto = modelMapper.map(entity, AccountDTO.class);
        return dto;
    }

    @Transactional
    public AccountDTO withdraw(Long id, Integer draw){
        Account entity = accountRepository.findById(id).get();
        Integer total = entity.getTotalAccount();
        entity.setTotalAccount(total - draw);
        entity = accountRepository.save(entity);
        return modelMapper.map(entity, AccountDTO.class);

    }

    @Transactional
    public AccountDTO input(Long id, Integer input){
        Account entity = accountRepository.findById(id).get();
        Integer total = entity.getTotalAccount();
        entity.setTotalAccount(total + input);
        entity = accountRepository.save(entity);
        return modelMapper.map(entity, AccountDTO.class);

    }




}
