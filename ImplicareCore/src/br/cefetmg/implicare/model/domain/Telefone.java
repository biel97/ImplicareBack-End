/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.implicare.model.domain;

/**
 *
 * @author Gabriel
 * 
 */

public class Telefone {
    private long CPF_CNPJ;
    private String Num_Telefone;
    private String Tipo_Telefone;
    private int DDD;
    private int Ramal;
    
    public Telefone(){}
    
    public Telefone(long CPF_CNPJ, String Num_Telefone, String Tipo_Telefone, int DDD, int Ramal){
        this.CPF_CNPJ = CPF_CNPJ;
        this.Num_Telefone = Num_Telefone;
        this.Tipo_Telefone = Tipo_Telefone;
        this.DDD = DDD;
        this.Ramal = Ramal;
    }

    public long getCPF_CNPJ() {
        return CPF_CNPJ;
    }

    public void setCPF_CNPJ(long CPF_CNPJ) {
        this.CPF_CNPJ = CPF_CNPJ;
    }

    public String getNum_Telefone() {
        return Num_Telefone;
    }

    public void setNum_Telefone(String Num_Telefone) {
        this.Num_Telefone = Num_Telefone;
    }

    public String getTipo_Telefone() {
        return Tipo_Telefone;
    }

    public void setTipo_Telefone(String Tipo_Telefone) {
        this.Tipo_Telefone = Tipo_Telefone;
    }

    public int getDDD() {
        return DDD;
    }

    public void setDDD(int DDD) {
        this.DDD = DDD;
    }

    public int getRamal() {
        return Ramal;
    }

    public void setRamal(int Ramal) {
        this.Ramal = Ramal;
    }
    
}
