/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.implicare.servlet;

import br.cefetmg.implicare.model.domain.Telefone;
import br.cefetmg.implicare.model.exception.BusinessException;
import br.cefetmg.implicare.model.exception.PersistenceException;
import br.cefetmg.implicare.model.service.TelefoneManagement;
import br.cefetmg.implicare.model.serviceImpl.TelefoneManagementImpl;
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

public class InserirTelefone extends HttpServlet {
    private TelefoneManagement TelefoneManagement;
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
            
            TelefoneManagement = new TelefoneManagementImpl();
            Telefone Telefone = this.TelefoneFromJson(payload);
            Result.setStatusOK();
            Result.setContent(TelefoneManagement.insert(Telefone));
            
        } catch (BusinessException | PersistenceException ex) {
            ex.printStackTrace();
            Logger.getLogger(InserirTelefone.class.getName()).log(Level.SEVERE, null, ex);
            Result.setContent(ex.getMessage());
            Result.setStatusBADREQUEST();
        } finally {
            PrintWriter writer = response.getWriter();
            writer.println(Gson.toJson(Result));
        }
        
    }

    private Telefone TelefoneFromJson(String str) {
        Gson = new Gson();
        Telefone Telefone = Gson.fromJson(str, Telefone.class);
        return Telefone;
    }
    
    @Override
    public String getServletInfo() {
        return "InsertTelefone";
    }

}
