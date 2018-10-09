/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.implicare.model.serviceImpl;

import br.cefetmg.implicare.dao.VagaDao;
import br.cefetmg.implicare.model.daoImpl.VagaDaoImpl;
import br.cefetmg.implicare.model.domain.Vaga;
import br.cefetmg.implicare.model.exception.BusinessException;
import br.cefetmg.implicare.model.exception.PersistenceException;
import br.cefetmg.implicare.model.service.VagaManagement;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author Gabriel
 */
public class VagaManagementImpl implements VagaManagement {
    private final VagaDao VagaDao;
    
    public VagaManagementImpl(){
        VagaDao = new VagaDaoImpl();
    }

    @Override
    public void insert(Vaga Vaga) throws BusinessException, PersistenceException {
        VagaDao.insert(Vaga);
    }

    @Override
    public boolean update(long CNPJ, int Cod_Cargo, Date Dat_Publicacao, Vaga Vaga) throws BusinessException, PersistenceException {
        boolean result = VagaDao.update(CNPJ, Cod_Cargo, Dat_Publicacao, Vaga);
        return result;
    }

    @Override
    public boolean delete(long CNPJ, int Cod_Cargo, Date Dat_Publicacao) throws PersistenceException {
        boolean result = VagaDao.delete(CNPJ, Cod_Cargo, Dat_Publicacao);
        return result;
    }

    @Override
    public ArrayList<Vaga> listarVagaEmpresa(long CNPJ) throws PersistenceException {
        ArrayList<Vaga> result = VagaDao.listarVagaEmpresa(CNPJ);
        return result;
    }

    @Override
    public ArrayList<Vaga> listarVagaCandidato(long CPF) throws PersistenceException {
        ArrayList<Vaga> result = VagaDao.listarVagaCandidato(CPF);
        return result;
    }

    @Override
    public Vaga pesquisar(long CNPJ, int Cod_Cargo, Date Dat_Publicacao) throws PersistenceException {
        Vaga result = VagaDao.pesquisar(CNPJ, Cod_Cargo, Dat_Publicacao);
        return result;
    }
    
}
