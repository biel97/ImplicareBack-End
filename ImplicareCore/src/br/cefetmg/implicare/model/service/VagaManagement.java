/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.implicare.model.service;

import br.cefetmg.implicare.model.domain.Vaga;
import br.cefetmg.implicare.model.exception.BusinessException;
import br.cefetmg.implicare.model.exception.PersistenceException;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author Gabriel
 * 
 */

public interface VagaManagement {
    public void insert(Vaga Vaga) throws BusinessException, PersistenceException;
    public boolean update(long CNPJ, int Cod_Cargo, Date Dat_Publicacao,Vaga Vaga) throws BusinessException, PersistenceException;
    public boolean delete(long CNPJ, int Cod_Cargo, Date Dat_Publicacao) throws PersistenceException;
    public ArrayList<Vaga> listarVagaEmpresa(long CNPJ) throws PersistenceException;
    public ArrayList<Vaga> listarVagaCandidato(long CPF) throws PersistenceException;
    public Vaga pesquisar(long CNPJ, int Cod_Cargo, Date Dat_Publicacao) throws PersistenceException;
}
