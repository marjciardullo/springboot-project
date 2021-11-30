package com.model;

public class FilmeDTO {
    private String TITULO, BIRTHYEAR, SINOPSE;

    private int IDFILME, IDDIRETOR;

    public FilmeDTO() {
    }

    public FilmeDTO(int IDFILME, String TITULO, int IDDIRETOR, String BIRTHYEAR, String SINOPSE) {
        this.TITULO = TITULO;
        this.IDDIRETOR = IDDIRETOR;
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

    public int getIDDIRETOR() {
        return IDDIRETOR;
    }

    public void setIDDIRETOR(int IDDIRETOR) {
        this.IDDIRETOR = IDDIRETOR;
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
