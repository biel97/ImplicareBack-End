/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.implicare.dao;

import br.cefetmg.implicare.model.domain.ExperienciaProfissional;
import br.cefetmg.implicare.model.exception.PersistenceException;
import java.util.ArrayList;

/**
 *
 * @author Gabriel
 * 
 */

public interface ExperienciaProfissionalDao {
    public void insert(ExperienciaProfissional ExperienciaProfissional) throws PersistenceException;
    public boolean update(long CPF, int Seq_Experiencia, int Cod_Cargo, ExperienciaProfissional ExperienciaProfssional) throws PersistenceException;
    public boolean delete(long CPF, int Seq_Experiencia, int Cod_Cargo) throws PersistenceException;
    public ArrayList<ExperienciaProfissional> listar(long CPF) throws PersistenceException;
    public ExperienciaProfissional pesquisar(long CPF, int Seq_Experiencia, int Cod_Cargo) throws PersistenceException;
}
