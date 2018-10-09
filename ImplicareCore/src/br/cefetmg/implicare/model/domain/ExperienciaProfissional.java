/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.implicare.model.domain;

import java.sql.Date;

/**
 *
 * @author Gabriel
 * 
 */

public class ExperienciaProfissional {
    private long CPF;
    private int Seq_Experiencia;
    private String Nom_Empresa;
    private int Cod_Cargo;
    private long Cod_CEP;
    private Date Data_Inicio;
    private Date Data_Termino;
    private String Desc_Experiencia_Profissional;
    private long Cod_Cidade;
    private long Cod_Estado;

    public ExperienciaProfissional(){}
    
    public ExperienciaProfissional(long CPF, int Seq_Experiencia, String Nom_Empresa, int Cod_Cargo, long Cod_Cep, Date Data_Inicio, Date Data_Termino, String Desc_Experiencia_Profissional, long Cod_Cidade, long Cod_Estado){
        this.CPF = CPF;
        this.Seq_Experiencia=Seq_Experiencia;
        this.Nom_Empresa = Nom_Empresa;
        this.Cod_Cargo= Cod_Cargo;
        this.Data_Inicio = Data_Inicio;
        this.Data_Termino = Data_Termino;
        this.Desc_Experiencia_Profissional = Desc_Experiencia_Profissional;
        this.Cod_Cidade = Cod_Cidade;
        this.Cod_Estado = Cod_Estado;
    }
    
    public long getCPF() {
        return CPF;
    }

    public void setCPF(long CPF) {
        this.CPF = CPF;
    }
    
    public int getSeq_Experiencia() {
        return Seq_Experiencia;
    }

    public void setSeq_Experiencia(int Seq_Experiencia) {
        this.Seq_Experiencia = Seq_Experiencia;
    }
    
    public String getNom_Empresa() {
        return Nom_Empresa;
    }

    public void setNom_Empresa(String Nom_Empresa) {
        this.Nom_Empresa = Nom_Empresa;
    }

    public int getCod_Cargo() {
        return Cod_Cargo;
    }

    public void setCod_Cargo(int Cod_Cargo) {
        this.Cod_Cargo = Cod_Cargo;
    }

    public long getCod_CEP() {
        return Cod_CEP;
    }

    public void setCod_CEP(long Cod_CEP) {
        this.Cod_CEP = Cod_CEP;
    }

    public Date getData_Inicio() {
        return Data_Inicio;
    }

    public void setData_Inicio(Date Data_Inicio) {
        this.Data_Inicio = Data_Inicio;
    }

    public Date getData_Termino() {
        return Data_Termino;
    }

    public void setData_Termino(Date Data_Termino) {
        this.Data_Termino = Data_Termino;
    }

    public String getDesc_Experiencia_Profissional() {
        return Desc_Experiencia_Profissional;
    }

    public void setDesc_Experiencia_Profissional(String Desc_Experiencia_Profissional) {
        this.Desc_Experiencia_Profissional = Desc_Experiencia_Profissional;
    }

    public long getCod_Cidade() {
        return Cod_Cidade;
    }

    public void setCod_Cidade(long Cod_Cidade) {
        this.Cod_Cidade = Cod_Cidade;
    }

    public long getCod_Estado() {
        return Cod_Estado;
    }

    public void setCod_Estado(long Cod_Estado) {
        this.Cod_Estado = Cod_Estado;
    }
    
}
