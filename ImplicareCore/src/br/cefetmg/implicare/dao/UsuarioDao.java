/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.implicare.dao;

import br.cefetmg.implicare.model.domain.Usuario;
import br.cefetmg.implicare.model.exception.PersistenceException;

/**
 *
 * @author Gabriel
 * 
 */

public interface UsuarioDao {
    public boolean insert(Usuario Usuario) throws PersistenceException;
    public boolean update(Usuario Usuario) throws PersistenceException;
    public boolean delete(Usuario Usuario) throws PersistenceException;
    public Usuario pesquisar(long CPF_CNPJ) throws PersistenceException;
    public Usuario login(long CPF_CNPJ, String Senha) throws PersistenceException;
}
