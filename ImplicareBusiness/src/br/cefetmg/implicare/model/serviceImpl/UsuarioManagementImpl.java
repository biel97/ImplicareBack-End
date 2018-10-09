/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.implicare.model.serviceImpl;

import br.cefetmg.implicare.dao.UsuarioDao;
import br.cefetmg.implicare.model.daoImpl.UsuarioDaoImpl;
import br.cefetmg.implicare.model.domain.Usuario;
import br.cefetmg.implicare.model.exception.BusinessException;
import br.cefetmg.implicare.model.exception.PersistenceException;
import br.cefetmg.implicare.model.service.UsuarioManagement;

/**
 *
 * @author Gabriel
 * 
 */

public class UsuarioManagementImpl implements UsuarioManagement {
    private final UsuarioDao UsuarioDao;
    
    public UsuarioManagementImpl(){
        UsuarioDao = new UsuarioDaoImpl();
    }
    
    @Override
    public void insert(Usuario Usuario) throws BusinessException, PersistenceException {
        UsuarioDao.insert(Usuario);
    }

    @Override
    public boolean update(long CPF_CNPJ, Usuario Usuario) throws BusinessException, PersistenceException {
        boolean result = UsuarioDao.update(CPF_CNPJ, Usuario);
        return result;
    }
    
    @Override
    public boolean delete(long CPF_CNPJ) throws BusinessException, PersistenceException {
        boolean result = UsuarioDao.delete(CPF_CNPJ);
        return result;
    }
    
    @Override
    public Usuario pesquisar(long CPF_CNPJ) throws PersistenceException {
        Usuario result = UsuarioDao.pesquisar(CPF_CNPJ);
        return result;
    }
    
    @Override
    public Usuario login(long CPF_CNPJ, String Senha) throws PersistenceException{
        Usuario result = UsuarioDao.login(CPF_CNPJ, Senha);
        return result;
    }
}
