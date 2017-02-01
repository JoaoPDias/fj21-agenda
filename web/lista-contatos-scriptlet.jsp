<%@page import="org.joda.time.format.DateTimeFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.*,
         br.com.caelum.agenda.jdbc.dao.*,
         br.com.caelum.agenda.jdbc.modelo.*,
         org.joda.time.format.DateTimeFormatter" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Contatos</title>
    </head>
    <body>
        <h1>Tabela de Contatos</h1>
        <table>
            <thead>
            <th>Nome</th>
            <th>E-mail</th>
            <th>Endereço</th>
            <th>Data de Nascimento</th>
            </thead>
            <tbody>
            <%
                ContatoDao dao = new ContatoDao();
                List<Contato> contatos = dao.getLista();
                DateTimeFormatter fmt = DateTimeFormat.forPattern("dd/MM/YYYY");
                for (Contato contato : contatos) {
            %>
            <tr>
                <td><%=contato.getNome()%></td>
                <td><%=contato.getEmail()%></td>
                <td><%=contato.getEndereco()%></td>
                <td><%=contato.getDataNascimento().toString(fmt)%></td>
            </tr>
            <%
                }
            %>
            </tbody>
        </table>
    </body>
</html>
