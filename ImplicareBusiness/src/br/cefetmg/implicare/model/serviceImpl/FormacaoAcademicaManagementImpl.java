/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.implicare.model.serviceImpl;

import br.cefetmg.implicare.dao.FormacaoAcademicaDao;
import br.cefetmg.implicare.model.daoImpl.FormacaoAcademicaDaoImpl;
import br.cefetmg.implicare.model.domain.FormacaoAcademica;
import br.cefetmg.implicare.model.exception.BusinessException;
import br.cefetmg.implicare.model.exception.PersistenceException;
import br.cefetmg.implicare.model.service.FormacaoAcademicaManagement;
import java.util.ArrayList;

/**
 *
 * @author Gabriel
 * 
 */

public class FormacaoAcademicaManagementImpl implements FormacaoAcademicaManagement {
    private final FormacaoAcademicaDao FormacaoAcademicaDao;
    
    public FormacaoAcademicaManagementImpl(){
        FormacaoAcademicaDao = new FormacaoAcademicaDaoImpl();
    }

    @Override
    public void insert(FormacaoAcademica FormacaoAcademica) throws BusinessException, PersistenceException {
        FormacaoAcademicaDao.insert(FormacaoAcademica);
    }

    @Override
    public boolean update(long CPF, int Seq_Formacao, int Cod_Area_Estudo, FormacaoAcademica FormacaoAcademica) throws BusinessException, PersistenceException {
        boolean result = FormacaoAcademicaDao.update(CPF, Seq_Formacao, Cod_Area_Estudo, FormacaoAcademica);
        return result;
    }

    @Override
    public boolean delete(long CPF, int Seq_Formacao, int Cod_Area_Estudo) throws PersistenceException {
        boolean result = FormacaoAcademicaDao.delete(CPF, Seq_Formacao, Cod_Area_Estudo);
        return result;
    }

    @Override
    public ArrayList<FormacaoAcademica> listar(long CPF) throws PersistenceException {
        ArrayList<FormacaoAcademica> result = FormacaoAcademicaDao.listar(CPF);
        return result;
    }

    @Override
    public FormacaoAcademica pesquisar(long CPF, int Seq_Formacao, int Cod_Area_Estudo) throws PersistenceException {
        FormacaoAcademica result = FormacaoAcademicaDao.pesquisar(CPF, Seq_Formacao, Cod_Area_Estudo);
        return result;
    }
    
}
