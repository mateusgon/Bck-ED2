package action;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistence.ArquivoDAO;

public class PostInicialAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String texto = request.getParameter("quantidadeElementos");
        String delimitador = ",";
        String[] tamanhos = texto.split(delimitador);
        Integer[] valores = new Integer[7];
        valores[0] = 6;
        for (Integer i = 1; i < 7; i++) {
            valores[i] = Integer.parseInt(tamanhos[i - 1]);
        }
        ArquivoDAO.getInstance(valores);
        RequestDispatcher dispacher = request.getRequestDispatcher("/WEB-INF/escolhaItem.jsp");
        dispacher.forward(request, response);
    }

}
