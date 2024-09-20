package br.edu.ifsp.bra.poliscientia.Model;

public class Professor {
    private String nome_professor;
    private String email_professor;
    private int idade;
    private String escola;
    private int id_professor;
    
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


}
