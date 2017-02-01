
package br.com.caelum.mvc.logica;

import br.com.caelum.agenda.jdbc.dao.ContatoDao;
import br.com.caelum.agenda.jdbc.modelo.Contato;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.joda.time.DateTime;

public class AlteraContatoLogic implements Logica{
    
    @Override
    public void executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        res.setContentType("text/html;charset=UTF-8");
        PrintWriter out = res.getWriter();
        Contato contato = new Contato();
        long id = Long.parseLong(req.getParameter("id"));
        contato.setId(id);
        contato.setNome(req.getParameter("nome"));
        contato.setEndereco(req.getParameter("endereco"));
        contato.setEmail(req.getParameter("email"));
        String dataEmTexto = req.getParameter("dataNascimento");
        DateTime datanasc;
        try {
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
            datanasc = new DateTime(date.getTime());
            contato.setDataNascimento(datanasc);
        } catch (ParseException e) {

            out.println("Erro de conversão da data");
            return; //para a execução do método
        }
        ContatoDao dao = new ContatoDao();
        dao.altera(contato);
        RequestDispatcher rd = req.getRequestDispatcher("/lista-contato-elegante.jsp");
        rd.forward(req, res);
        System.out.println("Alterando contato de " + contato.getNome());
        
        
    }
 
    
}
