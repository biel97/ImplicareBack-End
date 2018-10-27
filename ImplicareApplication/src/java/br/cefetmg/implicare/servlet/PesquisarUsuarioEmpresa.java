/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.implicare.servlet;

import br.cefetmg.implicare.model.domain.Empresa;
import br.cefetmg.implicare.model.exception.BusinessException;
import br.cefetmg.implicare.model.exception.PersistenceException;
import br.cefetmg.implicare.model.service.EmpresaManagement;
import br.cefetmg.implicare.model.serviceImpl.EmpresaManagementImpl;
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

public class PesquisarUsuarioEmpresa extends HttpServlet {
    private Empresa Empresa;
    private EmpresaManagement EmpresaManagement;
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
        
        long CNPJ = Long.parseLong(request.getParameter("CNPJ"));
        
        try {
            
            EmpresaManagement = new EmpresaManagementImpl();
            Empresa = new Empresa();
            Empresa = EmpresaManagement.pesquisar(CNPJ);
            
            if(Empresa == null) {
                Result.setStatusDOESNOTEXIST();
            } else {
                Result.setStatusOK();
                Result.setContent(EmpresaManagement.insert(Empresa));
            }
            
        } catch (BusinessException | PersistenceException ex) {
            Result.setContent(ex.getMessage());
            Result.setStatusBADREQUEST();
        } finally {
            PrintWriter writer = response.getWriter();
            writer.println(Gson.toJson(Result));
        }
        
    }

    @Override
    public String getServletInfo() {
        return "Pesquisar Usuario Empresa";
    }

}
