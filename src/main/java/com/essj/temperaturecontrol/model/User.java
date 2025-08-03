package com.essj.temperaturecontrol.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_user")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String nome;
    private String password;
    private LocalDateTime cadastro = LocalDateTime.now();


    public User() {
    }

    public User(Long id, String email, String nome, String password, LocalDateTime cadastro) {
        this.id = id;
        this.email = email;
        this.nome = nome;
        this.password = password;
        this.cadastro = cadastro;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getCadastro() {
        return cadastro;
    }

    public void setCadastro(LocalDateTime cadastro) {
        this.cadastro = cadastro;
    }
}
