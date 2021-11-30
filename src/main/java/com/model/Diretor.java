package com.model;

public class Diretor {
    private String DIRETOR;
    private int IDDIRETOR;

    public Diretor() {
    }

    public Diretor(String DIRETOR, int IDDIRETOR) {
        this.DIRETOR = DIRETOR;
        this.IDDIRETOR = IDDIRETOR;
    }

    public String getDIRETOR() {
        return DIRETOR;
    }

    public void setDIRETOR(String DIRETOR) {
        this.DIRETOR = DIRETOR;
    }

    public int getIDDIRETOR() {
        return IDDIRETOR;
    }

    public void setIDDIRETOR(int IDDIRETOR) {
        this.IDDIRETOR = IDDIRETOR;
    }

}
