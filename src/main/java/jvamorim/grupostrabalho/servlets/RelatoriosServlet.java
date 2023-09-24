package jvamorim.grupostrabalho.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import jvamorim.grupostrabalho.beans.AtuacaoBeanLocal;
import jvamorim.grupostrabalho.beans.PessoaBeanLocal;
import jvamorim.grupostrabalho.beans.GrupoBeanLocal;
import jvamorim.grupostrabalho.models.entities.Pessoa;
import jvamorim.grupostrabalho.models.entities.Grupo;
import jvamorim.grupostrabalho.utils.Utils;

@Transactional
public class RelatoriosServlet extends HttpServlet {

    @Inject
    private PessoaBeanLocal pessoaBean;
    @Inject
    private GrupoBeanLocal grupoBean;
    @Inject
    private AtuacaoBeanLocal atuacaoBean;
    
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
            out.println("<p><i>Utilize o sumário e os botões de navegação (setas) para uma melhor experiência.</i></p>");
            
            generateHtmlIndex(out);
            generateHtmlQuestao1(out);
            generateHtmlQuestao2(out);
            generateHtmlQuestao3(out);
            generateHtmlQuestao4(out);
            generateHtmlQuestao5(out);
            generateHtmlQuestao6(out);
            generateHtmlQuestao7(out);
            generateHtmlQuestao8(out);
            generateHtmlQuestao9(out);
            generateHtmlQuestao10(out);
            generateHtmlQuestao11(out);
            generateHtmlQuestao12(out);
            generateHtmlQuestao13(out);
            generateHtmlQuestao14(out);
            generateHtmlQuestao15(out);
            generateHtmlScript(out);
            
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
    
    private void generateHtmlIndex(PrintWriter out) {
        out.println("<h2 id=\"index\">Sumário</h2>");
        out.println("<ul>");
        
        out.println("<li><a href=\"#consulta-1-a\"> Consulta 1.A </a></li>");
        out.println("<li><a href=\"#consulta-1-b\"> Consulta 1.B </a></li>");
        out.println("<li><a href=\"#consulta-1-c\"> Consulta 1.C </a></li>");
        out.println("<li><a href=\"#consulta-2-a\"> Consulta 2.A </a></li>");
        out.println("<li><a href=\"#consulta-2-b\"> Consulta 2.B </a></li>");
        out.println("<li><a href=\"#consulta-2-c\"> Consulta 2.C </a></li>");
        out.println("<li><a href=\"#consulta-3-a\"> Consulta 3.A </a></li>");
        out.println("<li><a href=\"#consulta-3-b\"> Consulta 3.B </a></li>");
        out.println("<li><a href=\"#consulta-3-c\"> Consulta 3.C </a></li>");
        out.println("<li><a href=\"#consulta-4-a\"> Consulta 4.A </a></li>");
        out.println("<li><a href=\"#consulta-4-b\"> Consulta 4.B </a></li>");
        out.println("<li><a href=\"#consulta-4-c\"> Consulta 4.C </a></li>");
        out.println("<li><a href=\"#consulta-5-a\"> Consulta 5.A </a></li>");
        out.println("<li><a href=\"#consulta-5-b\"> Consulta 5.B </a></li>");
        out.println("<li><a href=\"#consulta-5-c\"> Consulta 5.C </a></li>");
        out.println("<li><a href=\"#consulta-6-a\"> Consulta 6.A </a></li>");
        out.println("<li><a href=\"#consulta-6-b\"> Consulta 6.B </a></li>");
        out.println("<li><a href=\"#consulta-6-c\"> Consulta 6.C </a></li>");
        out.println("<li><a href=\"#consulta-7\"> Consulta 7 </a></li>");
        out.println("<li><a href=\"#consulta-8-a\"> Consulta 8.A </a></li>");
        out.println("<li><a href=\"#consulta-8-b\"> Consulta 8.B </a></li>");
        out.println("<li><a href=\"#consulta-9\"> Consulta 9 </a></li>");
        out.println("<li><a href=\"#consulta-10\"> Consulta 10 </a></li>");
        out.println("<li><a href=\"#consulta-11\"> Consulta 11 </a></li>");
        out.println("<li><a href=\"#consulta-12\"> Consulta 12 </a></li>");
        out.println("<li><a href=\"#consulta-13\"> Consulta 13 </a></li>");
        out.println("<li><a href=\"#consulta-14\"> Consulta 14 </a></li>");
        out.println("<li><a href=\"#consulta-15\"> Consulta 15 </a></li>");
        
        out.println("</ul>");
    }

    private String buildHtmlQuestao(String id, String title, Object result) {
        String html = "<h2 id=\"" + id + "\">";
        html += "<a href=\"#index\" style=\"text-decoration: none; cursor: pointer;\">⬅️</a> ";
        html += "<a onclick=\"navigatePrevious('" + id + "')\" style=\"text-decoration: none; cursor: pointer;\">⬆️️</a> ";
        html += "<a onclick=\"navigateNext('" + id + "')\" style=\"text-decoration: none; cursor: pointer;\">⬇️️</a> ";
        html += title + "</h2>";
        html += "<p><pre>" + Utils.toJson(result) + "</pre></p>";
        return html;
    }
    
    private void generateHtmlQuestao1(PrintWriter out) {
        List<Pessoa> pessoasFromQuery = pessoaBean.findAll_Query();
        out.println(buildHtmlQuestao(
            "consulta-1-a",
            "Consulta 1.A: Quais as pessoas (dados completos) cadastradas? Por meio de Query",
            pessoasFromQuery
        ));
        
        List<Pessoa> pessoasFromTypedQuery = pessoaBean.findAll_TypedQuery();
        out.println(buildHtmlQuestao(
            "consulta-1-b",
            "Consulta 1.B: Quais as pessoas (dados completos) cadastradas? Por meio de TypedQuery",
            pessoasFromTypedQuery
        ));
        
        List<Pessoa> pessoasFromNamedQuery = pessoaBean.findAll_NamedQuery();
        out.println(buildHtmlQuestao(
            "consulta-1-c",
            "Consulta 1.C: Quais as pessoas (dados completos) cadastradas? Por meio de NamedQuery",
            pessoasFromNamedQuery
        ));
    }
    
    private void generateHtmlQuestao2(PrintWriter out) {
        List<String> nomesFromQuery = pessoaBean.findAllNome_Query();
        out.println(buildHtmlQuestao(
            "consulta-2-a",
            "Consulta 2.A: Quais os nomes das pessoas? Por meio de Query",
            nomesFromQuery
        ));
        
        List<String> nomesFromTypedQuery = pessoaBean.findAllNome_TypedQuery();
        out.println(buildHtmlQuestao(
            "consulta-2-b",
            "Consulta 2.B: Quais os nomes das pessoas? Por meio de TypedQuery",
            nomesFromTypedQuery
        ));
        
        List<String> nomesFromNamedQuery = pessoaBean.findAllNome_NamedQuery();
        out.println(buildHtmlQuestao(
            "consulta-2-c",
            "Consulta 2.C: Quais os nomes das pessoas? Por meio de NamedQuery",
            nomesFromNamedQuery
        ));
    }
    
    private void generateHtmlQuestao3(PrintWriter out) {
        List<Object[]> pessoasFromQuery = pessoaBean.findAllNomeEndereco_Query();
        out.println(buildHtmlQuestao(
            "consulta-3-a",
            "Consulta 3.A: Quais as pessoas (nome) e seus respectivos endereços (dados completos)? Por meio de Query",
            pessoasFromQuery
        ));
        
        List<Object[]> pessoasFromTypedQuery = pessoaBean.findAllNomeEndereco_TypedQuery();
        out.println(buildHtmlQuestao(
            "consulta-3-b",
            "Consulta 3.B: Quais as pessoas (nome) e seus respectivos endereços (dados completos)? Por meio de TypedQuery",
            pessoasFromTypedQuery
        ));
        
        List<Object[]> pessoasFromNamedQuery = pessoaBean.findAllNomeEndereco_NamedQuery();
        out.println(buildHtmlQuestao(
            "consulta-3-c",
            "Consulta 3.C: Quais as pessoas (nome) e seus respectivos endereços (dados completos)? Por meio de NamedQuery",
            pessoasFromNamedQuery
        ));
    }
    
    private void generateHtmlQuestao4(PrintWriter out) {
        List<Pessoa> pessoasFromQuery = pessoaBean.findAllInAvenida_Query();
        out.println(buildHtmlQuestao(
            "consulta-4-a",
            "Consulta 4.A: Quais pessoas (dados completos) moram em avenidas? Por meio de Query",
            pessoasFromQuery
        ));
        
        List<Pessoa> pessoasFromTypedQuery = pessoaBean.findAllInAvenida_TypedQuery();
        out.println(buildHtmlQuestao(
            "consulta-4-b",
            "Consulta 4.B: Quais pessoas (dados completos) moram em avenidas? Por meio de TypedQuery",
            pessoasFromTypedQuery
        ));
        
        List<Pessoa> pessoasFromNamedQuery = pessoaBean.findAllInAvenida_NamedQuery();
        out.println(buildHtmlQuestao(
            "consulta-4-c",
            "Consulta 4.C: Quais pessoas (dados completos) moram em avenidas? Por meio de NamedQuery",
            pessoasFromNamedQuery
        ));
    }
    
    private void generateHtmlQuestao5(PrintWriter out) {
        List<Pessoa> pessoasFromQuery = pessoaBean.findAllNotInPraca_Query();
        out.println(buildHtmlQuestao(
            "consulta-5-a",
            "Consulta 5.A: Quais pessoas (dados completos) não moram em praças? Por meio de Query",
            pessoasFromQuery
        ));
        
        List<Pessoa> pessoasFromTypedQuery = pessoaBean.findAllNotInPraca_TypedQuery();
        out.println(buildHtmlQuestao(
            "consulta-5-b",
            "Consulta 5.B: Quais pessoas (dados completos) não moram em praças? Por meio de TypedQuery",
            pessoasFromTypedQuery
        ));
        
        List<Pessoa> pessoasFromNamedQuery = pessoaBean.findAllNotInPraca_NamedQuery();
        out.println(buildHtmlQuestao(
            "consulta-5-c",
            "Consulta 5.C: Quais pessoas (dados completos) não moram em praças? Por meio de NamedQuery",
            pessoasFromNamedQuery
        ));
    }
    
    private void generateHtmlQuestao6(PrintWriter out) {
        List<Object[]> pessoasFromQuery = pessoaBean.findAllNomeTelefone_Query();
        out.println(buildHtmlQuestao(
            "consulta-6-a",
            "Consulta 6.A: Quais pessoas (nomes) e seus respectivos telefones (dados completos)? Por meio de Query",
            pessoasFromQuery
        ));
        
        List<Object[]> pessoasFromTypedQuery = pessoaBean.findAllNomeTelefone_TypedQuery();
        out.println(buildHtmlQuestao(
            "consulta-6-b",
            "Consulta 6.B: Quais pessoas (nomes) e seus respectivos telefones (dados completos)? Por meio de TypedQuery",
            pessoasFromTypedQuery
        ));
        
        List<Object[]> pessoasFromNamedQuery = pessoaBean.findAllNomeTelefone_NamedQuery();
        out.println(buildHtmlQuestao(
            "consulta-6-c",
            "Consulta 6.C: Quais pessoas (nomes) e seus respectivos telefones (dados completos)? Por meio de NamedQuery",
            pessoasFromNamedQuery
        ));
    }
    
    private void generateHtmlQuestao7(PrintWriter out) {
        List<Pessoa> pessoas = pessoaBean.findAllInNascimentoInterval(LocalDate.of(2001, 04, 01), LocalDate.of(2004, 05, 01).minusDays(1));
        out.println(buildHtmlQuestao(
            "consulta-7",
            "Consulta 7: Quais as pessoas (dados completos) que nasceram entre abril de 2001 e abril de 2004?",
            pessoas
        ));
    }
    
    private void generateHtmlQuestao8(PrintWriter out) {
        List<Pessoa> pessoasParana = pessoaBean.findAllByTelefonePrefixo("4");
        out.println(buildHtmlQuestao(
            "consulta-8-a",
            "Consulta 8.A: Quais pessoas (dados completos) têm telefone do estado do Paraná?",
            pessoasParana
        ));
        
        List<Pessoa> pessoasRio = pessoaBean.findAllByTelefonePrefixo("2");
        out.println(buildHtmlQuestao(
            "consulta-8-b",
            "Consulta 8.B: Quais pessoas (dados completos) têm telefone do estado do Rio de Janeiro?",
            pessoasRio
        ));
    }
    
    private void generateHtmlQuestao9(PrintWriter out) {
        List<Pessoa> pessoas = pessoaBean.findAllWithoutTelefone();
        out.println(buildHtmlQuestao(
            "consulta-9",
            "Consulta 9: Quais pessoas (dados completos) não possuem telefone?",
            pessoas
        ));
    }
    
    private void generateHtmlQuestao10(PrintWriter out) {
        List<Object[]> pessoas = pessoaBean.findAllTelefoneCount();
        out.println(buildHtmlQuestao(
            "consulta-10",
            "Consulta 10: Quantos telefones cada pessoa (nome) tem?",
            pessoas
        ));
    }
    
    private void generateHtmlQuestao11(PrintWriter out) {
        List<Grupo> grupos = grupoBean.findAllInativo();
        out.println(buildHtmlQuestao(
            "consulta-11",
            "Consulta 11: Quais grupos (dados completos) não estão ativos?",
            grupos
        ));
    }
    
    private void generateHtmlQuestao12(PrintWriter out) {
        List<Object[]> grupos = grupoBean.findAllNomeLider();
        out.println(buildHtmlQuestao(
            "consulta-12",
            "Consulta 12: Quais são os líderes (nomes) dos grupos (nomes)?",
            grupos
        ));
    }
    
    private void generateHtmlQuestao13(PrintWriter out) {
        List<String> nomes = grupoBean.findAllMembroNomeDescByNomeGrupo("Estudo IV");
        out.println(buildHtmlQuestao(
            "consulta-13",
            "Consulta 13: Quais são os membros (nomes) do grupo com nome \"Estudo IV\" com ordenação alfabética inversa?",
            nomes
        ));
    }
    
    private void generateHtmlQuestao14(PrintWriter out) {
        List<Grupo> grupos = grupoBean.findAllByLider("Beatriz Yana");
        out.println(buildHtmlQuestao(
            "consulta-14",
            "Consulta 14: Quais são os grupos (dados completos) liderados por \"Beatriz Yana\"?",
            grupos
        ));
    }
    
    private void generateHtmlQuestao15(PrintWriter out) {
        List<Object[]> atuacoes = atuacaoBean.findAllByMembroNome("Cecília Xerxes");
        out.println(buildHtmlQuestao(
            "consulta-15",
            "Consulta 15: Quais são as datas de início e de término da atuação e os grupos (nomes) nos quais \"Cecília Xerxes\" é membro?",
            atuacoes
        ));
    }
 
    private void generateHtmlScript(PrintWriter out) {
        out.println("<script>\n" +
                    "    function navigatePrevious(currentId) {\n" +
                    "        var allSections = document.querySelectorAll('h2');\n" +
                    "        var previous = null\n" +
                    "        for (const section of allSections) {\n" +
                    "            if (previous != null && section.id == currentId) {\n" +
                    "                previous.scrollIntoView({ behavior: \"smooth\" });\n" +
                    "                break;\n" +
                    "            }\n" +
                    "            previous = section;\n" +
                    "        }\n" +
                    "    }\n" +
                    "    function navigateNext(currentId) {\n" +
                    "        var allSections = document.querySelectorAll('h2');\n" +
                    "        var previous = null\n" +
                    "        for (const section of allSections) {\n" +
                    "            if (previous != null && previous.id == currentId) {\n" +
                    "                section.scrollIntoView({ behavior: \"smooth\" });\n" +
                    "                break;\n" +
                    "            }\n" +
                    "            previous = section;\n" +
                    "        }\n" +
                    "    }\n" +
                    "</script>");
    }
    
}
