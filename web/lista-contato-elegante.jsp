<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib tagdir="/WEB-INF/tags" prefix="Tabela" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Contatos</title>



    </head>
    <body>
        <c:import url="cabecalho.jsp"/>
        <h1>Lista de Contatos</h1>
        <jsp:useBean id="dao" class="br.com.caelum.agenda.jdbc.dao.ContatoDao"/>
        <table id="tabela">
            <thead>
            <th>Nome</th>
            <th>E-mail</th>
            <th>Endereço</th>
            <th>Data de Nascimento</th>
            <th>Opções</th>
        </thead>
        <tbody>


            <!-- percorre contatos montando as linhas da tabela -->
            <c:forEach var="contato" items="${dao.lista}" varStatus="id">
                <tr bgcolor="#${id.count % 2 ==0 ?'aaee88' : 'ffffff' }">
                    <td>${contato.nome}</td>
                    <c:choose>
                        <c:when test="${not empty contato.email}">
                            <td><a href="mailto:${contato.email}">${contato.email}</a></td>
                            </c:when>
                            <c:otherwise>
                            <td>E-mail não informado</td>
                        </c:otherwise>
                    </c:choose>
                    <td>${contato.endereco}</td>
                    <td><joda:format value="${contato.dataNascimento}" pattern="dd/MM/yyyy"/></td>
                    <td><a href="<c:url value="/mvc?logica=AlteraContatoLinkLogic&id=${contato.id}"/>">Alterar</a></td>
                </tr>
                
            </c:forEach>
                
        </tbody>
    </table>
    <c:import url="rodape.jsp"/>
</body>
</html>
