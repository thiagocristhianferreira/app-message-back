package com.appmessage.AppMessage.App.DTO;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "usuarios")
public class UserRegistrationDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String senha;

}
