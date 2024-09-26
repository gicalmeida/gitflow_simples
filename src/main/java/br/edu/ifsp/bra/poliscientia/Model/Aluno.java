package br.edu.ifsp.bra.poliscientia.Model;

import java.util.ArrayList;

public class Aluno {
    private String nome;
    private int idade;
    private String email_aluno;
    private String escola;
    private String senha;
    private int id_aluno;

    public Aluno(String nome, int idade, String email_aluno, String escola, int id_aluno) {
        this.nome = nome;
        this.idade = idade;
        this.email_aluno = email_aluno;
        this.escola = escola;
        this.id_aluno = id_aluno;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEmail_aluno() {
        return email_aluno;
    }

    public void setEmail_aluno(String email_aluno) {
        this.email_aluno = email_aluno;
    }

    public String getEscola() {
        return escola;
    }

    public void setEscola(String escola) {
        this.escola = escola;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getId_aluno() {
        return id_aluno;
    }

    public void setId_aluno(int id_aluno) {
        this.id_aluno = id_aluno;
    }

    

    
}
