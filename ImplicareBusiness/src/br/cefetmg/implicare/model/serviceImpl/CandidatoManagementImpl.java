/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.implicare.model.serviceImpl;

import br.cefetmg.implicare.model.daoImpl.CandidatoDaoImpl;
import br.cefetmg.implicare.model.domain.Candidato;
import br.cefetmg.implicare.model.exception.BusinessException;
import br.cefetmg.implicare.model.exception.PersistenceException;
import br.cefetmg.implicare.dao.CandidatoDao;
import br.cefetmg.implicare.model.service.CandidatoManagement;

/**
 *
 * @author Gabriel
 * 
 */

public class CandidatoManagementImpl implements CandidatoManagement {
    private final CandidatoDao PessoaFisicaDao;
    
    public CandidatoManagementImpl(){
        PessoaFisicaDao = new CandidatoDaoImpl(); 
    }
    
    @Override
    public void insert(Candidato Candidato) throws BusinessException, PersistenceException {
        PessoaFisicaDao.insert(Candidato);
    }

    @Override
    public boolean update(long CPF, Candidato Candidato) throws BusinessException, PersistenceException {
        boolean result = PessoaFisicaDao.update(CPF, Candidato);
        return result;
    }

    @Override
    public Candidato pesquisar(long CPF) throws PersistenceException {
        Candidato result = PessoaFisicaDao.pesquisar(CPF);
        return result;
    }
    
}
