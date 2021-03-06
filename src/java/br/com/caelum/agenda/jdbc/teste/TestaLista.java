package br.com.caelum.agenda.jdbc.teste;

import br.com.caelum.agenda.jdbc.dao.ContatoDao;
import br.com.caelum.agenda.jdbc.modelo.Contato;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.joda.time.format.DateTimeFormat;

public class TestaLista {

    public static void main(String args[]) {
        ContatoDao dao = new ContatoDao();
        List<Contato> contatos = dao.getLista();
        org.joda.time.format.DateTimeFormatter format = DateTimeFormat.forPattern("dd/MM/YYYY");
        if (contatos != null) {
            for (Contato contato : contatos) {
                System.out.println("Nome: " + contato.getNome());
                System.out.println("Email: " + contato.getEmail());
                System.out.println("Endereço: " + contato.getEndereco());
                System.out.println("Data de Nascimento: "
                        + contato.getDataNascimento().toString(format) + "\n");

            }

        } else {
            System.out.println("A consulta não retornou registros!");
        }
        long ind = 4;
        Contato contato = dao.getContato(ind);
        if (contato != null) {

            System.out.println("Nome: " + contato.getNome());
            System.out.println("Email: " + contato.getEmail());
            System.out.println("Endereço: " + contato.getEndereco());
            System.out.println("Data de Nascimento: "
                    + contato.getDataNascimento().toString(format) + "\n");

        } else {
            System.out.println("A consulta não retornou registros!");
        }

    }
}
