package com.cavalieri.BanckDemo.entities;

import com.cavalieri.BanckDemo.enumms.AccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tb_account")
public class Account {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(value = EnumType.STRING)
    private AccountType accountType;
    private Integer totalAccount;
    private Integer savingsAccount;

    @OneToMany(mappedBy = "account")
    private List<Client> clients = new ArrayList<>();

//    Removing all to use Lombok
//    public Account(){
//
//    }
//
//    public Account(Long id, AccountType accountType, Integer totalAccount, Integer savingsAccount, List<Client> clients) {
//        this.id = id;
//        this.accountType = accountType;
//        this.totalAccount = totalAccount;
//        this.savingsAccount = savingsAccount;
//        this.clients = clients;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
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
//    public void setSavingsAccount(Integer savingsAccount) {
//        this.savingsAccount = savingsAccount;
//    }
//
//    public List<Client> getClients() {
//        return clients;
//    }
//
//    public void setClients(List<Client> clients) {
//        this.clients = clients;
//    }
}
