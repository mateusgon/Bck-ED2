package action;

import hash.TabelaHashItem2;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistence.ArquivoDAO;
import persistence.GastoDAO;

public class PostInicialAction implements Action { // Responsável por processar a entrada do usuário que substituirá o Emtrada.txt

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Integer numero = Integer.parseInt(request.getParameter("quantidadeElementos")); // Os elementos e os números são recebidos em formato de texto
            TabelaHashItem2 hash = new TabelaHashItem2();
            Integer quantidadeDeputados = GastoDAO.getInstanceHash(hash);
            hash.buscarOrdenarDeputados(quantidadeDeputados);
            //Implementar lógica de exibição
            RequestDispatcher dispacher = request.getRequestDispatcher("/WEB-INF/resultadoItem2.jsp");
            dispacher.forward(request, response);
        } catch (Exception ex) {
            response.sendRedirect("erro.html");
        }
    }

}
