
package br.com.caelum.agenda.jdbc;

import java.sql.*;
import javax.servlet.ServletException;


public class ConnectionFactory {
    public Connection getConnection() throws ServletException{
        try
        {
            return DriverManager.getConnection("jdbc:mysql://localhost/fj21","root","1234");
        }
        catch(SQLException e)
        {
            throw new ServletException(e);
        }
    }
    }

