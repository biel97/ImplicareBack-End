/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.implicare.servlet;

import br.cefetmg.implicare.model.domain.AreaEstudo;
import br.cefetmg.implicare.model.exception.PersistenceException;
import br.cefetmg.implicare.model.service.AreaEstudoManagement;
import br.cefetmg.implicare.model.serviceImpl.AreaEstudoManagementImpl;
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

public class PesquisarAreaEstudo extends HttpServlet {
    private AreaEstudoManagement AreaEstudoManagement;
    private AreaEstudo AreaEstudo;
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
        
        int Cod_Area_Estudo = Integer.parseInt(request.getParameter("Cod_Area_Estudo"));
        
        try {
            
            AreaEstudoManagement = new AreaEstudoManagementImpl();
            AreaEstudo = new AreaEstudo();
            AreaEstudo = AreaEstudoManagement.pesquisar(Cod_Area_Estudo);
            
            if(AreaEstudo == null){
                Result.setStatusDOESNOTEXIST();
            } else {
                Result.setStatusOK();
                Result.setContent(AreaEstudo);
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
        return "Pesquisar Area Estudo";
    }
    
}
