package com.moduscreate.bankaccount;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

// Entidade JPA
// PanacheEntityBase vem do Quarkus
// Os atributos são públicos porque o Panache
// a classe entidade tem os métodos de manipulação 
// no banco de dados, isso dispensa um DAO ou repository
// 
@Entity
@Table(name = "transactions")
public class Transaction extends PanacheEntityBase {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    public String id;

    @Column(name = "account_id")
    public String accountId;

    @Column
    public String description;

    @Column @Enumerated(EnumType.STRING)
    public TransactionType type;

    @Column
    public double value;

}
