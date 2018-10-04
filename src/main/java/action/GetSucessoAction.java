package action;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetSucessoAction implements Action { // Quando utilizado a ordenação ou o hashing de todos os dados, a página a solicitação cai nesse Action

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/sucesso.jsp"); // Informa que as leituras foram feitas com sucesso
        dispatcher.forward(request, response);
    }

}
