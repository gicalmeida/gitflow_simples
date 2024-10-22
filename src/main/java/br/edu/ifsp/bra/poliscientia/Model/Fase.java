package br.edu.ifsp.bra.poliscientia.Model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Fase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_fase;

    private String instrucoes;
    private Date horarioDeInicio;
    private Date horarioDeTermino;

    public Fase(){
    }

    public Fase(int id_fase, String instrucoes, Date horarioDeInicio, Date horarioDeTermino) {
        this.id_fase = id_fase;
        this.instrucoes = instrucoes;
        this.horarioDeInicio = horarioDeInicio;
        this.horarioDeTermino = horarioDeTermino;
    }

    public int getId_fase() {
        return id_fase;
    }

    public void setId_fase(int id_fase) {
        this.id_fase = id_fase;
    }

    public String getInstrucoes() {
        return instrucoes;
    }

    public void setInstrucoes(String instrucoes) {
        this.instrucoes = instrucoes;
    }

    public Date getHorarioDeInicio() {
        return horarioDeInicio;
    }

    public void setHorarioDeInicio(Date horarioDeInicio) {
        this.horarioDeInicio = horarioDeInicio;
    }

    public Date getHorarioDeTermino() {
        return horarioDeTermino;
    }

    public void setHorarioDeTermino(Date horarioDeTermino) {
        this.horarioDeTermino = horarioDeTermino;
    }

}
