package br.edu.ifsp.bra.poliscientia.Model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_professor;

    private String nome_professor;
    private String email_professor;
    private int idade;
    private String escola;
    
    @OneToMany(mappedBy = "professor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SalaVirtual> sala;

    Professor(){
    }
    
    public Professor(int id_professor, String nome_professor, String email_professor, int idade, String escola) {
        this.id_professor = id_professor;
        this.nome_professor = nome_professor;
        this.email_professor = email_professor;
        this.idade = idade;
        this.escola = escola;
    }

    public String getNome_professor() {
        return nome_professor;
    }

    public void setNome_professor(String nome_professor) {
        this.nome_professor = nome_professor;
    }

    public String getEmail_professor() {
        return email_professor;
    }

    public void setEmail_professor(String email_professor) {
        this.email_professor = email_professor;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEscola() {
        return escola;
    }

    public void setEscola(String escola) {
        this.escola = escola;
    }

    public int getId_professor() {
        return id_professor;
    }
    
    public void setId_professor(int id_professor) {
        this.id_professor = id_professor;
    }

    public List<SalaVirtual> getSala() {
        return sala;
    }

    public void setSala(List<SalaVirtual> sala) {
        this.sala = sala;
    }

    
}
