/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.implicare.servlet;

import br.cefetmg.implicare.model.domain.Candidato;
import br.cefetmg.implicare.model.exception.BusinessException;
import br.cefetmg.implicare.model.exception.PersistenceException;
import br.cefetmg.implicare.model.service.CandidatoManagement;
import br.cefetmg.implicare.model.serviceImpl.CandidatoManagementImpl;
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

public class InserirUsuarioCandidato extends HttpServlet {
    private CandidatoManagement CandidatoManagement;
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
            
            CandidatoManagement = new CandidatoManagementImpl();
            Candidato Candidato = this.CandidatoFromJson(payload);
            Result.setStatusOK();
            Result.setContent(CandidatoManagement.insert(Candidato));
            
        } catch (BusinessException | PersistenceException ex) {
            ex.printStackTrace();
            Logger.getLogger(InserirUsuarioCandidato.class.getName()).log(Level.SEVERE, null, ex);
            Result.setContent(ex.getMessage());
            Result.setStatusBADREQUEST();
        } finally {
            PrintWriter writer = response.getWriter();
            writer.println(Gson.toJson(Result));
        }
        
    }
    
    private Candidato CandidatoFromJson(String str) {
        Gson = new Gson();
        Candidato Candidato = Gson.fromJson(str, Candidato.class);
        return Candidato;
    }

    @Override
    public String getServletInfo() {
        return "Update Usuario Candidato";
    }
    
}
