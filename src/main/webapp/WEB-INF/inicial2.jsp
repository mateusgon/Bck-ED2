<%@include file="jspf/cabecalho.jspf" %>
<div class="container text-center">
    <form method="post">
        <div class="form-group row">
            <label>Quantos elementos devem ser exibidos? Digite o n�mero. (Por exemplo, 5) </label>
            <textarea class="form-control" name="quantidadeElementos" rows="1"></textarea>
            <input type="submit" value="Enviar" class="btn btn-success"/>
            <input type="reset" class="btn btn-secondary"/>
        </div>
    </form>
</div>
<%@include file="jspf/rodape.jspf" %>