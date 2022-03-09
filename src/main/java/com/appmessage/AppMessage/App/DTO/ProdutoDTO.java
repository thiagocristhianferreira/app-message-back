package com.appmessage.AppMessage.App.DTO;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "produtos")
public class ProdutoDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Column(nullable = false, length = 100)
    public String nome;

    @Column(nullable = false, length = 50)
    public String categoria;

    @Column(nullable = false)
    public long estoque;
}
