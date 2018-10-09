/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.implicare.model.daoImpl;

import br.cefetmg.implicare.dao.UsuarioDao;
import br.cefetmg.implicare.model.domain.Usuario;
import br.cefetmg.implicare.model.exception.PersistenceException;
import br.cefetmg.inf.util.db.JDBCConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Gabriel
 */
public class UsuarioDaoImpl implements UsuarioDao{

    @Override
    public void insert(Usuario Usuario) throws PersistenceException {
        try {
                    
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "INSERT INTO Usuario (CPF_CNPJ, Email, Senha, Foto,"
                    + "Cod_Cep, Endereco, Desc_Usuario) VALUES(?,?,?,?,?,?,?) ";

            PreparedStatement ps = connection.prepareStatement(sql);
            
            ps.setLong(1, Usuario.getCPF_CNPJ());
            ps.setString(2, Usuario.getEmail());
            ps.setString(3, Usuario.getSenha());
            ps.setString(4, Usuario.getFoto());
            ps.setLong(5, Usuario.getCod_CEP());
            ps.setString(6, Usuario.getEndereco());
            ps.setString(7, Usuario.getDesc_Usuario());
            
            
            ResultSet rs = ps.executeQuery();

            rs.close();
            ps.close();
            connection.close();

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.toString());
        }
    }

    @Override
    public boolean update(long CPF_CNPJ, Usuario Usuario) throws PersistenceException {
       try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();
            
            String SQL = "UPDATE Usuario SET Email = ?, Senha = ?, Foto = ?, "
                    + "Cod_CEP, Endereco = ?, Desc_Usuario = ? "
                    + "WHERE CPF_CNPJ = ?";
            
            PreparedStatement ps = connection.prepareStatement(SQL);
       
            ps.setString(1, Usuario.getEmail());
            ps.setString(2, Usuario.getSenha());
            ps.setString(2, Usuario.getFoto());
            ps.setLong(4, Usuario.getCod_CEP());
            ps.setString(5, Usuario.getEndereco());
            ps.setString(6, Usuario.getDesc_Usuario());
            ps.setLong(7, CPF_CNPJ);
            
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
    public boolean delete(long CPF_CNPJ) throws PersistenceException {
        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();
            
            String SQL = "DELETE FROM Usuario WHERE CPF_CNPJ = ?";
            
            PreparedStatement ps = connection.prepareStatement(SQL);

            ps.setLong(1, CPF_CNPJ);
            
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
    public Usuario pesquisar(long CPF_CNPJ) throws PersistenceException {
        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM Usuario WHERE CPF_CNPJ = ?";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, CPF_CNPJ);
            ResultSet rs = ps.executeQuery();

            Usuario User = new Usuario();
            
            if (rs.next()) {
                User.setCPF_CNPJ(rs.getLong("CPF_CNPJ"));
                User.setEmail(rs.getString("Email"));
                User.setSenha(rs.getString("Senha"));
                User.setFoto(rs.getString("Foto"));
                User.setEndereco(rs.getString("Endereco"));
                User.setDesc_Usuario(rs.getString("Desc_Usuario"));
            }

            rs.close();
            ps.close();
            connection.close();

            return User;
            
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.toString());
            return null;
        }
    }

    @Override
    public Usuario login(long CPF_CNPJ, String Senha) throws PersistenceException {
        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM Usuario WHERE CPF_CNPJ = ? AND Senha = md5(?)";

            PreparedStatement ps = connection.prepareStatement(sql);
            
            ps.setLong(1, CPF_CNPJ);
            ps.setString(2, Senha);
            
            ResultSet rs = ps.executeQuery();

            Usuario User = null;
            
            if (rs.next()) {
                User = new Usuario();
                User.setCPF_CNPJ(rs.getLong("CPF_CNPJ"));
                User.setEmail(rs.getString("Email"));
                User.setSenha(rs.getString("Senha"));
                User.setFoto(rs.getString("Foto"));
                User.setCod_CEP(rs.getLong("Cod_CEP"));
                User.setEndereco(rs.getString("Endereco"));
                User.setDesc_Usuario(rs.getString("Desc_Usuario"));
            }

            rs.close();
            ps.close();
            connection.close();

            return User;
            
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.toString());
            return null;
        }
    }

}
