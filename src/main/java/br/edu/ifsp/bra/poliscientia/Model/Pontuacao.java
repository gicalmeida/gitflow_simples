package br.edu.ifsp.bra.poliscientia.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pontuacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_pontuacao;

    private int questoesCertas;
    private int questoesErradas;

    public Pontuacao() {
    }

    public Pontuacao(int id_pontuacao, int questoesCertas, int questoesErradas) {
        this.id_pontuacao = id_pontuacao;
        this.questoesCertas = questoesCertas;
        this.questoesErradas = questoesErradas;
    }

    public int getId_pontuacao() {
        return id_pontuacao;
    }

    public void setId_pontuacao(int id_pontuacao) {
        this.id_pontuacao = id_pontuacao;
    }

    public int getQuestoesCertas() {
        return questoesCertas;
    }

    public void setQuestoesCertas(int questoesCertas) {
        this.questoesCertas = questoesCertas;
    }

    public int getQuestoesErradas() {
        return questoesErradas;
    }

    public void setQuestoesErradas(int questoesErradas) {
        this.questoesErradas = questoesErradas;
    }

}
