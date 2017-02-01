/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.caelum.mvc.logica;

import br.com.caelum.agenda.jdbc.dao.ContatoDao;
import br.com.caelum.agenda.jdbc.modelo.Contato;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 *
 * @author jpdia
 */
public class AlteraContatoLinkLogic implements Logica {

    @Override
    public void executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        DateTimeFormatter fmt = DateTimeFormat.forPattern("dd/MM/YYYY");
        Long id = Long.parseLong(req.getParameter("id"));
        ContatoDao contatoDao = new ContatoDao();
        Contato contato = contatoDao.getContato(id);
        req.setAttribute("id", contato.getId());
        req.setAttribute("nome", contato.getNome());
        req.setAttribute("email", contato.getEmail());
        req.setAttribute("endereco", contato.getEndereco());
        req.setAttribute("datanasc", contato.getDataNascimento().toString(fmt));
        RequestDispatcher rd = req.getRequestDispatcher("altera-contato.jsp");
        rd.forward(req, res);
    }
}
