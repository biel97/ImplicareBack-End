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

public class Empresa {
    private long CNPJ;
    private String Nom_Razao_Social;
    private String Nome_Fantasia;
    
    public Empresa(){}

    public Empresa(long CNPJ, String Nom_Razao_Social, String Nome_Fantasia){
        this.CNPJ = CNPJ;
        this.Nom_Razao_Social = Nom_Razao_Social;
        this.Nome_Fantasia = Nome_Fantasia;
    }
    
    public long getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(long CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getNom_Razao_Social() {
        return Nom_Razao_Social;
    }

    public void setNom_Razao_Social(String Nom_Razao_Social) {
        this.Nom_Razao_Social = Nom_Razao_Social;
    }

    public String getNome_Fantasia() {
        return Nome_Fantasia;
    }

    public void setNome_Fantasia(String Nome_Fantasia) {
        this.Nome_Fantasia = Nome_Fantasia;
    }
    
}
