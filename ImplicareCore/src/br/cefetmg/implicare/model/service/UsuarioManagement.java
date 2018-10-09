/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.implicare.model.service;

import br.cefetmg.implicare.model.domain.Usuario;
import br.cefetmg.implicare.model.exception.BusinessException;
import br.cefetmg.implicare.model.exception.PersistenceException;

/**
 *
 * @author Gabriel
 * 
 */

public interface UsuarioManagement {
    public void insert(Usuario Usuario) throws BusinessException, PersistenceException;
    public boolean update(long CPF_CNPJ, Usuario Usuario) throws BusinessException, PersistenceException;
    public boolean delete(long CPF_CNPJ) throws BusinessException, PersistenceException;
    public Usuario pesquisar(long CPF_CNPJ) throws PersistenceException;
    public Usuario login(long CPF_CNPJ, String Senha) throws PersistenceException;
}
