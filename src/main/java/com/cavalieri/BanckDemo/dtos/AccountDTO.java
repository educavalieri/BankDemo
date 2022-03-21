package com.cavalieri.BanckDemo.dtos;

import com.cavalieri.BanckDemo.entities.Account;
import com.cavalieri.BanckDemo.entities.Client;
import com.cavalieri.BanckDemo.enumms.AccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountDTO implements Serializable {

    private AccountType accountType;
    private Integer totalAccount;
    private Integer savingsAccount;

    private List<ClientDTO> clients = new ArrayList<>();

//    private AccountDTO(){
//
//    }
//
//    public AccountDTO(AccountType accountType, Integer totalAccount, Integer savingsAccount, List<ClientDTO> clients) {
//        this.accountType = accountType;
//        this.totalAccount = totalAccount;
//        this.savingsAccount = savingsAccount;
//        this.clients = clients;
//    }
//
//    public AccountDTO(Account entity) {
//        accountType = entity.getAccountType();
//        totalAccount = entity.getTotalAccount();
//        savingsAccount = entity.getSavingsAccount();
//
//    }
//    public AccountDTO(Account entity, List<Client> clients) {
//        accountType = entity.getAccountType();
//        totalAccount = entity.getTotalAccount();
//        savingsAccount = entity.getSavingsAccount();
//        clients.forEach(x -> this.clients.add(new ClientDTO(x)));
//    }
//
//    public AccountType getAccountType() {
//        return accountType;
//    }
//
//    public void setAccountType(AccountType accountType) {
//        this.accountType = accountType;
//    }
//
//    public Integer getTotalAccount() {
//        return totalAccount;
//    }
//
//    public void setTotalAccount(Integer total_Account) {
//        this.totalAccount = total_Account;
//    }
//
//    public Integer getSavingsAccount() {
//        return savingsAccount;
//    }
//
//    public void setSavingsAccount(Integer savings_Account) {
//        this.savingsAccount = savings_Account;
//    }
//
//    public List<ClientDTO> getClients() {
//        return clients;
//    }
//
//    public void setClients(List<ClientDTO> clients) {
//        this.clients = clients;
//    }
}
