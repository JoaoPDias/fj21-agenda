<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags"
           prefix="caelum" %>
<!DOCTYPE html>
<html>
    <head>
         <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Alteração de Contato</title>
    </head>
    <body>  
        <c:import url="cabecalho.jsp" />
        Formulário para alteração de contatos:<br/>
        <form action="mvc" method="POST">
            Id:
            <input type="text" name="id" value="${requestScope.id}" readonly /><br/>
            Nome:
            <input type="text" name="nome" value="${requestScope.nome}"/><br/>
            E-mail:
            <input type="text" name="email" value="${requestScope.email}"/><br/>
            Endereço:
            <input type="text" name="endereco" value="${requestScope.endereco}"/><br/>
            Data de Nascimento:
            <caelum:campoData id="dataNascimento" />
            <input type="hidden"
                   name="logica" value="AlteraContatoLogic"/>
            <input type="submit" value="Enviar"/>
        </form>
        <c:import url="rodape.jsp" />
    </body>
</html>
