package com.model;

//import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
//import org.yaml.snakeyaml.events.Event.ID;

public class Filmes {
    private String TITULO, GENERO, DIRETOR, IMAGEM_LINK, SINOPSE;
    private int ANO, IDFILME;

    public Filmes() {
    }

    public Filmes(String TITULO, String GENERO, String DIRETOR, String IMAGEM_LINK, String SINOPSE, int ANO,
            int IDFILME) {
        this.TITULO = TITULO;
        this.GENERO = GENERO;
        this.DIRETOR = DIRETOR;
        this.IMAGEM_LINK = IMAGEM_LINK;
        this.SINOPSE = SINOPSE;
        this.ANO = ANO;
        this.IDFILME = IDFILME;
    }

    public String getTITULO() {
        return TITULO;
    }

    public void setTITULO(String TITULO) {
        this.TITULO = TITULO;
    }

    public String getGENERO() {
        return GENERO;
    }

    public void setGENERO(String GENERO) {
        this.GENERO = GENERO;
    }

    public String getDIRETOR() {
        return DIRETOR;
    }

    public void setDIRETOR(String DIRETOR) {
        this.DIRETOR = DIRETOR;
    }

    public String getIMAGEM_LINK() {
        return IMAGEM_LINK;
    }

    public void setIMAGEM_LINK(String IMAGEM_LINK) {
        this.IMAGEM_LINK = IMAGEM_LINK;
    }

    public String getSINOPSE() {
        return SINOPSE;
    }

    public void setSINOPSE(String SINOPSE) {
        this.SINOPSE = SINOPSE;
    }

    public int getANO() {
        return ANO;
    }

    public void setANO(int ANO) {
        this.ANO = ANO;
    }

    public int getIDFILME() {
        return IDFILME;
    }

    public void setIDFILME(int IDFILME) {
        this.IDFILME = IDFILME;
    }
}
