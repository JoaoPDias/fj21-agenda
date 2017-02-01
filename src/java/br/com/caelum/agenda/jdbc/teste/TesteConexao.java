package br.com.caelum.agenda.jdbc.teste;

import br.com.caelum.agenda.jdbc.ConnectionFactory;
import java.sql.*;
import javax.servlet.ServletException;

public class TesteConexao {
    public static void main(String args[]){
        try{
            Connection connection = new ConnectionFactory().getConnection();
            System.out.println("COnexão aberta");
            connection.close();
        }
        catch(SQLException | ServletException e)
        {
            System.out.println(e.getMessage());
        }
        
        
    
    }
}
