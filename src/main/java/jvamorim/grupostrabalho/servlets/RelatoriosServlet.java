package jvamorim.grupostrabalho.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import jvamorim.grupostrabalho.beans.PessoaBeanLocal;
import jvamorim.grupostrabalho.models.entities.Pessoa;
import jvamorim.grupostrabalho.utils.Utils;

@Transactional
public class RelatoriosServlet extends HttpServlet {

    @Inject
    private PessoaBeanLocal pessoaBean;
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Estudo Dirigido: JPQL - Relatórios</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Estudo Dirigido: JPQL - Relatórios</h1>");
            
            generateHtmlQuestao1(out);
            
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Estudo Dirigido: JPQL - Relatórios";
    }// </editor-fold>

    private void generateHtmlQuestao1(PrintWriter out) {
        List<Pessoa> pessoasFromQuery = pessoaBean.findAll_Query();
        List<Pessoa> pessoasFromTypedQuery = pessoaBean.findAll_TypedQuery();
        List<Pessoa> pessoasFromNamedQuery = pessoaBean.findAll_NamedQuery();
        
        out.println("<h2>Consulta 1.A: Quais as pessoas (dados completos) cadastradas? Por meio de Query</h2>");
        out.println("<p><pre>" + Utils.toJson(pessoasFromQuery) + "</pre></p>");
        
        out.println("<h2>Consulta 1.B: Quais as pessoas (dados completos) cadastradas? Por meio de TypedQuery</h2>");
        out.println("<p><pre>" + Utils.toJson(pessoasFromTypedQuery) + "</pre></p>");
        
        out.println("<h2>Consulta 1.C: Quais as pessoas (dados completos) cadastradas? Por meio de NamedQuery</h2>");
        out.println("<p><pre>" + Utils.toJson(pessoasFromNamedQuery) + "</pre></p>");
    }
    
}
