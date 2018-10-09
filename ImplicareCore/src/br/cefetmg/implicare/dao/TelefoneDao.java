/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.implicare.dao;

import br.cefetmg.implicare.model.domain.Telefone;
import br.cefetmg.implicare.model.exception.PersistenceException;
import java.util.ArrayList;

/**
 *
 * @author Gabriel
 * 
 */

public interface TelefoneDao {
    public void insert(Telefone Telefone) throws PersistenceException;
    public boolean update(long CPF_CNPJ, String Num_Telefone, Telefone Telefone) throws PersistenceException;
    public boolean delete(long CPF_CNPJ, String Num_Telefone) throws PersistenceException;
    public ArrayList<Telefone> listar(long CPF_CNPJ) throws PersistenceException;
    public Telefone pesquisar(long CPF_CNPJ, String Num_Telefone) throws PersistenceException;
}
