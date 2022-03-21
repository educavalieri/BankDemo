package com.cavalieri.BanckDemo.entities;

import com.cavalieri.BanckDemo.enumms.AccountType;
import com.cavalieri.BanckDemo.enumms.Titular;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tb_client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(value = EnumType.STRING)
    private Titular titular;
    private String name;
    private String lastName;
    private String document;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

// Removed to use lombok
//    public Client(){
//
//    }
//
//    public Client(Long id, Titular titular, String name, String lastName, String document, Account account) {
//        this.id = id;
//        this.titular = titular;
//        this.name = name;
//        this.lastName = lastName;
//        this.document = document;
//        this.account = account;
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
//        return lastName;
//    }
//
//    public void setLast_Name(String last_Name) {
//        this.lastName = last_Name;
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
//    public Account getAccount() {
//        return account;
//    }
//
//    public void setAccount(Account account) {
//        this.account = account;
//    }
}
