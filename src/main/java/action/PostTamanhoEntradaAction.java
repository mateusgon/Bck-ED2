package action;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistence.ArquivoDAO;

public class PostTamanhoEntradaAction implements Action { // Responsável por processar a entrada do usuário que substituirá o Emtrada.txt

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String texto = request.getParameter("quantidadeElementos"); // Os elementos e os números são recebidos em formato de texto
            String delimitador = ",";
            String[] tamanhos = texto.split(delimitador); // São divididos.
            Integer[] valores = new Integer[7]; // Sempre deverão existir 6 números
            valores[0] = 6;
            for (Integer i = 1; i < 7; i++) {
                valores[i] = Integer.parseInt(tamanhos[i - 1]);
            }
            ArquivoDAO.getInstance(valores); // Armazena a entrada do usuário
            RequestDispatcher dispacher = request.getRequestDispatcher("/WEB-INF/escolhaItem.jsp");
            dispacher.forward(request, response);
        } catch (Exception ex) {
            response.sendRedirect("erro.html");
        }
    }

}
