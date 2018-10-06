<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="jspf/cabecalho.jspf" %>
Tempo
<table class="table" style="margin-top:2rem">
    <thead style="background-color: black;color: white">
        <tr>
            <th scope="col"> Registros </th>
            <th scope="col"> Execução 1 </th>
            <th scope="col"> Execução 2 </th>
            <th scope="col"> Execução 3 </th>
            <th scope="col"> Execução 4 </th>
            <th scope="col"> Execução 5 </th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <th> 1º tamanho </th>
            <c:forEach var="resultados" items="${resultadoLeitura}" begin="0" end="4">
                <th>${resultados.tempoGasto} ns</th>
            </c:forEach>
        </tr>
        <tr>
            <th> 2º tamanho </th>
            <c:forEach var="resultados" items="${resultadoLeitura}" begin="5" end="9">
                <th>${resultados.tempoGasto} ns</th>
            </c:forEach>
        </tr>
        <tr>
            <th> 3º tamanho </th>
            <c:forEach var="resultados" items="${resultadoLeitura}" begin="10" end="14">
                <th>${resultados.tempoGasto} ns</th>
            </c:forEach>
        </tr>
        <tr>
            <th> 4º tamanho </th>
            <c:forEach var="resultados" items="${resultadoLeitura}" begin="15" end="19">
                <th>${resultados.tempoGasto} ns</th>
            </c:forEach>
        </tr>
        <tr>
            <th> 5º tamanho </th>
            <c:forEach var="resultados" items="${resultadoLeitura}" begin="20" end="24">
                <th>${resultados.tempoGasto} ns</th>
            </c:forEach>
        </tr>
        <tr>
            <th> 6º tamanho </th>
            <c:forEach var="resultados" items="${resultadoLeitura}" begin="25" end="29">
                <th>${resultados.tempoGasto} ns</th>
            </c:forEach>
        </tr>
    </tbody>
</table>
Número de trocas
<table class="table" style="margin-top:2rem">
    <thead style="background-color: black;color: white">
        <tr>
            <th scope="col"> Registros </th>
            <th scope="col"> Execução 1 </th>
            <th scope="col"> Execução 2 </th>
            <th scope="col"> Execução 3 </th>
            <th scope="col"> Execução 4 </th>
            <th scope="col"> Execução 5 </th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <th> 1º tamanho </th>
            <c:forEach var="resultados" items="${resultadoLeitura}" begin="0" end="4">
                <th>${resultados.numTrocas}</th>
            </c:forEach>
        </tr>
        <tr>
            <th> 2º tamanho </th>
            <c:forEach var="resultados" items="${resultadoLeitura}" begin="5" end="9">
                <th>${resultados.numTrocas}</th>
            </c:forEach>
        </tr>
        <tr>
            <th> 3º tamanho </th>
            <c:forEach var="resultados" items="${resultadoLeitura}" begin="10" end="14">
                <th>${resultados.numTrocas}</th>
            </c:forEach>
        </tr>
        <tr>
            <th> 4º tamanho </th>
            <c:forEach var="resultados" items="${resultadoLeitura}" begin="15" end="19">
                <th>${resultados.numTrocas}</th>
            </c:forEach>
        </tr>
        <tr>
            <th> 5º tamanho </th>
            <c:forEach var="resultados" items="${resultadoLeitura}" begin="20" end="24">
                <th>${resultados.numTrocas}</th>
            </c:forEach>
        </tr>
        <tr>
            <th> 6º tamanho </th>
            <c:forEach var="resultados" items="${resultadoLeitura}" begin="25" end="29">
                <th>${resultados.numTrocas}</th>
            </c:forEach>
        </tr>
    </tbody>
</table>
Número de comparações
<table class="table" style="margin-top:2rem">
    <thead style="background-color: black;color: white">
        <tr>
            <th scope="col"> Registros </th>
            <th scope="col"> Execução 1 </th>
            <th scope="col"> Execução 2 </th>
            <th scope="col"> Execução 3 </th>
            <th scope="col"> Execução 4 </th>
            <th scope="col"> Execução 5 </th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <th> 1º tamanho </th>
            <c:forEach var="resultados" items="${resultadoLeitura}" begin="0" end="4">
                <th>${resultados.numComparacoes}</th>
            </c:forEach>
        </tr>
        <tr>
            <th> 2º tamanho </th>
            <c:forEach var="resultados" items="${resultadoLeitura}" begin="5" end="9">
                <th>${resultados.numComparacoes}</th>
            </c:forEach>
        </tr>
        <tr>
            <th> 3º tamanho </th>
            <c:forEach var="resultados" items="${resultadoLeitura}" begin="10" end="14">
                <th>${resultados.numComparacoes}</th>
            </c:forEach>
        </tr>
        <tr>
            <th> 4º tamanho </th>
            <c:forEach var="resultados" items="${resultadoLeitura}" begin="15" end="19">
                <th>${resultados.numComparacoes}</th>
            </c:forEach>
        </tr>
        <tr>
            <th> 5º tamanho </th>
            <c:forEach var="resultados" items="${resultadoLeitura}" begin="20" end="24">
                <th>${resultados.numComparacoes}</th>
            </c:forEach>
        </tr>
        <tr>
            <th> 6º tamanho </th>
            <c:forEach var="resultados" items="${resultadoLeitura}" begin="25" end="29">
                <th>${resultados.numComparacoes}</th>
            </c:forEach>
        </tr>
    </tbody>
</table>

<%@include file="jspf/rodape.jspf" %>