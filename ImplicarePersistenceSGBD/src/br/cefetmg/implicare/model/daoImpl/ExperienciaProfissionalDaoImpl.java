/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.implicare.model.daoImpl;

import br.cefetmg.implicare.dao.ExperienciaProfissionalDao;
import br.cefetmg.implicare.model.domain.ExperienciaProfissional;
import br.cefetmg.implicare.model.exception.PersistenceException;
import br.cefetmg.inf.util.db.JDBCConnectionManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gabriel
 * 
 */

public class ExperienciaProfissionalDaoImpl implements ExperienciaProfissionalDao {

    @Override
    public void insert(ExperienciaProfissional ExperienciaProfissional) throws PersistenceException {
        try {
                    
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "INSERT INTO ExperienciaProfissional (CPF, Seq_Experiencia, Nom_Empresa, Cod_Cargo, "
                    + "Cod_Cep, Data_Inicio, Data_Termino, Desc_Experiencia_Profissional, Cod_Cidade, Cod_Estado) "
                    + "VALUES(?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement ps = connection.prepareStatement(sql);
            
            ps.setLong(1, ExperienciaProfissional.getCPF());
            ps.setInt(2, ExperienciaProfissional.getSeq_Experiencia());
            ps.setString(3, ExperienciaProfissional.getNom_Empresa());
            ps.setInt(4, ExperienciaProfissional.getCod_Cargo());
            ps.setLong(5, ExperienciaProfissional.getCod_CEP());
            ps.setDate(6, ExperienciaProfissional.getData_Inicio());
            ps.setDate(7, ExperienciaProfissional.getData_Termino());
            ps.setString(8, ExperienciaProfissional.getDesc_Experiencia_Profissional());
            ps.setLong(9, ExperienciaProfissional.getCod_Cidade());
            ps.setLong(10, ExperienciaProfissional.getCod_Estado());
            
            ResultSet rs = ps.executeQuery();

            rs.close();
            ps.close();
            connection.close();

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.toString());
        }
    }

    @Override
    public boolean update(long CPF, int Seq_Experiencia, int Cod_Cargo, ExperienciaProfissional ExperienciaProfissional) throws PersistenceException {
        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();
            
            String SQL = "UPDATE ExperienciaProfissional SET Nom_Empresa = ?, Cod_Cargo = ?, "
                    + "Cod_Cep = ?, Data_Inicio = ?, Data_Termino = ?, "
                    + "Desc_Experiencia_Profissional = ?, Cod_Cidade = ?, Cod_Estado = ?"
                    + "WHERE CPF = ?, Seq_Experiencia = ?, Cod_Cargo = ?";
            
            PreparedStatement ps = connection.prepareStatement(SQL);

            ps.setString(1, ExperienciaProfissional.getNom_Empresa());
            ps.setInt(2, ExperienciaProfissional.getCod_Cargo());
            ps.setLong(3, ExperienciaProfissional.getCod_CEP());
            ps.setDate(4, ExperienciaProfissional.getData_Inicio());
            ps.setDate(5, ExperienciaProfissional.getData_Termino());
            ps.setString(6, ExperienciaProfissional.getDesc_Experiencia_Profissional());
            ps.setLong(7, ExperienciaProfissional.getCod_Cidade());
            ps.setLong(8, ExperienciaProfissional.getCod_Estado());
            ps.setLong(8, CPF);
            ps.setInt(9, Seq_Experiencia);
            ps.setInt(10, Cod_Cargo);
            
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
    public boolean delete(long CPF, int Seq_Experiencia, int Cod_Cargo) throws PersistenceException {
        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();
            
            String SQL = "DELETE FROM ExperienciaProfissional"
                    + "WHERE CPF = ?, Seq_Experiencia = ?, Cod_Cargo = ?";
            
            PreparedStatement ps = connection.prepareStatement(SQL);
            
            ps.setLong(1, CPF);
            ps.setInt(2, Seq_Experiencia);
            ps.setInt(3, Cod_Cargo);
            
            ps.executeQuery(SQL);
            ps.close();
            connection.close();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.toString());
            return false;
        }
    }

    @Override
    public ArrayList<ExperienciaProfissional> listar(long CPF) throws PersistenceException {
        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM ExperienciaProfissional WHERE CPF = ? ORDER BY Seq_Experiencia;";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, CPF);
            ResultSet rs = ps.executeQuery();

            ArrayList<ExperienciaProfissional> lista = new ArrayList<>();
            
            if (rs.next()) {
                do {
                    ExperienciaProfissional Exp = new ExperienciaProfissional();
                    
                    Exp.setCPF(rs.getLong("CPF"));
                    Exp.setSeq_Experiencia(rs.getInt("Seq_Experiencia"));
                    Exp.setNom_Empresa(rs.getString("Nom_Empresa"));
                    Exp.setCod_Cargo(rs.getInt("Cod_Cargo"));
                    Exp.setCod_CEP(rs.getLong("Cod_Cep"));
                    Exp.setData_Inicio(rs.getDate("Data_Inicio"));
                    Exp.setData_Termino(rs.getDate("Data_Termino"));
                    Exp.setDesc_Experiencia_Profissional(rs.getString("Desc_Experiencia_Profissional"));
                    Exp.setCod_Cidade(rs.getLong("Cod_Cidade"));
                    Exp.setCod_Estado(rs.getLong("Cod_Estado"));
                   
                    lista.add(Exp);
                } while (rs.next());
            }

            rs.close();
            ps.close();
            connection.close();

            return lista;
            
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.toString());
            return null;
        }
    }

    @Override
    public ExperienciaProfissional pesquisar(long CPF, int Seq_Experiencia, int Cod_Cargo) throws PersistenceException {
        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM ExperienciaProfissional WHERE CPF = ?, Seq_Experiencia = ?, Cod_Cargo = ?";

            PreparedStatement ps = connection.prepareStatement(sql);
            
            ps.setLong(1, CPF);
            ps.setInt(2, Seq_Experiencia);
            ps.setInt(3, Cod_Cargo);
            
            ResultSet rs = ps.executeQuery();

            ExperienciaProfissional Exp = new ExperienciaProfissional();
            
            if (rs.next()) {
                Exp.setCPF(rs.getLong("CPF"));
                Exp.setSeq_Experiencia(rs.getInt("Seq_Experiencia"));
                Exp.setNom_Empresa(rs.getString("Nom_Empresa"));
                Exp.setCod_Cargo(rs.getInt("Cod_Cargo"));
                Exp.setCod_CEP(rs.getLong("Cod_Cep"));
                Exp.setData_Inicio(rs.getDate("Data_Inicio"));
                Exp.setData_Termino(rs.getDate("Data_Termino"));
                Exp.setDesc_Experiencia_Profissional(rs.getString("Desc_Experiencia_Profissional"));
                Exp.setCod_Cidade(rs.getLong("Cod_Cidade"));
                Exp.setCod_Estado(rs.getLong("Cod_Estado"));
            }

            rs.close();
            ps.close();
            connection.close();

            return Exp;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.toString());
            return null;
        }
    }

}
