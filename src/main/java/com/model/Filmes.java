package com.model;

//import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
//import org.yaml.snakeyaml.events.Event.ID;

public class Filmes {
    private String TITULO, DIRETOR, BIRTHYEAR, SINOPSE;

    private int IDFILME;

    public Filmes() {
    }

    public Filmes(int IDFILME, String TITULO, String DIRETOR, String BIRTHYEAR, String SINOPSE) {
        this.TITULO = TITULO;
        this.DIRETOR = DIRETOR;
        this.BIRTHYEAR = BIRTHYEAR;
        this.IDFILME = IDFILME;
        this.SINOPSE = SINOPSE;
    }

    public String getTITULO() {
        return TITULO;
    }

    public void setTITULO(String TITULO) {
        this.TITULO = TITULO;
    }

    public String getDIRETOR() {
        return DIRETOR;
    }

    public void setDIRETOR(String DIRETOR) {
        this.DIRETOR = DIRETOR;
    }

    public String getBIRTHYEAR() {
        return BIRTHYEAR;
    }

    public void setBIRTHYEAR(String BIRTHYEAR) {
        this.BIRTHYEAR = BIRTHYEAR;
    }

    public String getSINOPSE() {
        return SINOPSE;
    }

    public void setSINOPSE(String SINOPSE) {
        this.SINOPSE = SINOPSE;
    }

    public int getIDFILME() {
        return IDFILME;
    }

    public void setIDFILME(int IDFILME) {
        this.IDFILME = IDFILME;
    }
}
