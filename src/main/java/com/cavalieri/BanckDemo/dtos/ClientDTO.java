package com.cavalieri.BanckDemo.dtos;

import com.cavalieri.BanckDemo.entities.Account;
import com.cavalieri.BanckDemo.enumms.Titular;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientDTO implements Serializable {

    private Titular titular;
    private String name;
    private String lastName;
    private String document;
    private String accountNumber;

//    private ClientDTO(){
//
//    }
//
//    public ClientDTO(Titular titular, String name, String last_Name, String document, AccountDTO account) {
//        this.titular = titular;
//        this.name = name;
//        this.last_Name = last_Name;
//        this.document = document;
//        this.account = account;
//    }
//
//    public ClientDTO(Client entity) {
//        titular = entity.getTitular();
//        name = entity.getName();
//        last_Name = entity.getLast_Name();
//        document = entity.getDocument();
////        account = new AccountDTO(entity.getAccount());
//    }
//
//    public Titular getTitular() {
//        return titular;
//    }
//
//    public void setTitular(Titular titular) {
//        this.titular = titular;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getLast_Name() {
//        return last_Name;
//    }
//
//    public void setLast_Name(String last_Name) {
//        this.last_Name = last_Name;
//    }
//
//    public String getDocument() {
//        return document;
//    }
//
//    public void setDocument(String document) {
//        this.document = document;
//    }
//
//    public AccountDTO getAccount() {
//        return account;
//    }
//
//    public void setAccount(AccountDTO account) {
//        this.account = account;
//    }
}
