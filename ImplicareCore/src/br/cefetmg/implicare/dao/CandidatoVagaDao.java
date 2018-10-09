/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.implicare.dao;

import br.cefetmg.implicare.model.domain.CandidatoVaga;
import br.cefetmg.implicare.model.exception.PersistenceException;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author Gabriel
 * 
 */

public interface CandidatoVagaDao {
    public void insert(CandidatoVaga CandidatoVaga) throws PersistenceException;
    public boolean update(long CPF, int Cod_Cargo, long CNPJ, Date Dat_Publicacao, CandidatoVaga CandidatoVaga) throws PersistenceException;
    public ArrayList<CandidatoVaga> listar(int Cod_Cargo, long CNPJ, Date Dat_Publicacao) throws PersistenceException;
    public CandidatoVaga pesquisar(long CPF, int Cod_Cargo, long CNPJ, Date Dat_Publicacao) throws PersistenceException;
}
