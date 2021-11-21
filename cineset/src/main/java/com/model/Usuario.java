package com.model;

//import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
//import org.yaml.snakeyaml.events.Event.ID;

public class Usuario {
    private String NOME, EMAIL;
    private int SENHA, ID;

    public Usuario() {
    }

    public Usuario(String NOME, String EMAIL, int SENHA, int ID) {
        this.NOME = NOME;
        this.EMAIL = EMAIL;
        this.SENHA = SENHA;
        this.ID = ID;
    }

    public String getNOME() {
        return NOME;
    }

    public void setNOME(String NOME) {
        this.NOME = NOME;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public int getSENHA() {
        return SENHA;
    }

    public void setSENHA(int SENHA) {
        this.SENHA = SENHA;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
