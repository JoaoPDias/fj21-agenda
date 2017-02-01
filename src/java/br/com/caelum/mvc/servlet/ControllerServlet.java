package br.com.caelum.mvc.servlet;

import br.com.caelum.mvc.logica.Logica;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControllerServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String parametro = request.getParameter("logica");
        String nomeDaClasse = "br.com.caelum.mvc.logica." + parametro;
        
        try {
            Class classe = Class.forName(nomeDaClasse);
            Logica logica = (Logica)classe.newInstance();
            logica.executa(request, response);

        } catch (Exception e) {
            throw new ServletException("A lógica de " + "negócios causou uma exceção", e);

        
        }
    }
        
    }
