<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="calendar" %>
<html>
    <head>
        <title>Adicionar Contato</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <c:import url="cabecalho.jsp" />
        <form action="adicionaContato" method="post">
            Nome: <input type="text" name="nome" /><br />
            E-mail: <input type="text" name="email" /><br />
            Endereço: <input type="text" name="endereco" /><br />
            Data Nascimento: <calendar:campoData id="dataNascimento"/><br />
            <input type="submit" value="Gravar" />
        </form>
        <c:import url="rodape.jsp" />
    </body>
</html>
