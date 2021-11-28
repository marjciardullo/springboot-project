package com.model;

//import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
//import org.yaml.snakeyaml.events.Event.ID;

public class Filmes {
    private String TITULO, GENEROFILME, DIRETOR, SINOPSE;
    private int BIRTHYEAR, IDFILME;

    public Filmes() {
    }

    public Filmes(String TITULO, String GENEROFILME, String DIRETOR, String IMAGEM_LINK, String SINOPSE, int BIRTHYEAR,
            int IDFILME) {
        this.TITULO = TITULO;
        this.GENEROFILME = GENEROFILME;
        this.DIRETOR = DIRETOR;
        this.SINOPSE = SINOPSE;
        this.BIRTHYEAR = BIRTHYEAR;
        this.IDFILME = IDFILME;
    }

    public String getTITULO() {
        return TITULO;
    }

    public void setTITULO(String TITULO) {
        this.TITULO = TITULO;
    }

    public String getGENEROFILME() {
        return GENEROFILME;
    }

    public void setGENEROFILME(String GENEROFILME) {
        this.GENEROFILME = GENEROFILME;
    }

    public String getDIRETOR() {
        return DIRETOR;
    }

    public void setDIRETOR(String DIRETOR) {
        this.DIRETOR = DIRETOR;
    }

    public String getSINOPSE() {
        return SINOPSE;
    }

    public void setSINOPSE(String SINOPSE) {
        this.SINOPSE = SINOPSE;
    }

    public int getBIRTHYEAR() {
        return BIRTHYEAR;
    }

    public void setBIRTHYEAR(int BIRTHYEAR) {
        this.BIRTHYEAR = BIRTHYEAR;
    }

    public int getIDFILME() {
        return IDFILME;
    }

    public void setIDFILME(int IDFILME) {
        this.IDFILME = IDFILME;
    }
}
