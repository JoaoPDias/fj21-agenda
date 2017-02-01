

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bem Vindo</title>
    </head>
    <body>
        <%-- comentário em JSP aqui: nossa primeira página JSP --%>
        <%
            String mensagem = "Bem vindo ao sistema de agenda do FJ-21!";
        %>
        <% out.println(mensagem); %><br />
        <%
            String desenvolvido = "Desenvolvido por João Paulo Dias";
        %>
        <%= desenvolvido%><br />
        <%
            System.out.println("Tudo foi executado!");
        %>
    </body>
</html>
