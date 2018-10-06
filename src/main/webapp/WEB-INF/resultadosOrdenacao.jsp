<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="jspf/cabecalho.jspf" %>
Tempo
<table class="table" style="margin-top:2rem">
    <thead style="background-color: black;color: white">
        <tr>
            <th scope="col"> Registros </th>
            <th scope="col"> Execu��o 1 </th>
            <th scope="col"> Execu��o 2 </th>
            <th scope="col"> Execu��o 3 </th>
            <th scope="col"> Execu��o 4 </th>
            <th scope="col"> Execu��o 5 </th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <th> 1� tamanho </th>
            <c:forEach var="resultados" items="${resultadoLeitura}" begin="0" end="4">
                <th>${resultados.tempoGasto} ns</th>
            </c:forEach>
        </tr>
        <tr>
            <th> 2� tamanho </th>
            <c:forEach var="resultados" items="${resultadoLeitura}" begin="5" end="9">
                <th>${resultados.tempoGasto} ns</th>
            </c:forEach>
        </tr>
        <tr>
            <th> 3� tamanho </th>
            <c:forEach var="resultados" items="${resultadoLeitura}" begin="10" end="14">
                <th>${resultados.tempoGasto} ns</th>
            </c:forEach>
        </tr>
        <tr>
            <th> 4� tamanho </th>
            <c:forEach var="resultados" items="${resultadoLeitura}" begin="15" end="19">
                <th>${resultados.tempoGasto} ns</th>
            </c:forEach>
        </tr>
        <tr>
            <th> 5� tamanho </th>
            <c:forEach var="resultados" items="${resultadoLeitura}" begin="20" end="24">
                <th>${resultados.tempoGasto} ns</th>
            </c:forEach>
        </tr>
        <tr>
            <th> 6� tamanho </th>
            <c:forEach var="resultados" items="${resultadoLeitura}" begin="25" end="29">
                <th>${resultados.tempoGasto} ns</th>
            </c:forEach>
        </tr>
    </tbody>
</table>
N�mero de trocas
<table class="table" style="margin-top:2rem">
    <thead style="background-color: black;color: white">
        <tr>
            <th scope="col"> Registros </th>
            <th scope="col"> Execu��o 1 </th>
            <th scope="col"> Execu��o 2 </th>
            <th scope="col"> Execu��o 3 </th>
            <th scope="col"> Execu��o 4 </th>
            <th scope="col"> Execu��o 5 </th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <th> 1� tamanho </th>
            <c:forEach var="resultados" items="${resultadoLeitura}" begin="0" end="4">
                <th>${resultados.numTrocas}</th>
            </c:forEach>
        </tr>
        <tr>
            <th> 2� tamanho </th>
            <c:forEach var="resultados" items="${resultadoLeitura}" begin="5" end="9">
                <th>${resultados.numTrocas}</th>
            </c:forEach>
        </tr>
        <tr>
            <th> 3� tamanho </th>
            <c:forEach var="resultados" items="${resultadoLeitura}" begin="10" end="14">
                <th>${resultados.numTrocas}</th>
            </c:forEach>
        </tr>
        <tr>
            <th> 4� tamanho </th>
            <c:forEach var="resultados" items="${resultadoLeitura}" begin="15" end="19">
                <th>${resultados.numTrocas}</th>
            </c:forEach>
        </tr>
        <tr>
            <th> 5� tamanho </th>
            <c:forEach var="resultados" items="${resultadoLeitura}" begin="20" end="24">
                <th>${resultados.numTrocas}</th>
            </c:forEach>
        </tr>
        <tr>
            <th> 6� tamanho </th>
            <c:forEach var="resultados" items="${resultadoLeitura}" begin="25" end="29">
                <th>${resultados.numTrocas}</th>
            </c:forEach>
        </tr>
    </tbody>
</table>
N�mero de compara��es
<table class="table" style="margin-top:2rem">
    <thead style="background-color: black;color: white">
        <tr>
            <th scope="col"> Registros </th>
            <th scope="col"> Execu��o 1 </th>
            <th scope="col"> Execu��o 2 </th>
            <th scope="col"> Execu��o 3 </th>
            <th scope="col"> Execu��o 4 </th>
            <th scope="col"> Execu��o 5 </th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <th> 1� tamanho </th>
            <c:forEach var="resultados" items="${resultadoLeitura}" begin="0" end="4">
                <th>${resultados.numComparacoes}</th>
            </c:forEach>
        </tr>
        <tr>
            <th> 2� tamanho </th>
            <c:forEach var="resultados" items="${resultadoLeitura}" begin="5" end="9">
                <th>${resultados.numComparacoes}</th>
            </c:forEach>
        </tr>
        <tr>
            <th> 3� tamanho </th>
            <c:forEach var="resultados" items="${resultadoLeitura}" begin="10" end="14">
                <th>${resultados.numComparacoes}</th>
            </c:forEach>
        </tr>
        <tr>
            <th> 4� tamanho </th>
            <c:forEach var="resultados" items="${resultadoLeitura}" begin="15" end="19">
                <th>${resultados.numComparacoes}</th>
            </c:forEach>
        </tr>
        <tr>
            <th> 5� tamanho </th>
            <c:forEach var="resultados" items="${resultadoLeitura}" begin="20" end="24">
                <th>${resultados.numComparacoes}</th>
            </c:forEach>
        </tr>
        <tr>
            <th> 6� tamanho </th>
            <c:forEach var="resultados" items="${resultadoLeitura}" begin="25" end="29">
                <th>${resultados.numComparacoes}</th>
            </c:forEach>
        </tr>
    </tbody>
</table>

<%@include file="jspf/rodape.jspf" %>