package br.com.caelum.agenda.jdbc.dao;

import br.com.caelum.agenda.jdbc.ConnectionFactory;
import br.com.caelum.agenda.jdbc.modelo.Contato;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.ServletException;
import org.joda.time.DateTime;

public class ContatoDao {

    private Connection conn;

    public ContatoDao() {
        try{
        this.conn = new ConnectionFactory().getConnection();
        }
        catch(ServletException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public void adiciona(Contato contato) {
        String sql = "insert into contatos"
                + "(nome,email,endereco,dataNascimento)"
                + " values (?,?,?,?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, contato.getNome());
            stmt.setString(2, contato.getEmail());
            stmt.setString(3, contato.getEndereco());
            stmt.setDate(4, new Date(contato.getDataNascimento().getMillis()));

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
    }

    public List<Contato> getLista() {
        try {
            List<Contato> contatos = new LinkedList<>();
            PreparedStatement stmt = this.conn.prepareStatement("select * from contatos");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Contato contato = new Contato();
                contato.setId(rs.getLong("id"));
                contato.setNome(rs.getString("nome"));
                contato.setEmail(rs.getString("email"));
                contato.setEndereco(rs.getString("endereco"));
                contato.setDataNascimento(new DateTime(rs.getDate("dataNascimento")));

                contatos.add(contato);

            }
            rs.close();
            stmt.close();
            return contatos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public Contato getContato(Long id) {
        try {
            PreparedStatement stmt = this.conn.prepareStatement("select * from contatos where id = ?");
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            Contato contato = null;
            while (rs.next()) {
                contato = new Contato();
                contato.setId(rs.getLong("id"));
                contato.setNome(rs.getString("nome"));
                contato.setEmail(rs.getString("email"));
                contato.setEndereco(rs.getString("endereco"));
                contato.setDataNascimento(new DateTime(rs.getDate("dataNascimento")));

            }
            rs.close();
            stmt.close();
            return contato;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void altera(Contato contato) {
        String sql = "update contatos set nome=?, email=?,"
                + "endereco=?, dataNascimento=? where id=?";

        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, contato.getNome());
            stmt.setString(2, contato.getEmail());
            stmt.setString(3, contato.getEndereco());
            stmt.setDate(4, new Date(contato.getDataNascimento().getMillis()));
            stmt.setLong(5, contato.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void remove(Contato contato) {
        try {
            PreparedStatement stmt = this.conn
                    .prepareStatement("delete from contatos where id=?");
            stmt.setLong(1, contato.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
