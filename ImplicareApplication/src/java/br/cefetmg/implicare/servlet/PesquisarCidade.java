/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.implicare.servlet;

import br.cefetmg.implicare.model.domain.Cidade;
import br.cefetmg.implicare.model.exception.PersistenceException;
import br.cefetmg.implicare.model.service.CidadeManagement;
import br.cefetmg.implicare.model.serviceImpl.CidadeManagementImpl;
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

public class PesquisarCidade extends HttpServlet {
    private Cidade Cidade;
    private CidadeManagement CidadeManagement;
    private String result;
    
    public PesquisarCidade() {
        Cidade = null;
        result = "";
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        response.setContentType("application/json;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        int Cod_Cidade = Integer.parseInt(request.getParameter("Cod_Cidade"));
        
        try {
            CidadeManagement = new CidadeManagementImpl();
            Cidade = CidadeManagement.pesquisar(Cod_Cidade);
            
            if (Cidade != null) {
                result = "[ {"
                        + "\"Cod_Estado\": " + Cidade.getCod_Estado()
                        + ", \"Cod_Cidade\": \"" + Cidade.getCod_Cidade() + "\""
                        + ", \"Nom_Cidade\": \"" + Cidade.getNom_Cidade() + "\" },";
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
        return "Pesquisar Cidade";
    }
    
}
