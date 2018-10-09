/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.implicare.model.daoImpl;

import br.cefetmg.implicare.dao.CandidatoVagaDao;
import br.cefetmg.implicare.model.domain.CandidatoVaga;
import br.cefetmg.implicare.model.exception.PersistenceException;
import br.cefetmg.inf.util.db.JDBCConnectionManager;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Gabriel
 * 
 */

public class CandidatoVagaDaoImpl implements CandidatoVagaDao {

    @Override
    public void insert(CandidatoVaga CandidatoVaga) throws PersistenceException {
        try {
                    
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "INSERT INTO CandidatoVaga (CPF, Cod_Cargo, CNPJ,"
                    + "Dat_Publicacao, Status_Candidato) VALUES(?,?,?,?,?)";

            PreparedStatement ps = connection.prepareStatement(sql);
           
            ps.setLong(1, CandidatoVaga.getCPF());
            ps.setInt(2, CandidatoVaga.getCod_Cargo());
            ps.setLong(3, CandidatoVaga.getCNPJ());
            ps.setDate(4, CandidatoVaga.getDat_Publicacao());
            ps.setString(5, CandidatoVaga.getStatus_Candidato());
            
            ResultSet rs = ps.executeQuery();

            rs.close();
            ps.close();
            connection.close();

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.toString());
        }
    }

    @Override
    public boolean update(long CPF, int Cod_Cargo, long CNPJ, Date Dat_Publicacao, CandidatoVaga CandidatoVaga) throws PersistenceException {
        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();
            
            String SQL = "UPDATE CandidatoVaga SET Status_Candidato = ? "
                    + "WHERE CPF = ? , Cod_Cargo = ?,"
                    + "CNPJ = ?, Dat_Publicacao = ?";
            
            PreparedStatement ps = connection.prepareStatement(SQL);
            
            ps.setString(1, CandidatoVaga.getStatus_Candidato());
            ps.setLong(2, CPF);
            ps.setInt(3, Cod_Cargo);
            ps.setLong(4, CNPJ);
            ps.setDate(5, Dat_Publicacao);
            
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
   public ArrayList<CandidatoVaga> listar(int Cod_Cargo, long CNPJ, Date Dat_Publicacao) throws PersistenceException {
        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();
            
            String SQL = "SELECT * FROM CandidatoVaga"
                    + "WHERE Cod_Cargo = ?, CNPJ = ?, Dat_Publicacao = ?";
            
            PreparedStatement ps = connection.prepareStatement(SQL);
            
            ps.setInt(1, Cod_Cargo);
            ps.setLong(2, CNPJ);
            ps.setDate(3, Dat_Publicacao);
            
            ResultSet rs = ps.executeQuery(SQL);
            
            ArrayList<CandidatoVaga> lista = new ArrayList();
            CandidatoVaga Cand = new CandidatoVaga();
            
            while (rs.next()) {
                Cand.setCPF(rs.getLong("CPF"));
                Cand.setCod_Cargo(rs.getInt("Cod_Cargo"));
                Cand.setCNPJ(rs.getLong("CNPJ"));
                Cand.setDat_Publicacao(rs.getDate("Dat_Publicacao"));
                Cand.setStatus_Candidato(rs.getString("Status_Candidato"));
                lista.add(Cand);
            }

            rs.close();
            ps.close();
            connection.close();
            
            return lista; 
           
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return null;
        }
    }

    @Override
    public CandidatoVaga pesquisar(long CPF, int Cod_Cargo, long CNPJ, Date Dat_Publicacao) throws PersistenceException {
        try {
           Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM CandidatoVaga WHERE CPF = ?, Cod_Cargo = ?, CNPJ = ?, Dat_Publicacao = ?";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, CPF);
            ps.setInt(2, Cod_Cargo);
            ps.setLong(3, CNPJ);
            ps.setDate(4, Dat_Publicacao);
            ResultSet rs = ps.executeQuery();

            CandidatoVaga Cand = new CandidatoVaga();
            
            if (rs.next()) {
                Cand.setCPF(rs.getLong("CPF"));
                Cand.setCod_Cargo(rs.getInt("Cod_Cargo"));
                Cand.setCNPJ(rs.getLong("CNPJ"));
                Cand.setDat_Publicacao(rs.getDate("Dat_Publicacao"));
                Cand.setStatus_Candidato(rs.getString("Status_Candidato"));
            }

            rs.close();
            ps.close();
            connection.close();

            return Cand;
            
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.toString());
            return null;
        }
    }
   
}
