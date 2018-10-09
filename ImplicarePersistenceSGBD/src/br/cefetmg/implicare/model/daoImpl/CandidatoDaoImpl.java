/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.implicare.model.daoImpl;

import br.cefetmg.implicare.model.domain.Candidato;
import br.cefetmg.implicare.model.exception.PersistenceException;
import br.cefetmg.inf.util.db.JDBCConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import br.cefetmg.implicare.dao.CandidatoDao;

/**
 *
 * @author Gabriel
 * 
 */

public class CandidatoDaoImpl implements CandidatoDao {

    @Override
    public void insert(Candidato Candidato) throws PersistenceException {
        try {
                    
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "INSERT INTO Candidato (CPF, Nome, Data_Nascimento) "
                    + "VALUES(?,?,?)";

            PreparedStatement ps = connection.prepareStatement(sql);
        
            ps.setLong(1, Candidato.getCPF());
            ps.setString(2, Candidato.getNome());
            ps.setDate(3, Candidato.getData_Nascimento());
            
            ResultSet rs = ps.executeQuery();

            rs.close();
            ps.close();
            connection.close();

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.toString());
        }
    }

    @Override
    public boolean update(long CPF, Candidato Candidato) throws PersistenceException {
        try {
           Connection connection = JDBCConnectionManager.getInstance().getConnection();
            
            String SQL = "UPDATE Candidato SET Nome = ?, Data_Nascimento = ?"
                    + "WHERE CPF = ?";
            
            PreparedStatement ps = connection.prepareStatement(SQL);
            
            ps.setString(1, Candidato.getNome());
            ps.setDate(2, Candidato.getData_Nascimento());
            ps.setLong(3, CPF);
            
            ps.executeQuery(SQL);
            ps.close();
            connection.close();
            return true;
            
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return false;
        }
    }
    
    @Override
    public Candidato pesquisar(long CPF) throws PersistenceException {
        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM Candidato WHERE CPF = ?";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, CPF);
            ResultSet rs = ps.executeQuery();

            Candidato Pessoa = new Candidato();
            
            if (rs.next()) {
                Pessoa.setCPF(rs.getLong("CPF"));
                Pessoa.setNome(rs.getString("Nome"));
                Pessoa.setData_Nascimento(rs.getDate("Data_Nascimento"));
            }

            rs.close();
            ps.close();
            connection.close();

            return Pessoa;
            
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.toString());
            return null;
        }
    }
    
}
