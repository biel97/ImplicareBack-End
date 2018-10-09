/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.implicare.model.service;

import br.cefetmg.implicare.model.domain.Empresa;
import br.cefetmg.implicare.model.exception.BusinessException;
import br.cefetmg.implicare.model.exception.PersistenceException;

/**
 *
 * @author Gabriel
 * 
 */

public interface EmpresaManagement {
    public void insert(Empresa Empresa) throws BusinessException, PersistenceException;
    public boolean update(long CNPJ,Empresa Empresa) throws BusinessException, PersistenceException;
    public Empresa pesquisar(long CNPJ) throws PersistenceException;
}
