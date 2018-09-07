<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="jspf/cabecalho.jspf" %>

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
            <th> 1000 </th>
            <c:forEach var="resultados" items="${resultadoLeitura}" begin="0" end="4">
                <th>${resultados} ms</th>
            </c:forEach>
        </tr>
        <tr>
            <th> 5000 </th>
            <c:forEach var="resultados" items="${resultadoLeitura}" begin="5" end="9">
                <th>${resultados} ms</th>
            </c:forEach>
        </tr>
        <tr>
            <th> 10000 </th>
            <c:forEach var="resultados" items="${resultadoLeitura}" begin="10" end="14">
                <th>${resultados} ms</th>
            </c:forEach>
        </tr>
        <tr>
            <th> 50000 </th>
            <c:forEach var="resultados" items="${resultadoLeitura}" begin="15" end="19">
                <th>${resultados} ms</th>
            </c:forEach>
        </tr>
        <tr>
            <th> 100000 </th>
            <c:forEach var="resultados" items="${resultadoLeitura}" begin="20" end="24">
                <th>${resultados} ms</th>
            </c:forEach>
        </tr>
        <tr>
            <th> 500000 </th>
            <c:forEach var="resultados" items="${resultadoLeitura}" begin="25" end="29">
                <th>${resultados} ms</th>
            </c:forEach>
        </tr>
    </tbody>
</table>

<%@include file="jspf/rodape.jspf" %>