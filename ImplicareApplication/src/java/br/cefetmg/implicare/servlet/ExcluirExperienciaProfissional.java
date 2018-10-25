/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.implicare.servlet;

import br.cefetmg.implicare.model.domain.ExperienciaProfissional;
import br.cefetmg.implicare.model.exception.PersistenceException;
import br.cefetmg.implicare.model.service.ExperienciaProfissionalManagement;
import br.cefetmg.implicare.model.serviceImpl.ExperienciaProfissionalManagementImpl;
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

public class ExcluirExperienciaProfissional extends HttpServlet {
    private ExperienciaProfissionalManagement ExperienciaProfissionalManagement;
    private ServletUtil Util;
    private Gson Gson;
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=UTF-8");
        response.addHeader("Access-Control-Allow-Origin", "*");
        
        Result Result = new Result();
        Util = new ServletUtil();
        Gson = new Gson();
        
        try {
            String payload = Util.getJson(request);
            
            ExperienciaProfissionalManagement = new ExperienciaProfissionalManagementImpl();
            ExperienciaProfissional ExperienciaProfissional = this.ExperienciaProfissionalFromJson(payload);
            Result.setStatusOK();
            Result.setContent(ExperienciaProfissionalManagement.delete(ExperienciaProfissional));
            
        } catch (PersistenceException ex) {
            Result.setContent(ex.getMessage());
            Result.setStatusBADREQUEST();
        } finally {
            PrintWriter writer = response.getWriter();
            writer.println(Gson.toJson(Result));
        }
        
    }
    
    private ExperienciaProfissional ExperienciaProfissionalFromJson(String str) {
        Gson = new Gson();
        ExperienciaProfissional ExperienciaProfissional = Gson.fromJson(str, ExperienciaProfissional.class);
        return ExperienciaProfissional;
    }
    
    @Override
    public String getServletInfo() {
        return "Delete Experiencia Profissional";
    }

}
