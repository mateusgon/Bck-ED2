<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="jspf/cabecalho.jspf" %>

Maiores gastos deputados
<table style="background-color: black;color: white" class="table" style="margin-top:2rem">
    <thead>
        <tr>
            <th scope="col"> Nome do Deputado </th>
            <th scope="col"> ID </th>
            <th scope="col"> Partido </th>
            <th scope="col"> Valor </th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="dMaioresGastos" items="${dMaioresGastos}">
            <tr>
                <th> ${dMaioresGastos.nomeDeputado} </th>
                <th> ${dMaioresGastos.deputy_id} </th>
                <th> ${dMaioresGastos.partido} </th>
                <th> R$${dMaioresGastos.valor},00 </th>
            </tr>
        </c:forEach>
    </tbody>
</table>

Menores gastos deputados
<table style="background-color: black;color: white" class="table" style="margin-top:2rem">
    <thead>
        <tr>
            <th scope="col"> Nome do Deputado </th>
            <th scope="col"> ID </th>
            <th scope="col"> Partido </th>
            <th scope="col"> Valor </th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="dMenoresGastos" items="${dMenoresGastos}">
            <tr>
                <th> ${dMenoresGastos.nomeDeputado} </th>
                <th> ${dMenoresGastos.deputy_id} </th>
                <th> ${dMenoresGastos.partido} </th>
                <th> R$${dMenoresGastos.valor},00 </th>
            </tr>
        </c:forEach>
    </tbody>
</table>
Maiores gastos partidos
<table style="background-color: black;color: white" class="table" style="margin-top:2rem">
    <thead>
        <tr>
            <th scope="col"> Nome do Partido </th>
            <th scope="col"> Valor </th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="pMaioresGastos" items="${pMaioresGastos}">
            <tr>
                <th> ${pMaioresGastos.nome} </th>
                <th> R$${pMaioresGastos.valor},00 </th>
            </tr>
        </c:forEach>
    </tbody>
</table>

Menores gastos partidos
<table style="background-color: black;color: white" class="table" style="margin-top:2rem">
    <thead>
        <tr>
            <th scope="col"> Nome do Partido </th>
            <th scope="col"> Valor </th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="pMenoresGastos" items="${pMenoresGastos}">
            <tr>
                <th> ${pMenoresGastos.nome} </th>
                <th> R$${pMenoresGastos.valor},00 </th>
            </tr>
        </c:forEach>
    </tbody>
</table>

<%@include file="jspf/rodape.jspf" %>