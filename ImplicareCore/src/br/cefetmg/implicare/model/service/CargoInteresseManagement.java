/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.implicare.model.service;

import br.cefetmg.implicare.model.domain.CargoInteresse;
import br.cefetmg.implicare.model.exception.BusinessException;
import br.cefetmg.implicare.model.exception.PersistenceException;
import java.util.ArrayList;

/**
 *
 *@author Gabriel
 * 
 */

public interface CargoInteresseManagement {
    public boolean insert(CargoInteresse CargoInteresse) throws BusinessException, PersistenceException;
    public boolean delete(CargoInteresse CargoInteresse) throws PersistenceException;
    public ArrayList<CargoInteresse> listar(long CPF) throws PersistenceException;
}
