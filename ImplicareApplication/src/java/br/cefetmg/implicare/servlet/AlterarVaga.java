/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.implicare.servlet;

import br.cefetmg.implicare.model.domain.Vaga;
import br.cefetmg.implicare.model.exception.BusinessException;
import br.cefetmg.implicare.model.exception.PersistenceException;
import br.cefetmg.implicare.model.service.VagaManagement;
import br.cefetmg.implicare.model.serviceImpl.VagaManagementImpl;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gabriel
 * 
 */

public class AlterarVaga extends HttpServlet {
    private VagaManagement VagaManagement;
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
            
            VagaManagement = new VagaManagementImpl();
            Vaga Vaga = this.VagaFromJson(payload);
            Result.setStatusOK();
            Result.setContent(VagaManagement.update(Vaga));
            
        } catch (BusinessException | PersistenceException ex) {
            ex.printStackTrace();
            Logger.getLogger(AlterarVaga.class.getName()).log(Level.SEVERE, null, ex);
            Result.setContent(ex.getMessage());
            Result.setStatusBADREQUEST();
        } finally {
            PrintWriter writer = response.getWriter();
            writer.println(Gson.toJson(Result));
        }
        
    }
    
    private Vaga VagaFromJson(String str) {
        Gson = new Gson();
        Vaga Vaga = Gson.fromJson(str, Vaga.class);
        return Vaga;
    }
    
    @Override
    public String getServletInfo() {
        return "Update Vaga";
    }

}
