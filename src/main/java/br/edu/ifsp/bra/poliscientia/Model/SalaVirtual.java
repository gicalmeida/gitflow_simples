package br.edu.ifsp.bra.poliscientia.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class SalaVirtual {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_sala;

    private String nome;
    private String descricao;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "id_professor")
    private Professor professor;

    SalaVirtual(){
    }

    public SalaVirtual(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public int getId_sala() {
        return id_sala;
    }

    public void setId_sala(int id_sala) {
        this.id_sala = id_sala;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

}
