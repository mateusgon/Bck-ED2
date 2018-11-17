package action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PostInicialAction implements Action { // Responsável por processar a entrada de quantos dados serão exibidos na tela pelo Item 2

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Integer numero = Integer.parseInt(request.getParameter("quantidadeElementos")); // Recebe a quantidade de elementos
        } catch (Exception ex) {
            response.sendRedirect("erro.html");
        }
    }

}
