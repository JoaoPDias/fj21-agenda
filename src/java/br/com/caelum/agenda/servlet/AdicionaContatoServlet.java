/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.caelum.agenda.servlet;

import br.com.caelum.agenda.jdbc.dao.ContatoDao;
import br.com.caelum.agenda.jdbc.modelo.Contato;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.joda.time.DateTime;

@WebServlet(name = "AdicionaContato", urlPatterns = {"/adicionaContato"})
public class AdicionaContatoServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String nome = request.getParameter("nome");
        String endereco = request.getParameter("endereco");
        String email = request.getParameter("email");
        String dataEmTexto = request.getParameter("dataNascimento");
        DateTime datanasc;
        try {
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
            datanasc = new DateTime(date.getTime());
        } catch (ParseException e) {

            out.println("Erro de conversão da data");
            return; //para a execução do método
        }

        Contato contato = new Contato();
        contato.setNome(nome);
        contato.setEndereco(endereco);
        contato.setEmail(email);
        contato.setDataNascimento(datanasc);

        ContatoDao dao = new ContatoDao();
        dao.adiciona(contato);
        RequestDispatcher rd = request
                .getRequestDispatcher("/contato-adicionado.jsp");
        rd.forward(request, response);
    }

}
