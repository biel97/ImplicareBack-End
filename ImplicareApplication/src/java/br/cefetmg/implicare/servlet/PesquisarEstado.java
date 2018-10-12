/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.implicare.servlet;

import br.cefetmg.implicare.model.domain.Estado;
import br.cefetmg.implicare.model.exception.PersistenceException;
import br.cefetmg.implicare.model.service.EstadoManagement;
import br.cefetmg.implicare.model.serviceImpl.EstadoManagementImpl;
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

public class PesquisarEstado extends HttpServlet {
    private Estado Estado;
    private EstadoManagement EstadoManagement;
    private String result;
    
    public PesquisarEstado() {
        Estado = null;
        result = "";
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        response.setContentType("application/json;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        int Cod_Estado = Integer.parseInt(request.getParameter("Cod_Estado"));
        
        try {
            EstadoManagement = new EstadoManagementImpl();
            Estado = EstadoManagement.pesquisar(Cod_Estado);
            
            if (Estado != null) {
                result = "[ {"
                        + "\"Cod_Estado\": " + Estado.getCod_Estado()
                        + ", \"Nom_Estado\": \"" + Estado.getNom_Estado() + "\" },";
                int ult = result.lastIndexOf(',');
                result = result.substring(0, ult);
                result += "]";
            
            }
            
            else {
                result = "[]";
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            }
            
        } catch (PersistenceException ex) {
            result = ex.getMessage();
        }
        
        PrintWriter out = response.getWriter();
        response.addHeader("Access-Control-Allow-Origin", "*");
        out.println(result);
        
    }

    @Override
    public String getServletInfo() {
        return "Pesquisar Estado";
    }

}
