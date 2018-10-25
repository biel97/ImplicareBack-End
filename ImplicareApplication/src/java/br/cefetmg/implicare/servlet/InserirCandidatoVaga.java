/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.implicare.servlet;

import br.cefetmg.implicare.model.domain.CandidatoVaga;
import br.cefetmg.implicare.model.exception.BusinessException;
import br.cefetmg.implicare.model.exception.PersistenceException;
import br.cefetmg.implicare.model.service.CandidatoVagaManagement;
import br.cefetmg.implicare.model.serviceImpl.CandidatoVagaManagementImpl;
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

public class InserirCandidatoVaga extends HttpServlet {
    private CandidatoVagaManagement CandidatoVagaManagement;
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
            
            CandidatoVagaManagement = new CandidatoVagaManagementImpl();
            CandidatoVaga CandidatoVaga = this.CandidatoVagaFromJson(payload);
            Result.setStatusOK();
            Result.setContent(CandidatoVagaManagement.insert(CandidatoVaga));
            
        } catch (BusinessException | PersistenceException ex) {
            ex.printStackTrace();
            Logger.getLogger(InserirCandidatoVaga.class.getName()).log(Level.SEVERE, null, ex);
            Result.setContent(ex.getMessage());
            Result.setStatusBADREQUEST();
        } finally {
            PrintWriter writer = response.getWriter();
            writer.println(Gson.toJson(Result));
        }
        
    }
    
    private CandidatoVaga CandidatoVagaFromJson(String str) {
        Gson = new Gson();
        CandidatoVaga CandidatoVaga = Gson.fromJson(str, CandidatoVaga.class);
        return CandidatoVaga;
    }

    @Override
    public String getServletInfo() {
        return "Insert Candidato Vaga";
    }

}
