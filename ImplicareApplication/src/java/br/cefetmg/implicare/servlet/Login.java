/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.implicare.servlet;

import br.cefetmg.implicare.model.domain.Usuario;
import br.cefetmg.implicare.model.exception.BusinessException;
import br.cefetmg.implicare.model.exception.PersistenceException;
import br.cefetmg.implicare.model.service.UsuarioManagement;
import br.cefetmg.implicare.model.serviceImpl.UsuarioManagementImpl;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gabriel
 * 
 */

public class Login extends HttpServlet {
    private Usuario Usuario;
    private UsuarioManagement UsuarioManagement;
    private ServletUtil Util;
    private Gson Gson;
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=UTF-8");
        response.addHeader("Access-Control-Allow-Origin", "*");
        
        Result Result = new Result();
        Util = new ServletUtil();
        Gson = new Gson();
        
        long CPF_CNPJ = Long.parseLong(request.getParameter("CPF_CNPJ"));
        String Senha = request.getParameter("Senha");
        
        try {
            
            UsuarioManagement = new UsuarioManagementImpl();
            Usuario = new Usuario();
            Usuario = UsuarioManagement.login(CPF_CNPJ, Senha);
            
            if(Usuario == null) {
                Result.setStatusDOESNOTEXIST();
            } else {
                Result.setStatusOK();
                Result.setContent(Usuario);
            }
            
        } catch (PersistenceException ex) {
            Result.setContent(ex.getMessage());
            Result.setStatusBADREQUEST();
        } finally {
            PrintWriter writer = response.getWriter();
            writer.println(Gson.toJson(Result));
        }
        
    }

    @Override
    public String getServletInfo() {
        return "Login Usuario Empresa ou Candidato";
    }

}
